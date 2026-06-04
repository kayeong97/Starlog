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
@Table(name = "routines")
public class Routine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	private StarlogUser user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "goal_id")
	private Goal goal;

	@Column(name = "goal_id", insertable = false, updatable = false)
	private Long goalId;

	@Column(nullable = false, length = 100)
	private String title;

	@Column(name = "display_order", nullable = false)
	private int displayOrder;

	@Column(nullable = false)
	private boolean active = true;

	@Column(nullable = false, length = 20)
	private String frequency = "DAILY";

	@Column(name = "created_at", insertable = false, updatable = false)
	private LocalDateTime createdAt;

	protected Routine() {
	}

	public Routine(StarlogUser user, String title, int displayOrder) {
		this.user = user;
		this.title = title;
		this.displayOrder = displayOrder;
	}

	public Routine(StarlogUser user, String title, int displayOrder, String frequency) {
		this.user = user;
		this.title = title;
		this.displayOrder = displayOrder;
		this.frequency = frequency != null ? frequency : "DAILY";
	}

	public Long getId() { return id; }
	public StarlogUser getUser() { return user; }
	public Goal getGoal() { return goal; }
	public Long getGoalId() { return goalId; }
	public String getTitle() { return title; }
	public int getDisplayOrder() { return displayOrder; }
	public boolean isActive() { return active; }
	public String getFrequency() { return frequency; }
	public LocalDateTime getCreatedAt() { return createdAt; }
	public void setGoal(Goal goal) { this.goal = goal; }
	public void setActive(boolean active) { this.active = active; }
	public void update(String title, int displayOrder) {
		this.title = title;
		this.displayOrder = displayOrder;
	}
	public void update(String title, int displayOrder, String frequency) {
		this.title = title;
		this.displayOrder = displayOrder;
		this.frequency = frequency != null ? frequency : "DAILY";
	}
}
