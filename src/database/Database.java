/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/**
 *
 * @author muham
 */
public class Database {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/"
            + "addressbook?characterEncoding=latin1";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String USER = "root";
    public static final String PASS = "12345";
    Connection con;
    Statement  stmt;
    ResultSet rs;
    
    public Database(){
        try{
            Class.forName(DRIVER);
            con=DriverManager.getConnection(DB_URL,USER,PASS); 
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("select * from contact");
        }catch(ClassNotFoundException | SQLException e)
        { System.out.println("INSIDE The connect function"+e);}
    }
    public void connect() {
         try{
            Class.forName(DRIVER);
            con=DriverManager.getConnection(DB_URL,USER,PASS); 
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("select * from contact");
        }catch(ClassNotFoundException | SQLException e)
        { System.out.println("INSIDE The connect function"+e);}
    }   
    public ContactPerson firstRecord() throws SQLException{
//        connect();
        ContactPerson cp = new ContactPerson();
        try{
            if(rs.first()){
                cp.setID(rs.getInt(1));
                cp.setName(rs.getString(2));
                cp.setNick_name(rs.getString(3));
                cp.setEmail(rs.getString(8));
                cp.setCell_phone(rs.getString(7));
            }
        }catch(SQLException e){
            System.out.println("inside the firstRecord function "+e);
        }
//        disconnect();
        return cp;
    }
    public ContactPerson nextRecord() throws SQLException{
//        connect();
        ContactPerson cp = new ContactPerson();
        try{
            if(rs.next()){
                cp.setID(rs.getInt(1));
                cp.setName(rs.getString(2));
                cp.setNick_name(rs.getString(3));
                cp.setEmail(rs.getString(8));
                cp.setCell_phone(rs.getString(7));
            }else{
                cp=this.firstRecord();
            }
        }catch(SQLException e){
            System.out.println("inside the nextRecord function "+e);
        }
//        disconnect();
        return cp;  
    }    
    public ContactPerson prevRecord() throws SQLException{
//        connect();
        ContactPerson cp = new ContactPerson();
        try{
            if(rs.previous()){
                cp.setID(rs.getInt(1));
                cp.setName(rs.getString(2));
                cp.setNick_name(rs.getString(3));
                cp.setEmail(rs.getString(8));
                cp.setCell_phone(rs.getString(7));
            }else{
                cp=this.lastRecord();
            }
        }catch(SQLException e){
            System.out.println("inside the prevRecord function "+e);
        }
//        disconnect();
        return cp;  
    }
    public ContactPerson lastRecord() throws SQLException{
//        connect();
        ContactPerson cp = new ContactPerson();
        try{
            if(rs.last()){
                cp.setID(rs.getInt(1));
                cp.setName(rs.getString(2));
                cp.setNick_name(rs.getString(3));
                cp.setEmail(rs.getString(8));
                cp.setCell_phone(rs.getString(7));
            }
        }catch(SQLException e){
            System.out.println("inside the lastRecord function "+e);
        }
//        disconnect();
        return cp;  
    }
    public void disconnect() throws SQLException{
        con.close();
    }
    
//    public ContactPerson[] getContacts(){
//        ContactPerson[] CPlist=null;
//        ContactPerson cp = new ContactPerson();
//        try{
//            int i=0;
//            connect();
//            stmt = con.createStatement();
//            ResultSet rs=stmt.executeQuery("select * from contact");  
//            while(rs.next())
//            {
//                cp.setID(rs.getInt(1));
////                System.out.println(cp.getID());
//                cp.setName(rs.getString(2));
//                cp.setNick_name(rs.getString(3));
//                cp.setEmail(rs.getString(8));
//                cp.setCell_phone(rs.getString(7));
//                CPlist[i]=cp;
//                System.out.println("+++++"+CPlist[i].getID());
//                i++;
//            }
//            for(i=0;i<CPlist.length;i++)
//                System.out.println("outside while"+CPlist[i].getID());
//            con.close();
//        }catch(SQLException e)
//        { 
//            System.out.println("INSIDE The getContacts function"+e);
//        }
//        for(int i=0;i<CPlist.length;i++)
//                System.out.println("-++-"+CPlist[i].getID());
//        return CPlist;
//    }
    
//    public List<ContactPerson> getContactsForName(String name){
//        List<ContactPerson> CPlist = new ArrayList<ContactPerson>();
//        ContactPerson cp = new ContactPerson();
//        try{
//            connect();
//            stmt = con.createStatement();
//            ResultSet rs=stmt.executeQuery("select * from contact where name ="+name);
//            while(rs.next()){
//                cp.setID(rs.getInt(1));
//                cp.setName(rs.getString(2));
//                cp.setNick_name(rs.getString(3));
//                cp.setEmail(rs.getString(8));
//                cp.setCell_phone(rs.getString(7));
//                CPlist.add(cp);
//            }
//            con.close();
//        }catch(SQLException e){
//            System.out.println("INSIDE The getContactsForName function"+e);
//        }
//        return null;
//    }
//    
//    private ContactPerson createContactPerson(ResultSet rs){
//        
//        return null;
//        
//    }
}
