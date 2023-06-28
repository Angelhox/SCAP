
package Datos;

import java.sql.Date;

public class clsSocios {
    private int id;
    private String Cedula,Nombres,Apellidos,Correo,Telefono_Fijo,Telefono_Movil,Direccion;
    private Date Fecha_Nacimiento;

    public clsSocios() {
    }

    public clsSocios(String Cedula, String Nombres, String Apellidos, String Correo, String Telefono_Fijo, String Telefono_Movil, String Direccion, Date Fecha_Nacimiento) {
        this.Cedula = Cedula;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Correo = Correo;
        this.Telefono_Fijo = Telefono_Fijo;
        this.Telefono_Movil = Telefono_Movil;
        this.Direccion = Direccion;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public clsSocios(int id, String Cedula, String Nombres, String Apellidos, String Correo, String Telefono_Fijo, String Telefono_Movil, String Direccion, Date Fecha_Nacimiento) {
        this.id = id;
        this.Cedula = Cedula;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Correo = Correo;
        this.Telefono_Fijo = Telefono_Fijo;
        this.Telefono_Movil = Telefono_Movil;
        this.Direccion = Direccion;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTelefono_Fijo() {
        return Telefono_Fijo;
    }

    public void setTelefono_Fijo(String Telefono_Fijo) {
        this.Telefono_Fijo = Telefono_Fijo;
    }

    public String getTelefono_Movil() {
        return Telefono_Movil;
    }

    public void setTelefono_Movil(String Telefono_Movil) {
        this.Telefono_Movil = Telefono_Movil;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public Date getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(Date Fecha_Nacimiento) {
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }
    
}
