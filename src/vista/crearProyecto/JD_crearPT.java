/*
 Existen casos

 * Crear proyecto con nuevo perfil y nuevo test. CASO UNO
 * Crear proyecto con plantilla perfil y nuevo test
 * Crear proyecto con nuevo perfil y plantilla test

 * crear un nuevo test en un proyecto ya existente.
 */
package vista.crearProyecto;

import org.json.simple.JSONArray;

public class JD_crearPT extends javax.swing.JDialog {

    private int banderadeCasos = 0;
    private String proyecto;
    private String descripcion;
    private String nomTest;
    private org.json.simple.JSONArray lst_perfil = new org.json.simple.JSONArray();
    private org.json.simple.JSONArray lst_preguntas = new org.json.simple.JSONArray();

    public JD_crearPT(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        this.setLocationRelativeTo(null);
//        test();
        pintarPerfil();
    }

    public JD_crearPT(java.awt.Frame parent, boolean modal, String proyecto, String descripcion, int banderadeCasos) {
        super(parent, modal);
        this.banderadeCasos = banderadeCasos;
        this.proyecto = proyecto;
        this.descripcion = descripcion;
        initComponents();
        this.setLocationRelativeTo(null);
        //CASO UNO
        if (banderadeCasos == 1) {
            jp_contenedor.add(new JP_perfil(this, banderadeCasos, this.proyecto, this.descripcion));
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_contenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jp_contenedorLayout = new javax.swing.GroupLayout(jp_contenedor);
        jp_contenedor.setLayout(jp_contenedorLayout);
        jp_contenedorLayout.setHorizontalGroup(
            jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jp_contenedorLayout.setVerticalGroup(
            jp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(JD_crearPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_crearPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_crearPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_crearPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_crearPT dialog = new JD_crearPT(new javax.swing.JFrame(), true);
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

    public void pintarPerfil() {
        jp_contenedor.removeAll();
        jp_contenedor.updateUI();
        jp_contenedor.add(new JP_perfil(this, banderadeCasos, this.proyecto, this.descripcion));
    }

    public void pintarTest() {
        jp_contenedor.removeAll();
        jp_contenedor.updateUI();
        jp_contenedor.add(new JP_miTest(this, banderadeCasos, this.proyecto, this.descripcion));
    }

    public String getNomTest() {
        return nomTest;
    }

    public void setNomTest(String nomTest) {
        this.nomTest = nomTest;
    }

    public JSONArray getLst_perfil() {
        return lst_perfil;
    }

    public void setLst_perfil(JSONArray lst_perfil) {
        this.lst_perfil = lst_perfil;
    }

    public JSONArray getLst_preguntas() {
        return lst_preguntas;
    }

    public void setLst_preguntas(JSONArray lst_preguntas) {
        this.lst_preguntas = lst_preguntas;
    }

    public void crearCasoUno() {
        /*
         Crear proyecto con nuevo perfil y nuevo test. CASO UNO
        
         En este momento ya deven de tener valor asignado las siguientes variables
        
         proyecto;
         descripcion;
         nomTest;
         lst_perfil;
         lst_preguntas;
         */

        
        boolean a = controlador.Archivos.crearProyectoCasoUno(
                proyecto,
                descripcion,
                nomTest,
                lst_perfil,
                lst_preguntas);
        if (a){
            javax.swing.JOptionPane.showMessageDialog(null, "Proyecto creado exitosamente");
        }
        this.dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jp_contenedor;
    // End of variables declaration//GEN-END:variables

}
