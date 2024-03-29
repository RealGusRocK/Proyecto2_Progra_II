/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ModifPerfil.java
 *
 * Created on Nov 30, 2011, 1:41:41 PM
 */
package Clases;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class ModifPerfil extends javax.swing.JFrame {

    /** Creates new form ModifPerfil */
    String mail;
    public ModifPerfil(String correo) {
      Perfil  p=new Perfil(correo);
      mail=correo;
        initComponents();
        Object t=p.getTel();
        String b=t.toString();
        this.txt_tel.setText(b);
       this.ck_act.setSelected(true);
        Object dia=p.getDia();
        Object mes=p.getMes();
       Object anio=p.getAnio();
       String d=dia.toString();
       String m=mes.toString();
        String a=anio.toString();
        this.cmb_dia.setSelectedItem(d);
        this.cmb_mes.setSelectedItem(m);
        this.cmb_año.setSelectedItem(a);
        try {
            p.close();
        } catch (IOException ex) {
            System.out.println("amd");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmb_dia = new javax.swing.JComboBox();
        cmb_mes = new javax.swing.JComboBox();
        cmb_año = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        ck_act = new javax.swing.JCheckBox();
        ck_desa = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_tel = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bot_regresar1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bot_regresar = new javax.swing.JButton();
        modPerfil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(560, 420));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setText("Telefono");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 125, 120, 14);

        jLabel3.setText("Fecha de Nacimiento: ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 163, 130, 14);

        cmb_dia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cmb_dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_diaActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_dia);
        cmb_dia.setBounds(187, 158, 50, 20);

        cmb_mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        getContentPane().add(cmb_mes);
        cmb_mes.setBounds(260, 158, 50, 20);

        cmb_año.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", " " }));
        getContentPane().add(cmb_año);
        cmb_año.setBounds(331, 158, 70, 20);

        jLabel7.setText("Estado de Cuenta");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 204, 130, 14);

        ck_act.setText("Activada");
        ck_act.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ck_actMouseClicked(evt);
            }
        });
        ck_act.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck_actActionPerformed(evt);
            }
        });
        getContentPane().add(ck_act);
        ck_act.setBounds(10, 226, 130, 23);

        ck_desa.setText("Desactivada");
        ck_desa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ck_desaMouseClicked(evt);
            }
        });
        getContentPane().add(ck_desa);
        ck_desa.setBounds(10, 252, 130, 23);

        jScrollPane1.setViewportView(txt_tel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(168, 118, 256, 22);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Clases/Imagenes/logo3.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 3, 18));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Clases/Imagenes/Modificar%20Perfil.jpg"))); // NOI18N

        jLabel4.setText("DD/MM/AA");

        bot_regresar.setText("Regresar");
        bot_regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bot_regresarMouseClicked(evt);
            }
        });

        modPerfil.setText("Modificar");
        modPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modPerfilMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel1)
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(392, 392, 392)
                .addComponent(bot_regresar1)
                .addContainerGap(158, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addComponent(modPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(bot_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(bot_regresar1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modPerfil, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bot_regresar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 550, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_diaActionPerformed
        
}//GEN-LAST:event_cmb_diaActionPerformed

    private void ck_actActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck_actActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ck_actActionPerformed

    private void ck_actMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ck_actMouseClicked
        this.ck_act.setSelected(true);
        this.ck_desa.setSelected(false);
    }//GEN-LAST:event_ck_actMouseClicked

    private void ck_desaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ck_desaMouseClicked
        this.ck_desa.setSelected(true);
        this.ck_act.setSelected(false);
    }//GEN-LAST:event_ck_desaMouseClicked

    private void modPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modPerfilMouseClicked
        if(this.ck_desa.isSelected()){
            int a=JOptionPane.showConfirmDialog(this, "Esta Seguro que Desea Desactivar Su Cuenta?");
            if(a==0){
                Perfil  p=new Perfil(mail);
                
                dispose();
                p.cancelarCuenta();
                try {
                    p.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
                LogIn log=new LogIn();
                
                log.setVisible(true);
            }
        }else{
            Perfil  p=new Perfil(mail);
            int tel=Integer.parseInt(this.txt_tel.getText());
            int d=Integer.parseInt((String)(this.cmb_dia.getSelectedItem()));
            int m=Integer.parseInt((String)(this.cmb_mes.getSelectedItem()));
            int a=Integer.parseInt((String)(this.cmb_año.getSelectedItem()));
            Calendar c=Calendar.getInstance();
            c.set(a, m-1, d);
            p.modificarPerfil(tel, c.getTime());

            JOptionPane.showMessageDialog(null, "Perfil Modificado.");
            try {
                p.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Profile pr=new Profile(mail);
            dispose();
            pr.setVisible(true);
        }
    }//GEN-LAST:event_modPerfilMouseClicked

    private void bot_regresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bot_regresarMouseClicked
        Profile pr=new Profile(mail);
        dispose();
        pr.setVisible(true);
    }//GEN-LAST:event_bot_regresarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ModifPerfil("gustavo_ocampo@hotmail.com").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bot_regresar;
    private javax.swing.JLabel bot_regresar1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox ck_act;
    private javax.swing.JCheckBox ck_desa;
    private javax.swing.JComboBox cmb_año;
    private javax.swing.JComboBox cmb_dia;
    private javax.swing.JComboBox cmb_mes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modPerfil;
    private javax.swing.JTextPane txt_tel;
    // End of variables declaration//GEN-END:variables
}
