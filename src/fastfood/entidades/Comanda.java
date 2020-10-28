
package fastfood.entidades;


public class Comanda {
    private int idComanda ;
    private Pedido pedido;
    private Producto producto;
    private int cantidad;
    private double importe;

    public Comanda() {
    }
   
    public Comanda(int idComanda) {
        this.idComanda = idComanda;
    }

    public Comanda(int idComanda, Pedido pedido, Producto producto, int cantidad, double importe) {
        this.idComanda = idComanda;
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    

    public Comanda(Pedido pedido, Producto producto, int cantidad, double importe) {
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.importe = importe;
    }
    

    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
}
