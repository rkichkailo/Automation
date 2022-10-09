package com.academy.Ruslana_Kichkailo.homework3.query_executor;

import com.academy.Ruslana_Kichkailo.homework3.model.User;

import java.sql.*;

import static java.lang.String.format;

public class DBLoginQueryExecutor {

    public static boolean checkUserCredentials(Connection connection, int userId, String name, User user) throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(format("SELECT * FROM Users WHERE userId = '%d' AND name = '%s';",
                        userId, name));
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            if (resultSet.getInt("userId") == userId &&
                    resultSet.getString("name").equalsIgnoreCase(name)){
                user.setId(userId);
                user.setName(name);
                user.setAddress(resultSet.getString("address"));
            }
            return true;
        }
        resultSet.close();
        statement.close();
        return false;
    }
}
