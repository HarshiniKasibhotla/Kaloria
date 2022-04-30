package com.csci5308.kaloria.utilities;

public interface Constants {

    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    public static final String DIETICIAN_ID_REGEX = "DIET[0-9]{5}[A-Z]{1}";

    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    public static final String LOWERCASE_LETTER_REGEX = "[a-z]";

    public static final String UPPERCASE_LETTER_REGEX = "[A-Z]";

    public static final String DIGIT_REGEX = "[0-9]";

    public static final String SPECIAL_CHARACTERS_REGEX = "[#%@&*!^?]";

    public static final String FIRST_NAME = "firstName";

    public static final String LAST_NAME = "lastName";

    public static final String EMAIL = "email";

    public static final String MOBILE_NO = "mobileNo";

    public static final String DOB = "dateOfBirth";

    public static final String CITY = "city";

    public static final String ZIPCODE = "zipCode";

    public static final String PASSWORD = "password";

    public static final String QUALIFICATION = "qualification";

    public static final String AREAS_OF_EXPERTISE = "areaOfExpertise";

    public static final String REGISTRATION_ID = "registrationId";

    public static final String ADDRESS = "address";

    public static final String AVAILABILITY_HOURS = "availabilityHours";

    public static final String TIMESLOT = "timeSlot";

    public static final String USER_REGISTER_EXCEPTION = "Exception occured while registering user with email ";

    public static final String DIETICIAN_REGISTER_EXCEPTION = "Exception occured while registering Dieticia with email ";

    public static final String BAD_FIELD_VALUES = ".Bad field Values entered";

    public static final String EMAIL_CONFIG_FILE_PATH = "/mail.properties";

    public static final String DATABASE_URL = "DATABASE_URL";

    public static final String DATABASE_USERNAME = "DATABASE_USER_NAME";

    public static final String DATABASE_PASSWORD = "DATABASE_PASSWORD";

    public static final String EMAIL_SUBJECT_FOR_SUCCESSFUL_REGISTRATION = "KALORIA --- Account Creation Notification";

    public static final String EMAIL_BODY_FOR_CREDENTIALS = "Your registration to Kaloria is completed successfully. \nHere are your credentials\nUsername: ";

    public static final String EMAIL_PASSWORD = "\nPassword: ";

    public static final String DIETICIAN_MESSAGE = "\nYou will not be able to login until we verify and approve your details. You will be notified once your account is approved";

    public static final String EMAIL_CLOSING = "\nRegards,\nAdmin Team,\nKALORIA";

    public static final String REGISTRATION_SUCCESS = "User registered successfully";

    public static final String ADMIN = "admin";

    public static final String USER = "user";

    public static final String DIETICIAN = "dietician";

}
