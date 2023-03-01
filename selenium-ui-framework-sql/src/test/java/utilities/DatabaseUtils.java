package utilities;

import java.sql.*;

public class DatabaseUtils {


    static String url = ConfigReader.getConfigProperty("db.url");
    static String username = ConfigReader.getConfigProperty("db.username");
    static String password = ConfigReader.getConfigProperty("db.password");
    static Connection con;
    static Statement stmt;
    static ResultSet rs;


    public static void initializeDBProperties() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
        }catch (Exception e){
      e.printStackTrace();
        }

    }

    public static void closeDBConnection(){
        try {
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static ResultSet executeQuery(String query) {

        try {
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
//
//        while(rs.next()){
//        System.out.println(rs.getString("first_name"));
//        }

}






