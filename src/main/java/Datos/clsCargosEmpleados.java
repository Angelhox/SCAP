
package Datos;

public class clsCargosEmpleados {
 private int id;
 private String Cargo_Descripcion;

    public clsCargosEmpleados() {
    }

    public clsCargosEmpleados(String Cargo_Descripcion) {
        this.Cargo_Descripcion = Cargo_Descripcion;
    }

    public clsCargosEmpleados(int id, String Cargo_Descripcion) {
        this.id = id;
        this.Cargo_Descripcion = Cargo_Descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo_Descripcion() {
        return Cargo_Descripcion;
    }

    public void setCargo_Descripcion(String Cargo_Descripcion) {
        this.Cargo_Descripcion = Cargo_Descripcion;
    }
 
}
