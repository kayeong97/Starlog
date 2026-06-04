package starlog.com.starlog.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "goals")
public class Goal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	private StarlogUser user;

	@Column(nullable = false, length = 120)
	private String title;

	@Column(nullable = false, length = 40)
	private String category;

	@Column(name = "target_date")
	private LocalDate targetDate;

	@Column(columnDefinition = "TEXT")
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private GoalStatus status = GoalStatus.ACTIVE;

	@Column(name = "progress_percent", nullable = false)
	private int progressPercent;

	@Column(name = "created_at", insertable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at", insertable = false, updatable = false)
	private LocalDateTime updatedAt;

	protected Goal() {
	}

	public Goal(StarlogUser user, String title, String category, LocalDate targetDate, String description) {
		this.user = user;
		this.title = title;
		this.category = category;
		this.targetDate = targetDate;
		this.description = description;
	}

	public Long getId() { return id; }
	public StarlogUser getUser() { return user; }
	public String getTitle() { return title; }
	public String getCategory() { return category; }
	public LocalDate getTargetDate() { return targetDate; }
	public String getDescription() { return description; }
	public GoalStatus getStatus() { return status; }
	public int getProgressPercent() { return progressPercent; }
	public LocalDateTime getCreatedAt() { return createdAt; }
	public LocalDateTime getUpdatedAt() { return updatedAt; }

	public void setProgressPercent(int progressPercent) { this.progressPercent = progressPercent; }

	public void update(String title, String category, LocalDate targetDate, String description) {
		this.title = title;
		this.category = category;
		this.targetDate = targetDate;
		this.description = description;
	}

	public void updateStatus(GoalStatus status) {
		this.status = status;
	}
}
