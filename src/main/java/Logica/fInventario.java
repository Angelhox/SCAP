
package Logica;

import Conexion.conexion;
import Datos.clsInventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class fInventario {


    ImageIcon iconoExito = new ImageIcon("src/main/resources/guardar32x32.png"); // Reemplaza con la ruta de tu archivo de imagen
    private conexion conexion = new conexion();
    private Connection connection = conexion.conectar();
    private String sSQL = "";
    public int totalregistros = 0;

    public DefaultTableModel mostrar(String buscar, String criterioBusqueda, String criterioOrden, String orden) {
        DefaultTableModel modelo;
        String[] titulos = {"Id", "Fecha", "Estado,Nombre"};
        String[] registros = new String[3];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "Select inventario.id,inventario.Fecha,inventario.Estado,inventario.Nombre "
                + "  from inventario  where  " + criterioBusqueda
                + " like '%" + buscar + "%' order by " + criterioOrden + " " + orden + ";";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("Fecha");
                registros[2] = rs.getString("Estado");       
                registros[3] = rs.getString("Inventario");       
                totalregistros += 1;
                modelo.addRow(registros);
            }
            JOptionPane.showMessageDialog(null, "La acción se ha realizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE, iconoExito);
return modelo;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return null;
    }

    public boolean insertar(clsInventario inventario) {
        sSQL = "Insert into inventario (Fecha,Estado,Nombre) values(?,?,?);";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setDate(1, inventario.getFecha());
            pst.setString(2, inventario.getEstado());
            pst.setString(3, inventario.getNombre());
            int n = pst.executeUpdate();
            if (n != 0) {
                JOptionPane.showMessageDialog(null, "La acción se ha realizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE, iconoExito);
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return false;
    }

    public boolean editar(clsInventario inventario) {
        sSQL = "Update inventario set Fecha=?,Estado=?,Nombre=? where inventario.id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setDate(1, inventario.getFecha());
            pst.setString(2, inventario.getEstado());
            pst.setString(3, inventario.getNombre());
            pst.setInt(4,inventario.getId());
            int n = pst.executeUpdate();
            if (n != 0) {
                JOptionPane.showMessageDialog(null, "La acción se ha realizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE, iconoExito);
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return false;
    }

    public boolean eliminar(clsInventario inventario) {
        sSQL = "Delete from inventario where inventario.id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setInt(1, inventario.getId());
            int n = pst.executeUpdate();
            if (n != 0) {
                JOptionPane.showMessageDialog(null, "La acción se ha realizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE, iconoExito);
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return false;
    }
}

