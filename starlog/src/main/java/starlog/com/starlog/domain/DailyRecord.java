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
@Table(name = "daily_records")
public class DailyRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	private StarlogUser user;

	@Column(name = "record_date", nullable = false)
	private LocalDate recordDate;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private Mood mood;

	@Column(name = "star_amount", nullable = false)
	private int starAmount = 1;

	@Column(name = "created_at", insertable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at", insertable = false, updatable = false)
	private LocalDateTime updatedAt;

	protected DailyRecord() {
	}

	public DailyRecord(StarlogUser user, LocalDate recordDate, String content, Mood mood, int starAmount) {
		this.user = user;
		this.recordDate = recordDate;
		this.content = content;
		this.mood = mood;
		this.starAmount = starAmount;
	}

	public Long getId() { return id; }
	public StarlogUser getUser() { return user; }
	public LocalDate getRecordDate() { return recordDate; }
	public String getContent() { return content; }
	public Mood getMood() { return mood; }
	public int getStarAmount() { return starAmount; }
	public LocalDateTime getCreatedAt() { return createdAt; }
	public LocalDateTime getUpdatedAt() { return updatedAt; }
}
