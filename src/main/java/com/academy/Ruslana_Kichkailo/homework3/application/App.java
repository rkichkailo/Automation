package com.academy.Ruslana_Kichkailo.homework3.application;

import static com.academy.Ruslana_Kichkailo.homework3.application.AccountMenu.*;
import static com.academy.Ruslana_Kichkailo.homework3.application.LoginForm.*;
import static com.academy.Ruslana_Kichkailo.homework3.application.Menu.*;
import static com.academy.Ruslana_Kichkailo.homework3.query_executor.DBAccountQueryExecutor.printAllAccounts;
import static com.academy.Ruslana_Kichkailo.homework3.service.AccountService.inputAccount;
import static com.academy.Ruslana_Kichkailo.homework3.service.UserService.inputNewUser;

import com.academy.Ruslana_Kichkailo.homework3.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class App {
    private static final String JDBC_DRIVER_PATH = "org.sqlite.JDBC";
    private static final String DATABASE_URL = "jdbc:sqlite:src\\main\\resources\\dataBase.db";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        User user = new User();

        if (isDriverExists()){
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            String userAction;
            do{
                getWelcomeMenu();
                userAction = scanner.nextLine();
                switch (userAction){
                    case "1" -> getLoginForm(connection, scanner, user);
                    case "2" -> inputNewUser(connection, scanner, user);
                    case "3" -> showGoodByeMessage();
                    default ->  System.out.println("No option selected");
                }
            } while (showMenu());
            while (isLogged()){
                getAccountMenu();
                userAction = scanner.nextLine();
                switch (userAction) {
                    case "1" -> inputAccount(connection, scanner, user);
                    case "2" -> printAllAccounts(connection, user);
                    case "3" -> showAccountMenu(connection, scanner, user);
                    case "4" -> showGoodByeMessage();
                }
            }
            scanner.close();
            connection.close();
        }
    }

    public static boolean isDriverExists() {
        try {
            Class.forName(JDBC_DRIVER_PATH);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC Driver was not found");
            return false;
        }
    }
}
