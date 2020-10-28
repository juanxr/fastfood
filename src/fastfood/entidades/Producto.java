
package fastfood.entidades;


public class Producto {
    private int idProducto;
    private String nombreProducto;
    private double precio;
    private Boolean estadoProducto;

    public Producto() {
    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(int idProducto, String nombreProducto, double precio, Boolean estadoProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.estadoProducto = estadoProducto;
    }

    public Producto(String nombreProducto, double precio, Boolean estadoProducto) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.estadoProducto = estadoProducto;
    }
    
    

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Boolean getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(Boolean estadoProducto) {
        this.estadoProducto = estadoProducto;
    }
    
    
}
