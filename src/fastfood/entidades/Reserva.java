
package fastfood.entidades;

import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private int mesa;
    private int dni;
    private String nombre;
    private String apellido;
    private LocalDate fecha;
    private Boolean estadoReserva;

    public Reserva() {
    }

    public Reserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Reserva(int idReserva, int mesa, int dni, String nombre, String apellido, LocalDate fecha, Boolean estadoReserva) {
        this.idReserva = idReserva;
        this.mesa = mesa;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.estadoReserva = estadoReserva;
    }

    public Reserva(int mesa, int dni, String nombre, String apellido, LocalDate fecha, Boolean estadoReserva) {
        this.mesa = mesa;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.estadoReserva = estadoReserva;
    }
    
    

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Boolean getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(Boolean estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
    
}
