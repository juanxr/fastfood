package fastfood.modelo;

import java.sql.*;

import java.util.*;
import javax.swing.JOptionPane;
import fastfood.entidades.*;

public class ProductoData {

    private Connection con;

    public ProductoData(Conexion c) {
        con = c.getConnection();
    }
//INSERT INTO `producto` (`id_producto`, `nombre_producto`, `precio`, `estado_ producto`) VALUES (NULL, 'Tostado', '155.33', '1')
    public void guardarProducto(Producto producto) {
        String sql = "INSERT INTO `producto` (`nombre_producto`, `precio`, `estado_ producto`) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombreProducto());
            ps.setDouble(2, producto.getPrecio());
            ps.setBoolean(3, producto.getEstadoProducto());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No se puede obtener id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Producto buscarProducto(int id) {
        Producto p = null;
        String sql = "SELECT * FROM producto WHERE id_producto=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Producto();
                p.setIdProducto(rs.getInt(1));
                p.setNombreProducto(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setEstadoProducto(rs.getBoolean(4));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudeo encontrar producto");
        }
        return p;
    }

    public ArrayList<Producto> obtenerProductos() {
        Producto p;
        ArrayList<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p = new Producto();
                p.setIdProducto(rs.getInt(1));
                p.setNombreProducto(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setEstadoProducto(rs.getBoolean(4));
                productos.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener productos");
        }
        return productos;
    }

    public List<Producto> obtenerProductosDisponibles() {
        Producto p;
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE estado_producto=1 ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p = new Producto();
                p.setIdProducto(rs.getInt(1));
                p.setNombreProducto(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setEstadoProducto(rs.getBoolean(4));
                productos.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener productos");
        }
        return productos;
    }

    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE producto SET nombre_producto =? ,precio =? , estado_producto =? WHERE id_producto=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombreProducto());
            ps.setDouble(2, producto.getPrecio());
            ps.setBoolean(3, producto.getEstadoProducto());
            ps.setInt(4, producto.getIdProducto());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no se pudo actualizar producto");
        }
    }

    public void borrarProducto(int id) {

        String sql = "DELETE FROM producto WHERE id_producto=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo borrar producto");
        }
    }
}
