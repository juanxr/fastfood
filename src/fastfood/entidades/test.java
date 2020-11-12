/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.entidades;

import fastfood.modelo.Conexion;
import fastfood.modelo.MesaData;
import fastfood.modelo.MeseroData;
import fastfood.modelo.PedidoData;
import fastfood.modelo.ProductoData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus Lucero
 */
public class test {

   
    public static void main(String[] args) {
        Mesa mesa1 = new Mesa(1,true,6);
        Mesa mesa2 = new Mesa(2,true,2);
        Mesa mesa3 = new Mesa(3,true,4);
        Mesa mesa4 = new Mesa(4,false,10);
        
        Mesero juan = new Mesero(1,14669771,"27-14669771-2","Juan","Funes",true);
        Mesero fabio = new Mesero(4,15669772,"27-15669772-2","Fabio","Perez",true);
        Mesero claudio = new Mesero(5,27849637,"20-27849637-5","Claudio","Garcia",false);
        
        Producto cafe = new Producto(41,"Cafe",170.45,true);
        Producto tostado = new Producto(22,"Tostado",190.99,true);
        Producto submarino = new Producto(11,"Submarino",220,true);
        
        List<Producto> menu1 = new ArrayList<>();
        menu1.add(cafe);
        menu1.add(tostado);
        menu1.add(submarino);
        
        
        Pedido pedido = new Pedido(1,mesa1,juan,true,menu1);
        //System.out.println(pedido.calcularImporte());
       
        Conexion c=new Conexion();
        //MesaData mesaData1 = new MesaData(c);
       // mesaData1.guardarMesa(mesa1);
        
      //  MeseroData juanData = new MeseroData(c);
      //  juanData.guardarMesero(juan);
        
       // ProductoData menu1Data  = new ProductoData(c);
       // menu1Data.guardarProducto(tostado);
        
         // PedidoData pedidoData1 = new PedidoData(c);
        //  pedidoData1.guardarPedido(pedido);
        //  pedidoData1.borrarPedido(1);
        
        
        
        
        
        
    }
    
}
