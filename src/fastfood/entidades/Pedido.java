
package fastfood.entidades;


public class Pedido {
    private int idPedido;
    private int mesa;
    private int mesero;
    private Boolean estadoPedido;
    private double importePedido;

    public Pedido() {
    }

    public Pedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(int idPedido, int mesa, int mesero, Boolean estadoPedido, double importePedido) {
        this.idPedido = idPedido;
        this.mesa = mesa;
        this.mesero = mesero;
        this.estadoPedido = estadoPedido;
        this.importePedido = importePedido;
    }

    public Pedido(int mesa, int mesero, Boolean estadoPedido, double importePedido) {
        this.mesa = mesa;
        this.mesero = mesero;
        this.estadoPedido = estadoPedido;
        this.importePedido = importePedido;
    }
    

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public int getMesero() {
        return mesero;
    }

    public void setMesero(int mesero) {
        this.mesero = mesero;
    }

    public Boolean getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(Boolean estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public double getImportePedido() {
        return importePedido;
    }

    public void setImportePedido(double importePedido) {
        this.importePedido = importePedido;
    }
    
    
}
