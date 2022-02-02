/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbmsviewer;

/**
 *
 * @author ahmedsalah
 */
public class ContactPerson {

    private int ID;
    private String name;
    private String nick_name;
    private String address;
    private String home_phone;
    private String cell_phone;
    private String email;
    private String birthdate;
    private String web_site;
    private String profession;

    public ContactPerson() {
        name = "";
        nick_name = "";
        address = "";
        home_phone = "";
        cell_phone = "";
        email = "";
        birthdate = "";
        web_site = "";
        profession = "";
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
    }

    public void setCell_phone(String cell_phone) {
        this.cell_phone = cell_phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setWeb_site(String web_site) {
        this.web_site = web_site;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public String getAddress() {
        return address;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public String getCell_phone() {
        return cell_phone;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getWeb_site() {
        return web_site;
    }

    public String getProfession() {
        return profession;
    }
}
