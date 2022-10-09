package com.academy.Ruslana_Kichkailo.homework3.query_executor;

import com.academy.Ruslana_Kichkailo.homework3.model.Account;
import com.academy.Ruslana_Kichkailo.homework3.model.User;

import java.sql.*;

import static java.lang.String.format;

public class DBAccountQueryExecutor {

    public static void printAllAccounts(Connection connection, User user) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(format("""
                        SELECT Accounts.accountId, Accounts.currency\s
                        FROM Users\s
                        JOIN Accounts ON Users.userId = Accounts.userId\s
                        WHERE Users.userId = '%d';""", user.getId()));
        if (resultSet.next()){
            do {
                System.out.println("Account ID: " + resultSet.getInt("accountId") +
                        " currency: " + resultSet.getString("currency"));
            } while (resultSet.next());
        } else {
            System.out.println("You don't have any account yet");
        }
        resultSet.close();
        statement.close();
    }

    public static void addAccount(Connection connection, User user, Account account) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format(
                "INSERT INTO Accounts (userId, balance, currency) VALUES('%d', '%d', '%s')",
                user.getId(), account.getBalance(), account.getCurrency()));
        statement.close();
    }

    public static int getAccountIdFromDataBase(Connection connection, User user, Account account) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(format("""
                        SELECT Accounts.accountId\s
                        FROM Users\s
                        JOIN Accounts ON Users.userId = Accounts.userId\s
                        WHERE Users.userId = '%d' AND Accounts.currency IS '%s';""",
                user.getId(), account.getCurrency()));
        int id = resultSet.getInt("accountId");
        resultSet.close();
        statement.close();
        return id;
    }

    public static boolean checkAccountCurrencyExists(Connection connection, User user, String currency) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(format("""
                        SELECT Accounts.currency\s
                        FROM Users\s
                        JOIN Accounts ON Users.userId = Accounts.userId\s
                        WHERE Users.userId = '%d' AND Accounts.currency IS '%s'""", user.getId(), currency));
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            if (resultSet.getString("currency").equals(currency)) {
                return true;
            }
        }
        resultSet.close();
        statement.close();
        return false;
    }

    public static int showAccountBalance(Connection connection, int accountId) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(format(
                "SELECT balance FROM Accounts WHERE accountId = '%d';", accountId));
        int balance = resultSet.getInt("balance");
        resultSet.close();
        statement.close();
        return balance;
    }

    public static void updateAccountBalance(Connection connection, int newBalance, int accountId) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format(
                "UPDATE Accounts SET balance = '%d' WHERE accountId = '%d';", newBalance, accountId));
        statement.close();
    }
}
