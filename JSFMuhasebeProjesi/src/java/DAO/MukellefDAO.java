/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entity.Mukellef;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class MukellefDAO extends Util.DBConnection {
    // CRUD islemleri
    public void mukellefOlustur(Mukellef m) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into kullanici_tablosu (kullanici_adi,kullanici_parola,kullanici_borc) values ('" + m.getMukellefKullaniciAdi() + "','" + m.getMukellefParola() + "','" + m.getMukellefBorc() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void mukellefSil(Mukellef m) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from kullanici_tablosu where kullanici_id=" + m.getMukellefID());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void mukellefGuncelle(Mukellef m) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update kullanici_tablosu set kullanici_adi='" + m.getMukellefKullaniciAdi() + "',kullanici_parola='" + m.getMukellefParola() + "' where kullanici_id=" + m.getMukellefID());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void mukellefBorcBilgisiGuncelle(Mukellef m) {
        try {
            Statement st = this.connect().createStatement();
            int kalan = m.getMukellefBorc() - m.getMukellefOdeme();
            st.executeUpdate("update kullanici_tablosu set kullanici_borc=" + /*Integer.toString(kalan)*/ kalan + " where kullanici_id=" + m.getMukellefID());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<Mukellef> mukellefRead() {
        List<Mukellef> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanici_tablosu order by kullanici_id asc");
            while (rs.next()) {
                Mukellef temp = new Mukellef(rs.getInt("kullanici_id"), rs.getString("kullanici_adi"), rs.getString("kullanici_parola"), rs.getInt("kullanici_borc"));
                list.add(temp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    
    // sadece bir mukellef
    public List<Mukellef> mukellefReadPayment() {
        List<Mukellef> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            /*
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanici_tablosu where kullanici_adi=" + LoginJSF.SessionUtils.getUserName());
            while (rs.next()) {
                Mukellef temp = new Mukellef(rs.getInt("kullanici_id"), rs.getString("kullanici_adi"), rs.getString("kullanici_parola"), rs.getInt("kullanici_borc"));
                list.add(temp);
            }
                    */
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vt_muhasebe", "root", "");
            preparedStatement = connection.prepareStatement("select * from kullanici_tablosu where kullanici_adi=?");
            preparedStatement.setString(1, LoginJSF.SessionUtils.getUserName());
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            
            Mukellef temp = new Mukellef(resultSet.getInt("kullanici_id"), resultSet.getString("kullanici_adi"), resultSet.getString("kullanici_parola"), resultSet.getInt("kullanici_borc"));
            list.add(temp);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
}
