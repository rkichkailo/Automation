package com.academy.Ruslana_Kichkailo.homework3.service;
import com.academy.Ruslana_Kichkailo.homework3.application.LoginForm;
import com.academy.Ruslana_Kichkailo.homework3.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static com.academy.Ruslana_Kichkailo.homework3.query_executor.DBUserQueryExecutor.*;

public class UserService {
    public static void inputNewUser(Connection connection, Scanner scanner, User user) throws SQLException {
        System.out.println("Enter your name *: ");
        String name = scanner.nextLine();
        if (!checkUserNameExists(connection, name)){
            user.setName(name);
            System.out.println("Enter your address (optional): ");
            if (scanner.hasNextLine()){
                user.setAddress(scanner.nextLine());
            }
            addUser(connection, user);
            getUserIdFromDataBase(connection, user);
            System.out.println("New user successfully created!" +
                    "\nYour userId: " + user.getId());
            LoginForm.setIsLogged(true);
        } else {
            System.out.println("This name is already used");
        }
    }
}
