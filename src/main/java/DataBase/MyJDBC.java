package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Luke(New Man) Zhang
 * @Date 5/8/2022 9:39 PM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class MyJDBC {

    public static void main(String[] args){

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-test", "root",
                    "root%1234");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from image");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
