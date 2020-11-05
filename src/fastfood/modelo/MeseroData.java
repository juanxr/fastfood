package fastfood.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import fastfood.entidades.*;
import fastfood.modelo.Conexion;

public class MeseroData {

 private Connection con;

    public MeseroData(Conexion c) {
        con = c.getConnection();
    }

    public void guardarMesero(Mesero mesero) {
        String sql = "INSERT INTO mesero(dni_mesero,cuit_mesero, nombre_mesero, apellido_mesero, estado_mesero)VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, mesero.getDniMesero());
            ps.setInt(2,mesero.getCuitMesero());
            ps.setString(3, mesero.getNombreMesero());
            ps.setString(4, mesero.getApellidoMesero());
            ps.setBoolean(5, mesero.getEstadoMesero());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                mesero.setIdMesero(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "Error no se pudo guardar el mesero");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar mesero");
        }
    }
    
    public Mesero buscarMesero(int id){
    Mesero m =null;
    String sql="SELECT * FROM mesero WHERE id_mesero=?";
    try{
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            m = new Mesero();
            m.setIdMesero(rs.getInt("id_mesero"));
            m.setCuitMesero(rs.getInt("cuit_mesero"));
            m.setDniMesero(rs.getInt("dni_mesero"));    
            m.setNombreMesero(rs.getString("nombre_mesero"));
            m.setApellidoMesero(rs.getString("apellido_mesero"));
            m.setEstadoMesero(rs.getBoolean("estado_mesero"));
            JOptionPane.showMessageDialog(null, "Mesero encontrado");
        }
        rs.close();
        ps.close();
    }
    catch(SQLException e){
        
        JOptionPane.showMessageDialog(null,"Error buscar mesero por id");

    }
    return m;
    }
    
    public List<Mesero> obtenerMeseros(){
    Mesero m;
    List<Mesero>meseros=new ArrayList<>();
    String sql = "SELECT * FROM mesero";
    try{
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
        m=new Mesero();
        m.setIdMesero(rs.getInt(1));
        m.setDniMesero(rs.getInt(2));
        m.setCuitMesero(rs.getInt(3));
        m.setNombreMesero(rs.getString(4));
        m.setApellidoMesero(rs.getString(5));
        m.setEstadoMesero(rs.getBoolean(6));
        meseros.add(m);}
    }
    catch(SQLException e){
    JOptionPane.showMessageDialog(null, "Error al Obtener Meseros");}
   return meseros;}
    
    public void actualizarMesero(Mesero mesero){
    String sql="UPDATE mesero SET dni_mesero=?,cuit_mesero=?,nombre_mesero=?, apellido_mesero=?, estado_mesero=? ";
    try{
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, mesero.getDniMesero());
    ps.setInt(2, mesero.getCuitMesero());
    ps.setString(3, mesero.getNombreMesero());
    ps.setString(4, mesero.getApellidoMesero());
    ps.setBoolean(5, mesero.getEstadoMesero());
    ps.executeUpdate();
     JOptionPane.showMessageDialog(null, "Se actualizo Mesero");
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null, "Error al actualizar mesero");}
    }
    
    public void borrarMesero(int id){
    String sql="DELETE FROM mesero WHERE id_mesero=?";
    try{
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, id);
    ps.executeUpdate();
    ps.close();
    JOptionPane.showMessageDialog(null, "Mesero Borrado");    
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al borrar Mesero");
    } }
}

