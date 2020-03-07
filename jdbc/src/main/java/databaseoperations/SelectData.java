package databaseoperations;

import connections.DbConnection;

import java.sql.*;

public class SelectData implements Function {
    public void operation() throws SQLException {
        Connection con = DbConnection.DbConnectionReturn();
        Statement myStmt = con.createStatement();
        String sql;
        //PreparedStatement statement;
        sql = "select * from employees.employees";
        ResultSet rs = myStmt.executeQuery(sql);

        while (rs.next()){
            String id = rs.getString("id");
            String name = rs.getString("name");
            String city = rs.getString("city");
            String age = rs.getString("age");
            String deptName = rs.getString("deptName");
            System.out.println("Record " + id + " is " + name + " " + city + " " + age + " " + deptName);
        }
    }
}
