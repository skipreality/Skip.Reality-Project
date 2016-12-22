/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skip.reality.project.sw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DesTrUcTioN
 */
public class AddGameModel{
    
        public void TheQueryGame(String query){
        Connection connect = null;
        Statement st = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","");
            JOptionPane.showMessageDialog(null,"Connection Please Wait.. Or Press OK");
            st = connect.createStatement();
            st.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Game Has Been Added");

        }catch (Exception exc){
            JOptionPane.showMessageDialog(null,"Error While Trying To Add The Game");
        }
    }
    
        
        public ArrayList<String> search(String query, String gname) throws SQLException{
        ArrayList<String> result = new ArrayList<>(); 
        String returnresult = "";
        Connection con = null;
        Statement st = null;
        ResultSet res = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","");
            st = con.createStatement();
            res = st.executeQuery(query);
            
            while (res.next()){
                returnresult = res.getString(gname);
                result.add(returnresult);
            }
            
        } catch (Exception exc){
            JOptionPane.showMessageDialog(null, exc.getMessage());
         
        }
        
        return result;
    }   
        
        public void addgame_DB(String nameg,String idg,String typeg,String descg){
        TheQueryGame("INSERT INTO game (Gname,Gid,Gtype,Gdesc) VALUES ('" + nameg + "','" + idg + "','" + typeg + "','" + descg + "');");
    }
        public ArrayList<String> retgame_DB() throws SQLException{
        ArrayList<String> Return_Query_Result = new ArrayList<>();
        Return_Query_Result= search("SELECT * FROM game","Gname");
        return Return_Query_Result;
    }
    
}
