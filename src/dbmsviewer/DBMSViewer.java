/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dbmsviewer;

//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author ahmedsalah
 */
public class DBMSViewer extends Application {

    /**
     * @param args the command line arguments
     */
    ContactBrowser cb;
    public static final String DB_Name ="addressbook";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/"+DB_Name+"?characterEncoding=latin1";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String USER = "root";
    public static final String PASS = "258307aA";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        cb = new ContactBrowser();
    }

    @Override
    public void stop() throws SQLException {
        cb.db.disconnect();
    }

//public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection conn = conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "258307aA");
//        System.out.println("Sucess....");
//    }
}
