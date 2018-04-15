package repository;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DataBaseConnection {
    public static Connection conn;

    public static void connect() {
        Properties serverProps = new Properties(System.getProperties());
        try {
            serverProps.load(new FileReader("connection"));
            System.setProperties(serverProps);
            //      System.getProperties().list(System.out);
        } catch (IOException e) {
            System.out.println("Eroare " + e);
        }
        String tasksFile = System.getProperty("tasksFile");
    }

    //cod
    private static Connection getNewConnection() {
        connect();
        String driver = System.getProperty("jdbc.driver");
        String url = System.getProperty("jdbc.url");
        String user = System.getProperty("jdbc.user");
        String pass = System.getProperty("jdbc.pass");
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            System.out.println("Eroare incarcare driver " + e);
        } catch (SQLException e) {
            System.out.println("Eroare stabilire conexiune " + e);
        }
        return con;
    }

    public static void openConnection(){
        try {
            if(conn==null || conn.isClosed()) {
                conn = getNewConnection();
                System.out.println("OPENED A NEW CONNECTION");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Conexiunea n-a putut sa se inchida " + e);
        }
    }
}
