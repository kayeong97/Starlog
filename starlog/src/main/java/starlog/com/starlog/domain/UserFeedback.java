package starlog.com.starlog.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_feedback")
public class UserFeedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private StarlogUser user;

	@Column(name = "author_name", nullable = false, length = 80)
	private String authorName;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String message;

	@Column(nullable = false, length = 40)
	private String category = "GENERAL";

	@Column(name = "created_at", insertable = false, updatable = false)
	private LocalDateTime createdAt;

	protected UserFeedback() {
	}

	public UserFeedback(StarlogUser user, String authorName, String message, String category) {
		this.user = user;
		this.authorName = authorName;
		this.message = message;
		this.category = category;
	}

	public Long getId() { return id; }
	public StarlogUser getUser() { return user; }
	public String getAuthorName() { return authorName; }
	public String getMessage() { return message; }
	public String getCategory() { return category; }
	public LocalDateTime getCreatedAt() { return createdAt; }
}
