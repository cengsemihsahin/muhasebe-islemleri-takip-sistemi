/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class Mukellef /*extends Util.DBConnection*/ {
    private int mukellefID;
    private String mukellefKullaniciAdi;
    private String mukellefParola;
    private int mukellefBorc;
    private int mukellefOdeme;
    
    public Mukellef() {
    }

    public Mukellef(int mukellefID, String mukellefKullaniciAdi, String mukellefParola, int mukellefBorc, int mukellefOdeme) {
        this.mukellefID = mukellefID;
        this.mukellefKullaniciAdi = mukellefKullaniciAdi;
        this.mukellefParola = mukellefParola;
        this.mukellefBorc = mukellefBorc;
        this.mukellefOdeme = mukellefOdeme;
    }

    public Mukellef(int mukellefID, String mukellefKullaniciAdi, String mukellefParola, int mukellefBorc) {
        this.mukellefID = mukellefID;
        this.mukellefKullaniciAdi = mukellefKullaniciAdi;
        this.mukellefParola = mukellefParola;
        this.mukellefBorc = mukellefBorc;
    }

    //borcu yok
    /*
    public Mukellef(int mukellefID, String mukellefKullaniciAdi, String mukellefParola) {
        this.mukellefID = mukellefID;
        this.mukellefKullaniciAdi = mukellefKullaniciAdi;
        this.mukellefParola = mukellefParola;
    }
    */
    
    public int getMukellefOdeme() {
        return mukellefOdeme;
    }

    public void setMukellefOdeme(int mukellefOdeme) {
        this.mukellefOdeme = mukellefOdeme;
    }

    public int getMukellefBorc() {
        return mukellefBorc;
    }

    public void setMukellefBorc(int mukellefBorc) {
        this.mukellefBorc = mukellefBorc;
    }

    public int getMukellefID() {
        return mukellefID;
    }

    public void setMukellefID(int mukellefID) {
        this.mukellefID = mukellefID;
    }

    public String getMukellefKullaniciAdi() {
        return mukellefKullaniciAdi;
    }

    public void setMukellefKullaniciAdi(String mukellefKullaniciAdi) {
        this.mukellefKullaniciAdi = mukellefKullaniciAdi;
    }

    public String getMukellefParola() {
        return mukellefParola;
    }

    public void setMukellefParola(String mukellefParola) {
        this.mukellefParola = mukellefParola;
    }
    
    public /*String*/ int mukellefBorcGoster() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
       // System.out.println(LoginJSF.SessionUtils.getUserName());
        try {
            //Statement st = this.connect().createStatement();
            //ResultSet rs = st.executeQuery("select kullanici_borc from kullanici_tablosu where kullanici_adi='" + LoginJSF.SessionUtils.getUserName() + "'"); //" + LoginJSF.SessionUtils.getUserName()+ "
            
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vt_muhasebe", "root", "");
            preparedStatement = connection.prepareStatement("select kullanici_borc from kullanici_tablosu where kullanici_adi=?");
            preparedStatement.setString(1, LoginJSF.SessionUtils.getUserName());
            resultSet = preparedStatement.executeQuery();
            //System.out.println(resultSet.getInt("kullanici_borc"));
            resultSet.next(); // bos olmamasina dikkat et (borc bulunmamaktadir)
            
            
            //return 0;
            return resultSet.getInt("kullanici_borc");
            //return LoginJSF.SessionUtils.getUserName();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
            //return "BOS";
        }
    }
    
    
    
}
