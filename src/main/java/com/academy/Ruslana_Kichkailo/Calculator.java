package com.academy.Ruslana_Kichkailo;


public class Calculator {
    public static double calculate (String number1, String number2, String operator){
        double result = 0.0;
        try {
            double firstNumber = Double.parseDouble(number1);
            double secondValue = Double.parseDouble(number2);

            switch (operator){
                case "+":
                    result = addition(firstNumber, secondValue);
                    break;
                case "-":
                    result = subtraction(firstNumber, secondValue);
                    break;
                case "*":
                   result = multiplication(firstNumber, secondValue);
                   break;
                case "/":
                   result = division(firstNumber, secondValue);
                   break;
                default: System.out.println("something wrong....");

            }
        }catch (Exception e){
            e.getStackTrace();
        }
        return result;
    }
    public static double addition(double number1, double number2)throws NumberFormatException{
        return number1 + number2;
    }
    public static double subtraction(double number1, double number2)throws NumberFormatException{
        return number1 - number2;
    }
    public static double multiplication(double number1, double number2)throws NumberFormatException{
        return number1 * number2;
    }
    public static double division(double number1, double number2)throws NumberFormatException,  ArithmeticException{
        return number1 / number2;
    }
}
