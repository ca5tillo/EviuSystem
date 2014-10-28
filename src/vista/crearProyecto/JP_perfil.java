/*
Existen casos

* Crear proyecto con nuevo perfil y nuevo test. CASO UNO
* Crear proyecto con plantilla perfil y nuevo test
* Crear proyecto con nuevo perfil y plantilla test

* crear un nuevo test en un proyecto ya existente.
*/
package vista.crearProyecto;

import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author lp-ub-14
 */
public class JP_perfil extends javax.swing.JPanel {

    private String categoria = "";
    private JP_perfil_Item item;
    private final java.util.Map<Integer, JP_perfil_Item> map_categorias = new java.util.HashMap<>();
    private int id = 0; // es el id dl item su key
    private int count =0;//al crear categoria suma uno al eliminar una categoria resta uno
    private boolean bandera = true;//saber si sigo añadiendo opciones
    private boolean editando=false;
    private final JD_crearPT JD_crearPT;
    private final int banderadeCasos;
    private final String proyecto;
    private final String descripcion;
    
    public JP_perfil(JD_crearPT JD_crearPT, int banderadeCasos,String proyecto,String descripcion) {
        this.proyecto = proyecto;
        this.descripcion = descripcion;
        this.banderadeCasos = banderadeCasos;
        this.JD_crearPT = JD_crearPT;
        initComponents();
        if(banderadeCasos==1)jb_aceptar.setText("Siguiente");
        this.setSize(900, 509);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_categoria = new javax.swing.JLabel();
        jl_opcion = new javax.swing.JLabel();
        jtf_opcion = new javax.swing.JTextField();
        jb_aceptarOpcion = new javax.swing.JButton();
        jtf_categoria = new javax.swing.JTextField();
        jb_aceptar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jb_añadirCategoria = new javax.swing.JButton();
        jl_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jp_contenedor = new javax.swing.JPanel();
        jl_trabajandoEn = new javax.swing.JLabel();

        jl_categoria.setText("Categoria.");

        jl_opcion.setText("Opcion.");

        jb_aceptarOpcion.setText("Aceptar");
        jb_aceptarOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_aceptarOpcionActionPerformed(evt);
            }
        });

        jb_aceptar.setText("Aceptar");
        jb_aceptar.setEnabled(false);
        jb_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_aceptarActionPerformed(evt);
            }
        });

        jb_cancelar.setText("Cancelar");
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });

        jb_añadirCategoria.setText("Añadir otra categoria.");
        jb_añadirCategoria.setEnabled(false);
        jb_añadirCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_añadirCategoriaActionPerformed(evt);
            }
        });

        jl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_titulo.setText("Nuevo Seleccion de Perfil");

        jp_contenedor.setLayout(new javax.swing.BoxLayout(jp_contenedor, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane1.setViewportView(jp_contenedor);

        jl_trabajandoEn.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jl_categoria)
                            .addComponent(jl_opcion)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtf_opcion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jb_aceptarOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtf_categoria)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jb_añadirCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jl_trabajandoEn, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jb_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(25, 25, 25)))))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jl_trabajandoEn)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_categoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jl_opcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_opcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb_aceptarOpcion))
                        .addGap(73, 73, 73)
                        .addComponent(jb_añadirCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_aceptar)
                    .addComponent(jb_cancelar))
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jb_aceptarOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_aceptarOpcionActionPerformed
        boolean continuar = true;
        if (bandera) {
            categoria = jtf_categoria.getText();
            if (!categoria.equals("")) {
                //validar que no este repetido
                if(noExisteCategoria(categoria)){
                    map_categorias.put(id, new JP_perfil_Item(this, id, categoria));
                    
                    count++;
                    if(count==1)jb_aceptar.setEnabled(true); 
                    bandera = false;
                    jl_trabajandoEn.setText("Trabajando en la categoria:  "+categoria);
                }else{
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Esta categoria ya existe");
                }
            } else {
                continuar = false;
                JOptionPane.showMessageDialog(null, "ingresa un nombre de categoria");
            }
        }
        if (continuar) {
            String opcion = jtf_opcion.getText();
            if (!opcion.equals("")) {
                if(editando){
                    item.addOpcion(opcion);
                    item.updateUI();
                }else{
                    item = map_categorias.get(id);
                    item.addOpcion(opcion);
                    jp_contenedor.add(item);
                    jtf_opcion.setText("");

                    jp_contenedor.updateUI();
                    jb_añadirCategoria.setEnabled(true);
                    jtf_categoria.setEnabled(false);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Ingrese Texto en opcion ");
            }
        }
    }//GEN-LAST:event_jb_aceptarOpcionActionPerformed

    private void jb_añadirCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_añadirCategoriaActionPerformed
        crearCategoria();
    }//GEN-LAST:event_jb_añadirCategoriaActionPerformed

    private void jb_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_aceptarActionPerformed
        // BOTON ACEPTAR
        crearJSON();
        
        //CASO UNO
        if(banderadeCasos==1){
            JD_crearPT.pintarTest();
        }
    }//GEN-LAST:event_jb_aceptarActionPerformed

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        JD_crearPT.dispose();
    }//GEN-LAST:event_jb_cancelarActionPerformed
    
    public void removeItem(int id) {
        /*
        un Item esta compuestao de la categoria y sus Opciones
        */
        jp_contenedor.remove(map_categorias.get(id));
        jp_contenedor.updateUI();
        map_categorias.remove(id);
        crearCategoria();
        count--;
        if (count==0){
            /*
            count es el numero de categorias si es = 0
            no se puede continuar 
            */
            bandera=true;
            jb_aceptar.setEnabled(false);
        }
    }
    
    public void editarCategorial(int id){
        item = map_categorias.get(id);
        jl_trabajandoEn.setText("Trabajando en la categoria:  "+item.getCategoria());
        jtf_categoria.setText(item.getCategoria());
        jtf_opcion.setText("");
        editando=true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_aceptar;
    private javax.swing.JButton jb_aceptarOpcion;
    private javax.swing.JButton jb_añadirCategoria;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JLabel jl_categoria;
    private javax.swing.JLabel jl_opcion;
    private javax.swing.JLabel jl_titulo;
    private javax.swing.JLabel jl_trabajandoEn;
    private javax.swing.JPanel jp_contenedor;
    private javax.swing.JTextField jtf_categoria;
    private javax.swing.JTextField jtf_opcion;
    // End of variables declaration//GEN-END:variables
    //regresa True si no son iguales
    
    private void crearCategoria(){
        bandera = true;
        jtf_categoria.setEnabled(true);
        jtf_categoria.setText("");
        id++;
        editando=false;
        jtf_opcion.setText("");
    }
    
    private boolean noExisteCategoria(String categoria) {
        boolean a = true;
        java.util.Iterator it = map_categorias.keySet().iterator();
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            if (categoria.equals(map_categorias.get(key).getCategoria())) {
                a = false;
            }
        }
        return a;
    }
    
    private void crearJSON(){
        org.json.simple.JSONObject jsonobj= new org.json.simple.JSONObject();
        org.json.simple.JSONArray lst_perfil= new org.json.simple.JSONArray();
        
        java.util.Iterator it = map_categorias.keySet().iterator();
        while(it.hasNext()){
            org.json.simple.JSONObject obj_perfil= new org.json.simple.JSONObject();
            
            Integer key = (Integer)it.next();
            String categoria = map_categorias.get(key).getCategoria();
            obj_perfil.put("categoria", categoria);
            
//            String opciones = 
            org.json.simple.JSONArray lst_opciones= new org.json.simple.JSONArray();
            
            Map<Integer, JP_perfil_ItemOpcion> map_opc = map_categorias.get(key).getMap_opciones();
            java.util.Iterator it_opc = map_opc.keySet().iterator();
            while(it_opc.hasNext()){
                Integer key_opc = (Integer)it_opc.next();
                String opcion = map_opc.get(key_opc).getOpcion();
                lst_opciones.add(opcion);
            }
            
            obj_perfil.put("opciones",lst_opciones);
            lst_perfil.add(obj_perfil);
        }
        jsonobj.put("lst_perfil",lst_perfil);
        
        System.out.println(""+lst_perfil);
        JD_crearPT.setLst_perfil(lst_perfil);
    }
}
