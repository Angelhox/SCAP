
package Datos;

import java.sql.Date;

public class clsPlanilla {
  private int id,fkMedidores,fkParametros;  
  private String Codigo,Estado,Lectura_Actual,Lectura_Anterior,Observacion;
  private Date Fecha;
  private Double valor;

    public clsPlanilla() {
    }

    public clsPlanilla(int fkMedidores, int fkParametros, String Codigo, String Estado, String Lectura_Actual, String Lectura_Anterior, String Observacion, Date Fecha, Double valor) {
        this.fkMedidores = fkMedidores;
        this.fkParametros = fkParametros;
        this.Codigo = Codigo;
        this.Estado = Estado;
        this.Lectura_Actual = Lectura_Actual;
        this.Lectura_Anterior = Lectura_Anterior;
        this.Observacion = Observacion;
        this.Fecha = Fecha;
        this.valor = valor;
    }

    public clsPlanilla(int id, int fkMedidores, int fkParametros, String Codigo, String Estado, String Lectura_Actual, String Lectura_Anterior, String Observacion, Date Fecha, Double valor) {
        this.id = id;
        this.fkMedidores = fkMedidores;
        this.fkParametros = fkParametros;
        this.Codigo = Codigo;
        this.Estado = Estado;
        this.Lectura_Actual = Lectura_Actual;
        this.Lectura_Anterior = Lectura_Anterior;
        this.Observacion = Observacion;
        this.Fecha = Fecha;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkMedidores() {
        return fkMedidores;
    }

    public void setFkMedidores(int fkMedidores) {
        this.fkMedidores = fkMedidores;
    }

    public int getFkParametros() {
        return fkParametros;
    }

    public void setFkParametros(int fkParametros) {
        this.fkParametros = fkParametros;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getLectura_Actual() {
        return Lectura_Actual;
    }

    public void setLectura_Actual(String Lectura_Actual) {
        this.Lectura_Actual = Lectura_Actual;
    }

    public String getLectura_Anterior() {
        return Lectura_Anterior;
    }

    public void setLectura_Anterior(String Lectura_Anterior) {
        this.Lectura_Anterior = Lectura_Anterior;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

   
   
}
