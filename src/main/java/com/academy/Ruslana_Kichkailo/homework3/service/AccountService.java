package com.academy.Ruslana_Kichkailo.homework3.service;
import com.academy.Ruslana_Kichkailo.homework3.model.Account;
import com.academy.Ruslana_Kichkailo.homework3.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static com.academy.Ruslana_Kichkailo.homework3.query_executor.DBAccountQueryExecutor.*;

public class AccountService {
    private static final int DEFAULT_BALANCE = 0;
    private static final String CURRENCY_PATTERN = "USA|EUR|RU|BR";
    public static void inputAccount(Connection connection, Scanner scanner, User user) throws SQLException {
        do {
            System.out.println("Enter account currency: USA/EUR/RU/BR");
            String currency = scanner.nextLine();
            if (currency.matches(CURRENCY_PATTERN)){
                if (!checkAccountCurrencyExists(connection, user, currency)){
                    Account account = new Account();
                    account.setCurrency(currency);
                    account.setBalance(DEFAULT_BALANCE);
                    addAccount(connection, user, account);
                    System.out.println("New account successfully created!" +
                            "\nYour accountId: " + getAccountIdFromDataBase(connection, user, account));
                } else {
                    System.out.println("You already have an account with this currency");
                }
                break;
            }
        } while (true);
    }
}
