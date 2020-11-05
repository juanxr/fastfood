
package fastfood.entidades;


public class Remito {
        private int idRemito;
        private Pedido pedido;
        private Producto producto;
        private int cantidad;
        private double importe;

    public Remito() {
    }

    public Remito(int idRemito) {
        this.idRemito = idRemito;
    }

    public Remito(int idRemito, Pedido pedido, Producto producto, int cantidad, double importe) {
        this.idRemito = idRemito;
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public Remito(Pedido pedido, Producto producto, int cantidad, double importe) {
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.importe = importe;
    }
        
        
    
    

    public int getIdRemito() {
        return idRemito;
    }

    public void setIdRemito(int idRemito) {
        this.idRemito = idRemito;
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
