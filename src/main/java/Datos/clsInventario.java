
package Datos;

import java.sql.Date;

public class clsInventario {
  private int id;
private Date Fecha;
private String Estado,Nombre;

    public clsInventario() {
    }

    public clsInventario(Date Fecha, String Estado, String Nombre) {
        this.Fecha = Fecha;
        this.Estado = Estado;
        this.Nombre = Nombre;
    }

    public clsInventario(int id, Date Fecha, String Estado, String Nombre) {
        this.id = id;
        this.Fecha = Fecha;
        this.Estado = Estado;
        this.Nombre = Nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

   
}
