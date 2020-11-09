
package fastfood.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
public class Pedido {
    private int idPedido;
    private Mesa  mesa;
    private Mesero mesero;
    private boolean estadoPedido;
     private LocalDateTime fechaPedido;

    public Pedido() {
    }

    public Pedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(int idPedido, Mesa mesa, Mesero mesero, boolean estadoPedido, LocalDate fecha) {
        this.idPedido = idPedido;
        this.mesa = mesa;
        this.mesero = mesero;
        this.estadoPedido = estadoPedido;
        this.fechaPedido = fechaPedido;
    }

    public Pedido(Mesa mesa, Mesero mesero, boolean estadoPedido, LocalDate fecha) {
        this.mesa = mesa;
        this.mesero = mesero;
        this.estadoPedido = estadoPedido;
        this.fechaPedido = fechaPedido;
    }

    public Pedido(Mesa mesa, Mesero mesero, boolean estadoPedido) {
        this.mesa = mesa;
        this.mesero = mesero;
        this.estadoPedido = estadoPedido;
    }
     
     

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public boolean isEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(boolean estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fecha) {
        this.fechaPedido = fecha;
    }
    

    
    
}
