package starlog.com.starlog.domain;

public enum Mood {
	GREAT("최고예요"),
	GOOD("좋아요"),
	NORMAL("평범해요"),
	SAD("흐려요"),
	UPSET("속상해요"),
	COMPLEX("복잡해요");

	private final String displayName;

	Mood(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
