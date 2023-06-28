
package Datos;

import java.sql.Date;

public class clsAdicionales {
  private int id,fkPlanilla;
  private String Tipo,Motivo,Estado;
  private Date Fecha;
  private Double Valor;

    public clsAdicionales() {
    }

    public clsAdicionales(int fkPlanilla, String Tipo, String Motivo, String Estado, Date Fecha, Double Valor) {
        this.fkPlanilla = fkPlanilla;
        this.Tipo = Tipo;
        this.Motivo = Motivo;
        this.Estado = Estado;
        this.Fecha = Fecha;
        this.Valor = Valor;
    }

    public clsAdicionales(int id, int fkPlanilla, String Tipo, String Motivo, String Estado, Date Fecha, Double Valor) {
        this.id = id;
        this.fkPlanilla = fkPlanilla;
        this.Tipo = Tipo;
        this.Motivo = Motivo;
        this.Estado = Estado;
        this.Fecha = Fecha;
        this.Valor = Valor;
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

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double Valor) {
        this.Valor = Valor;
    }
  
}
