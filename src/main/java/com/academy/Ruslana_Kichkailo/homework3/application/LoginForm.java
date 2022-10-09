package com.academy.Ruslana_Kichkailo.homework3.application;

import com.academy.Ruslana_Kichkailo.homework3.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static com.academy.Ruslana_Kichkailo.homework3.query_executor.DBLoginQueryExecutor.checkUserCredentials;

public class LoginForm {
    private static final int LOGIN_ATTEMPTS = 3;
    private static int userLoginAttempts = 0;
    private static boolean isLogged = false;
    public static boolean isLoginEnabled = true;
    public static void getLoginForm(Connection connection, Scanner scanner, User user) throws SQLException {
        if (userLoginAttempts < 3){
            System.out.println("Your name:" );
            String userName = scanner.nextLine();
            System.out.println("Your id:" );
            try {
                int userID = Integer.parseInt(scanner.nextLine());
                if (checkUserCredentials(connection, userID, userName, user)){
                    System.out.println("User logged in successfully");
                    user.setId(userID);
                    isLogged = true;
                } else {
                    System.out.println("Incorrect credentials provided! Try again");
                    userLoginAttempts++;
                    System.out.println("Attempts used: " + userLoginAttempts + " out of " + LOGIN_ATTEMPTS);
                }
            } catch (NumberFormatException e){
                System.out.println("Incorrect credentials provided! Try again");
                userLoginAttempts++;
                System.out.println("Attempts used: " + userLoginAttempts + " out of " + LOGIN_ATTEMPTS);
            }
        } else {
            System.out.println("Your attempts exceed. Try again later");
            isLoginEnabled = false;
        }
    }

    public static boolean isLogged() {
        return isLogged;
    }

    public static void setIsLogged(boolean isLogged) {
        LoginForm.isLogged = isLogged;
    }
}
