package com.academy.Ruslana_Kichkailo.homework3.query_executor;

import com.academy.Ruslana_Kichkailo.homework3.model.User;

import java.sql.*;
import java.util.Objects;

import static java.lang.String.format;

public class DBUserQueryExecutor {

    public static boolean checkUserNameExists(Connection connection, String userName) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(format(
                "SELECT * FROM Users WHERE name = '%s';", userName));
        if (resultSet.next()) {
            if (Objects.equals(resultSet.getString("name"), userName))
                return true;
        }
        resultSet.close();
        statement.close();
        return false;
    }

    public static void addUser(Connection connection, User user) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format(
                "INSERT INTO Users (name, address) VALUES('%s', '%s')",
                user.getName(),user.getAddress()));
        statement.close();
    }

    public static void getUserIdFromDataBase(Connection connection, User user) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(format(
                "SELECT * FROM Users WHERE name = '%s';", user.getName()));
        user.setId(resultSet.getInt("userId"));
        resultSet.close();
        statement.close();
    }

    public static boolean checkUserHasAccounts(Connection connection, User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(format("""
                        SELECT Accounts.accountId\s
                        FROM Users\s
                        JOIN Accounts ON Users.userId = Accounts.userId\s
                        WHERE Users.userId = '%d';""", user.getId()));
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            return true;
        }
        resultSet.close();
        statement.close();
        return false;
    }
}
