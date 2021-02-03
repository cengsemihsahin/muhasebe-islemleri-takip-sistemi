/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ASUS
 */
public abstract class DBConnection {
    private Connection connection;
    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vt_muhasebe", "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return this.connection;
    }
}
