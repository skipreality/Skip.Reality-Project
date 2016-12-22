/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skip.reality.project.sw;

import java.sql.*;
import javax.swing.*;
/**
 *
 * @author DesTrUcTioN
 */
public class MysqlConnect{
    
    Connection connect = null;
    public static Connection ConnectDB(){
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","");
            JOptionPane.showMessageDialog(null,"Connection Please Wait.. Or Press OK");
            
            return connect;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"e");
            
            return null;
        }
        
        
        
    }
    
}
