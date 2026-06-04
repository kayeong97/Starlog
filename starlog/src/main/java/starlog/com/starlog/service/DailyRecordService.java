package starlog.com.starlog.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import starlog.com.starlog.domain.DailyRecord;
import starlog.com.starlog.domain.Mood;
import starlog.com.starlog.domain.StarlogUser;
import starlog.com.starlog.repository.DailyRecordRepository;
import starlog.com.starlog.repository.StarlogUserRepository;

@Service
public class DailyRecordService {

	private final DailyRecordRepository dailyRecordRepository;
	private final StarlogUserRepository userRepository;

	public DailyRecordService(DailyRecordRepository dailyRecordRepository, StarlogUserRepository userRepository) {
		this.dailyRecordRepository = dailyRecordRepository;
		this.userRepository = userRepository;
	}

	@Transactional
	public DailyRecord create(StarlogUser user, LocalDate recordDate, String content, Mood mood) {
		dailyRecordRepository.findByUserIdAndRecordDate(user.getId(), recordDate)
				.ifPresent(record -> {
					throw new IllegalArgumentException("오늘 기록은 이미 저장되었습니다.");
				});
		StarlogUser managedUser = userRepository.findById(user.getId())
				.orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
		DailyRecord record = dailyRecordRepository.save(new DailyRecord(managedUser, recordDate, content, mood, 1));
		managedUser.rewardStars(1);
		return record;
	}

	@Transactional(readOnly = true)
	public long countByUser(Long userId) {
		return dailyRecordRepository.countByUserId(userId);
	}

	@Transactional(readOnly = true)
	public long countAll() {
		return dailyRecordRepository.count();
	}

	@Transactional(readOnly = true)
	public long countByUserAndMonth(Long userId, LocalDate month) {
		LocalDate start = month.withDayOfMonth(1);
		LocalDate end = start.plusMonths(1).minusDays(1);
		return dailyRecordRepository.countByUserIdAndRecordDateBetween(userId, start, end);
	}

	@Transactional(readOnly = true)
	public List<DailyRecord> recentRecords(Long userId) {
		return dailyRecordRepository.findTop12ByUserIdOrderByRecordDateDesc(userId);
	}

	@Transactional(readOnly = true)
	public List<DailyRecord> recordsInMonth(Long userId, LocalDate month) {
		LocalDate start = month.withDayOfMonth(1);
		LocalDate end = start.plusMonths(1).minusDays(1);
		return dailyRecordRepository.findByUserIdAndRecordDateBetweenOrderByRecordDateAsc(userId, start, end);
	}
}
