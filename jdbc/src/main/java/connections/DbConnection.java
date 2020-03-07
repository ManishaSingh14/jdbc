package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

//public static void main(String[] args) {
//Connection c  = new DbConnection().DbConnectionReturn();
//System.out.println(c);

      public static Connection DbConnectionReturn() {
          String url = "jdbc:mysql://localhost:3306/student";
          String username ="root";
          String password="";
              Connection con = null;
          try {
              con = DriverManager.getConnection(url, username, password);
              if (con != null) {
                  System.out.println("connected");
              }

          } catch (SQLException e) {
              e.printStackTrace();
          }
          return con;
      }
  }

