/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojdbcmysql;
import java.sql.*;
/**
 * This is a demo application of operation on MySQL server through JDBC connector.
 * @author Myles
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
        Statement stm=con.createStatement();
        String sql_openDatabase="Use MyCigar";
        String sql_selectTable="Select * from Tcigar;";
        ResultSet result;
        result=stm.executeQuery(sql_openDatabase);
        result=stm.executeQuery(sql_selectTable);
        while (result.next()){
            System.out.println(result.getString("name"));
        }    
        result.close();
        stm.close();
        con.close();
    }
    
}
