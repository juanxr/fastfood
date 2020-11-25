
package fastfood.modelo;

import java.sql.*;
import java.util.*;
import fastfood.entidades.*;
import javax.swing.JOptionPane;


public class MesaData {
      private Connection con;
    
    public MesaData(Conexion conexion){
        con=conexion.getConnection();  
    }
    
    public void guardarMesa(Mesa mesa){
        String sql="INSERT INTO mesa(estado_mesa, capacidad_mesa) VALUES (?,?)";
        
        try{
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setBoolean(1,mesa.isEstadoMesa());
            ps.setInt(2, mesa.getCapacidadMesa());
            ps.executeUpdate();
            
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                mesa.setIdMesa(rs.getInt(1));
            }else{
                JOptionPane.showMessageDialog(null,"No se pudo obtener IDMesa");
            }
            
        rs.close();
        ps.close();
        //con.close();
        JOptionPane.showMessageDialog(null,"Mesa guardada");
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al guardar mesa");
        }
    }
    
    public Mesa buscarMesa(int id){
        Mesa mesa=null;
        
        String sql="SELECT * FROM mesa WHERE id_mesa=(?)";
        
        try{
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs= ps.executeQuery();
            
            if(rs.next()){
                mesa = new Mesa();
                mesa.setIdMesa(rs.getInt(1));               
                mesa.setEstadoMesa(rs.getBoolean(2));       
                mesa.setCapacidadMesa(rs.getInt(3));      
                
                JOptionPane.showMessageDialog(null, "Mesa encontrada");
            }
            
        rs.close();
        ps.close();
        //con.close();
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al guardar mesa");
        }
    return mesa;
    }

public ArrayList<Mesa> obtenerMesas(){
        Mesa mesa= null;
        ArrayList<Mesa> mesas= new ArrayList<>();
        String sql="SELECT * FROM mesa";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                mesa = new Mesa();
                mesa.setIdMesa(rs.getInt(1));
                mesa.setEstadoMesa(rs.getBoolean(2));
                mesa.setCapacidadMesa(rs.getInt(3));
                mesas.add(mesa);
            }
            JOptionPane.showMessageDialog(null, "Mesas encontradas");
         ps.close();
         rs.close();
         //con.close();
         
        }catch(SQLException e){   
            JOptionPane.showMessageDialog(null, "Mesas no encontradas ", "Error!", JOptionPane.WARNING_MESSAGE);   
        }
        
    return mesas;
    }
    
    public ArrayList<Mesa> obtenerMesasDisponibles(){
        Mesa mesa= null;
        ArrayList<Mesa> mesas= new ArrayList<>();
        String sql="SELECT * FROM mesa WHERE estado_mesa = 1";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                mesa = new Mesa();
                mesa.setIdMesa(rs.getInt(1));
                mesa.setEstadoMesa(rs.getBoolean(2));
                mesa.setCapacidadMesa(rs.getInt(3));
                mesas.add(mesa);
            }
            
         ps.close();
         rs.close();
         //con.close();
         
        }catch(SQLException e){   
            JOptionPane.showMessageDialog(null, "Mesas no encontradas ", "Error!", JOptionPane.WARNING_MESSAGE);   
        }
        
    return mesas;
    }
    
    public void actualizarMesa(Mesa mesa){
        String sql="UPDATE mesa SET estado_mesa= ?, capacidad_maxima= ? WHERE id_mesa";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, mesa.isEstadoMesa());
            ps.setInt(2, mesa.getCapacidadMesa());
            ps.setInt(3, mesa.getIdMesa());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Mesa Actualizada");
            
            ps.close();
            //con.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Mesa no actualizada ", "Error!", JOptionPane.WARNING_MESSAGE);
    }
    
  }
    
  public void borrarMesa(int id){
      String sql="DELETE FROM mesa WHERE id_mesa=?";
      
      try{
          PreparedStatement ps=con.prepareStatement(sql);
          ps.setInt(1, id);
          ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "Mesa Borrada");
          ps.close();
          //con.close();
          
      }catch(SQLException e){
          JOptionPane.showMessageDialog(null, "Mesa no borrada ", "Error!", JOptionPane.WARNING_MESSAGE);
      }
  }
}
    

