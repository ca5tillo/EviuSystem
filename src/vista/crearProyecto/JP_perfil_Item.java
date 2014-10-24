
package vista.crearProyecto;

import java.util.Map;

public class JP_perfil_Item extends javax.swing.JPanel {
    private  String categoria="categoria";
    private final  int id ;
    private int id_opcion=0;// es el id dl item su key
    private int count =0;//al crear categoria suma uno al eliminar una categoria resta uno
    private final java.util.Map<Integer,JP_perfil_ItemOpcion> map_opciones = new java.util.HashMap<>();
    private final JP_perfil JP_perfil;
    public JP_perfil_Item(JP_perfil JP_perfil,int id, String categoria) {
        this.JP_perfil = JP_perfil;
        this.id = id;
        this.categoria=categoria;
        this.setSize(400, 104);
        initComponents();

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_eliminar = new javax.swing.JLabel();
        jp_contenedor = new javax.swing.JPanel();
        jl_editar = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(categoria));

        jl_eliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/basura.png"))); // NOI18N
        jl_eliminar.setToolTipText("Eliminar");
        jl_eliminar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jl_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jl_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_eliminarMouseClicked(evt);
            }
        });

        jp_contenedor.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones:"));
        jp_contenedor.setLayout(new javax.swing.BoxLayout(jp_contenedor, javax.swing.BoxLayout.PAGE_AXIS));

        jl_editar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        jl_editar.setToolTipText("Editar");
        jl_editar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jl_editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jl_editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_editarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jp_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jl_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jl_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_eliminarMouseClicked
        //botecito de basura
        JP_perfil.removeItem(id);
    }//GEN-LAST:event_jl_eliminarMouseClicked
    
    private void jl_editarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_editarMouseClicked
        //Editar esta categoria
        JP_perfil.editarCategorial(id);
        
    }//GEN-LAST:event_jl_editarMouseClicked
    
    public void addOpcion(String opcion){
        map_opciones.put(id_opcion, new JP_perfil_ItemOpcion(this,id_opcion,opcion));
        jp_contenedor.add(map_opciones.get(id_opcion));
        id_opcion++;
        count++;
    }
    
    public void removeOpcion(int id){
        /*
        Quita opcion seleccionada 
        Si la categoria se queda sin opciones se elimina automaticamente 
        */
        jp_contenedor.remove(map_opciones.get(id));
        jp_contenedor.updateUI();
        map_opciones.remove(id);
        count--;
        if(count==0){
            JP_perfil.removeItem(this.id);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jl_editar;
    private javax.swing.JLabel jl_eliminar;
    private javax.swing.JPanel jp_contenedor;
    // End of variables declaration//GEN-END:variables
    public String getCategoria(){
        return categoria;
    }

    public Map<Integer, JP_perfil_ItemOpcion> getMap_opciones() {
        return map_opciones;
    }
    
}
