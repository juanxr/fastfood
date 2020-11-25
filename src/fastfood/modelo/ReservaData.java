package fastfood.modelo;

import java.awt.HeadlessException;
import java.sql.*;
import java.time.*;
import java.util.*;
import javax.swing.JOptionPane;
import fastfood.entidades.*;


public class ReservaData {
    private Connection con;
    
    public ReservaData(Conexion conexion){
        con=conexion.getConnection();
    }
    
}

