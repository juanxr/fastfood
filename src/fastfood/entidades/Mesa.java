
package fastfood.entidades;


public class Mesa {
    private int idMesa;
    private boolean estadoMesa;
    private int capacidadMesa;

    public Mesa() {
    }

    public Mesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public Mesa(int idMesa, boolean estadoMesa, int capacidadMesa) {
        this.idMesa = idMesa;
        this.estadoMesa = estadoMesa;
        this.capacidadMesa = capacidadMesa;
    }

    public Mesa(boolean estadoMesa, int capacidadMesa) {
        this.estadoMesa = estadoMesa;
        this.capacidadMesa = capacidadMesa;
    }
    

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public boolean isEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(boolean estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public int getCapacidadMesa() {
        return capacidadMesa;
    }

    public void setCapacidadMesa(int capacidadMesa) {
        this.capacidadMesa = capacidadMesa;
    }
    
}
