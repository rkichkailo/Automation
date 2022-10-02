package com.academy.Ruslana_Kichkailo;

public class Calculator {
    public static double calculate (double number1, double number2, String operator) {

        double result = 0.0;
        try{
            switch (operator) {
                case "+" -> result = add(number1, number2);
                case "-" -> result = subtract(number1, number2);
                case "*" -> result = multiply(number1, number2);
                case "/" -> result = divide(number1, number2);
                default -> System.out.println("something wrong....");
            }
        } catch (ArithmeticException e){
            e.getStackTrace();
        }
        return result;
    }

    public static double add(double number1, double number2)throws NumberFormatException{
        return number1 + number2;
    }

    public static double subtract(double number1, double number2)throws NumberFormatException{
        return number1 - number2;
    }

    public static double multiply(double number1, double number2)throws NumberFormatException{
        return number1 * number2;
    }

    public static double divide(double number1, double number2){
        try {
            if (number2 == 0.0){
                throw new java.lang.ArithmeticException("/0");
            }
        }catch (ArithmeticException e){
            System.out.println("Error: division by zero");
        }
        return number1 / number2;
    }
}
