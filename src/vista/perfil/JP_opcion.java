
package vista.perfil;

public class JP_opcion extends javax.swing.JPanel {
    private JP_categoria JP_categoria;
    private String opcion;
    
    public JP_opcion(JP_categoria JP_categoria, String opcion) {
        this.JP_categoria = JP_categoria;
        this.opcion = opcion;
        this.setSize(590,375);
        initComponents();
        jl_nombreopcion.setText(opcion);
        this.rb_.setSelected(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_nombreopcion = new javax.swing.JLabel();
        rb_ = new javax.swing.JRadioButton();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jl_nombreopcion.setText("jLabel1");
        jl_nombreopcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_nombreopcionMouseClicked(evt);
            }
        });

        rb_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rb_, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jl_nombreopcion, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rb_, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_nombreopcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jl_nombreopcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_nombreopcionMouseClicked
        select();
        
    }//GEN-LAST:event_jl_nombreopcionMouseClicked
    private void select(){
        JP_opcion JP_opcion = JP_categoria.getJP_opcion();
        if (JP_opcion != null){
            JP_opcion.rb_.setSelected(false);
        }
        this.rb_.setSelected(true);
        JP_categoria.setJP_opcion(this);
        
        if (JP_categoria.getBandera()==0){
            JP_categoria.sumarUnoaCount();
            JP_categoria.setBandera(1);
        }
        if(JP_categoria.getCount()==JP_categoria.getNumCategorias()){
            JP_categoria.habilitarboton();
        }
        JP_categoria.setOpcion(opcion);
    }
    private void rb_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_ActionPerformed
        // TODO add your handling code here:
         select();
    }//GEN-LAST:event_rb_ActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
//        select();
    }//GEN-LAST:event_formAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jl_nombreopcion;
    private javax.swing.JRadioButton rb_;
    // End of variables declaration//GEN-END:variables
}
