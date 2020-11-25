package fastfood.modelo;

import fastfood.entidades.Remito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class RemitoData {
     private Connection con;

    public RemitoData(Conexion c) {
        con = c.getConnection();
    }
    
    public void guardarRemito(Remito re){
        String sql="INSERT INTO detalle_pedido ( id_pedido , id_producto , cantidad , importe ) VALUES (?,?,?,?)";
                try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, re.getPedido().getIdPedido());
            ps.setInt(2, re.getProducto().getIdProducto());
            ps.setInt(3, re.getCantidad());
            ps.setDouble(4, re.getImporte());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                re.setIdRemito(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "detalle pedido no guardado");
        }
    }

Remito re= new Remito();
        String sql="SELECT * FROM remito WHERE id_remito=? ";
}