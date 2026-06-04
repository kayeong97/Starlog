package starlog.com.starlog.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import starlog.com.starlog.domain.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long> {
	List<Goal> findTop3ByUserIdOrderByCreatedAtDesc(Long userId);
	List<Goal> findByUserIdOrderByCreatedAtDesc(Long userId);
}
