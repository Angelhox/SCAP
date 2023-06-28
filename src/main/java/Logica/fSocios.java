
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

import Conexion.conexion;
import Datos.clsEmpleados;
import Datos.clsSocios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fSocios {

    ImageIcon iconoExito = new ImageIcon("src/main/resources/guardar32x32.png"); // Reemplaza con la ruta de tu archivo de imagen
    private conexion conexion = new conexion();
    private Connection connection = conexion.conectar();
    private String sSQL = "";
    public int totalregistros = 0;

    public DefaultTableModel mostrar(String buscar, String criterioBusqueda, String criterioOrden, String orden) {
        DefaultTableModel modelo;
        String[] titulos = {"Id", "Cedula", "Nombres", "Apellidos",
            "Fecha de Nacimiento", "Correo","Telefono fijo", "Telefono movil","Direccion"};
        String[] registros = new String[9];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "Select socios.id,socios.Cedula,socios.Nombres,socios.Apellidos,socios.Fecha_Nacimiento,"
                + "socios.Correo,socios.Telefono_Fijo,socios.Telefono_Movil,socios.Direccion"
                + "  from socios  where  " + criterioBusqueda
                + " like '%" + buscar + "%' order by " + criterioOrden + " " + orden + ";";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("Cedula");
                registros[2] = rs.getString("Nombres");
                registros[3] = rs.getString("Apellidos");
                registros[4] = rs.getString("Fecha_Nacimiento");
                registros[5] = rs.getString("Correo");
                registros[6] = rs.getString("Telefono_Fijo");
                registros[7] = rs.getString("Telefono_Movil");
                registros[8] = rs.getString("Direccion");
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
        public DefaultTableModel mostrarMedidoresSocio(int idSocio) {
        DefaultTableModel modelo;
        String[] titulos = {"Id", "Codigo", "Marca", "Barrio"};
        String[] registros = new String[4];
        modelo = new DefaultTableModel(null, titulos);
        sSQL="Select medidores.id,medidores.Codigo,medidores.Marca,medidores.Barrio "
                + "from medidores join socios on socios.id=medidores.fkSocios where socios.id="+idSocio+";";
      /*  sSQL="Select medidores.id,medidores.Codigo,medidores.Marca,"
                + "(Selec medidores.Barrio,medidores.Calle_Principal,medidores.Calle_Secundaria from medidores)"
                + " as Direccion from medidores join socios "
                + "on socios.id=medidores.fkSocios where socios.id="+idSocio+";";
   /*     sSQL = "Select socios.id,socios.Cedula,socios.Nombres,socios.Apellidos,socios.Fecha_Nacimiento,"
                + "socios.Correo,socios.Telefono_Fijo,socios.Telefono_Movil,socios.Direccion"
                + "  from socios  where  " + criterioBusqueda
                + " like '%" + buscar + "%' order by " + criterioOrden + " " + orden + ";";*/
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("Codigo");
                registros[2] = rs.getString("Marca");
                registros[3] = rs.getString("Barrio");
          
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

    public boolean insertar(clsSocios socio) {
        sSQL = "Insert into socios (Cedula,Nombres,Apellidos,Fecha_Nacimiento,Correo,Telefono_Fijo,"
                + "Telefono_Movil,Direccion) values(?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setString(1, socio.getCedula());
            pst.setString(2, socio.getNombres());
            pst.setString(3, socio.getApellidos());
            pst.setDate(4, socio.getFecha_Nacimiento());
            pst.setString(5, socio.getCorreo());
            pst.setString(6, socio.getTelefono_Fijo());
            pst.setString(7, socio.getTelefono_Movil());
            pst.setString(8, socio.getDireccion());
    
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

    public boolean editar(clsSocios socio) {
        sSQL = "Update socios set Cedula=?,Nombres=?,Apellidos=?,Fecha_Nacimiento=?,Correo=?,Telefono_Fijo=?,Telefono_Movil=?,"
                + "Direccion=? where socios.id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setString(1, socio.getCedula());
            pst.setString(2, socio.getNombres());
            pst.setString(3, socio.getApellidos());
            pst.setDate(4, socio.getFecha_Nacimiento());
            pst.setString(5, socio.getCorreo());
            pst.setString(6, socio.getTelefono_Fijo());
            pst.setString(7, socio.getTelefono_Movil());
            pst.setString(8, socio.getDireccion());  
            pst.setInt(9,socio.getId());
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

    public boolean eliminar(clsSocios socio) {
        sSQL = "Delete from socios where socios.id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setInt(1, socio.getId());
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
