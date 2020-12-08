package com.telecom.richard.drogo.tables.constants;

public interface TaskConstants extends IConstants {
	// BEGIN: ATTRIBUTES
	public static final int COLUMN_LENGTH_TITLE = P7; // 128 characters maximum.
	public static final int COLUMN_LENGTH_NBHOURSFORECAST = P2; // 4 characters maximum.
	public static final int COLUMN_LENGTH_NBHOURSREAL = P2;
	public static final int COLUMN_LENGTH_CREATED = P4; // 16 characters should be enough.
	
	public final static String MESSAGE_TITLE_FR = "Le titre ne peut pas être vide !";

	public static final long MIN_NBHOURSFORECAST = 1;
	public static final long MIN_NBHOURSREAL = 1;
	// END: ATTRIBUTES
}
