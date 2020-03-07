package databaseoperations;

import connections.DbConnection;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateData implements Function {
    private int id;
    private String name;
    private String city;
    private int age;
    private String deptName;

    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id : ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the name : ");
        name = sc.nextLine();
        System.out.println("Enter the city : ");
        city = sc.nextLine();
        System.out.println("Enter the age : ");
        age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the deptName: ");
        deptName = sc.nextLine();
    }

    public void operation() throws SQLException {
        Connection con = DbConnection.DbConnectionReturn();
        Statement myStmt = con.createStatement();
        String sql;
        PreparedStatement statement;
        sql = "UPDATE employees.employees SET name=?, city=?, age=?, deptName=? WHERE id=?";
        System.out.println("Enter the ID to update");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println("Enter the new values\n");
        input();
        Employee employee = new Employee(id, name, city, age, deptName);
        statement = con.prepareStatement(sql);
        statement.setString(1, employee.getName());
        statement.setString(2, employee.getCity());
        statement.setString(3, Integer.toString(employee.getAge()));
        statement.setString(4, employee.getDeptName());
        statement.setString(5, Integer.toString(employee.getId()));
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
    }
}

