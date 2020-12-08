package com.telecom.richard.drogo.tables.constants;

public interface DeveloperConstants extends IConstants {
	// BEGIN: ATTRIBUTES
	public static final int COLUMN_LENGTH_FIRSTNAME = P5;
	public static final int COLUMN_LENGTH_LASTNAME = P5;
	public static final int COLUMN_LENGTH_PASSWORD = P10; // TODO: We put a length that large in case we want to encrypt the password later.
	public static final int COLUMN_LENGTH_EMAIL = P6; // 64 characters maximum.
	public static final int COLUMN_LENGTH_STARTCONTRACT = P4; // 16 characters should be enough.
	
	public static final int SIZE_MIN_PASSWORD = P3; // 8 characters minimum.
	public static final int SIZE_MAX_PASSWORD = P5; // 32 characters maximum.
	public static final int SIZE_MAX_EMAIL = COLUMN_LENGTH_EMAIL;
	
	public static final String MESSAGE_FIRSTNAME_FR = "Veuillez saisir votre prénom.";
	public static final String MESSAGE_LASTNAME_FR = "Veuillez saisir votre nom de famille.";
	public static final String MESSAGE_PASSWORD_FR = "Veuillez saisir un mot de passe compris entre " + SIZE_MIN_PASSWORD + " et " + SIZE_MAX_PASSWORD + " caractères.";
	public static final String MESSAGE_EMAIL_FR = "Veuillez saisir une adresse mail valide et avec moins de " + COLUMN_LENGTH_EMAIL + " caractères.";
	// END: ATTRIBUTES
}
