package com.academy.Ruslana_Kichkailo;

public class DataCheck {
    private static final String PATTERN_TO_CHECK_OPERATOR = "[\\+\\-\\*\\/]";
    public static int checkMenuFunctionSelected(String userChoice)throws NumberFormatException{
        return Integer.parseInt(userChoice);
    }
    public static double checkNumber(String number)throws NumberFormatException{
        return Double.parseDouble(number);
    }
    public static boolean checkOperator(String operator)throws NumberFormatException{
        return operator.matches(PATTERN_TO_CHECK_OPERATOR);
    }
}