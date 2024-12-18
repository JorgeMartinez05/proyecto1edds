/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Coberturas.BFS;
import Coberturas.DFS;
import EDD.Lista;
import Funcionalidades.Funcion;
import Funcionalidades.Validacion;
import static GUI.CargaDeRed.grafoEDD;
import static GUI.CargaDeRed.t;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Enrique León
 */
public class Coberturas extends javax.swing.JFrame {
    
    DefaultComboBoxModel estacionesCobertura = new DefaultComboBoxModel ();
    private Funcion funcion = new Funcion();
    private BFS coberturaBFS = new BFS();
    private DFS coberturaDFS = new DFS (grafoEDD, t);

    
    public Coberturas() {
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        estacionesCobertura.removeAllElements();
        this.llenarComboBoxEstaciones();
    }
        
    private void llenarComboBoxEstaciones(){
        estacionesCobertura.removeAllElements();
        Lista nombres = funcion.estacionesConSucursal(grafoEDD);
        for (int i = 0; i < nombres.getSize(); i++) {
            String nombreActual = (String) nombres.getValor(i);
            estacionesCobertura.addElement(nombreActual);
        }
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
        jLabel2 = new javax.swing.JLabel();
        nombreEstacionInicial = new javax.swing.JComboBox<>();
        revisarCobertura = new javax.swing.JButton();
        volverMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Revisar coberturas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 320, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setText("Seleccione la estación: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, 20));

        nombreEstacionInicial.setModel(estacionesCobertura);
        nombreEstacionInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreEstacionInicialActionPerformed(evt);
            }
        });
        jPanel1.add(nombreEstacionInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 360, -1));

        revisarCobertura.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        revisarCobertura.setText("Revisar Cobertura");
        revisarCobertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revisarCoberturaActionPerformed(evt);
            }
        });
        jPanel1.add(revisarCobertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 180, -1));

        volverMenu.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        volverMenu.setText("Ir al menú");
        volverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverMenuActionPerformed(evt);
            }
        });
        jPanel1.add(volverMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreEstacionInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreEstacionInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreEstacionInicialActionPerformed

    private void revisarCoberturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revisarCoberturaActionPerformed
        String tipoBusqueda="";
        Validacion validar = new Validacion();
        tipoBusqueda = JOptionPane.showInputDialog("Coloque el tipo de busqueda (BFS o DFS): ");
        while(validar.validarTipoBusqueda(tipoBusqueda) == -1){
            tipoBusqueda = JOptionPane.showInputDialog("Coloque el tipo de busqueda (BFS o DFS): ");
        }
        
        String nombreEstacion = (String) nombreEstacionInicial.getSelectedItem();
        if(validar.validarTipoBusqueda(tipoBusqueda) == 0){
            coberturaBFS.recorridoBFS(grafoEDD.buscarEstacion(nombreEstacion), t);
        }else{
            coberturaDFS.busquedaDFS(grafoEDD.buscarEstacion(nombreEstacion));
        }
    }//GEN-LAST:event_revisarCoberturaActionPerformed

    private void volverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverMenuActionPerformed
        MenuPrincipal menu = new MenuPrincipal();
        this.dispose();
    }//GEN-LAST:event_volverMenuActionPerformed

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
            java.util.logging.Logger.getLogger(Coberturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Coberturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Coberturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Coberturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Coberturas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> nombreEstacionInicial;
    private javax.swing.JButton revisarCobertura;
    private javax.swing.JButton volverMenu;
    // End of variables declaration//GEN-END:variables
}
