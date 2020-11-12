package fastfood.entidades;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int idPedido;
    private Mesa mesa;
    private Mesero mesero;
    private Boolean estadoPedido;
    private List<Producto> productos = new ArrayList<>();
    private double importePedido;

    public Pedido() {
    }

    public Pedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(int idPedido, Mesa mesa, Mesero mesero, Boolean estadoPedido, List<Producto> productos) {
        this.idPedido = idPedido;
        this.mesa = mesa;
        this.mesero = mesero;
        this.estadoPedido = estadoPedido;
        this.productos = productos;
        this.calcularImporte();
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Pedido(Mesa mesa, Mesero mesero, Boolean estadoPedido, double importePedido) {
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
        return this.mesa.getIdMesa();
    }

    public void setMesa(int mesa) {
        this.mesa.setIdMesa(mesa);
    }

    public int getMesero() {
        return this.mesero.getIdMesero();
    }

    public void setMesero(int mesero) {
        this.mesero.setIdMesero(mesero);
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

    public double calcularImporte() {
        double total = 0;
        for (int x = 0; x < productos.size(); x++) {
            total += productos.get(x).getPrecio();

        }
        this.importePedido = total;
        return this.importePedido;
    }
}
