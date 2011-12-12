/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HomeFeed.java
 *
 * Created on Nov 24, 2011, 9:39:13 PM
 */
package Clases;

import java.io.IOException;

/**
 *
 * @author Gustavo
 */
public class HomeFeed extends javax.swing.JFrame {

    /** Creates new form HomeFeed */
        String perfil;
    
    public HomeFeed(String correo) {
     Posts   p=new Posts(correo);
        perfil=correo;
        initComponents();
        this.txt_postIn.setText(p.getPostIn());
        try {
            p.cerrar();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_postIn = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_Perfil = new javax.swing.JLabel();
        lbl_salir = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        txt_postIn.setColumns(20);
        txt_postIn.setEditable(false);
        txt_postIn.setRows(5);
        jScrollPane1.setViewportView(txt_postIn);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 129, 565, 390);

        jLabel3.setFont(new java.awt.Font("Vineta BT", 0, 14));
        jLabel3.setText("Actualizaciones Recientes ");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 95, 309, 32);

        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 3, 24));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Clases/Imagenes/facebinpequeño.jpg"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 230, 55);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lbl_Perfil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_Perfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Clases/Imagenes/Mi%20Perfil.jpg"))); // NOI18N
        lbl_Perfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_PerfilMouseClicked(evt);
            }
        });

        lbl_salir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Clases/Imagenes/Salir.jpg"))); // NOI18N
        lbl_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_salirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(323, Short.MAX_VALUE)
                .addComponent(lbl_Perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lbl_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(481, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 570, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseClicked

        LogIn l = new LogIn();         dispose();         l.setVisible(true);     }//GEN-LAST:event_lbl_salirMouseClicked

    private void lbl_PerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_PerfilMouseClicked

        Profile p = new Profile(perfil);         dispose();         p.setVisible(true);     }//GEN-LAST:event_lbl_PerfilMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new HomeFeed("").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Perfil;
    private javax.swing.JLabel lbl_salir;
    private javax.swing.JTextArea txt_postIn;
    // End of variables declaration//GEN-END:variables
}
