/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import static GUI.CargaDeRed.grafoEDD;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public MenuPrincipal() {
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        colocarSucursal = new javax.swing.JButton();
        eliminarSucursal = new javax.swing.JButton();
        Coberturas = new javax.swing.JButton();
        EstablecerValorT = new javax.swing.JButton();
        mostrarRed = new javax.swing.JButton();
        CargarRed = new javax.swing.JButton();
        AgregarLineas = new javax.swing.JButton();
        SalirMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Menu Principal");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        colocarSucursal.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        colocarSucursal.setText("Colocar sucursal");
        colocarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colocarSucursalActionPerformed(evt);
            }
        });
        jPanel1.add(colocarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 180, -1));

        eliminarSucursal.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        eliminarSucursal.setText("Eliminar sucursal");
        eliminarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarSucursalActionPerformed(evt);
            }
        });
        jPanel1.add(eliminarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 180, -1));

        Coberturas.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        Coberturas.setText("Coberturas");
        Coberturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoberturasActionPerformed(evt);
            }
        });
        jPanel1.add(Coberturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 180, 30));

        EstablecerValorT.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        EstablecerValorT.setText("Establecer valor T");
        EstablecerValorT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstablecerValorTActionPerformed(evt);
            }
        });
        jPanel1.add(EstablecerValorT, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        mostrarRed.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        mostrarRed.setText("Mostrar red");
        mostrarRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarRedActionPerformed(evt);
            }
        });
        jPanel1.add(mostrarRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 180, -1));

        CargarRed.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        CargarRed.setText("Cargar red");
        CargarRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarRedActionPerformed(evt);
            }
        });
        jPanel1.add(CargarRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 180, -1));

        AgregarLineas.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        AgregarLineas.setText("Agregar línea");
        AgregarLineas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarLineasActionPerformed(evt);
            }
        });
        jPanel1.add(AgregarLineas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 170, -1));

        SalirMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SalirMenu.setForeground(new java.awt.Color(0, 0, 255));
        SalirMenu.setText("X");
        SalirMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirMenuActionPerformed(evt);
            }
        });
        jPanel1.add(SalirMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void colocarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colocarSucursalActionPerformed
        ColocarSucursal colocarSucursal = new ColocarSucursal();
        this.dispose();
    }//GEN-LAST:event_colocarSucursalActionPerformed

    private void CargarRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarRedActionPerformed
        grafoEDD.destruir();
        CargaDeRed cargarRed = new CargaDeRed();
        this.dispose();


    }//GEN-LAST:event_CargarRedActionPerformed

    private void EstablecerValorTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstablecerValorTActionPerformed
        EstablecerValorT establecerValorT = new EstablecerValorT();
        this.dispose();
    }//GEN-LAST:event_EstablecerValorTActionPerformed

    private void eliminarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarSucursalActionPerformed
        if (grafoEDD.haySucursales()) {
            EliminarSucursal eliminarSucursal = new EliminarSucursal();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debes agregar sucursales para poder entrar a esta sección");
        }
    }//GEN-LAST:event_eliminarSucursalActionPerformed

    private void AgregarLineasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarLineasActionPerformed
        AgregarEstaciones aggEstaciones = new AgregarEstaciones();
        this.dispose();
    }//GEN-LAST:event_AgregarLineasActionPerformed

    private void CoberturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoberturasActionPerformed
        if (grafoEDD.haySucursales()) {
            Coberturas cobertura = new Coberturas();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debes agregar suscursales para poder entrar a esta seccion");
        }
    }//GEN-LAST:event_CoberturasActionPerformed

    private void SalirMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirMenuActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirMenuActionPerformed

    private void mostrarRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarRedActionPerformed
       System.setProperty("org.graphstream.ui", "swing");
        MostrarGrafo mostrarGrafo = new MostrarGrafo(grafoEDD);
        mostrarGrafo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mostrarRedActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarLineas;
    private javax.swing.JButton CargarRed;
    private javax.swing.JButton Coberturas;
    private javax.swing.JButton EstablecerValorT;
    private javax.swing.JButton SalirMenu;
    private javax.swing.JButton colocarSucursal;
    private javax.swing.JButton eliminarSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton mostrarRed;
    // End of variables declaration//GEN-END:variables
}
