package starlog.com.starlog.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import starlog.com.starlog.domain.Routine;

public interface RoutineRepository extends JpaRepository<Routine, Long> {
	List<Routine> findByUserIdAndActiveTrueOrderByDisplayOrderAsc(Long userId);
	List<Routine> findByGoalIdAndActiveTrue(Long goalId);
	List<Routine> findByGoalId(Long goalId);
}
