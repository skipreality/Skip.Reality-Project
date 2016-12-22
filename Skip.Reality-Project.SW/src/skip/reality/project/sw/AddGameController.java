/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skip.reality.project.sw;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DesTrUcTioN
 */
public class AddGameController{
    

    public void addgame(String namee, String idd, String typee, String descc){
        
        AddGameModel db_addgame = new AddGameModel();
        db_addgame.addgame_DB(namee,idd,typee,descc);
    }
    
        public ArrayList<String> retgames() throws SQLException{
        ArrayList<String> arrgame = new ArrayList<>();
        AddGameModel db_retgames = new AddGameModel();
        arrgame = db_retgames.retgame_DB();
        return arrgame;
    }
    
}
