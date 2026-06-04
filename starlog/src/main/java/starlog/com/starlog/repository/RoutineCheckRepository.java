package starlog.com.starlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import starlog.com.starlog.domain.RoutineCheck;

public interface RoutineCheckRepository extends JpaRepository<RoutineCheck, Long> {
	boolean existsByRoutineIdAndRecordId(Long routineId, Long recordId);

	@Query("SELECT COUNT(rc) FROM RoutineCheck rc WHERE rc.routine.goal.id = :goalId AND rc.routine.active = true AND rc.checked = true")
	long countCheckedByGoalId(@Param("goalId") Long goalId);
}
