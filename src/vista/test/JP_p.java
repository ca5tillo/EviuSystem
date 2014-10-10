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
public class JP_p extends javax.swing.JPanel {

    private String id;
    private String tarea;
    

    public JP_p(String id, String tarea, String[] t1, String[] t2) {
        
        
        this.id = id;
        this.tarea = tarea;
 initComponents();
        rb_no.setActionCommand("no");
        rb_si.setActionCommand("si");

       seleccion();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbg_realizo = new javax.swing.ButtonGroup();
        jl_id = new javax.swing.JLabel();
        jl_tarea = new javax.swing.JLabel();
        jb_siguiente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        rb_si = new javax.swing.JRadioButton();
        rb_no = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

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

        jTextArea1.setColumns(17);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel8.setText("Observaciones (Opcional)");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(rb_si)
                                .addGap(18, 18, 18)
                                .addComponent(rb_no)))
                        .addGap(0, 53, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jb_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rb_si)
                                .addComponent(rb_no))
                            .addGap(34, 34, 34)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jb_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
private void seleccion(){
        
            String realizo= jbg_realizo.getSelection().getActionCommand();
         
            JSONObject respuesta = new JSONObject();
            respuesta.put("id_pregunta",id);
            respuesta.put("pregunta",jl_tarea.getText());
            respuesta.put("realizo",realizo);
            respuesta.put("tiempo", "");
            respuesta.put("animo","");
            respuesta.put("nota",jTextArea1.getText());
            
            jb_siguiente.setActionCommand("" + respuesta);
        
    }
    private void jb_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_siguienteActionPerformed
        seleccion();
        this.setVisible(false);
    }//GEN-LAST:event_jb_siguienteActionPerformed

    private void rb_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_siActionPerformed
        seleccion();
    }//GEN-LAST:event_rb_siActionPerformed

    private void rb_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_noActionPerformed
        seleccion();
    }//GEN-LAST:event_rb_noActionPerformed
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JButton jb_siguiente;
    private javax.swing.ButtonGroup jbg_realizo;
    private javax.swing.JLabel jl_id;
    private javax.swing.JLabel jl_tarea;
    private javax.swing.JRadioButton rb_no;
    private javax.swing.JRadioButton rb_si;
    // End of variables declaration//GEN-END:variables
    
}
