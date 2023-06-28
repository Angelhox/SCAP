
package Logica;

import Conexion.conexion;
import Datos.clsEmpleados;
import Datos.clsParametros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fParametros {
      ImageIcon iconoExito = new ImageIcon("src/main/resources/guardar32x32.png"); // Reemplaza con la ruta de tu archivo de imagen
    private conexion conexion = new conexion();
    private Connection connection = conexion.conectar();
    private String sSQL = "";
    public int totalregistros = 0;

    public DefaultTableModel mostrar(String buscar, String criterioBusqueda, String criterioOrden, String orden) {
        DefaultTableModel modelo;
        String[] titulos = {"Id", "Nombre", "Valor"};
        String[] registros = new String[3];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "Select parametros.id,parametros.Nombre,parametros.valor "
                + "  from parametros  where  " + criterioBusqueda
                + " like '%" + buscar + "%' order by " + criterioOrden + " " + orden + ";";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("Nombre");
                registros[2] = rs.getString("Valor");
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

    public boolean insertar(clsParametros parametro) {
        sSQL = "Insert into parametros (Nombre,Valor) values(?,?);";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setString(1, parametro.getNombre());
            pst.setDouble(2, parametro.getValor());
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

    public boolean editar(clsParametros parametro) {
        sSQL = "Update parametros set Nombre=?,Valor=?  where parametros.id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setString(1, parametro.getNombre());
            pst.setDouble(2, parametro.getValor());
            pst.setInt(3,parametro.getId());
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

    public boolean eliminar(clsParametros parametro) {
        sSQL = "Delete from parametros where parametros.id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setInt(1, parametro.getId());
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
