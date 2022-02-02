/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbmsviewer;

import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Vector;

/**
 *
 * @author ahmedsalah
 */
public class Database {

    public static final String DB_Name = "addressbook";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/"
            + DB_Name + "?characterEncoding=latin1";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String USER = "root";
    public static final String PASS = "258307aA";
    Connection con;
    Statement stmt;
    ResultSet rs;
    PreparedStatement ps;

    public Database() {
        try {
//        Connection conn = conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "258307aA");

            Class.forName(DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("select * from contact");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("INSIDE The connect function" + e);
        }
    }

    public void connect() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("select * from contact");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("INSIDE The connect function" + e);
        }
    }

    public ContactPerson firstRecord() throws SQLException {
//        connect();
        ContactPerson cp = new ContactPerson();
        try {
            if (rs.first()) {
                cp.setID(rs.getInt(1));
                cp.setName(rs.getString(2));
                cp.setNick_name(rs.getString(3));
                cp.setEmail(rs.getString(8));
                cp.setCell_phone(rs.getString(7));
            }
        } catch (SQLException e) {
            System.out.println("inside the firstRecord function " + e);
        }
//        disconnect();
        return cp;
    }

    public ContactPerson nextRecord() throws SQLException {
        ContactPerson cp = new ContactPerson();
        try {
            if (rs.next()) {
                cp.setID(rs.getInt(1));
                cp.setName(rs.getString(2));
                cp.setNick_name(rs.getString(3));
                cp.setEmail(rs.getString(8));
                cp.setCell_phone(rs.getString(7));
            } else {
                cp = this.firstRecord();
            }
        } catch (SQLException e) {
            System.out.println("inside the nextRecord function " + e);
        }
        return cp;
    }

    public ContactPerson prevRecord() throws SQLException {
//        connect();
        ContactPerson cp = new ContactPerson();
        try {
            if (rs.previous()) {
                cp.setID(rs.getInt(1));
                cp.setName(rs.getString(2));
                cp.setNick_name(rs.getString(3));
                cp.setEmail(rs.getString(8));
                cp.setCell_phone(rs.getString(7));
            } else {
                cp = this.lastRecord();
            }
        } catch (SQLException e) {
            System.out.println("inside the prevRecord function " + e);
        }
        return cp;
    }

    public ContactPerson lastRecord() throws SQLException {
        ContactPerson cp = new ContactPerson();
        try {
            if (rs.last()) {
                cp.setID(rs.getInt(1));
                cp.setName(rs.getString(2));
                cp.setNick_name(rs.getString(3));
                cp.setEmail(rs.getString(8));
                cp.setCell_phone(rs.getString(7));
            }
        } catch (SQLException e) {
            System.out.println("inside the lastRecord function " + e);
        }
        return cp;
    }

    public void addRecord(String userNameValue, String nick_nameValue, String emailValue, String phoneValue) throws SQLException {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO contact (name , nick_name , address , home_phone , work_phone , cell_phone , email , birthdate , web_site , profession) values (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, userNameValue);
            ps.setString(2, nick_nameValue);
            ps.setString(3, "0");
            ps.setString(4, phoneValue);
            ps.setString(5, phoneValue);
            ps.setString(6, phoneValue);
            ps.setString(7, emailValue);
            ps.setString(8, "1999/07/30");
            ps.setString(9, "google.com");
            ps.setString(10, "profession");
            int i = ps.executeUpdate();
            System.out.println("you insert " + i);
            disconnect();
            connect();

        } catch (SQLException e) {
            System.out.println("inside the lastRecord function " + e);
        }
        disconnect();
        connect();
    }
public void deleteRecord(int idValue) throws SQLException {
        try {
            PreparedStatement ps = con.prepareStatement("delete from contact where id =?");
            ps.setInt(1,idValue);
            int i = ps.executeUpdate();
            System.out.println("you deleted " + i);
            disconnect();
            connect();

        } catch (SQLException e) {
            System.out.println("inside the lastRecord function " + e);
        }
    }
public void updateRecord(int idValue,String userNameValue, String nick_nameValue, String emailValue, String phoneValue) throws SQLException {
        try {
            PreparedStatement ps = con.prepareStatement("update contact set name =?, nick_name =? , address =?, home_phone =?, work_phone =?, cell_phone =?, email =?, birthdate =?, web_site =?, profession=? where id =?");
            ps.setString(1, userNameValue);
            ps.setString(2, nick_nameValue);
            ps.setString(3, "0");
            ps.setString(4, phoneValue);
            ps.setString(5, phoneValue);
            ps.setString(6, phoneValue);
            ps.setString(7, emailValue);
            ps.setString(8, "1999/07/30");
            ps.setString(9, "google.com");
            ps.setString(10, "profession");
            ps.setInt(11, idValue);
            int i = ps.executeUpdate();
            System.out.println("you updated " + i);
            disconnect();
            connect();

        } catch (SQLException e) {
            System.out.println("inside the lastRecord function " + e);
        }
        disconnect();
        connect();
    }
    public void disconnect() throws SQLException {
        con.close();
    }
}
