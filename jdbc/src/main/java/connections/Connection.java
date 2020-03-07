package connections;

import databaseoperations.DeleteData;
import databaseoperations.InsertData;
import databaseoperations.SelectData;
import databaseoperations.UpdateData;

import java.sql.SQLException;
import java.util.Scanner;

public class Connection {

    public static void main(String[] args) throws SQLException {
        java.sql.Connection c = new DbConnection().DbConnectionReturn();
        System.out.println(c);
        int choice;

        while(true) {

            System.out.println("Press for the appropriate functionality\n 1.Insert\n 2.Select\n 3.Update\n 4.Delete\n 5.Stop\n");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    InsertData i = new InsertData();
                    i.operation();
                    break;
                case 2:
                    SelectData s = new SelectData();
                    s.operation();
                    break;
                case 3:
                    UpdateData u = new UpdateData();
                    u.operation();
                    break;
                case 4:
                    DeleteData d = new DeleteData();
                    d.operation();
                    break;
                case 5:
                    return;

            }

        }

    }
}
