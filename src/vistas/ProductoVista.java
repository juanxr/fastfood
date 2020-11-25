/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import fastfood.entidades.Producto;
import fastfood.modelo.Conexion;
import fastfood.modelo.ProductoData;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class ProductoVista extends javax.swing.JInternalFrame {

    private ProductoData pd;
    private Conexion conexion;

    public ProductoVista() {
        initComponents();
        this.setLocation(310, 50);
        conexion = new Conexion();
        pd = new ProductoData(conexion);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbGuardar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jcbActualizar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jtfId = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jtfPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JCheckBox();

        jLabel1.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 48)); // NOI18N
        jLabel1.setText("~Producto~");

        jLabel2.setText("Id:");

        jLabel3.setText("Nombre del producto:");

        jLabel4.setText("Precio:");

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbBorrar.setText("Borrar");
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        jcbActualizar.setText("Actualizar");
        jcbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbActualizarActionPerformed(evt);
            }
        });

        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jtfPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPrecioActionPerformed(evt);
            }
        });

        jLabel5.setText("Estado");

        jcbEstado.setText("Activo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jbGuardar)
                                .addGap(145, 145, 145)
                                .addComponent(jcbActualizar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcbEstado)
                                            .addComponent(jbBorrar, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(114, 114, 114)
                                        .addComponent(jbBuscar)))))))
                .addContainerGap(134, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbLimpiar)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jbBuscar)
                    .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jbLimpiar)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbBorrar)
                    .addComponent(jcbActualizar))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPrecioActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        int x = JOptionPane.showConfirmDialog(this, "Esta seguro que desea BORRAR el mesero?", "ATENCION!!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(jtfId.getText());
            pd.borrarProducto(id);
            limpiar();}
    }//GEN-LAST:event_jbBorrarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        int x = JOptionPane.showConfirmDialog(this, "Esta seguro que desea GUARDAR el mesero?", "ATENCION!!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x == JOptionPane.YES_OPTION) {
            String nombre = jtfNombre.getText();
            double precio = Double.parseDouble(jtfPrecio.getText());
            boolean estado = jcbEstado.isSelected();
            Producto producto = new Producto(nombre,precio, estado);
            pd.guardarProducto(producto);
            jtfId.setText(producto.getIdProducto()+"");
            if (jtfNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "No puede dejar el campo nombre vacio");
            }
            limpiar();
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jcbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbActualizarActionPerformed
        boolean cargado = true;
        if (jtfId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo id esta vacio: " + jtfId.getText(), "ERROR!", JOptionPane.WARNING_MESSAGE);
        }
        if (cargado) {
            int id = Integer.parseInt(jtfId.getText());
            Producto producto  = pd.buscarProducto(id);
            if (producto != null) {
                //jtfId.setText(producto.getIdProducto() + "");
                jtfNombre.setText(producto.getNombreProducto()+ "");
                jtfPrecio.setText(producto.getPrecio()+ "");
                jcbEstado.setSelected(producto.getEstadoProducto());
                limpiar();
            }
        }
    }//GEN-LAST:event_jcbActualizarActionPerformed
    void limpiar(){
    jtfId.setText("");
    jtfNombre.setText("");
    jtfPrecio.setText("");
    jcbEstado.setSelected(false);
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jcbActualizar;
    private javax.swing.JCheckBox jcbEstado;
    private javax.swing.JTextField jtfId;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfPrecio;
    // End of variables declaration//GEN-END:variables
}
