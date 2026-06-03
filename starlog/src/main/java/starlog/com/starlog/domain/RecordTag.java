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
@Table(name = "record_tags")
public class RecordTag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "record_id")
	private DailyRecord record;

	@Column(nullable = false, length = 30)
	private String name;

	protected RecordTag() {
	}

	public RecordTag(DailyRecord record, String name) {
		this.record = record;
		this.name = name;
	}

	public Long getId() { return id; }
	public DailyRecord getRecord() { return record; }
	public String getName() { return name; }
}
