package Logica;

import Conexion.conexion;
import Datos.clsImplementos;
import Datos.clsServicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fServicios {

    ImageIcon iconoExito = new ImageIcon("src/main/resources/guardar32x32.png"); // Reemplaza con la ruta de tu archivo de imagen
    private conexion conexion = new conexion();
    private Connection connection = conexion.conectar();
    private String sSQL = "";
    public int totalregistros = 0;

    public DefaultTableModel mostrar(String buscar, String criterioBusqueda, String criterioOrden, String orden) {
        DefaultTableModel modelo;
        String[] titulos = {"Id", "fkPlanilla", "Nombre", "Descripcion", "Fecha", "Estado",
            "Tipo", "Valor"};
        String[] registros = new String[8];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "Select servicios.id,servicios.fkPlanilla,servicios.Nombre,servicios.Descripcion,servicios.Fecha,servicios.Estado,"
                + "servicios.Tipo,servicios.Valor"
                + "  from servicios  where  " + criterioBusqueda
                + " like '%" + buscar + "%' order by " + criterioOrden + " " + orden + ";";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("fkPlanilla");
                registros[2] = rs.getString("fkNombre");
                registros[3] = rs.getString("Descripcion");
                registros[4] = rs.getString("Fecha");
                registros[5] = rs.getString("Estado");
                registros[6] = rs.getString("Tipo");
                registros[7] = rs.getString("Valor");
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

    public DefaultTableModel mostrarServiciosPlanilla(String buscar, String criterioBusqueda, String criterioOrden, String orden, int idPlanilla) {
        DefaultTableModel modelo;
        String[] titulos = {"Id", "fkPlanilla", "Nombre", "Descripcion", "Fecha", "Estado",
            "Tipo", "Valor"};
        String[] registros = new String[8];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "Select servicios.id,servicios.fkPlanilla,servicios.Nombre,servicios.Descripcion,servicios.Fecha,servicios.Estado,"
                + "servicios.Tipo,servicios.Valor"
                + "  from servicios  where  " + criterioBusqueda
                + " like '%" + buscar + "%' and servicios.fkPlanilla=" + idPlanilla + " order by " + criterioOrden + " " + orden + ";";
        try {
            System.out.println(sSQL);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("fkPlanilla");
                registros[2] = rs.getString("Nombre");
                registros[3] = rs.getString("Descripcion");
                registros[4] = rs.getString("Fecha");
                registros[5] = rs.getString("Estado");
                registros[6] = rs.getString("Tipo");
                registros[7] = rs.getString("Valor");
                modelo.addRow(registros);
                totalregistros += 1;

            }
            JOptionPane.showMessageDialog(null, "La acción se ha realizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE, iconoExito);
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return null;
    }

    public boolean insertar(clsServicios servicio) {
        sSQL = "Insert into servicios (Nombre,Descripcion,Fecha,"
                + "Estado,Tipo,Valor,fkPlanilla) values(?,?,?,?,?,?,?);";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setString(1, servicio.getNombre());
            pst.setString(2, servicio.getDescripcion());
            pst.setDate(3, servicio.getFecha());
            pst.setString(4, servicio.getEstado());
            pst.setString(5, servicio.getTipo());
            pst.setDouble(6, servicio.getValor());
            pst.setInt(7, servicio.getFkPlanilla());
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

    public boolean editar(clsServicios servicio) {
        sSQL = "Update servicios set Nombre=?,Descripcion=?,Fecha=?,Estado=?,"
                + "Tipo=?,Valor=?,fkPlanilla=? where servicios.id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setString(1, servicio.getNombre());
            pst.setString(2, servicio.getDescripcion());
            pst.setDate(3, servicio.getFecha());
            pst.setString(4, servicio.getEstado());
            pst.setString(5, servicio.getTipo());
            pst.setDouble(6, servicio.getValor());
            pst.setInt(7, servicio.getFkPlanilla());
            pst.setInt(8, servicio.getId());
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

    public boolean eliminar(clsServicios servicio) {
        sSQL = "Delete from servicios where servicios.id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setInt(1, servicio.getId());
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
