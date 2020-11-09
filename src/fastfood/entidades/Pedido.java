
package fastfood.entidades;

import java.time.LocalDate;
public class Pedido {
    private int idPedido;
    private int mesa;
    private int mesero;
    private Boolean estadoPedido;
     private LocalDate fecha;
    

    public Pedido() {
    }

    public Pedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(int idPedido, int mesa, int mesero, Boolean estadoPedido, LocalDate fecha) {
        this.idPedido = idPedido;
        this.mesa = mesa;
        this.mesero = mesero;
        this.estadoPedido = estadoPedido;
        this.fecha = fecha;
    }

    public Pedido(int mesa, int mesero, Boolean estadoPedido, LocalDate fecha) {
        this.mesa = mesa;
        this.mesero = mesero;
        this.estadoPedido = estadoPedido;
        this.fecha = fecha;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

   
    
}
