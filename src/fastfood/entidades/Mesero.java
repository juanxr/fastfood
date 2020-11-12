
package fastfood.entidades;


public class Mesero {
    private int idMesero;
    private int dniMesero;
    private String cuitMesero;
    private String nombreMesero;
    private String apellidoMesero;
    private Boolean estadoMesero;

    public Mesero() {
    }

    public Mesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public Mesero(int idMesero, int dniMesero, String cuitMesero, String nombreMesero, String apellidoMesero, Boolean estadoMesero) {
        this.idMesero = idMesero;
        this.dniMesero = dniMesero;
        this.cuitMesero = cuitMesero;
        this.nombreMesero = nombreMesero;
        this.apellidoMesero = apellidoMesero;
        this.estadoMesero = estadoMesero;
    }

    public Mesero(int dniMesero, String cuitMesero, String nombreMesero, String apellidoMesero, Boolean estadoMesero) {
        this.dniMesero = dniMesero;
        this.cuitMesero = cuitMesero;
        this.nombreMesero = nombreMesero;
        this.apellidoMesero = apellidoMesero;
        this.estadoMesero = estadoMesero;
    }
    

    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public int getDniMesero() {
        return dniMesero;
    }

    public void setDniMesero(int dniMesero) {
        this.dniMesero = dniMesero;
    }

    public String getCuitMesero() {
        return cuitMesero;
    }

    public void setCuitMesero(String cuitMesero) {
        this.cuitMesero = cuitMesero;
    }

    public String getNombreMesero() {
        return nombreMesero;
    }

    public void setNombreMesero(String nombreMesero) {
        this.nombreMesero = nombreMesero;
    }

    public String getApellidoMesero() {
        return apellidoMesero;
    }

    public void setApellidoMesero(String apellidoMesero) {
        this.apellidoMesero = apellidoMesero;
    }

    public Boolean getEstadoMesero() {
        return estadoMesero;
    }

    public void setEstadoMesero(Boolean estadoMesero) {
        this.estadoMesero = estadoMesero;
    }
    
    
}
