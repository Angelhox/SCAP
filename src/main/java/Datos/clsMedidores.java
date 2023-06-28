
package Datos;

import java.sql.Date;

public class clsMedidores {
     private int id,fkSocios;
    private String Codigo,Marca,Barrio,Calle_Principal,Calle_Secundaria,Numero_Casa,Referencia,Observacion;
    private Date FechaInstalacion;

    public clsMedidores() {
    }

    public clsMedidores(int fkSocios, String Codigo, String Marca, String Barrio, String Calle_Principal, String Calle_Secundaria, String Numero_Casa, String Referencia, String Observacion, Date FechaInstalacion) {
        this.fkSocios = fkSocios;
        this.Codigo = Codigo;
        this.Marca = Marca;
        this.Barrio = Barrio;
        this.Calle_Principal = Calle_Principal;
        this.Calle_Secundaria = Calle_Secundaria;
        this.Numero_Casa = Numero_Casa;
        this.Referencia = Referencia;
        this.Observacion = Observacion;
        this.FechaInstalacion = FechaInstalacion;
    }

    public clsMedidores(int id, int fkSocios, String Codigo, String Marca, String Barrio, String Calle_Principal, String Calle_Secundaria, String Numero_Casa, String Referencia, String Observacion, Date FechaInstalacion) {
        this.id = id;
        this.fkSocios = fkSocios;
        this.Codigo = Codigo;
        this.Marca = Marca;
        this.Barrio = Barrio;
        this.Calle_Principal = Calle_Principal;
        this.Calle_Secundaria = Calle_Secundaria;
        this.Numero_Casa = Numero_Casa;
        this.Referencia = Referencia;
        this.Observacion = Observacion;
        this.FechaInstalacion = FechaInstalacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkSocios() {
        return fkSocios;
    }

    public void setFkSocios(int fkSocios) {
        this.fkSocios = fkSocios;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getBarrio() {
        return Barrio;
    }

    public void setBarrio(String Barrio) {
        this.Barrio = Barrio;
    }

    public String getCalle_Principal() {
        return Calle_Principal;
    }

    public void setCalle_Principal(String Calle_Principal) {
        this.Calle_Principal = Calle_Principal;
    }

    public String getCalle_Secundaria() {
        return Calle_Secundaria;
    }

    public void setCalle_Secundaria(String Calle_Secundaria) {
        this.Calle_Secundaria = Calle_Secundaria;
    }

    public String getNumero_Casa() {
        return Numero_Casa;
    }

    public void setNumero_Casa(String Numero_Casa) {
        this.Numero_Casa = Numero_Casa;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String Referencia) {
        this.Referencia = Referencia;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public Date getFechaInstalacion() {
        return FechaInstalacion;
    }

    public void setFechaInstalacion(Date FechaInstalacion) {
        this.FechaInstalacion = FechaInstalacion;
    }
    
}
