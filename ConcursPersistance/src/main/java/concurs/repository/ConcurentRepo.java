package concurs.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConcurentRepo implements IConcurentRepo {
    @Override
    public String showAllConcurentNames(){
        DataBaseConnection.openConnection();
        String result="";
        try{
            PreparedStatement preparedStatement = DataBaseConnection.conn.prepareStatement(
                    "SElECT * FROM concurs"
            );
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                result += "\n: " + rs.getString(2) +"\n";
            }
        }catch (SQLException ex){
            System.err.println(ex.getSQLState());
            System.err.println(ex.getErrorCode());
            System.err.println(ex.getMessage());
        }
        return result;

    }

    public String countDesen(){
        DataBaseConnection.openConnection();
        String result="";
        try{
            PreparedStatement preparedStatement = DataBaseConnection.conn.prepareStatement(
                    "SElECT Count(*) FROM concurs WHERE `numeProba`='desen'"
            );
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                result +=  rs.getString(1) ;
            }
        }catch (SQLException ex){
            System.err.println(ex.getSQLState());
            System.err.println(ex.getErrorCode());
            System.err.println(ex.getMessage());
        }
        System.out.print("REPO_TEST"+result);
        return result;

    }


    public String countPoezie(){
        DataBaseConnection.openConnection();
        String result="";
        try{
            PreparedStatement preparedStatement = DataBaseConnection.conn.prepareStatement(
                    "SElECT Count(*) FROM concurs WHERE `numeProba`='poezie'"
            );
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                result +=  rs.getString(1) ;
            }
        }catch (SQLException ex){
            System.err.println(ex.getSQLState());
            System.err.println(ex.getErrorCode());
            System.err.println(ex.getMessage());
        }
        System.out.print("REPO_TEST"+result);
        return result;

    }


    public String countComori(){
        DataBaseConnection.openConnection();
        String result="";
        try{
            PreparedStatement preparedStatement = DataBaseConnection.conn.prepareStatement(
                    "SElECT Count(*) FROM concurs WHERE `numeProba`='comori'"
            );
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                result +=  rs.getString(1) ;
            }
        }catch (SQLException ex){
            System.err.println(ex.getSQLState());
            System.err.println(ex.getErrorCode());
            System.err.println(ex.getMessage());
        }
        System.out.print("REPO_TEST"+result);
        return result;

    }

    @Override
    public String showAllCompetitors() {
        DataBaseConnection.openConnection();
        String result="";
        try{
            PreparedStatement preparedStatement = DataBaseConnection.conn.prepareStatement(
                    "SElECT * FROM concurs"
            );
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                result += "\nNume Concurent: " + rs.getString(2) +
                        "\nCategorie Varsta: " + rs.getString(3) +
                        "\nNume Concurs: " + rs.getString(4)+
                "\n----------------------------------";
            }
        }catch (SQLException ex){
            System.err.println(ex.getSQLState());
            System.err.println(ex.getErrorCode());
            System.err.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public String searchCompetitorByConcurs(String numeConcurs) {
        DataBaseConnection.openConnection();
        String result="";
        try {
            PreparedStatement preparedStatement = DataBaseConnection.conn.prepareStatement(
                    "SElECT * FROM concurs WHERE NumeProba=?"
            );
            preparedStatement.setString(1, numeConcurs);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result += "\nNume Concurent: " + rs.getString(2) +
                        "\nCategorie Varsta: " + rs.getString(3) +
                        "\nNume Concurs: " + rs.getString(4);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState());
            System.err.println(ex.getErrorCode());
            System.err.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public String searchCompetitorByName(String nume) {
        DataBaseConnection.openConnection();
        String result="";
        try{
            PreparedStatement preparedStatement = DataBaseConnection.conn.prepareStatement(
                    "SElECT * FROM concurs WHERE NumeConcurent=?"
            );
            preparedStatement.setString(1,nume);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                result += "Nume Concurent: " + rs.getString(2) +
                        "\nCategorie Varsta: " + rs.getString(3) +
                        "\nNume Concurs: " + rs.getString(4) ;
            }
        }catch (SQLException ex){
            System.err.println(ex.getSQLState());
            System.err.println(ex.getErrorCode());
            System.err.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public String searchCompetitorByVarstaCategory(String varstaCategory) {
        DataBaseConnection.openConnection();
        String result="";
        try{
            PreparedStatement preparedStatement = DataBaseConnection.conn.prepareStatement(
                    "SElECT * FROM concurs WHERE CategorieVarsta=?"
            );
            preparedStatement.setString(1,varstaCategory);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                result += "Nume Concurent: " + rs.getString(2) +
                        "\nCategorie Varsta: " + rs.getString(3) +
                        "\nNume Concurs: " + rs.getString(4) +
                "\n--------------------------------------------";
            }
        }catch (SQLException ex){
            System.err.println(ex.getSQLState());
            System.err.println(ex.getErrorCode());
            System.err.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public void addConcurent(String numeConcurent, String  nameProba,int age) {
        DataBaseConnection.openConnection();
        String result="";
        String categorie="";
        if((age>=6)&&(age<=8)){
            categorie="6-8";
        }else if((age>=9)&&(age<=11)){
            categorie="9-11";
        }else if((age>=12)&&(age<=15)){
            categorie="12-15";
        }else System.out.println("Invalid Age");

        try{
            PreparedStatement preparedStatement = DataBaseConnection.conn.prepareStatement(
                    "INSERT INTO `lab2`.`concurs` (`NumeConcurent`, `CategorieVarsta`, `NumeProba`) VALUES (?,?,?);\n"
            );
            preparedStatement.setString(1,numeConcurent);
            preparedStatement.setString(2,categorie);
            preparedStatement.setString(3,nameProba);
            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement1 = DataBaseConnection.conn.prepareStatement(
                    "INSERT INTO concurent (name, age) VALUES (?,?)"
            );
            preparedStatement1.setString(1,numeConcurent);
            preparedStatement1.setString(2,Integer.toString(age));
            preparedStatement1.executeUpdate();

        }catch (SQLException ex) {
            System.err.println(ex.getSQLState());
            System.err.println(ex.getErrorCode());
            System.err.println(ex.getMessage());
        }
    }
}
