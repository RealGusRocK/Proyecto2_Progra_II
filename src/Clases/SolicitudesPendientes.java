/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SolicitudesPendientes.java
 *
 * Created on Dec 3, 2011, 9:23:35 PM
 */
package Clases;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class SolicitudesPendientes extends javax.swing.JFrame {

    /** Creates new form SolicitudesPendientes */
    String mail;
    public SolicitudesPendientes(String correo) {
        mail=correo;
        initComponents();
        ManageFriends mf=new ManageFriends(correo);
        addComboBox(mf.getListadoSolicitudes());
        this.txt_lista.setText(mf.listarAmigosPendientes());
        try {
            mf.cerrarConexion();
        } catch (IOException ex) {
            System.out.println("txt");
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_lista = new javax.swing.JTextPane();
        cmb_listado = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bot_return = new javax.swing.JButton();
        bot_rechazar = new javax.swing.JButton();
        bot_aceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(562, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 3, 18));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Clases/Imagenes/Solicitudes%20Pendientes.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(128, 11, 314, 39);

        txt_lista.setEditable(false);
        jScrollPane1.setViewportView(txt_lista);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 68, 277, 278);

        cmb_listado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        getContentPane().add(cmb_listado);
        cmb_listado.setBounds(305, 156, 180, 20);

        jLabel2.setText("Lista de Solicitudes Pendientes");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(305, 136, 250, 14);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        bot_return.setText("Regresar");
        bot_return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bot_returnMouseClicked(evt);
            }
        });

        bot_rechazar.setText("Rechazar");
        bot_rechazar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bot_rechazarMouseClicked(evt);
            }
        });

        bot_aceptar.setText("Aceptar");
        bot_aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bot_aceptarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(296, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bot_return)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bot_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bot_rechazar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(229, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bot_rechazar)
                    .addComponent(bot_aceptar))
                .addGap(65, 65, 65)
                .addComponent(bot_return)
                .addGap(30, 30, 30))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 560, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bot_aceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bot_aceptarMouseClicked
        ManageFriends mf=new ManageFriends(mail);
        if(!this.cmb_listado.getSelectedItem().equals("")){
            String n=(String) this.cmb_listado.getSelectedItem();
            if(mf.aceptarSolicitud(n)){
                JOptionPane.showMessageDialog(null,"Solicitud Aceptada.");
            }
            addComboBox(mf.getListadoSolicitudes());
            this.txt_lista.setText(mf.listarAmigosPendientes());
        }
        try {
            mf.cerrarConexion();
        } catch (IOException ex) {
            System.out.println("txt");
        }
    }//GEN-LAST:event_bot_aceptarMouseClicked

    private void bot_rechazarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bot_rechazarMouseClicked
        ManageFriends mf=new ManageFriends(mail);
        if(!this.cmb_listado.getSelectedItem().equals("")){
            String n=(String) this.cmb_listado.getSelectedItem();
            if(mf.rechazarSolicitud(n)){
                JOptionPane.showMessageDialog(null,"Solicitud Rechazada.");
            }
            addComboBox(mf.getListadoSolicitudes());
            this.txt_lista.setText(mf.listarAmigosPendientes());
        }
        try {
            mf.cerrarConexion();
        } catch (IOException ex) {
            System.out.println("txt");
        }
    }//GEN-LAST:event_bot_rechazarMouseClicked

    private void bot_returnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bot_returnMouseClicked
        Profile p=new Profile(mail);
        dispose();
        p.setVisible(true);
    }//GEN-LAST:event_bot_returnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SolicitudesPendientes("prueba4").setVisible(true);
            }
        });
    }
    
    private void addComboBox(String ar[]){
        this.cmb_listado.removeAllItems();
        this.cmb_listado.addItem("");
        for(int i=0;i<ar.length;i++){
            this.cmb_listado.addItem(ar[i]);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bot_aceptar;
    private javax.swing.JButton bot_rechazar;
    private javax.swing.JButton bot_return;
    private javax.swing.JComboBox cmb_listado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane txt_lista;
    // End of variables declaration//GEN-END:variables
}
