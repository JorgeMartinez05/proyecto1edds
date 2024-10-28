/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import EDD.Lista;
import Funcionalidades.Funcion;
import static GUI.CargaDeRed.grafoEDD;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Enrique León
 */
public class ColocarSucursal extends javax.swing.JFrame {

    DefaultComboBoxModel modeloEstaciones = new DefaultComboBoxModel();
    private Funcion funcion = new Funcion();
    
    public ColocarSucursal() {
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.llenarComboBoxEstaciones();
    }

    
    private void llenarComboBoxEstaciones() {
        modeloEstaciones.removeAllElements();
        Lista nombres = funcion.estacionesSinSucursal(grafoEDD);
        for (int i = 0; i < nombres.getSize(); i++) {
            String nombreActual = (String) nombres.getValor(i);
            modeloEstaciones.addElement(nombreActual);
        }
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        estacionesSinSucursal = new javax.swing.JComboBox<>();
        colocarSucursal = new javax.swing.JButton();
        irMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Colocar sucursal");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setText("Seleccione la estación donde desees colocar la sucursal:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        estacionesSinSucursal.setModel(modeloEstaciones);
        jPanel1.add(estacionesSinSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 290, -1));

        colocarSucursal.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        colocarSucursal.setText("Colocar sucursal");
        colocarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colocarSucursalActionPerformed(evt);
            }
        });
        jPanel1.add(colocarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 200, -1));

        irMenu.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        irMenu.setText("Ir al menú");
        irMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irMenuActionPerformed(evt);
            }
        });
        jPanel1.add(irMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void colocarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colocarSucursalActionPerformed
        String nombre = (String) estacionesSinSucursal.getSelectedItem();
        grafoEDD.buscarEstacion(nombre).getEstacion().setSucursal(true);
        this.llenarComboBoxEstaciones();
    }//GEN-LAST:event_colocarSucursalActionPerformed

    private void irMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irMenuActionPerformed
       MenuPrincipal menu = new MenuPrincipal();
       this.dispose();
    }//GEN-LAST:event_irMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ColocarSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColocarSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColocarSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColocarSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColocarSucursal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton colocarSucursal;
    private javax.swing.JComboBox<String> estacionesSinSucursal;
    private javax.swing.JButton irMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
