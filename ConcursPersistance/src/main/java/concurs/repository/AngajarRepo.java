package concurs.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AngajarRepo implements IAngajatRepo {

    public boolean check(String username, String password) {
        DataBaseConnection.openConnection();
        try {
            PreparedStatement preparedStatement = DataBaseConnection.conn.prepareStatement("SELECT * FROM lab2.angajat WHERE  `name`=? and `password`=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);


            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            if (rs.getString("name") != null)
                return true;
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState());
            System.err.println(ex.getErrorCode());
            System.err.println(ex.getMessage());
        }
        return false;
    }
}
