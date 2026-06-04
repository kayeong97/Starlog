package starlog.com.starlog.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import starlog.com.starlog.domain.StarlogUser;

public interface StarlogUserRepository extends JpaRepository<StarlogUser, Long> {
	Optional<StarlogUser> findByUsername(String username);
	boolean existsByEmail(String email);
	boolean existsByUsername(String username);
}
