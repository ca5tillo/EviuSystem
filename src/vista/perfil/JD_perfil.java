package vista.perfil;

import controlador.modelos.Categoria;

public class JD_perfil extends javax.swing.JDialog {

    private int Count = 0;
    private int numCategorias = 0;
    private static vista.Eviu Eviu;
    private static String nomProyecto;
    java.util.ArrayList<JP_categoria> lst_JP_categoria = new java.util.ArrayList();

    public JD_perfil(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        font();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jp_contenedor = new javax.swing.JPanel();
        jb_aceptar = new javax.swing.JButton();
        jl_titulo = new javax.swing.JLabel();
        jb_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jp_contenedor.setLayout(new javax.swing.BoxLayout(jp_contenedor, javax.swing.BoxLayout.PAGE_AXIS));

        addCategorias();

        jScrollPane1.setViewportView(jp_contenedor);

        jb_aceptar.setText("Aceptar");
        jb_aceptar.setEnabled(false);
        jb_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_aceptarActionPerformed(evt);
            }
        });

        jl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_titulo.setText("Ingrese el Perfil del encuestado ");

        jb_cancelar.setText("Cancelar");
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jb_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jl_titulo)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_aceptar)
                    .addComponent(jb_cancelar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        Eviu.pintarPanel_ProyectoAbierto(nomProyecto);
        this.dispose();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_aceptarActionPerformed
        for (JP_categoria a :lst_JP_categoria){
            a.getCategoria();
            a.getOpcion();
            System.out.println(a.getCategoria()+" "+a.getOpcion());
        }
        this.dispose();
    }//GEN-LAST:event_jb_aceptarActionPerformed

    public static void main(vista.Eviu _Eviu, final String _nomProyecto) {
        nomProyecto = _nomProyecto;
        Eviu = _Eviu;
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
            java.util.logging.Logger.getLogger(JD_perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                final JD_perfil dialog = new JD_perfil(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        Eviu.pintarPanel_ProyectoAbierto(nomProyecto);
                        dialog.dispose();
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_aceptar;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JLabel jl_titulo;
    private javax.swing.JPanel jp_contenedor;
    // End of variables declaration//GEN-END:variables
    

    private void addCategorias() {
        java.util.ArrayList<controlador.modelos.Categoria> perfil = new java.util.ArrayList();
        perfil = controlador.LeerDatos.getPerfil(nomProyecto);
        numCategorias= perfil.size();
        for (int i = 0; i < perfil.size(); i++) {
            lst_JP_categoria.add(new JP_categoria(this, perfil.get(i).getCategoria(), perfil.get(i).getOpciones()));
            jp_contenedor.add(lst_JP_categoria.get(i));
        }
    }

    public int getCount() {
        return Count;
    }

    public int getNumCategorias() {
        return numCategorias;
    }

    public void setCount(int Count) {
        this.Count += Count;
    }

    public void habilitarBoton() {
        jb_aceptar.setEnabled(true);
    }

    private void font() {
        jl_titulo.setFont(vista.Config.getTam_Titulo());
    }
}
