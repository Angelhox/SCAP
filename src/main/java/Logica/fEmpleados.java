package Logica;

import Conexion.conexion;
import Datos.clsEmpleados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fEmpleados {

    ImageIcon iconoExito = new ImageIcon("src/main/resources/guardar32x32.png"); // Reemplaza con la ruta de tu archivo de imagen
    private conexion conexion = new conexion();
    private Connection connection = conexion.conectar();
    private String sSQL = "";
    public int totalregistros = 0;

    public DefaultTableModel mostrar(String buscar, String criterioBusqueda, String criterioOrden, String orden) {
        DefaultTableModel modelo;
        String[] titulos = {"Id", "Cedula", "Nombres", "Apellidos",
            "Cargo", "Telefono", "Correo", "Usuario", "Clave"};
        String[] registros = new String[9];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "Select empleados.id,empleados.Cedula,empleados.Nombres,empleados.Apellidos,"
                + "empleados.Telefono,empleados.correo,empleados.Cargo,empleados.Usuario,empleados.Clave"
                + "  from empleados  where  " + criterioBusqueda
                + " like '%" + buscar + "%' order by " + criterioOrden + " " + orden + ";";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("Cedula");
                registros[2] = rs.getString("Nombres");
                registros[3] = rs.getString("Apellidos");
                registros[4] = rs.getString("Cargo");
                registros[5] = rs.getString("Telefono");
                registros[6] = rs.getString("Correo");
                registros[7] = rs.getString("Usuario");
                registros[8] = rs.getString("Clave");
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

    public boolean insertar(clsEmpleados empleado) {
        sSQL = "Insert into empleados (Cedula,Nombres,Apellidos,Telefono,"
                + "Correo,Usuario,Clave,Cargo) values(?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setString(1, empleado.getCedula());
            pst.setString(2, empleado.getNombres());
            pst.setString(3, empleado.getApellidos());
            pst.setString(4, empleado.getTelefono());
            pst.setString(5, empleado.getCorreo());
            pst.setString(6, empleado.getUsuario());
            pst.setString(7, empleado.getClave());
            pst.setString(8, empleado.getCargo());
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

    public boolean editar(clsEmpleados empleado) {
        sSQL = "Update empleados set Cedula=?,Nombres=?,Apellidos=?,Telefono=?,Correo=?,"
                + "Usuario=?,Clave=?,Cargo=? where empleados.id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setString(1, empleado.getCedula());
            pst.setString(2, empleado.getNombres());
            pst.setString(3, empleado.getApellidos());
            pst.setString(4, empleado.getTelefono());
            pst.setString(5, empleado.getCorreo());
            pst.setString(6, empleado.getUsuario());
            pst.setString(7, empleado.getClave());
            pst.setString(8, empleado.getCargo());
            pst.setInt(9,empleado.getId());
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

    public boolean eliminar(clsEmpleados empleado) {
        sSQL = "Delete from empleados where empleados.id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setInt(1, empleado.getId());
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
