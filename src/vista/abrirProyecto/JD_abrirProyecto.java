/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.abrirProyecto;

/**
 *
 * @author lp-ub-14
 */
public class JD_abrirProyecto extends javax.swing.JDialog {
    String proyectoSeleccionado;
    JP_itemProyecto JP_itemProyecto;
    vista.Eviu Eviu;
    /**
     * Creates new form JD_abrirProyecto
     * @param parent
     * @param modal
     */
    public JD_abrirProyecto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.Eviu=(vista.Eviu) parent;
        initComponents();
        this.setLocationRelativeTo(null);
        font();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jp_contenedor = new javax.swing.JPanel();
        jb_abrir = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_titulo.setText("Tus Proyectos.");

        jp_contenedor.setLayout(new javax.swing.BoxLayout(jp_contenedor, javax.swing.BoxLayout.PAGE_AXIS));

        setLstProyectos();

        jScrollPane1.setViewportView(jp_contenedor);

        jb_abrir.setText("Abrir");
        jb_abrir.setEnabled(false);
        jb_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_abrirActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jl_titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 136, Short.MAX_VALUE)
                        .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jb_abrir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_titulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_abrir)
                    .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_abrirActionPerformed
        Eviu.pintarPanel_ProyectoAbierto(proyectoSeleccionado);
        this.dispose();
    }//GEN-LAST:event_jb_abrirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_abrir;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JLabel jl_titulo;
    private javax.swing.JPanel jp_contenedor;
    // End of variables declaration//GEN-END:variables
    private void font() {
        jl_titulo.setFont(vista.Config.getTam_Titulo());
    }

    public void setLstProyectos() {
        /*
         Agragara todos los proyectos a jp_contenedor
         este contenedor tiene un scroll 
         cada proyecto en un panel con un label con el nombre del proyecto
         */
        java.util.ArrayList<String> str_array_proyectos = controlador.Archivos.getProyectos();
        for (String nomProyecto : str_array_proyectos) {
            jp_contenedor.add(new JP_itemProyecto(nomProyecto,this));
        }
//        str_array_proyectos = null;
    }

    public String getProyectoSeleccionado() {
        return proyectoSeleccionado;
    }

    public void setProyectoSeleccionado(String proyectoSeleccionado) {
        this.proyectoSeleccionado = proyectoSeleccionado;
    }

    public JP_itemProyecto getJP_itemProyecto() {
        return JP_itemProyecto;
    }

    public void setJP_itemProyecto(JP_itemProyecto JP_itemProyecto) {
        this.JP_itemProyecto = JP_itemProyecto;
    }
    public void habilitarBotonAbrir(){
        jb_abrir.setEnabled(true);
    }
}
