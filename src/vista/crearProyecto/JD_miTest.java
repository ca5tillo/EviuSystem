/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.crearProyecto;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class JD_miTest extends javax.swing.JDialog {
    private int count = 0;
    
    private final Map<Integer, JP_miT_item> map_preguntas = new HashMap<>();
    public JD_miTest(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Nuevo Test");
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbg_cronometrar = new javax.swing.ButtonGroup();
        rbg_animo = new javax.swing.ButtonGroup();
        jl_titulo = new javax.swing.JLabel();
        jl_pregunta = new javax.swing.JLabel();
        jtf_pregunta = new javax.swing.JTextField();
        jl_cronometrar = new javax.swing.JLabel();
        rb_si = new javax.swing.JRadioButton();
        rb_no = new javax.swing.JRadioButton();
        jl_tiempo1 = new javax.swing.JLabel();
        jl_t1_min = new javax.swing.JLabel();
        jl_t1_sec = new javax.swing.JLabel();
        jl_t2_min = new javax.swing.JLabel();
        jl_tiempo2 = new javax.swing.JLabel();
        jl_t2_sec = new javax.swing.JLabel();
        jb_finalizar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rb_animo_si = new javax.swing.JRadioButton();
        rb_animo_no = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jb_añadirPregunta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lp_contenedor = new javax.swing.JPanel();
        jcb_t1_min = new javax.swing.JComboBox();
        jcb_t1_sec = new javax.swing.JComboBox();
        jcb_t2_min = new javax.swing.JComboBox();
        jcb_t2_sec = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_titulo.setText("Nuevo Test");

        jl_pregunta.setText("Pregunta /  Tarea");

        jl_cronometrar.setText("Cronometrar.");

        rbg_cronometrar.add(rb_si);
        rb_si.setText("Si");
        rb_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_siActionPerformed(evt);
            }
        });

        rbg_cronometrar.add(rb_no);
        rb_no.setSelected(true);
        rb_no.setText("No");
        rb_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_noActionPerformed(evt);
            }
        });

        jl_tiempo1.setText("Tiempo 1");
        jl_tiempo1.setEnabled(false);

        jl_t1_min.setText("min.");
        jl_t1_min.setEnabled(false);

        jl_t1_sec.setText("sec.");
        jl_t1_sec.setEnabled(false);

        jl_t2_min.setText("min.");
        jl_t2_min.setEnabled(false);

        jl_tiempo2.setText("Tiempo 2");
        jl_tiempo2.setEnabled(false);

        jl_t2_sec.setText("sec.");
        jl_t2_sec.setEnabled(false);

        jb_finalizar.setText("Finalizar");
        jb_finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_finalizarActionPerformed(evt);
            }
        });

        jb_cancelar.setText("Cancelar");
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });

        jLabel1.setText(" Estado de Animo");

        rbg_animo.add(rb_animo_si);
        rb_animo_si.setText("Si");

        rbg_animo.add(rb_animo_no);
        rb_animo_no.setSelected(true);
        rb_animo_no.setText("No");

        jLabel2.setText("Tomara en cuenta el");

        jb_añadirPregunta.setText("Añadir Pregunta");
        jb_añadirPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_añadirPreguntaActionPerformed(evt);
            }
        });

        lp_contenedor.setLayout(new javax.swing.BoxLayout(lp_contenedor, javax.swing.BoxLayout.PAGE_AXIS));

        addItem();

        jScrollPane1.setViewportView(lp_contenedor);

        jcb_t1_min.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
            "00","01","02","03","04","05","06","07","08","09","10",
            "11","12","13","14","15","16","17","18","19","20",
            "21","22","23","24","25","26","27","28","29","30",
            "31","32","33","34","35","36","37","38","39","40",
            "41","42","43","44","45","46","47","48","49","50",
            "51","52","53","54","55","56","57","58","59","60"
        }));
        jcb_t1_min.setEnabled(false);

        jcb_t1_sec.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
            "00","01","02","03","04","05","06","07","08","09","10",
            "11","12","13","14","15","16","17","18","19","20",
            "21","22","23","24","25","26","27","28","29","30",
            "31","32","33","34","35","36","37","38","39","40",
            "41","42","43","44","45","46","47","48","49","50",
            "51","52","53","54","55","56","57","58","59","60"
        }));
        jcb_t1_sec.setEnabled(false);

        jcb_t2_min.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
            "00","01","02","03","04","05","06","07","08","09","10",
            "11","12","13","14","15","16","17","18","19","20",
            "21","22","23","24","25","26","27","28","29","30",
            "31","32","33","34","35","36","37","38","39","40",
            "41","42","43","44","45","46","47","48","49","50",
            "51","52","53","54","55","56","57","58","59","60"
        }));
        jcb_t2_min.setEnabled(false);

        jcb_t2_sec.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
            "00","01","02","03","04","05","06","07","08","09","10",
            "11","12","13","14","15","16","17","18","19","20",
            "21","22","23","24","25","26","27","28","29","30",
            "31","32","33","34","35","36","37","38","39","40",
            "41","42","43","44","45","46","47","48","49","50",
            "51","52","53","54","55","56","57","58","59","60"
        }));
        jcb_t2_sec.setEnabled(false);

        jLabel3.setText("Nombre det Test:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jb_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_cronometrar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rb_si)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rb_no))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jl_tiempo1)
                                            .addComponent(jl_tiempo2)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jl_t1_min)
                                                .addGap(32, 32, 32)
                                                .addComponent(jl_t1_sec))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jl_t2_min)
                                                .addGap(32, 32, 32)
                                                .addComponent(jl_t2_sec))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jcb_t1_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jcb_t1_sec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jcb_t2_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jcb_t2_sec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rb_animo_si)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(rb_animo_no))
                                            .addComponent(jLabel1)))
                                    .addComponent(jb_añadirPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_pregunta)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextField1))
                                        .addComponent(jtf_pregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jl_pregunta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_pregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_cronometrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rb_si)
                                    .addComponent(rb_no))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jl_tiempo1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jl_t1_min)
                                    .addComponent(jl_t1_sec))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jcb_t1_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcb_t1_sec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jl_tiempo2)
                                .addGap(8, 8, 8))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)
                                        .addGap(30, 30, 30))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rb_animo_si)
                                        .addComponent(rb_animo_no)))
                                .addGap(36, 36, 36)
                                .addComponent(jb_añadirPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_t2_min)
                            .addComponent(jl_t2_sec))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcb_t2_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcb_t2_sec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(98, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jb_finalizar)
                            .addComponent(jb_cancelar))
                        .addGap(39, 39, 39))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_añadirPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_añadirPreguntaActionPerformed
        /*
         {
         "str_pregunta":"pregunta 3",
         "str_id":"03",
         "boolean_seMediraPorTiempo":false,
         "boolean_EstadoDeAnimo":true,
         "str_t1":"",
         "str_t2":""
      }
        */
        String pregunta = jtf_pregunta.getText();
        String idpregunta="";
        boolean tiempo=false;
        boolean animo=false;
        String t1="";
        String t2="";
        if (pregunta.equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese una pregunta");
        }else{
            if(rb_si.isSelected()){
                tiempo = true;
                t1 = "00:"+jcb_t1_min.getSelectedItem()+":"+jcb_t1_sec.getSelectedItem()+":00";
                t2 = "00:"+jcb_t2_min.getSelectedItem()+":"+jcb_t2_sec.getSelectedItem()+":00";
            }
            if(rb_animo_si.isSelected()){
                animo=true;
            }
            map_preguntas.put(count,new JP_miT_item(this,count,idpregunta,pregunta,tiempo,t1,t2,animo));
           
            lp_contenedor.add(map_preguntas.get(count));
            lp_contenedor.updateUI();
            count++;
            jtf_pregunta.setText("");
            rb_no.setSelected(true);
            rb_animo_no.setSelected(true);
            desactivarTiempos();
        }
        
    }//GEN-LAST:event_jb_añadirPreguntaActionPerformed
    public void quitarPregunta(int id){
        lp_contenedor.remove(map_preguntas.get(id));
        lp_contenedor.updateUI();
        map_preguntas.remove(id);
    }
    private void rb_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_siActionPerformed
        jl_tiempo1.setEnabled(true);
        jl_t1_min.setEnabled(true);
        jl_t1_sec.setEnabled(true);
        jcb_t1_min.setEnabled(true);
        jcb_t1_sec.setEnabled(true);
        jl_tiempo2.setEnabled(true);
        jl_t2_min.setEnabled(true);
        jl_t2_sec.setEnabled(true);
        jcb_t2_min.setEnabled(true);
        jcb_t2_sec.setEnabled(true);
    }//GEN-LAST:event_rb_siActionPerformed
    private void desactivarTiempos(){
        jl_tiempo1.setEnabled(false);
        jl_t1_min.setEnabled(false);
        jl_t1_sec.setEnabled(false);
        jcb_t1_min.setEnabled(false);
        jcb_t1_sec.setEnabled(false);
        jl_tiempo2.setEnabled(false);
        jl_t2_min.setEnabled(false);
        jl_t2_sec.setEnabled(false);
        jcb_t2_min.setEnabled(false);
        jcb_t2_sec.setEnabled(false);
    }
    private void rb_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_noActionPerformed
        desactivarTiempos();
    }//GEN-LAST:event_rb_noActionPerformed

    private void jb_finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_finalizarActionPerformed
        java.util.Iterator it = map_preguntas.keySet().iterator();
        while(it.hasNext()){
            Integer key = (Integer)it.next();
            System.out.println("clave = "+key+"  valor = "+map_preguntas.get(key).getJSON());
        }
    }//GEN-LAST:event_jb_finalizarActionPerformed

    public static void main() {
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
            java.util.logging.Logger.getLogger(JD_miTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_miTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_miTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_miTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_miTest dialog = new JD_miTest(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jb_añadirPregunta;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_finalizar;
    private javax.swing.JComboBox jcb_t1_min;
    private javax.swing.JComboBox jcb_t1_sec;
    private javax.swing.JComboBox jcb_t2_min;
    private javax.swing.JComboBox jcb_t2_sec;
    private javax.swing.JLabel jl_cronometrar;
    private javax.swing.JLabel jl_pregunta;
    private javax.swing.JLabel jl_t1_min;
    private javax.swing.JLabel jl_t1_sec;
    private javax.swing.JLabel jl_t2_min;
    private javax.swing.JLabel jl_t2_sec;
    private javax.swing.JLabel jl_tiempo1;
    private javax.swing.JLabel jl_tiempo2;
    private javax.swing.JLabel jl_titulo;
    private javax.swing.JTextField jtf_pregunta;
    private javax.swing.JPanel lp_contenedor;
    private javax.swing.JRadioButton rb_animo_no;
    private javax.swing.JRadioButton rb_animo_si;
    private javax.swing.JRadioButton rb_no;
    private javax.swing.JRadioButton rb_si;
    private javax.swing.ButtonGroup rbg_animo;
    private javax.swing.ButtonGroup rbg_cronometrar;
    // End of variables declaration//GEN-END:variables
    private void addItem(){
        
    }
}
