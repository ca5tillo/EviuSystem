
package vista;
import vista.inicio.*;
public class Eviu extends javax.swing.JFrame {

    public Eviu() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarPanelinicio();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jmb_barra = new javax.swing.JMenuBar();
        jm_archivo = new javax.swing.JMenu();
        jmi_abrirProyecto = new javax.swing.JMenuItem();
        jm_editar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jm_archivo.setText("Archivo");

        jmi_abrirProyecto.setText("Abrir Proyecto");
        jm_archivo.add(jmi_abrirProyecto);

        jmb_barra.add(jm_archivo);

        jm_editar.setText("Editar");
        jmb_barra.add(jm_editar);

        setJMenuBar(jmb_barra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Eviu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eviu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eviu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eviu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Eviu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jm_archivo;
    private javax.swing.JMenu jm_editar;
    private javax.swing.JMenuBar jmb_barra;
    private javax.swing.JMenuItem jmi_abrirProyecto;
    // End of variables declaration//GEN-END:variables
private void mostrarPanelinicio() {
        JP_inicio jp_inicio = new JP_inicio();
        jp_inicio.setVisible(true);
        this.add(jp_inicio);
        jp_inicio.updateUI();
    }
}
