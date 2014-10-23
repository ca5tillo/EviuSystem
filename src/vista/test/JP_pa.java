/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.test;

import java.awt.event.*;
import javax.swing.Timer;
import org.json.simple.JSONObject;

/**
 *
 * @author lp-ub-14
 */
public class JP_pa extends javax.swing.JPanel {

    private String id;
    private String tarea;

    public JP_pa(String id, String tarea, String[] t1, String[] t2) {

        this.id = id;
        this.tarea = tarea;
        initComponents();
        rb_desepcionado.setActionCommand("desepcionado");
        rb_enojado.setActionCommand("enojado");
        rb_feliz.setActionCommand("feliz");
        rb_impaciente.setActionCommand("impaciente");
        rb_na.setActionCommand("n-a");
        rb_no.setActionCommand("no");
        rb_si.setActionCommand("si");
        seleccion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbg_tiempo = new javax.swing.ButtonGroup();
        jbg_realizo = new javax.swing.ButtonGroup();
        jbg_animo = new javax.swing.ButtonGroup();
        jl_id = new javax.swing.JLabel();
        jl_tarea = new javax.swing.JLabel();
        jb_siguiente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        rb_si = new javax.swing.JRadioButton();
        rb_no = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        rb_feliz = new javax.swing.JRadioButton();
        rb_impaciente = new javax.swing.JRadioButton();
        rb_enojado = new javax.swing.JRadioButton();
        rb_na = new javax.swing.JRadioButton();
        rb_desepcionado = new javax.swing.JRadioButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue));

        jl_id.setText(id);

        jl_tarea.setText(tarea);

        jb_siguiente.setText("Siguiente");
        jb_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_siguienteActionPerformed(evt);
            }
        });

        jLabel6.setText("Se Realizo la tarea.");

        jbg_realizo.add(rb_si);
        rb_si.setSelected(true);
        rb_si.setText("Si");
        rb_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_siActionPerformed(evt);
            }
        });

        jbg_realizo.add(rb_no);
        rb_no.setText("No");
        rb_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_noActionPerformed(evt);
            }
        });

        jLabel7.setText("Estado de animo.");

        jTextArea1.setColumns(17);
        jTextArea1.setRows(5);
        jTextArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea1FocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jLabel8.setText("Observaciones (Opcional)");

        jbg_animo.add(rb_feliz);
        rb_feliz.setText("Feliz");
        rb_feliz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_felizActionPerformed(evt);
            }
        });

        jbg_animo.add(rb_impaciente);
        rb_impaciente.setText("Impaciente");
        rb_impaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_impacienteActionPerformed(evt);
            }
        });

        jbg_animo.add(rb_enojado);
        rb_enojado.setText("Enojado");
        rb_enojado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_enojadoActionPerformed(evt);
            }
        });

        jbg_animo.add(rb_na);
        rb_na.setSelected(true);
        rb_na.setText("N/A");
        rb_na.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_naActionPerformed(evt);
            }
        });

        jbg_animo.add(rb_desepcionado);
        rb_desepcionado.setText("Desepcionado");
        rb_desepcionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_desepcionadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_id)
                        .addGap(18, 18, 18)
                        .addComponent(jl_tarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(rb_si)
                                        .addGap(18, 18, 18)
                                        .addComponent(rb_no))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(rb_feliz)
                                .addGap(18, 18, 18)
                                .addComponent(rb_impaciente)
                                .addGap(18, 18, 18)
                                .addComponent(rb_desepcionado)
                                .addGap(18, 18, 18)
                                .addComponent(rb_enojado)
                                .addGap(18, 18, 18)
                                .addComponent(rb_na)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jb_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_id)
                    .addComponent(jl_tarea))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb_si)
                            .addComponent(rb_no))
                        .addGap(34, 34, 34))
                    .addComponent(jb_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_feliz)
                    .addComponent(rb_impaciente)
                    .addComponent(rb_desepcionado)
                    .addComponent(rb_enojado)
                    .addComponent(rb_na))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
private void seleccion() {

        String realizo = jbg_realizo.getSelection().getActionCommand();
        String animo = jbg_animo.getSelection().getActionCommand();

        JSONObject respuesta = new JSONObject();
        respuesta.put("id_pregunta", id);
        respuesta.put("pregunta", jl_tarea.getText());
        respuesta.put("realizo", realizo);
        respuesta.put("tiempo", "");
        respuesta.put("animo", animo);
        respuesta.put("nota", jTextArea1.getText());
        
        jb_siguiente.setActionCommand("" + respuesta);

    }
    private void jb_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_siguienteActionPerformed
        seleccion();
        this.setVisible(false);
        
    }//GEN-LAST:event_jb_siguienteActionPerformed

    private void rb_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_siActionPerformed
        // TODO add your handling code here:
        seleccion();
    }//GEN-LAST:event_rb_siActionPerformed

    private void rb_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_noActionPerformed
        // TODO add your handling code here:
        seleccion();
    }//GEN-LAST:event_rb_noActionPerformed

    private void rb_felizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_felizActionPerformed
        // TODO add your handling code here:
        seleccion();
    }//GEN-LAST:event_rb_felizActionPerformed

    private void rb_impacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_impacienteActionPerformed
        // TODO add your handling code here:
        seleccion();
    }//GEN-LAST:event_rb_impacienteActionPerformed

    private void rb_desepcionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_desepcionadoActionPerformed
        // TODO add your handling code here:
        seleccion();
    }//GEN-LAST:event_rb_desepcionadoActionPerformed

    private void rb_enojadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_enojadoActionPerformed
        // TODO add your handling code here:
        seleccion();
    }//GEN-LAST:event_rb_enojadoActionPerformed

    private void rb_naActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_naActionPerformed
        // TODO add your handling code here:
        seleccion();
    }//GEN-LAST:event_rb_naActionPerformed

    private void jTextArea1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea1FocusLost
        seleccion();
    }//GEN-LAST:event_jTextArea1FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JButton jb_siguiente;
    private javax.swing.ButtonGroup jbg_animo;
    private javax.swing.ButtonGroup jbg_realizo;
    private javax.swing.ButtonGroup jbg_tiempo;
    private javax.swing.JLabel jl_id;
    private javax.swing.JLabel jl_tarea;
    private javax.swing.JRadioButton rb_desepcionado;
    private javax.swing.JRadioButton rb_enojado;
    private javax.swing.JRadioButton rb_feliz;
    private javax.swing.JRadioButton rb_impaciente;
    private javax.swing.JRadioButton rb_na;
    private javax.swing.JRadioButton rb_no;
    private javax.swing.JRadioButton rb_si;
    // End of variables declaration//GEN-END:variables

}
