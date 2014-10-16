/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.perfil;

public class JP_categoria extends javax.swing.JPanel {
    private JP_opcion JP_opcion;
    private final JD_perfil JD_perfil;
    private java.util.ArrayList<String> opciones;
    private  String categoria="";
    private String opcion="";
    private int bandera=0;
    public JP_categoria(JD_perfil JD_perfil,
            String categoria,
            java.util.ArrayList<String> _opciones) {
        opciones=_opciones;
        this.categoria = categoria;
        this.JD_perfil = JD_perfil;
        this.setSize(590,375);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_contenedor = new javax.swing.JPanel();

        setBorder(null);

        jp_contenedor.setBorder(javax.swing.BorderFactory.createTitledBorder(categoria));
        jp_contenedor.setLayout(new javax.swing.BoxLayout(jp_contenedor, javax.swing.BoxLayout.PAGE_AXIS));
        addopciones();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private void addopciones(){
        for(String opc:opciones){
            jp_contenedor.add(new JP_opcion(this,opc));
        }
    }
    // Variables declaration - do not modify
    // End of variables declaration
    public JP_opcion getJP_opcion() {
        return JP_opcion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jp_contenedor;
    // End of variables declaration//GEN-END:variables

    public void setJP_opcion(JP_opcion JP_opcion) {
        this.JP_opcion = JP_opcion;
    }

    public void sumarUnoaCount(){
        JD_perfil.setCount(1);
    }
    public int getCount() {
        return JD_perfil.getCount();
    }

    public int getNumCategorias() {
        return JD_perfil.getNumCategorias();
    }
    public void habilitarboton(){
        JD_perfil.habilitarBoton();
    }

    public int getBandera() {
        return bandera;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
    
}
