
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_nombreopcion = new javax.swing.JLabel();

        jl_nombreopcion.setText("jLabel1");
        jl_nombreopcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_nombreopcionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jl_nombreopcion, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jl_nombreopcion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jl_nombreopcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_nombreopcionMouseClicked
        JP_opcion JP_opcion = JP_categoria.getJP_opcion();
        if (JP_opcion != null){
            JP_opcion.setBackground(null);
        }
        this.setBackground(vista.Config.colorDeSeleccionado());
        JP_categoria.setJP_opcion(this);
        
        if (JP_categoria.getBandera()==0){
            JP_categoria.sumarUnoaCount();
            JP_categoria.setBandera(1);
        }
        if(JP_categoria.getCount()==JP_categoria.getNumCategorias()){
            JP_categoria.habilitarboton();
        }
        JP_categoria.setOpcion(opcion);
        
    }//GEN-LAST:event_jl_nombreopcionMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jl_nombreopcion;
    // End of variables declaration//GEN-END:variables
}
