package starlog.com.starlog.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class StarlogUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false, length = 50)
	private String nickname;

	@Column(nullable = false, unique = true, length = 50)
	private String username;

	@Column(name = "password_hash", nullable = false)
	private String passwordHash;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private UserRole role = UserRole.USER;

	@Column(name = "level_name", nullable = false, length = 50)
	private String levelName = "NEW EXPLORER";

	@Column(name = "star_count", nullable = false)
	private int starCount;

	@Column(name = "current_streak", nullable = false)
	private int currentStreak;

	@Column(name = "created_at", insertable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at", insertable = false, updatable = false)
	private LocalDateTime updatedAt;

	protected StarlogUser() {
	}

	public StarlogUser(String email, String nickname, String username, String passwordHash, LocalDate birthDate) {
		this.email = email;
		this.nickname = nickname;
		this.username = username;
		this.passwordHash = passwordHash;
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getNickname() {
		return nickname;
	}

	public String getUsername() {
		return username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public UserRole getRole() {
		return role;
	}

	public String getLevelName() {
		return levelName;
	}

	public int getStarCount() {
		return starCount;
	}

	public int getCurrentStreak() {
		return currentStreak;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void rewardStars(int amount) {
		this.starCount += Math.max(amount, 0);
		this.currentStreak += 1;
	}
}
