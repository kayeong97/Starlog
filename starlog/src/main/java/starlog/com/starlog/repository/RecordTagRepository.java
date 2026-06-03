package starlog.com.starlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import starlog.com.starlog.domain.RecordTag;

public interface RecordTagRepository extends JpaRepository<RecordTag, Long> {
}
