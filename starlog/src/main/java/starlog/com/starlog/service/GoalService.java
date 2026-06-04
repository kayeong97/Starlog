package starlog.com.starlog.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import starlog.com.starlog.domain.Goal;
import starlog.com.starlog.domain.Routine;
import starlog.com.starlog.domain.StarlogUser;
import starlog.com.starlog.repository.GoalRepository;
import starlog.com.starlog.repository.RoutineCheckRepository;
import starlog.com.starlog.repository.RoutineRepository;
import starlog.com.starlog.repository.StarlogUserRepository;

@Service
public class GoalService {

	private final GoalRepository goalRepository;
	private final StarlogUserRepository userRepository;
	private final RoutineRepository routineRepository;
	private final RoutineCheckRepository routineCheckRepository;

	public GoalService(GoalRepository goalRepository,
			StarlogUserRepository userRepository,
			RoutineRepository routineRepository,
			RoutineCheckRepository routineCheckRepository) {
		this.goalRepository = goalRepository;
		this.userRepository = userRepository;
		this.routineRepository = routineRepository;
		this.routineCheckRepository = routineCheckRepository;
	}

	@Transactional
	public Goal create(StarlogUser user, String title, String category, LocalDate targetDate, String description) {
		StarlogUser managedUser = userRepository.findById(user.getId())
				.orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
		return goalRepository.save(new Goal(managedUser, title, category, targetDate, description));
	}

	@Transactional(readOnly = true)
	public List<Goal> recentGoals(Long userId) {
		return goalRepository.findTop3ByUserIdOrderByCreatedAtDesc(userId);
	}

	@Transactional(readOnly = true)
	public List<Goal> findAllByUser(Long userId) {
		return goalRepository.findByUserIdOrderByCreatedAtDesc(userId);
	}

	@Transactional(readOnly = true)
	public Optional<Goal> findById(Long goalId, Long userId) {
		return goalRepository.findById(goalId)
				.filter(g -> g.getUser().getId().equals(userId));
	}

	@Transactional
	public Goal update(Long goalId, Long userId, String title, String category, LocalDate targetDate, String description) {
		Goal goal = goalRepository.findById(goalId)
				.filter(g -> g.getUser().getId().equals(userId))
				.orElseThrow(() -> new IllegalArgumentException("목표를 찾을 수 없습니다."));
		goal.update(title, category, targetDate, description);
		return goal;
	}

	@Transactional
	public void recalculateAllForUser(Long userId) {
		List<Goal> goals = goalRepository.findByUserIdOrderByCreatedAtDesc(userId);
		for (Goal goal : goals) {
			List<Routine> linked = routineRepository.findByGoalIdAndActiveTrue(goal.getId());
			if (linked.isEmpty()) continue;

			LocalDate createdDate = goal.getCreatedAt() != null
					? goal.getCreatedAt().toLocalDate()
					: LocalDate.now();
			// 전체 기간 기준 (마감일 없으면 90일)
			LocalDate targetDate = goal.getTargetDate();
			LocalDate endDate = targetDate != null ? targetDate : createdDate.plusDays(89);
			long totalDays = Math.max(1, ChronoUnit.DAYS.between(createdDate, endDate) + 1);

			long totalExpected = 0;
			for (Routine r : linked) {
				String freq = r.getFrequency() != null ? r.getFrequency() : "DAILY";
				totalExpected += switch (freq) {
					case "EVERY_OTHER" -> Math.max(1, (totalDays + 1) / 2);
					case "WEEKLY_3"    -> Math.max(1, Math.round(totalDays * 3.0 / 7));
					case "FOCUS"       -> Math.max(1, Math.round(totalDays * 0.3));
					default            -> totalDays;
				};
			}

			long totalChecked = routineCheckRepository.countCheckedByGoalId(goal.getId());
			int percent = (int) Math.min(100, Math.round(totalChecked * 100.0 / totalExpected));
			goal.setProgressPercent(percent);
		}
	}
}
