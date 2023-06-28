
package Logica;

import Conexion.conexion;
import Datos.clsImplementos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fImplementos {

    ImageIcon iconoExito = new ImageIcon("src/main/resources/guardar32x32.png"); // Reemplaza con la ruta de tu archivo de imagen
    private conexion conexion = new conexion();
    private Connection connection = conexion.conectar();
    private String sSQL = "";
    public int totalregistros = 0;

    public DefaultTableModel mostrar(String buscar, String criterioBusqueda, String criterioOrden, String orden) {
        DefaultTableModel modelo;
        String[] titulos = {"Id", "fkInventario","Codigo", "Nombre", "Tipo",
            "Descripcion", "Marca","Stock", "Precio", "Iva"};
        String[] registros = new String[10];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "Select implementos.id,implementos.fkInventario,implementos.Codigo,implementos.Nombre,implementos.Tipo,"
                + "implementos.Descripcion,implementos.Marca,implementos.Stock,implementos.Precio,implementos.Iva"
                + "  from implementos  where  " + criterioBusqueda
                + " like '%" + buscar + "%' order by " + criterioOrden + " " + orden + ";";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("fkInventario");
                registros[2]=rs.getString("Codigo");
                registros[3] = rs.getString("Nombre");
                registros[4] = rs.getString("Tipo");
                registros[5] = rs.getString("Descripcion");
                registros[6] = rs.getString("Marca");
                registros[7] = rs.getString("Stock");
                registros[8] = rs.getString("Precio");
                registros[9] = rs.getString("Iva");
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
        public String[] mostrarInventariosImplementos(int idInventario) {
  
        String[] registros = new String[4];

        sSQL="Select inventario.id,inventario.Fecha,inventario.Estado,inventario.Nombre "
                + " from inventario  where  inventario.id="+idInventario+";";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("Fecha");
                registros[2] = rs.getString("Estado");
                registros[3] = rs.getString("Nombre");
          
                totalregistros += 1;
       
            }
            JOptionPane.showMessageDialog(null, "La acción se ha realizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE, iconoExito);
return registros;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return null;
    }
    public boolean insertar(clsImplementos implemento) {
        sSQL = "Insert into implementos (Codigo,Nombre,Tipo,Descripcion,Marca,"
                + "Stock,Precio,Iva,fkInventario) values(?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setString(1, implemento.getCodigo());
            pst.setString(2, implemento.getNombre());
            pst.setString(3, implemento.getTipo());
            pst.setString(4, implemento.getDescripcion());
            pst.setString(5, implemento.getMarca());
            pst.setDouble(6, implemento.getStock());
            pst.setDouble(7, implemento.getPrecio());
            pst.setDouble(8, implemento.getIva());
            pst.setInt(9, implemento.getFkInventario());
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

    public boolean editar(clsImplementos implemento) {
        sSQL = "Update implementos set Codigo=?,Nombre=?,Tipo=?,Descripcion=?,Marca=?,"
                + "Stock=?,Precio=?,Iva=?,fkInventario=? where implementos.id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setString(1,  implemento.getCodigo());
            pst.setString(2,  implemento.getNombre());
            pst.setString(3,  implemento.getTipo());
            pst.setString(4,  implemento.getDescripcion());
            pst.setString(5,  implemento.getMarca());
            pst.setDouble(6,  implemento.getStock());                                   
            pst.setDouble(7,  implemento.getPrecio());
            pst.setDouble(8,  implemento.getIva());
            pst.setInt(9, implemento.getFkInventario());
            pst.setInt(10, implemento.getId());
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

    public boolean eliminar(clsImplementos implemento) {
        sSQL = "Delete from implementos where implementos.id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);
            pst.setInt(1, implemento.getId());
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
   
