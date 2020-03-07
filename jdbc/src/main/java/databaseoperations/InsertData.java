package databaseoperations;

import connections.DbConnection;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData implements Function {
    int id;
    String name;
    String city;
    int age;
    String deptName;

    private void insert() {
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
        PreparedStatement statement;
        String sql = "INSERT INTO employees.employees(id, name, city, age, deptName) VALUES (?, ?, ?, ?,?)";
        statement = con.prepareStatement(sql);
        System.out.println("Enter the Values");
        Employee employee = new Employee(id, name, city, age, deptName);
        statement.setString(1, Integer.toString(employee.getId()));
        statement.setString(2, employee.getName());
        statement.setString(3, employee.getCity());
        statement.setString(4, Integer.toString(employee.getAge()));
        statement.setString(5, employee.getDeptName());
        insert();
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("New employee added");

        }
    }
}