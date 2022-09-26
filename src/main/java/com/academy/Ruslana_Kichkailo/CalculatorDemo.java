package com.academy.Ruslana_Kichkailo;

import java.math.BigDecimal;
import java.util.*;

public class CalculatorDemo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Enter first number");
                String value1 = scanner.nextLine();
                System.out.println("Enter second number");
                String value2 = scanner.nextLine();
                System.out.println("Enter on of the operator: + - * /");
                String operator = scanner.nextLine();
                try {
                    Double.parseDouble(value1);
                    Double.parseDouble(value2);
                    if (operator.matches("[\\+\\-\\*\\/]")) {
                        System.out.println(Calculator.calculate(value1, value2, operator));
                    } else {
                        System.out.println("Incorrect operator");
                    }
                } catch (NumberFormatException e){
                    System.out.println("Incorrect value entered");
                }
            }catch (Exception e){
                System.out.println("Not accessible value: " + e);
            }

    }
}
