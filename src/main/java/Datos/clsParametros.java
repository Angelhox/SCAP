package Datos;

public class clsParametros {
    private int id;
    private String Nombre;
    private double Valor;

    public clsParametros() {
    }

    public clsParametros(String Nombre, double Valor) {
        this.Nombre = Nombre;
        this.Valor = Valor;
    }

    public clsParametros(int id, String Nombre, double Valor) {
        this.id = id;
        this.Nombre = Nombre;
        this.Valor = Valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }
    
}
