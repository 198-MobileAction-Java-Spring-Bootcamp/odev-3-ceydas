package com.ceydog.hw3ceydas.gen.util;

import com.ceydog.hw3ceydas.gen.enums.GenErrorMessage;
import org.apache.commons.lang3.StringUtils;

import java.util.function.IntPredicate;

public class VehicleDetailsValidationUtil {


    public static void validateVehicle(String username){

        if (StringUtils.containsWhitespace(username)){
            throw new RuntimeException(GenErrorMessage.LICENCE_PLATE_CANNOT_CONTAIN_WHITESPACE.getMessage());
        }

        if ( !isAlphaNumeric(username)){
            throw new RuntimeException(GenErrorMessage.LICENCE_PLATE_CANNOT_CONTAIN_SPECIAL.getMessage());
        }

        if ( containsLowerCase(username)){
            throw new RuntimeException(GenErrorMessage.LICENCE_PLATE_CANNOT_CONTAIN_LOWER.getMessage());
        }

        if( containsTurkishChars(username)){
            throw new RuntimeException(GenErrorMessage.LICENCE_PLATE_CANNOT_CONTAIN_TURKISH.getMessage());

        }


    }

    private static boolean isAlphaNumeric(String value){
        return value.chars().allMatch(i -> Character.isLetterOrDigit(i));
    }

    private static boolean containsLowerCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isLowerCase(i));
    }


    private static boolean containsTurkishChars(String value){
        for (int i = 0; i < value.length() ; i++) {
            if (value.charAt(i) == 'Ç' ||
                    value.charAt(i) == 'Ğ' ||
                    value.charAt(i) == 'Ü' ||
                    value.charAt(i) == 'Ş'||
                    value.charAt(i) == 'İ' ||
                    value.charAt(i) == 'Ç' ||
                    value.charAt(i) == 'Ö' ||
                    value.charAt(i) == 'Ç'){
                return true;
            }
        }
        return false;
    }
    private static boolean contains(String value, IntPredicate predicate) {
        return value.chars().anyMatch(predicate);
    }
}
