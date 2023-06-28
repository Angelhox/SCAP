package Logica;

import Conexion.conexion;
import Datos.clsPlanilla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fPlanilla {

    ImageIcon iconoExito = new ImageIcon("src/main/resources/guardar32x32.png"); // Reemplaza con la ruta de tu archivo de imagen
    private conexion conexion = new conexion();
    private Connection connection = conexion.conectar();
    private String sSQL = "";
    public int totalregistros = 0;

    public DefaultTableModel mostrar(String buscar, String criterioBusqueda, String criterioOrden, String orden) {
        DefaultTableModel modelo;
        String[] titulos = {"Id", "fkMedidores", "fkParametros", "Codigo", "Fecha", "Estado", "Lectura Anterior",
            "Lectura Actual", "Valor", "Observación"};
        String[] registros = new String[10];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "Select planilla.id,planilla.fkMedidores,planilla.fkParametros,planilla.Codigo,planilla.Fecha,planilla.Estado,planilla.Lectura_Anterior,"
                + "planilla.Lectura_Actual,planilla.Valor,planilla.Observacion"
                + "  from planilla  where  " + criterioBusqueda
                + " like '%" + buscar + "%' order by " + criterioOrden + " " + orden + ";";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("fkMedidores");
                registros[2] = rs.getString("fkParametros");
                registros[3] = rs.getString("Codigo");
                registros[4] = rs.getString("Fecha");
                registros[5] = rs.getString("Estado");
                registros[6] = rs.getString("Lectura_Anterior");
                registros[7] = rs.getString("Lectura_Actual");
                registros[8] = rs.getString("Valor");
                registros[9] = rs.getString("Observacion");

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

    public DefaultTableModel mostrarPlanillasMedidor(String buscar, String criterioBusqueda, String criterioOrden, String orden, int idMedidor) {
        DefaultTableModel modelo;
        String[] titulos = {"Id", "fkMedidores", "fkParametros", "Codigo","Fecha", "Estado", "Lectura Anterior",
            "Lectura Actual", "Valor", "Observación"};
        String[] registros = new String[10];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "Select planilla.id,planilla.fkMedidores,planilla.fkParametros,planilla.Codigo,planilla.Fecha"
                + ",planilla.Estado,planilla.Lectura_Anterior,"
                + "planilla.Lectura_Actual,planilla.Valor,planilla.Observacion"
                + "  from planilla  where  " + criterioBusqueda
                + " like '%" + buscar + "%' and planilla.fkMedidores=" + idMedidor + " order by " + criterioOrden + " " + orden + ";";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("fkMedidores");
                registros[2] = rs.getString("fkParametros");
                registros[3] = rs.getString("Codigo");
                registros[4] = rs.getString("Fecha");
                registros[5] = rs.getString("Estado");
                registros[6] = rs.getString("Lectura_Anterior");
                registros[7] = rs.getString("Lectura_Actual");
                registros[8] = rs.getString("Valor");
                registros[9] = rs.getString("Observacion");

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

    public boolean insertar(clsPlanilla planilla) {
        sSQL = "Insert into planilla (Codigo,Fecha,Estado,Lectura_Anterior,Lectura_Actual,Observacion,"
                + "Valor,fkMedidores,fkParametros) values(?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setString(1, planilla.getCodigo());
            pst.setDate(2, planilla.getFecha());
            pst.setString(3, planilla.getEstado());
            pst.setString(4, planilla.getLectura_Anterior());
            pst.setString(5, planilla.getLectura_Actual());
            pst.setString(6, planilla.getObservacion());
            pst.setDouble(7, planilla.getValor());
            pst.setInt(8, planilla.getFkMedidores());
            pst.setInt(9, planilla.getFkParametros());

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

    public boolean editar(clsPlanilla planilla) {
        sSQL = "Update planilla set Codigo=?,Fecha=?,Estado=?,Lectura_Anterior=?,Lectura_Actual=?,Observacion=?,"
                + "Valor=?,fkMedidores=?,fkParametros=? where planilla.id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setString(1, planilla.getCodigo());
            pst.setDate(2, planilla.getFecha());
            pst.setString(3, planilla.getEstado());
            pst.setString(4, planilla.getLectura_Anterior());
            pst.setString(5, planilla.getLectura_Actual());
            pst.setString(6, planilla.getObservacion());
            pst.setDouble(7, planilla.getValor());
            pst.setInt(8, planilla.getFkMedidores());
            pst.setInt(9, planilla.getFkParametros());
            pst.setInt(10, planilla.getId());
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

    public boolean eliminar(clsPlanilla planilla) {
        sSQL = "Delete from planilla where planilla.id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setInt(1, planilla.getId());
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
