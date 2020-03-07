package databaseoperations;

import connections.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteData implements Function {
    public void operation() throws SQLException {
        Connection con = DbConnection.DbConnectionReturn();
        Statement myStmt = con.createStatement();
        String sql;
        PreparedStatement statement;
        sql = "DELETE FROM employees.employees WHERE id=?";
        statement = con.prepareStatement(sql);
        System.out.println("Enter the Employee id to delete");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        statement.setString(1, Integer.toString(id));
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Employee deleted");
        }
    }
}
