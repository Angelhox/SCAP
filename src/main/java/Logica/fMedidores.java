
package Logica;

import Conexion.conexion;
import Datos.clsMedidores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fMedidores {

    ImageIcon iconoExito = new ImageIcon("src/main/resources/guardar32x32.png"); // Reemplaza con la ruta de tu archivo de imagen
    private conexion conexion = new conexion();
    private Connection connection = conexion.conectar();
    private String sSQL = "";
    public int totalregistros = 0;

    public DefaultTableModel mostrar(String buscar, String criterioBusqueda, String criterioOrden, String orden) {
        DefaultTableModel modelo;
        String[] titulos = {"Id", "fkSocios","Código", "Marca", "Fecha Instalacion","Barrio","Calle Principal","Calle Secundaria",
            "N° Casa", "Referencia","Observacion"};
        String[] registros = new String[11];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "Select medidores.id,medidores.fkSocios,medidores.Codigo,medidores.Marca,medidores.Barrio,"
                + "medidores.Calle_Principal,medidores.Calle_Secundaria,medidores.Numero_Casa,"
                + "medidores.Referencia,medidores.Observacion,medidores.Fecha_Instalacion"
      
                + "  from medidores  where  " + criterioBusqueda
                + " like '%" + buscar + "%' order by " + criterioOrden + " " + orden + ";";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("fkSocios");
                registros[2] = rs.getString("Codigo");
                registros[3] = rs.getString("Marca");
                registros[4] = rs.getString("Fecha_Instalacion");
                registros[5] = rs.getString("Barrio");
                registros[6] = rs.getString("Calle_Principal");
                registros[7] = rs.getString("Calle_Secundaria");
                registros[8] = rs.getString("Numero_Casa");
                registros[9] = rs.getString("Referencia");
                registros[10] = rs.getString("Observacion");
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
    
    public DefaultTableModel mostrarconParametros(String buscar, String criterioBusqueda, String criterioOrden, String orden) {
        DefaultTableModel modelo;
        String[] titulos = {"Id", "fkSocios","Cedula","Nombres","Apellidos","Código", "Marca",
            "Fecha Instalacion","Barrio","Calle Principal","Calle Secundaria",
            "N° Casa", "Referencia","Observacion"};
        String[] registros = new String[14];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "Select medidores.id,medidores.fkSocios,socios.Cedula,socios.Nombres,socios.Apellidos,"
                + "medidores.Codigo,medidores.Marca,medidores.Barrio,"
                + "medidores.Calle_Principal,medidores.Calle_Secundaria,medidores.Numero_Casa,"
                + "medidores.Referencia,medidores.Observacion,medidores.Fecha_Instalacion"
                + "  from medidores join socios on socios.id=medidores.fkSocios where  " + criterioBusqueda
                + " like '%" + buscar + "%' order by " + criterioOrden + " " + orden + ";";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("fkSocios");
                registros[2] = rs.getString("Cedula");
                registros[3] = rs.getString("Nombres");
                registros[4] = rs.getString("Apellidos");
                registros[5] = rs.getString("Codigo");
                registros[6] = rs.getString("Marca");
                registros[7] = rs.getString("Fecha_Instalacion");
                registros[8] = rs.getString("Barrio");
                registros[9] = rs.getString("Calle_Principal");
                registros[10] = rs.getString("Calle_Secundaria");
                registros[11] = rs.getString("Numero_Casa");
                registros[12] = rs.getString("Referencia");
                registros[13] = rs.getString("Observacion");
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
        /*public DefaultTableModel mostrarMedidoresSocio(int idSocio) {
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
    /*    try {
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
    }*/

    public boolean insertar(clsMedidores medidor) {
        sSQL = "Insert into medidores (Codigo,Marca,Fecha_Instalacion,Barrio,Calle_Principal,"
                + "Calle_Secundaria,Numero_Casa,Referencia,"
                + "Observacion,fkSocios) values(?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setString(1, medidor.getCodigo());
            pst.setString(2, medidor.getMarca());
            pst.setDate(3, medidor.getFechaInstalacion());
            pst.setString(4, medidor.getBarrio());
            pst.setString(5, medidor.getCalle_Principal());
            pst.setString(6, medidor.getCalle_Secundaria());
            pst.setString(7, medidor.getNumero_Casa());
            pst.setString(8, medidor.getReferencia());
            pst.setString(9, medidor.getObservacion());
            pst.setInt(10 , medidor.getFkSocios());
    
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

    public boolean editar(clsMedidores medidor) {
        sSQL = "Update medidores set Codigo=?,Marca=?,Fecha_Instalacion=?,Barrio=?,Calle_Principal=?,"
                + "Calle_Secundaria=?,Numero_Casa=?,Referencia=?,"
                + "Observacion=?,fkSocios=? where medidores.id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setString(1, medidor.getCodigo());
            pst.setString(2, medidor.getMarca());
            pst.setDate(3, medidor.getFechaInstalacion());
            pst.setString(4, medidor.getBarrio());
            pst.setString(5, medidor.getCalle_Principal());
            pst.setString(6, medidor.getCalle_Secundaria());
            pst.setString(7, medidor.getNumero_Casa());
            pst.setString(8, medidor.getReferencia());  
            pst.setString(9, medidor.getObservacion());  
            pst.setInt(10, medidor.getFkSocios());  
            pst.setInt(11,medidor.getId());
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

    public boolean eliminar(clsMedidores medidor) {
        sSQL = "Delete from medidores where medidores.id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setInt(1, medidor.getId());
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
