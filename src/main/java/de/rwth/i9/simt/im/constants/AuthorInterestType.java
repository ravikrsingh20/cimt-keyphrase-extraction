package de.rwth.i9.simt.im.constants;

public enum AuthorInterestType {
	WIKIPEDIA_BASED, DEFAULT;

	public static AuthorInterestType fromString(String value) {
		if ("WIKIPEDIA_BASED".equalsIgnoreCase(value))
			return WIKIPEDIA_BASED;
		return DEFAULT;
	}

}
