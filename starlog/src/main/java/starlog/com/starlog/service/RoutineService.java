package starlog.com.starlog.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import starlog.com.starlog.domain.DailyRecord;
import starlog.com.starlog.domain.Goal;
import starlog.com.starlog.domain.Routine;
import starlog.com.starlog.domain.RoutineCheck;
import starlog.com.starlog.domain.StarlogUser;
import starlog.com.starlog.repository.GoalRepository;
import starlog.com.starlog.repository.RoutineCheckRepository;
import starlog.com.starlog.repository.RoutineRepository;
import starlog.com.starlog.repository.StarlogUserRepository;

@Service
public class RoutineService {

	private final RoutineRepository routineRepository;
	private final RoutineCheckRepository routineCheckRepository;
	private final StarlogUserRepository userRepository;
	private final GoalRepository goalRepository;

	public RoutineService(RoutineRepository routineRepository,
			RoutineCheckRepository routineCheckRepository,
			StarlogUserRepository userRepository,
			GoalRepository goalRepository) {
		this.routineRepository = routineRepository;
		this.routineCheckRepository = routineCheckRepository;
		this.userRepository = userRepository;
		this.goalRepository = goalRepository;
	}

	@Transactional(readOnly = true)
	public List<Routine> findActiveByUser(Long userId) {
		return routineRepository.findByUserIdAndActiveTrueOrderByDisplayOrderAsc(userId);
	}

	@Transactional(readOnly = true)
	public List<Routine> findByGoal(Long goalId) {
		return routineRepository.findByGoalIdAndActiveTrue(goalId);
	}

	@Transactional
	public void replaceGoalRoutines(Long userId, Long goalId, List<String> names) {
		StarlogUser user = userRepository.findById(userId).orElseThrow();
		Goal goal = goalRepository.findById(goalId).orElseThrow();

		routineRepository.deleteAll(routineRepository.findByGoalId(goalId));

		if (names == null) return;
		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i).trim();
			if (!name.isEmpty()) {
				Routine r = new Routine(user, name, i);
				r.setGoal(goal);
				routineRepository.save(r);
			}
		}
	}

	@Transactional
	public void saveChecks(DailyRecord record, List<Long> checkedIds) {
		List<Routine> routines = routineRepository.findByUserIdAndActiveTrueOrderByDisplayOrderAsc(
				record.getUser().getId());
		for (Routine routine : routines) {
			if (!routineCheckRepository.existsByRoutineIdAndRecordId(routine.getId(), record.getId())) {
				boolean checked = checkedIds != null && checkedIds.contains(routine.getId());
				routineCheckRepository.save(new RoutineCheck(routine, record, checked));
			}
		}
	}
}
