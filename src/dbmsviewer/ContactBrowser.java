/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbmsviewer;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ahmedsalah
 */
public class ContactBrowser {

    ContactPerson cp = new ContactPerson();
    Database db = new Database();

    public ContactBrowser() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("DBMS");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        Text scenetitle = new Text("Contact Details");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label ID = new Label("ID:");
        grid.add(ID, 0, 1);

        TextField IDTextField = new TextField();
        grid.add(IDTextField, 3, 1);
        IDTextField.setDisable(true);

        Label userName = new Label("First Name:");
        grid.add(userName, 0, 2);

        TextField userTextField = new TextField();
        grid.add(userTextField, 3, 2);

        Label nn = new Label("Nickname:");
        grid.add(nn, 0, 3);

        TextField nicl_nameTextField = new TextField();
        grid.add(nicl_nameTextField, 3, 3);

        Label emaillb = new Label("Email:");
        grid.add(emaillb, 0, 4);

        TextField emailtf = new TextField();
        grid.add(emailtf, 3, 4);

        Label phonelb = new Label("Phone:");
        grid.add(phonelb, 0, 5);

        TextField phonetf = new TextField();
        grid.add(phonetf, 3, 5);

        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");
        Button updateButton = new Button("Update");
        Button firstButton = new Button("First");

        Button nextButton = new Button("Next");
        Button prevButton = new Button("Prev");
        Button lastButton = new Button("Last");

        HBox first = new HBox(10);
        first.setAlignment(Pos.BOTTOM_LEFT);
        first.getChildren().add(firstButton);
        grid.add(first, 0, 6);

        HBox next = new HBox(10);
        next.setAlignment(Pos.BOTTOM_LEFT);
        next.getChildren().add(nextButton);
        grid.add(next, 1, 6);

        HBox pre = new HBox(10);
        pre.setAlignment(Pos.BOTTOM_LEFT);
        pre.getChildren().add(prevButton);
        grid.add(pre, 2, 6);

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(lastButton);
        grid.add(hbBtn, 3, 6);
//addButton
        HBox AddBtn = new HBox(10);
        AddBtn.setAlignment(Pos.BOTTOM_LEFT);
        AddBtn.getChildren().add(addButton);
        grid.add(AddBtn, 4, 6);

        HBox deleteBtn = new HBox(10);
        deleteBtn.setAlignment(Pos.BOTTOM_LEFT);
        deleteBtn.getChildren().add(deleteButton);
        grid.add(deleteBtn, 5, 6);
//updateButton

        HBox updateBtn = new HBox(10);
        updateBtn.setAlignment(Pos.BOTTOM_LEFT);
        updateBtn.getChildren().add(updateButton);
        grid.add(updateBtn, 6, 6);

        firstButton.setOnAction((ae) -> {
            try {
                cp = db.firstRecord();
                IDTextField.setText(String.valueOf(cp.getID()));
                userTextField.setText(cp.getName());
                nicl_nameTextField.setText(cp.getNick_name());
                emailtf.setText(cp.getEmail());
                phonetf.setText(cp.getCell_phone());
            } catch (SQLException ex) {
                Logger.getLogger(ContactBrowser.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        nextButton.setOnAction((ae) -> {
            try {
                cp = db.nextRecord();
                IDTextField.setText(String.valueOf(cp.getID()));
                userTextField.setText(cp.getName());
                nicl_nameTextField.setText(cp.getNick_name());
                emailtf.setText(cp.getEmail());
                phonetf.setText(cp.getCell_phone());
            } catch (SQLException ex) {
                Logger.getLogger(ContactBrowser.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        prevButton.setOnAction((ae) -> {
            try {
                cp = db.prevRecord();
                IDTextField.setText(String.valueOf(cp.getID()));
                userTextField.setText(cp.getName());
                nicl_nameTextField.setText(cp.getNick_name());
                emailtf.setText(cp.getEmail());
                phonetf.setText(cp.getCell_phone());
            } catch (SQLException ex) {
                Logger.getLogger(ContactBrowser.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        lastButton.setOnAction((ae) -> {
            try {
                cp = db.lastRecord();
                IDTextField.setText(String.valueOf(cp.getID()));
                userTextField.setText(cp.getName());
                nicl_nameTextField.setText(cp.getNick_name());
                emailtf.setText(cp.getEmail());
                phonetf.setText(cp.getCell_phone());
            } catch (SQLException ex) {
                Logger.getLogger(ContactBrowser.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
//addButton
        addButton.setOnAction((ae) -> {
            try {
                String userNameValue = userTextField.getText();
                String nick_nameValue = nicl_nameTextField.getText();
                String emailValue = emailtf.getText();
                String phoneValue = phonetf.getText();
                db.addRecord(userNameValue, nick_nameValue, emailValue, phoneValue);
            } catch (SQLException ex) {
                Logger.getLogger(ContactBrowser.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        deleteButton.setOnAction((ae) -> {
            try {
                if (!IDTextField.getText().equals("")) {
                    int idValue = Integer.parseInt(IDTextField.getText());
                    db.deleteRecord(idValue);
                } else {
                    System.out.println("enter value please");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ContactBrowser.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        updateButton.setOnAction((ae) -> {
            try {
                if (!IDTextField.getText().equals("")) {
                    int idValue = Integer.parseInt(IDTextField.getText());
                    String userNameValue = userTextField.getText();
                    String nick_nameValue = nicl_nameTextField.getText();
                    String emailValue = emailtf.getText();
                    String phoneValue = phonetf.getText();
                    db.updateRecord(idValue, userNameValue, nick_nameValue, emailValue, phoneValue);
                } else {
                    System.out.println("enter value please");
                }

            } catch (SQLException ex) {
                Logger.getLogger(ContactBrowser.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Scene scene = new Scene(grid, 1000, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
