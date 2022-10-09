package com.academy.Ruslana_Kichkailo.homework3.application;

import com.academy.Ruslana_Kichkailo.homework3.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static com.academy.Ruslana_Kichkailo.homework3.query_executor.DBAccountQueryExecutor.showAccountBalance;
import static com.academy.Ruslana_Kichkailo.homework3.query_executor.DBTransactionQueryExecutor.printAllTransactions;
import static com.academy.Ruslana_Kichkailo.homework3.query_executor.DBUserQueryExecutor.checkUserHasAccounts;
import static com.academy.Ruslana_Kichkailo.homework3.service.TransactionService.*;

public class AccountMenu {

    public static void getAccountActions() {
        System.out.println("""
                Select action:
                --------------------
                1 - Show Balance
                2 - Top up balance
                3 - Get money
                4 - Show transactions
                5 - Close account""");
    }

    public static void showAccountMenu(Connection connection, Scanner scanner, User user) throws SQLException {
        if (checkUserHasAccounts(connection,user)){
            System.out.println("Select account:");
            int userAccount = Integer.parseInt(scanner.nextLine());
            boolean accountIsOpened = true;
            String optionSelected;
            while (accountIsOpened){
                getAccountActions();
                optionSelected = scanner.nextLine();
                switch (optionSelected){
                    case "1" -> System.out.println("Current balance is " + showAccountBalance(connection, userAccount));
                    case "2" -> topUpBalance (connection, scanner, userAccount);
                    case "3" -> topDownBalance(connection, scanner,userAccount);
                    case "4" -> printAllTransactions(connection, userAccount);
                    case "5" -> accountIsOpened = false;
                }
            }
        } else {
            System.out.println("You don't have any account yet");
        }
    }
}
