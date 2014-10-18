package vista;

import org.json.simple.JSONArray;
import vista.inicio.*;

public  class Eviu extends javax.swing.JFrame {

    private final java.awt.Container contenPane = getContentPane();
    /*JSONArray perfil
        Es una lista de objetos JSON de la siguiente forma 
        {"categoria":"categoria",
         "opcion":"opcion"}
    */
    private org.json.simple.JSONArray perfil = new org.json.simple.JSONArray();
    public Eviu() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Eviu");
        contenPane.add(new JP_inicio());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jmb_barra = new javax.swing.JMenuBar();
        jm_archivo = new javax.swing.JMenu();
        jmi_abrirProyecto = new javax.swing.JMenuItem();
        jmi_nuevoProyecto = new javax.swing.JMenuItem();
        jm_editar = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jm_archivo.setText("Archivo");

        jmi_abrirProyecto.setText("Abrir Proyecto");
        jmi_abrirProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_abrirProyectoActionPerformed(evt);
            }
        });
        jm_archivo.add(jmi_abrirProyecto);

        jmi_nuevoProyecto.setText("Nuevo Proyecto");
        jmi_nuevoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_nuevoProyectoActionPerformed(evt);
            }
        });
        jm_archivo.add(jmi_nuevoProyecto);

        jmb_barra.add(jm_archivo);

        jm_editar.setText("Editar");

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jm_editar.add(jMenuItem1);

        jmb_barra.add(jm_editar);

        setJMenuBar(jmb_barra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmi_abrirProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_abrirProyectoActionPerformed
        final vista.abrirProyecto.JD_abrirProyecto dialog
                        = new vista.abrirProyecto.JD_abrirProyecto(this, true);
         //si se cierra la ventana cierro el proceso
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        dialog.dispose();
                    }
                });
        dialog.setVisible(true);

    }//GEN-LAST:event_jmi_abrirProyectoActionPerformed

    private void jmi_nuevoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_nuevoProyectoActionPerformed
         final vista.crearProyecto.JD_crearProyecto dialog = new vista.crearProyecto.JD_crearProyecto(this, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        dialog.dispose();
                    }
                });
                dialog.setVisible(true);
        
        
    }//GEN-LAST:event_jmi_nuevoProyectoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        pintarPanel_ProyectoAbierto("Eviu");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(Eviu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eviu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eviu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eviu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Eviu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jm_archivo;
    private javax.swing.JMenu jm_editar;
    private javax.swing.JMenuBar jmb_barra;
    private javax.swing.JMenuItem jmi_abrirProyecto;
    private javax.swing.JMenuItem jmi_nuevoProyecto;
    // End of variables declaration//GEN-END:variables
    
    public void pintarPanelInicio() {
        // Borrar todo el contenido de la ventana \\
        contenPane.removeAll();
        contenPane.repaint();
        // Pintar pantalla de inicio
        JP_inicio JP_inicio=new JP_inicio();
        contenPane.add(JP_inicio);
        JP_inicio.updateUI();
        
    }

    public void pintarPanel_ProyectoAbierto(String nomproyecto) {

        contenPane.removeAll();
        contenPane.repaint();

        vista.abrirProyecto.JP_proyectoAbierto 
                jp_proyectoAbierto = 
                new vista.abrirProyecto.JP_proyectoAbierto(nomproyecto,this);
        
        jp_proyectoAbierto.setVisible(true);
        
        
        contenPane.add(jp_proyectoAbierto);
        jp_proyectoAbierto.updateUI();
    }
    public void pintarPanel_test(String nomProyecto,String nomTest){
        contenPane.removeAll();
        contenPane.repaint();
        vista.test.JP_test a = new vista.test.JP_test(nomProyecto,nomTest,this);
        a.setVisible(true);
        contenPane.add(a);
        a.updateUI();
    }
    public void bloquearVentanaPrincipal(){
//        jm_archivo.setEnabled(false);
    }

    public JSONArray getPerfil() {
        return perfil;
    }

    public void setPerfil(JSONArray perfil) {
        this.perfil = perfil;
    }


    
}
