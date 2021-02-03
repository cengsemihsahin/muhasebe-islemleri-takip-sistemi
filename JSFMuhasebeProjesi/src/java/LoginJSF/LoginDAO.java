/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LoginJSF;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 * DAO (data access paket)
 */
public class LoginDAO {
    public static boolean validate(String user, String password, int tip) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
                con = DataConnect.getConnection();
                if (tip == 1) {
                    ps = con.prepareStatement("Select kullanici_adi, kullanici_parola from admin_tablosu where kullanici_adi = ? and kullanici_parola = ?");
                }
                else if (tip == 2) {
                    ps = con.prepareStatement("Select kullanici_adi, kullanici_parola from kullanici_tablosu where kullanici_adi = ? and kullanici_parola = ?");
                }
                
                ps.setString(1, user);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                        // bulundu
                        return true;
                }
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                return false;
        } finally {
                DataConnect.close(con);
        }
        return false;
    }
}
