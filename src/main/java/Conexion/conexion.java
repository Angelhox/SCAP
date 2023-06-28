/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author USE
 */
public class conexion {

    public String db = "bdscapstdop1";
    public String url = "jdbc:mysql://localhost:3309/" + db;
    public String user = "root";
    public String pass = "root";

    public conexion() {

    }

    public Connection conectar() {
        Connection link = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            link = (Connection) DriverManager.getConnection(this.url, this.user, this.pass);
            System.out.println("Conectados ala base publica");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            System.out.println("no conectados: " + e);
        }
        return link;
    }

    public static void main(String[] args) {
        conexion c = new conexion();
        c.conectar();
    }
}
