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

@Entity
@Table(name = "routine_checks")
public class RoutineCheck {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "routine_id")
	private Routine routine;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "record_id")
	private DailyRecord record;

	@Column(nullable = false)
	private boolean checked;

	protected RoutineCheck() {
	}

	public RoutineCheck(Routine routine, DailyRecord record, boolean checked) {
		this.routine = routine;
		this.record = record;
		this.checked = checked;
	}

	public Long getId() { return id; }
	public Routine getRoutine() { return routine; }
	public DailyRecord getRecord() { return record; }
	public boolean isChecked() { return checked; }
}
