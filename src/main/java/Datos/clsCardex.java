
package Datos;

import java.sql.Date;

public class clsCardex {
  private int id,fkImplementos,fkServicios,Cantidad;
private Date Fecha;

    public clsCardex() {
    }

    public clsCardex(int fkImplementos, int fkServicios, int Cantidad, Date Fecha) {
        this.fkImplementos = fkImplementos;
        this.fkServicios = fkServicios;
        this.Cantidad = Cantidad;
        this.Fecha = Fecha;
    }

    public clsCardex(int id, int fkImplementos, int fkServicios, int Cantidad, Date Fecha) {
        this.id = id;
        this.fkImplementos = fkImplementos;
        this.fkServicios = fkServicios;
        this.Cantidad = Cantidad;
        this.Fecha = Fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkImplementos() {
        return fkImplementos;
    }

    public void setFkImplementos(int fkImplementos) {
        this.fkImplementos = fkImplementos;
    }

    public int getFkServicios() {
        return fkServicios;
    }

    public void setFkServicios(int fkServicios) {
        this.fkServicios = fkServicios;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

}
