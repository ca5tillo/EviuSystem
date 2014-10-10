
package vista.abrirProyecto;

public class JP_itemProyecto extends javax.swing.JPanel {
    JD_abrirProyecto JD_abrirProyecto;
    public JP_itemProyecto(String nomProyecto,JD_abrirProyecto JD_abrirProyecto) {
        this.JD_abrirProyecto=JD_abrirProyecto;
        initComponents();
        jl_nombreProyecto.setText(nomProyecto);
        jl_nombreProyecto.setFont(vista.Config.getTam_subTitulo());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_nombreProyecto = new javax.swing.JLabel();

        jl_nombreProyecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_nombreProyectoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jl_nombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jl_nombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jl_nombreProyectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_nombreProyectoMouseClicked
       JP_itemProyecto JP_itemProyecto = JD_abrirProyecto.getJP_itemProyecto();
       if (JP_itemProyecto != null){
        //si hay un obj seleccionado le quito el color.
           JP_itemProyecto.setBackground(null);
       }
       this.setBackground(vista.Config.colorDeSeleccionado());//le cambio el fondo al proyecto seleccionado
      
       JD_abrirProyecto.setJP_itemProyecto(this);// Guardo el que acabo de seleccionar
       JD_abrirProyecto.setProyectoSeleccionado(jl_nombreProyecto.getText());//gusrdo en variable el nombre del proyecto seleccionado
       
       JD_abrirProyecto.habilitarBotonAbrir();
    }//GEN-LAST:event_jl_nombreProyectoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jl_nombreProyecto;
    // End of variables declaration//GEN-END:variables
}
