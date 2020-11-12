/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.modelo;

import fastfood.entidades.Mesero;
import fastfood.entidades.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Lucero
 */
public class PedidoData {

    private Connection con;

    public PedidoData(Conexion c) {
        con = c.getConnection();
    }

    public void guardarPedido(Pedido pedido) {
        String sql = "INSERT INTO `pedido` (`id_mesa`, `id_mesero`, `estado_pedido`, `importe_pedido`) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedido.getMesa());
            ps.setInt(2, pedido.getMesero());
            ps.setBoolean(3, pedido.getEstadoPedido());
            ps.setDouble(4, pedido.getImportePedido());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pedido.getIdPedido();
            } else {
                JOptionPane.showMessageDialog(null, "Error no se pudo guardar el id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Pedido buscarPedido(int id) {
        Pedido p = null;
        String sql = "SELECT * FROM pedido WHERE id_pedido=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Pedido();
                p.setEstadoPedido(rs.getBoolean("estado_pedido"));
                p.setIdPedido(rs.getInt("id_pedido"));
                p.setImportePedido(rs.getDouble("importe_pedido"));
                p.setMesa(rs.getInt("id_mesa"));
                p.setMesero(rs.getInt("id_mesero"));
                JOptionPane.showMessageDialog(null, "Pedido no encontrado");
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error buscar pedido por id");

        }
        return p;
    }

    public List<Pedido> obtenerPedidos() {
        Pedido p;
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p = new Pedido();
                p.setEstadoPedido(rs.getBoolean("estado_pedido"));
                p.setIdPedido(rs.getInt("id_pedido"));
                p.setImportePedido(rs.getDouble("importe_pedido"));
                p.setMesa(rs.getInt("id_mesa"));
                p.setMesero(rs.getInt("id_mesero"));
                pedidos.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Obtener Pedidos");
        }
        return pedidos;
    }

    public void actualizarPedido(Pedido pedido) {
        String sql = "UPDATE `pedido` SET `id_mesa`=?,`id_mesero`=?,`estado_pedido`=?,`importe_pedido`=? WHERE 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getMesa());
            ps.setInt(2, pedido.getMesero());
            ps.setBoolean(3, pedido.getEstadoPedido());
            ps.setDouble(4, pedido.getImportePedido());
            ps.executeUpdate();
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se actualizo el pedido");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el pedido");
        }
    }

    public void borrarPedido(int id) {
        String sql = "DELETE FROM pedido WHERE id_pedido=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Pedido Borrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar Pedido");
        }
    }

}
