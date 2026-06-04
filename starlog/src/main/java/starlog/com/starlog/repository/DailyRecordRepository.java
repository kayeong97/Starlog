package starlog.com.starlog.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import starlog.com.starlog.domain.DailyRecord;

public interface DailyRecordRepository extends JpaRepository<DailyRecord, Long> {
	Optional<DailyRecord> findByUserIdAndRecordDate(Long userId, LocalDate recordDate);
	long countByUserId(Long userId);
	long countByUserIdAndRecordDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
	List<DailyRecord> findTop12ByUserIdOrderByRecordDateDesc(Long userId);
	List<DailyRecord> findByUserIdAndRecordDateBetweenOrderByRecordDateAsc(Long userId, LocalDate startDate, LocalDate endDate);
}
