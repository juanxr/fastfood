
package fastfood.modelo;

import java.awt.HeadlessException;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import fastfood.entidades.*;

public class PedidoData {
    private Connection con;

     public PedidoData(Conexion conexion) {
        con = conexion.getConnection();
    }
     public Mesero buscarMesero(int id) {
        Conexion c = new Conexion();
        MeseroData meseroData = new MeseroData(c);
        return meseroData.buscarMesero(id);
    }

    public Mesa buscarMesa(int id) {
        Conexion c = new Conexion();
        MesaData mesaData = new MesaData(c);
        return mesaData.buscarMesa(id);
    }

     
     
     public void guardarPedido(Pedido pedi) {
        int n = 0;
        try {
            String bus = "INSERT INTO pedido(id_mesa, id_mesero, estado_pedido, fecha_pedido) VALUES (?,?,?,?)";
            PreparedStatement prs = con.prepareStatement(bus, Statement.RETURN_GENERATED_KEYS);

            prs.setInt(1, pedi.getMesa().getIdMesa());
            prs.setInt(2, pedi.getMesero().getIdMesero());
            prs.setBoolean(3, pedi.isEstadoPedido());
            prs.setTimestamp(4, Timestamp.valueOf(pedi.getFechaPedido()));
            prs.executeUpdate();
            ResultSet rs = prs.getGeneratedKeys();

            if (rs.next()) {
                pedi.setIdPedido(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar ");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no se pudo guardr mesa y mesero");
        }
    }
     
     
      public List<Pedido> obtenerPedidos() {
        List<Pedido> listapedidos = new ArrayList<>();
        Pedido pedido = null;
        String sql = "SELECT * FROM pedido";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mesa mesa = new Mesa();
                Mesero mesero = new Mesero();
                pedido = new Pedido(mesa, mesero, true);
                pedido.setIdPedido(rs.getInt(1));
                mesa = buscarMesa(rs.getInt(2));
                mesero = buscarMesero(rs.getInt(3));
                pedido.setMesa(mesa);
                pedido.setMesero(mesero);
                pedido.setEstadoPedido(rs.getBoolean(4));
                pedido.setFechaPedido(rs.getTimestamp(5).toLocalDateTime());
                listapedidos.add(pedido);
                JOptionPane.showMessageDialog(null, "se encontraron datos ");
            }
            rs.close();
            ps.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puedieron encontrar datos ");
        }
        return listapedidos;
    }
      public void actualizarPedido(Pedido pedido) {
        String sql = "UPDATE pedido SET estado_pedido=? WHERE pedido.id_pedido=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, pedido.isEstadoPedido());
            ps.setInt(2, pedido.getIdPedido());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pedido actualizado");
            ps.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el pedido");
        }
    }
       public void borrarPedido(int id) {
        String sql = "DELETE FROM pedido WHERE  pedido.id_pedido=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pedido eliminado");
            ps.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el pedido");
        }
    }
        public Pedido buscarPedido(int id) {
        Pedido pedido = null;
        String sql = "SELECT * FROM pedido WHERE pedido.id_pedido=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt(1));
                Mesa mesa = buscarMesa(rs.getInt(2));
                Mesero mesero = buscarMesero(rs.getInt(3));
                pedido.setMesa(mesa);
                pedido.setMesero(mesero);
                pedido.setEstadoPedido(rs.getBoolean(4));
                pedido.setFechaPedido(rs.getTimestamp(5).toLocalDateTime());
            }
            rs.close();
            ps.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar");
        }
        return pedido;
    }
    
    public void darBajaPedido(int id){
      String sql="UPDATE pedido SET estado_pedido= ? WHERE id_pedido =?";
      try{
          PreparedStatement ps= con.prepareStatement(sql);
          ps.setBoolean(1, false);
          ps.setInt(2, id);
          ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "Se dio de baja el pedido");
          ps.close();
          //con.close();
          
      }catch(SQLException e){
          JOptionPane.showMessageDialog(null, "Pedido NO dado de baja ", "Error!", JOptionPane.WARNING_MESSAGE);
      } 
  }
  
  public void darAltaPedido(int id){
      String sql="UPDATE pedido SET estado_pedido=? WHERE id_pedido=?";
      try{
          PreparedStatement ps= con.prepareStatement(sql);
          ps.setBoolean(1, true);
          ps.setInt(2, id);
          ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "Se dio de alta el pedido ");
          ps.close();
          //con.close();
          
      }catch(SQLException e){
          JOptionPane.showMessageDialog(null, "Pedido NO dado de Alta ", "Error!", JOptionPane.WARNING_MESSAGE);
      } 
  }
    
    
    
}

