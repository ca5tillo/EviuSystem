
package vista.crearProyecto;

public class JP_perfil_ItemOpcion extends javax.swing.JPanel {
    private JP_perfil_Item JP_perfil_Item;
    private String opcion = "opcion";
    private int id_opcion;
    public JP_perfil_ItemOpcion(JP_perfil_Item JP_perfil_Item,int id_opcion, String opcion) {
        this.JP_perfil_Item = JP_perfil_Item;
        this.id_opcion = id_opcion;
        this.opcion = opcion;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_opcion = new javax.swing.JLabel();
        jl_eliminarOpcion = new javax.swing.JLabel();

        jl_opcion.setText(opcion);

        jl_eliminarOpcion.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jl_eliminarOpcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_eliminarOpcion.setText("X");
        jl_eliminarOpcion.setToolTipText("Eliminar Opcion");
        jl_eliminarOpcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jl_eliminarOpcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_eliminarOpcionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_opcion, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_eliminarOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_eliminarOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_opcion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jl_eliminarOpcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_eliminarOpcionMouseClicked
        //simbolo X
        JP_perfil_Item.removeOpcion(id_opcion);
    }//GEN-LAST:event_jl_eliminarOpcionMouseClicked

    public String getOpcion() {
        return opcion;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jl_eliminarOpcion;
    private javax.swing.JLabel jl_opcion;
    // End of variables declaration//GEN-END:variables
}
