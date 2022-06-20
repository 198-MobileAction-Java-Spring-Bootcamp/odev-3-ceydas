package com.ceydog.hw3ceydas.gen.enums;

public enum GenErrorMessage {
    LICENCE_PLATE_CANNOT_CONTAIN_WHITESPACE("Licence plate number cannot contain whitespaces!"),
    LICENCE_PLATE_CANNOT_CONTAIN_SPECIAL("Licence plate number cannot contain special characters!"),
    LICENCE_PLATE_CANNOT_CONTAIN_TURKISH("Licence plate number cannot contain Turkish characters!"),
    LICENCE_PLATE_CANNOT_CONTAIN_LOWER("Licence plate number cannot contain lowercase letters!"),
    ITEM_NOT_FOUND("Item not found!"),
    PARAMETER_CANNOT_BE_NULL("Parameter cannot be null!"),
    USER_DOES_NOT_EXIST("User does not exist!")
    ;
    private String message;

    GenErrorMessage(String message) { this.message = message;}

    public String getMessage() {
        return message;
    }

}
