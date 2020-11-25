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
    
    
    public void registrarReserva(Reserva reserva){
        int x=0;
        List<Reserva> reservaon = new ArrayList<>();
        reservaon=obtenerReservas();

        String sql="INSERT INTO reserva(id_mesa, dni, nombre, apellido, fecha, estado_reserva )"+
                "VALUES (?,?,?,?,?,?,?,?)";
        try{
            for(int i=0;i<reservaon.size();i++){
                
                Reserva res = reservaon.get(i);
                if(res.getDni()==reserva.getDni()&& res.getFecha().compareTo(reserva.getFecha())==0 && reserva.getMesa().isEstadoMesa()){
                    x++;
                }
                if(res.getMesa().getIdMesa()==reserva.getMesa().getIdMesa()&&res.getFecha().compareTo(reserva.getFecha())==0){
                    x++;
                }
            }
            if(x==0){
                
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, reserva.getMesa().getIdMesa());
            ps.setInt(2, reserva.getDni());
            ps.setString(3, reserva.getNombre());
            ps.setString(4, reserva.getApellido());
            ps.setDate(5, java.sql.Date.valueOf(reserva.getFecha()));
            ps.setBoolean(6, reserva.getEstadoReserva());
            
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                reserva.setIdReserva(rs.getInt(1));
            }else{
                JOptionPane.showMessageDialog(null,"No se obtuvo id");
            }
            ps.close();
            rs.close();
            //con.close();
            JOptionPane.showMessageDialog(null,"Reserva Registrada");
            
            }else{JOptionPane.showMessageDialog(null,"Ya se registro una reserva con ese DNI y en esa Fecha-Hora");}
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,"Error al registrar reserva");
        }
    }
    
    public void actualizarReserva(Reserva reserva){    
        String sql="UPDATE reserva SET id_mesa = ?, dni = ?, nombre = ?, apellido"
                + " = ?, fecha_reserva = ?,"
                + " estado_reserva =? , fecha_ahora = ?, cantidad_cliente = ? WHERE id_reserva=?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, reserva.getMesa().getIdMesa());
            ps.setInt(2, reserva.getDni());
            ps.setString(3, reserva.getNombre());
            ps.setString(4, reserva.getApellido());
            ps.setDate(5, java.sql.Date.valueOf(reserva.getFecha()));
            ps.setBoolean(6, reserva.getEstadoReserva());
            ps.setInt(9, reserva.getIdReserva());
            
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null,"Actualizacion realizada con exito");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al actualizar Reserva");
        }
        
    }
public Reserva buscarReserva(int id){
        Reserva reserva=null;
        String sql="SELECT * FROM reserva WHERE reserva.id_reserva=?";
        
        try{
            
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                reserva= new Reserva();
                reserva.setIdReserva(rs.getInt(1));
                Mesa m=buscarMesa(rs.getInt(2));
                reserva.setMesa(m);
                reserva.setDni(rs.getInt(3));
                reserva.setNombre(rs.getString(4));
                reserva.setApellido(rs.getString(5));
                reserva.setFecha(rs.getDate(6).toLocalDate());
                reserva.setEstadoReserva(rs.getBoolean(7));
               
                JOptionPane.showMessageDialog(null, "Reserva encontrada");
            }
            rs.close();
            ps.close();
            //con.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al buscar Reserva");
        }
        return reserva;
    }
     public Mesa buscarMesa(int id){
            Conexion c =new Conexion();
            MesaData ad = new MesaData(c);
            return ad.buscarMesa(id);      
    }
    
     public List<Reserva> obtenerReservas(){
         List<Reserva> reservas = new ArrayList<>();
         Reserva reserv;
         
         String sql="SELECT * FROM reserva";
         try{
             PreparedStatement ps= con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             
             while(rs.next()){
                 reserv = new Reserva();
                 reserv.setIdReserva(rs.getInt(1));
                 Mesa m =buscarMesa(rs.getInt(2));      
                 reserv.setMesa(m);
                 reserv.getMesa().setIdMesa(rs.getInt(2));
                 reserv.setDni(rs.getInt(3));
                 reserv.setNombre(rs.getString(4));
                 reserv.setApellido(rs.getString(5));
                 reserv.setFecha(rs.getDate(6).toLocalDate());
                 reserv.setEstadoReserva(rs.getBoolean(7));
                 reservas.add(reserv); 
             }
             ps.close();
             rs.close();
             //con.close();
         }catch(SQLException e){
             
             JOptionPane.showMessageDialog(null,"Error al Listar reservas");
         }
      return reservas;  
     }
public void borrarReserva(int id){
         String sql="DELETE FROM reserva WHERE reserva.id_reserva=?";
         try{
             PreparedStatement ps =con.prepareStatement(sql);
             ps.setInt(1, id);
             ps.executeUpdate();
             JOptionPane.showMessageDialog(null, "Reserva Eliminada");  
             
         }catch(HeadlessException | SQLException e){
             JOptionPane.showMessageDialog(null, "No se pudo eliminar reserva", "Error", JOptionPane.WARNING_MESSAGE);
         }
    
    }}
 