

package vista.crearProyecto;

import javax.swing.JOptionPane;

public class JD_crearProyecto extends javax.swing.JDialog {
    vista.Eviu Eviu;
    public JD_crearProyecto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        Eviu= (vista.Eviu) parent;
        initComponents();
        font() ;
        this.setTitle("Nuevo proyecto");
        this.setLocationRelativeTo(null);
        jb_crear.setActionCommand("Crear");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbg_test = new javax.swing.ButtonGroup();
        rbg_perfil = new javax.swing.ButtonGroup();
        jtf_nomProyecto = new javax.swing.JTextField();
        rb_crearTest = new javax.swing.JRadioButton();
        jl_test = new javax.swing.JLabel();
        jb_cancelar = new javax.swing.JButton();
        jl_nomProyecto = new javax.swing.JLabel();
        rb_testEjemplo = new javax.swing.JRadioButton();
        jb_crear = new javax.swing.JButton();
        jl_descripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_descripcion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        rb_perfilEjemplo = new javax.swing.JRadioButton();
        rb_crearPerfil = new javax.swing.JRadioButton();
        jl_titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        rbg_test.add(rb_crearTest);
        rb_crearTest.setText("Crear mi Propio Test.");
        rb_crearTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_crearTestActionPerformed(evt);
            }
        });

        jl_test.setText("Test");

        jb_cancelar.setText("Cancelar");
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });

        jl_nomProyecto.setText("Nombre del Proyecto");

        rbg_test.add(rb_testEjemplo);
        rb_testEjemplo.setSelected(true);
        rb_testEjemplo.setText("Usear Test Ejemplo.");
        rb_testEjemplo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_testEjemploActionPerformed(evt);
            }
        });

        jb_crear.setText("Crear");
        jb_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_crearActionPerformed(evt);
            }
        });

        jl_descripcion.setText("Descripción del Proyecto.");

        jta_descripcion.setColumns(20);
        jta_descripcion.setRows(5);
        jScrollPane1.setViewportView(jta_descripcion);

        jLabel1.setText("Perfiles (crear una plantilla de seleccion de perfiles) ");

        rbg_perfil.add(rb_perfilEjemplo);
        rb_perfilEjemplo.setSelected(true);
        rb_perfilEjemplo.setText("Usar Perfil Ejemplo.");
        rb_perfilEjemplo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_perfilEjemploActionPerformed(evt);
            }
        });

        rbg_perfil.add(rb_crearPerfil);
        rb_crearPerfil.setText("Crear mi propio perfil.");
        rb_crearPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_crearPerfilActionPerformed(evt);
            }
        });

        jl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_titulo.setText("Nuevo Proyecto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jb_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jl_nomProyecto)
                                    .addComponent(jl_descripcion)
                                    .addComponent(jl_test)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rb_perfilEjemplo)
                                            .addComponent(rb_testEjemplo)
                                            .addComponent(rb_crearTest)
                                            .addComponent(rb_crearPerfil)))
                                    .addComponent(jScrollPane1)
                                    .addComponent(jtf_nomProyecto))))
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jl_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jl_titulo)
                .addGap(18, 18, 18)
                .addComponent(jl_nomProyecto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_nomProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_descripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_test)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_testEjemplo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_crearTest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_perfilEjemplo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_crearPerfil)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_crear)
                    .addComponent(jb_cancelar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void rb_crearTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_crearTestActionPerformed
        jb_crear.setText("Siguiente");
        jb_crear.setActionCommand("Siguiente");
    }//GEN-LAST:event_rb_crearTestActionPerformed

    private void rb_crearPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_crearPerfilActionPerformed
        jb_crear.setText("Siguiente");
        jb_crear.setActionCommand("Siguiente");
    }//GEN-LAST:event_rb_crearPerfilActionPerformed

    private void rb_testEjemploActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_testEjemploActionPerformed
        if(rb_perfilEjemplo.isSelected()){
            jb_crear.setText("Crear");
            jb_crear.setActionCommand("Crear");
        }
    }//GEN-LAST:event_rb_testEjemploActionPerformed

    private void rb_perfilEjemploActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_perfilEjemploActionPerformed
        if(rb_testEjemplo.isSelected()){
            jb_crear.setText("Crear");
            jb_crear.setActionCommand("Crear");
        }
    }//GEN-LAST:event_rb_perfilEjemploActionPerformed

    private void jb_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_crearActionPerformed
        String nomProyecto = jtf_nomProyecto.getText();
        String descripcion = jta_descripcion.getText();

        if(nomProyecto.equals("")){
            JOptionPane.showMessageDialog(this, "Ingrese un Nombre de Proyecto");
        }else{
            if(jb_crear.getActionCommand().equals("Crear")){
                crearProyectoSimple(nomProyecto,descripcion);
                Eviu.pintarPanel_ProyectoAbierto(nomProyecto);
            }else if(jb_crear.getActionCommand().equals("Siguiente")){
                if (rb_crearTest.isSelected() && rb_crearPerfil.isSelected()){
                    /*         CASO UNO        */
                    crearproyecto(nomProyecto,descripcion,1);
                    this.dispose();
                }else if(rb_crearTest.isSelected() && rb_perfilEjemplo.isSelected()){
                    /*         CASO DOS        */
                    crearproyecto(nomProyecto,descripcion,2);
                    this.dispose();
                }else if(rb_testEjemplo.isSelected() && rb_crearPerfil.isSelected()){
                    /*         CASO TRES        */
                    crearproyecto(nomProyecto,descripcion,3);
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_jb_crearActionPerformed
    public void abrirProyecto(String nomP){
        Eviu.pintarPanel_ProyectoAbierto(nomP);
    }
    private void crearproyecto(final String nomProyecto,final String descripcio,final int caso){
        /*
        Crear proyecto con nuevo perfil y nuevo test.
        CASO UNO
        */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                final JD_crearPT dialog = 
                        new JD_crearPT(
                                new javax.swing.JFrame(), 
                                true,
                                nomProyecto,
                                descripcio,
                                caso,
                                Eviu);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        dialog.dispose();
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
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
            java.util.logging.Logger.getLogger(JD_crearProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_crearProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_crearProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_crearProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_crearProyecto dialog = new JD_crearProyecto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_crear;
    private javax.swing.JLabel jl_descripcion;
    private javax.swing.JLabel jl_nomProyecto;
    private javax.swing.JLabel jl_test;
    private javax.swing.JLabel jl_titulo;
    private javax.swing.JTextArea jta_descripcion;
    private javax.swing.JTextField jtf_nomProyecto;
    private javax.swing.JRadioButton rb_crearPerfil;
    private javax.swing.JRadioButton rb_crearTest;
    private javax.swing.JRadioButton rb_perfilEjemplo;
    private javax.swing.JRadioButton rb_testEjemplo;
    private javax.swing.ButtonGroup rbg_perfil;
    private javax.swing.ButtonGroup rbg_test;
    // End of variables declaration//GEN-END:variables
    private void font() {
        jl_titulo.setFont(vista.Config.getTam_subTitulo());
//        jl_inicio2.setFont(vista.Config.getTam_subTitulo());
//        jl_inicio3.setFont(vista.Config.getTam_subTitulo());
//        jl_iniciosub1.setFont(vista.Config.getTam_Titulo());
//        jl_iniciosub2.setFont(vista.Config.getTam_Titulo());
    }
    private void crearProyectoSimple(String nomProyecto,String descripcion){
        
        if(controlador.Archivos.crearProyectoSimple(nomProyecto, descripcion)){
            JOptionPane.showMessageDialog(this, "Se Creo Exitosamente el Proyecto:\n"+nomProyecto);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Erros al crear el Proyecto");
        }
    }
}
