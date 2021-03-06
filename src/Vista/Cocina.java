/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis Sepulveda
 */
public class Cocina extends javax.swing.JFrame {

    private Controlador Controlador;

    public Cocina(Controlador Controlador) {

        this.Controlador = Controlador;
        initComponents();
        lblprocesar.setVisible(false);
        this.setLocationRelativeTo(null);                                       //Centrar la ventana
    }

    Cocina() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        jButton2 = new javax.swing.JButton();
        tiempoTxtField = new javax.swing.JTextField();
        progress = new javax.swing.JProgressBar();
        lblprocesar = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        CocinaTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jButton2.setText("Cocinar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 600, 110, -1));
        jPanel1.add(tiempoTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, 130, 30));
        jPanel1.add(progress, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 520, 20));

        lblprocesar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblprocesar.setText("Cocinando...");
        jPanel1.add(lblprocesar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 100, -1));

        CocinaTable.setFont(new java.awt.Font("Kartika", 1, 13)); // NOI18N
        CocinaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#Mesa", "#Camarero", "Pedidos", "#Orden"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CocinaTable.getTableHeader().setResizingAllowed(false);
        CocinaTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(CocinaTable);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 830, 360));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 1, 29)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("COCINA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 850, 46));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/f3.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int fila = CocinaTable.getSelectedRow();
        System.out.println(fila);
        if (fila != -1) {

            DefaultTableModel model = (DefaultTableModel) CocinaTable.getModel();
            String valor = model.getValueAt(fila, 0).toString();
            int num = Integer.parseInt(valor);
            Controlador.ObtenerMesa(num).setProceso(1);
            try {
                Controlador.ActualizarStock();
            } catch (IOException ex) {
                Logger.getLogger(Cocina.class.getName()).log(Level.SEVERE, null, ex);
            }

            ProgressBar p = new ProgressBar(lblprocesar, progress, tiempoTxtField, CocinaTable);
            p.execute();
        }


    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Cocina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cocina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cocina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cocina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Controlador c = null;
                new Cocina(c).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable CocinaTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblprocesar;
    private javax.swing.JProgressBar progress;
    private javax.swing.JTextField tiempoTxtField;
    // End of variables declaration//GEN-END:variables
}
