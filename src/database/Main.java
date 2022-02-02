/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author muham
 */
public class Main extends Application {
    ContactBrowser cb;
    public static  void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
         cb = new ContactBrowser();
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public void stop() throws SQLException{
        cb.db.disconnect();
    }
}
