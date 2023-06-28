
package Datos;

import java.sql.Date;

public class clsServicios {
    private int id,fkPlanilla;
    private String Nombre,Descripcion,Estado,Tipo;
    private Double Valor;
private Date Fecha;
    public clsServicios() {
    }

    public clsServicios(int fkPlanilla, String Nombre, String Descripcion, String Estado, String Tipo, Double Valor, Date Fecha) {
        this.fkPlanilla = fkPlanilla;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
        this.Tipo = Tipo;
        this.Valor = Valor;
        this.Fecha = Fecha;
    }

    public clsServicios(int id, int fkPlanilla, String Nombre, String Descripcion, String Estado, String Tipo, Double Valor, Date Fecha) {
        this.id = id;
        this.fkPlanilla = fkPlanilla;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
        this.Tipo = Tipo;
        this.Valor = Valor;
        this.Fecha = Fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkPlanilla() {
        return fkPlanilla;
    }

    public void setFkPlanilla(int fkPlanilla) {
        this.fkPlanilla = fkPlanilla;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double Valor) {
        this.Valor = Valor;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

}