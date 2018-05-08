package concurs.repository;

import concurs.model.Concurs;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConcursRepo implements IConcursRepo {
    @Override
    public  void afiseazaProbaNume() {
        DataBaseConnection.openConnection();
        String result="";
        try{
            PreparedStatement preparedStatement = DataBaseConnection.conn.prepareStatement(
                    "SElECT * FROM probe"
            );
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                result += "Nume Concurs: " + rs.getString(2)+"\n";
                result += "Categorie de Varsta: " + rs.getString(3)+"\n";
            }
        }catch (SQLException ex){
            System.err.println(ex.getSQLState());
            System.err.println(ex.getErrorCode());
            System.err.println(ex.getMessage());
        }
        System.out.print(result);
    }

    @Override
    public Concurs gasesteProba(String nume, String categorie) {
        DataBaseConnection.openConnection();
        String result="";
        try{
            PreparedStatement preparedStatement = DataBaseConnection.conn.prepareStatement(
                    "SElECT * FROM probe where nume=? AND categorie=?"
            );
            preparedStatement.setString(1,nume);
            preparedStatement.setString(2,categorie);
            ResultSet rs = preparedStatement.executeQuery();
        }catch (SQLException ex){
            System.err.println(ex.getSQLState());
            System.err.println(ex.getErrorCode());
            System.err.println(ex.getMessage());
        }
        return  new Concurs(nume,categorie);
    }
}
