package com.academy.Ruslana_Kichkailo.homework3.query_executor;

import com.academy.Ruslana_Kichkailo.homework3.model.Transaction;

import java.sql.*;

import static java.lang.String.format;

public class DBTransactionQueryExecutor {

    public static void addTransaction(Connection connection, Transaction transaction, int accountId) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format(
                "INSERT INTO Transactions (accountId, amount) VALUES('%d', '%d')",
                accountId, transaction.getAmount()));
        statement.close();
    }

    public static void printAllTransactions(Connection connection, int accountId) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(format(
                "SELECT Transactions.amount " +
                        "FROM Accounts JOIN Transactions " +
                        "ON Accounts.accountId = Transactions.accountId " +
                        "WHERE Transactions.accountId = '%d'", accountId));
        if (resultSet.next()){
            do {
                System.out.println(resultSet.getInt("amount"));
            } while (resultSet.next());
        } else {
            System.out.println("You don't have any transactions yet");
        }
        resultSet.close();
        statement.close();
    }
}
