package Datos;

public class clsImplementos {
    private int id,fkInventario ;
    private String Codigo,Nombre,Tipo,Descripcion,Marca;
    private Double Precio, Iva,Stock;

    public clsImplementos() {
    }

    public clsImplementos(int fkInventario, String Codigo, String Nombre, String Tipo, String Descripcion, String Marca, Double Precio, Double Iva, Double Stock) {
        this.fkInventario = fkInventario;
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Descripcion = Descripcion;
        this.Marca = Marca;
        this.Precio = Precio;
        this.Iva = Iva;
        this.Stock = Stock;
    }

    public clsImplementos(int id, int fkInventario, String Codigo, String Nombre, String Tipo, String Descripcion, String Marca, Double Precio, Double Iva, Double Stock) {
        this.id = id;
        this.fkInventario = fkInventario;
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Descripcion = Descripcion;
        this.Marca = Marca;
        this.Precio = Precio;
        this.Iva = Iva;
        this.Stock = Stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkInventario() {
        return fkInventario;
    }

    public void setFkInventario(int fkInventario) {
        this.fkInventario = fkInventario;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public Double getIva() {
        return Iva;
    }

    public void setIva(Double Iva) {
        this.Iva = Iva;
    }

    public Double getStock() {
        return Stock;
    }

    public void setStock(Double Stock) {
        this.Stock = Stock;
    }

  
    
}
