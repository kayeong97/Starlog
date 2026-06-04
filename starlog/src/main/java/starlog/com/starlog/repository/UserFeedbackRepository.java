package starlog.com.starlog.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import starlog.com.starlog.domain.UserFeedback;

public interface UserFeedbackRepository extends JpaRepository<UserFeedback, Long> {
	List<UserFeedback> findTop5ByOrderByCreatedAtDesc();
}
