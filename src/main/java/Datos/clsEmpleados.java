
package Datos;

public class clsEmpleados {
    private int id;
    private String Cedula,Nombres,Apellidos,Telefono,Correo,Usuario,Clave,Cargo;

    public clsEmpleados() {
    }

    public clsEmpleados(String Cedula, String Nombres, String Apellidos, String Telefono, String Correo, String Usuario, String Clave, String Cargo) {
        this.Cedula = Cedula;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Usuario = Usuario;
        this.Clave = Clave;
        this.Cargo = Cargo;
    }

    public clsEmpleados(int id, String Cedula, String Nombres, String Apellidos, String Telefono, String Correo, String Usuario, String Clave, String Cargo) {
        this.id = id;
        this.Cedula = Cedula;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Usuario = Usuario;
        this.Clave = Clave;
        this.Cargo = Cargo;
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

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

 
    
}
