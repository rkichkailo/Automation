package com.academy.Ruslana_Kichkailo.homework3.service;

import com.academy.Ruslana_Kichkailo.homework3.model.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static com.academy.Ruslana_Kichkailo.homework3.query_executor.DBAccountQueryExecutor.*;
import static com.academy.Ruslana_Kichkailo.homework3.query_executor.DBTransactionQueryExecutor.*;

public class TransactionService {
    private static final int MAX_TRANSACTION_AMOUNT = 1_000_000_000;
    private static final int MAX_BALANCE = 2_000_000_000;
    private static final int MIN_BALANCE = 0;

    public static void topUpBalance(Connection connection, Scanner scanner, int accountId) throws SQLException {
        System.out.printf("Enter amount (up to '%d')%n", MAX_TRANSACTION_AMOUNT );
        int currentBalance = showAccountBalance(connection, accountId);
        int amount = Integer.parseInt(scanner.nextLine());
        int newBalance = currentBalance + amount;
        if (currentBalance == MAX_BALANCE){
            System.out.println("Your balance is maximum available = " + MAX_BALANCE);
        } else if (amount < 0 || amount > MAX_TRANSACTION_AMOUNT) {
            System.out.println("Unacceptable amount provided. Maximum amount = " + MAX_TRANSACTION_AMOUNT);
        } else if ((newBalance) > MAX_BALANCE){
            System.out.println("Provided amount is too big. Unable to set balance more than " + MAX_BALANCE);
        } else {
            Transaction transaction = new Transaction();
            transaction.setAmount(amount);
            addTransaction(connection, transaction, accountId);
            updateAccountBalance(connection, newBalance, accountId);
            System.out.println("Your balance updated successfully");
        }
    }

    public static void topDownBalance(Connection connection, Scanner scanner, int accountId) throws SQLException {
        int currentBalance = showAccountBalance(connection, accountId);
        System.out.printf("Enter amount (up to '%d')%n", MAX_TRANSACTION_AMOUNT );
        int amount = Integer.parseInt(scanner.nextLine());
        int newBalance = currentBalance - amount;
        if (currentBalance == MIN_BALANCE){
            System.out.println("Unable to update balance. Your balance is " + MIN_BALANCE);
        } else if (amount < 0 || amount > MAX_TRANSACTION_AMOUNT) {
            System.out.println("Unacceptable amount provided. Maximum amount = " + MAX_TRANSACTION_AMOUNT);
        } else if (newBalance < MIN_BALANCE){
            System.out.println("Provided amount is too big. Unable to set balance less than " + MIN_BALANCE);
        } else {
            Transaction transaction = new Transaction();
            transaction.setAmount(-amount);
            addTransaction(connection, transaction, accountId);
            updateAccountBalance(connection, newBalance, accountId);
            System.out.println("Your balance updated successfully");
        }
    }
}
