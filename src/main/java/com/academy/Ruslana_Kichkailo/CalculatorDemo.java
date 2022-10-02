package com.academy.Ruslana_Kichkailo;
import java.util.*;
public class CalculatorDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("""
                    ----------------------
                    Calculator application
                    ----------------------
                    Enter 1 to calculate numbers
                    Enter 2 to close app""");
            String userChoice = scanner.nextLine();
            try {
                switch (DataCheck.checkMenuFunctionSelected(userChoice)) {
                    case 1 -> {
                        System.out.println("Enter first number");
                        double number1 = DataCheck.checkNumber(scanner.nextLine());
                        System.out.println("Enter second number");
                        double number2 = DataCheck.checkNumber(scanner.nextLine());
                        System.out.println("Enter math operator");
                        String operator = scanner.nextLine();
                        if (DataCheck.checkOperator(operator)) {
                            System.out.println("Result = " + Calculator.calculate(number1, number2, operator));
                        } else {
                            System.out.println("Unacceptable operator provided. Please try again");
                        }
                    }
                    case 2 -> {
                        System.out.println("Good Bye!");
                        showMenu = false;
                    }
                    default -> System.out.println("Please try again");
                }
            } catch (Exception e) {
                System.out.println("Unacceptable value provided. Please try again");
            }
        }
        scanner.close();
    }
}
