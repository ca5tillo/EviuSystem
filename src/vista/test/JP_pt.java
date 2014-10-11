/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.test;

import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Timer;
import org.json.simple.JSONObject;

/**
 *
 * @author lp-ub-14
 */
public class JP_pt extends javax.swing.JPanel {

    Cronometro cronometro = new Cronometro();
    private String id;
    private String tarea;
    int t1[] = new int[4];
    int t2[] = new int[4];
    Calendar c1 = GregorianCalendar.getInstance();
    Calendar c2 = GregorianCalendar.getInstance();

    public JP_pt(String id, String tarea, String[] t1, String[] t2) {

        this.t1[0] = Integer.parseInt(t1[0]);
        this.t1[1] = Integer.parseInt(t1[1]);
        this.t1[2] = Integer.parseInt(t1[2]);
        this.t1[3] = Integer.parseInt(t1[3]);
        c1.set(0, 0, 0, this.t1[0], this.t1[1], this.t1[2]);

        this.t2[0] = Integer.parseInt(t2[0]);
        this.t2[1] = Integer.parseInt(t2[1]);
        this.t2[2] = Integer.parseInt(t2[2]);
        this.t2[3] = Integer.parseInt(t2[3]);
        c2.set(0, 0, 0, this.t2[0], this.t2[1], this.t2[2]);

        this.id = id;
        this.tarea = tarea;
        initComponents();

        rb_no.setActionCommand("no");
        rb_si.setActionCommand("si");

        cambiarLabel(t1, t2);
        jb_iniciar.setActionCommand("iniciar");
        seleccion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbg_tiempo = new javax.swing.ButtonGroup();
        jbg_realizo = new javax.swing.ButtonGroup();
        jl_id = new javax.swing.JLabel();
        jl_tarea = new javax.swing.JLabel();
        jb_siguiente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jl_cronometro = new javax.swing.JLabel();
        jb_detener = new javax.swing.JButton();
        jb_iniciar = new javax.swing.JButton();
        jl_iconoCronometro = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rb_tiempo1 = new javax.swing.JRadioButton();
        rb_tiempo2 = new javax.swing.JRadioButton();
        rb_tiempo3 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        rb_si = new javax.swing.JRadioButton();
        rb_no = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue));

        jl_id.setText(id);

        jl_tarea.setText(tarea);

        jb_siguiente.setText("Siguiente");
        jb_siguiente.setEnabled(false);
        jb_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_siguienteActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(132, 123, 123), null, null));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Crónometro");

        jl_cronometro.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jl_cronometro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_cronometro.setText("00:00:00:00");

        jb_detener.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/stop.png"))); // NOI18N
        jb_detener.setEnabled(false);
        jb_detener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_detenerActionPerformed(evt);
            }
        });

        jb_iniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/play.png"))); // NOI18N
        jb_iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_iniciarActionPerformed(evt);
            }
        });

        jl_iconoCronometro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_iconoCronometro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reloj.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_cronometro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_iconoCronometro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jb_detener, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jb_iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_iconoCronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jl_cronometro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jb_iniciar)
                    .addComponent(jb_detener, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel3.setText("Tiempos");

        jbg_tiempo.add(rb_tiempo1);
        rb_tiempo1.setSelected(true);
        rb_tiempo1.setText("Menos de 6 min.");

        jbg_tiempo.add(rb_tiempo2);
        rb_tiempo2.setText("jRadioButton1");

        jbg_tiempo.add(rb_tiempo3);
        rb_tiempo3.setText("jRadioButton1");

        jLabel6.setText("Se Realizo la tarea.");

        jbg_realizo.add(rb_si);
        rb_si.setSelected(true);
        rb_si.setText("Si");
        rb_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_siActionPerformed(evt);
            }
        });

        jbg_realizo.add(rb_no);
        rb_no.setText("No");
        rb_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_noActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(17);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel8.setText("Observaciones (Opcional)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rb_tiempo2)
                                            .addComponent(rb_tiempo1)
                                            .addComponent(rb_tiempo3))))
                                .addGap(177, 177, 177)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(rb_si)
                                        .addGap(18, 18, 18)
                                        .addComponent(rb_no))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(78, 78, 78)))
                        .addGap(0, 245, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_id)
                        .addGap(18, 18, 18)
                        .addComponent(jl_tarea, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jb_siguiente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jb_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rb_si)
                                    .addComponent(rb_no)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jl_id)
                                    .addComponent(jl_tarea))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rb_tiempo1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rb_tiempo2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rb_tiempo3)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jb_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_iniciarActionPerformed
        botonpalyypausa();
    }//GEN-LAST:event_jb_iniciarActionPerformed
    private void botonpalyypausa() {
        if (jb_iniciar.getActionCommand().equals("iniciar")) {
            cronometro.iniciar();
            jb_iniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pause.png"))); // NOI18N
            jb_iniciar.setActionCommand("pause");
        } else if (jb_iniciar.getActionCommand().equals("pause")) {
            cronometro.pausar();
            jb_iniciar.setActionCommand("iniciar");
            jb_iniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/play.png")));
            jb_detener.setEnabled(true);
            jb_siguiente.setEnabled(true);
            seleccion();

        }
    }

    private void seleccion() {
        String tiempo_ = jl_cronometro.getText();
        String realizo = jbg_realizo.getSelection().getActionCommand();
        String animo = "";
        JSONObject respuesta = new JSONObject();
        respuesta.put("id_pregunta", jl_id.getText());
        respuesta.put("pregunta", jl_tarea.getText());
        respuesta.put("realizo", realizo);
        respuesta.put("tiempo", tiempo_);
        respuesta.put("animo", animo);
        respuesta.put("nota", jTextArea1.getText());

        jb_siguiente.setActionCommand("" + respuesta);
    }
    private void jb_detenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_detenerActionPerformed
        cronometro.pausar();
        cronometro.reiniciar();
        jb_iniciar.setEnabled(true);
        jb_detener.setEnabled(false);
        jb_siguiente.setEnabled(false);
    }//GEN-LAST:event_jb_detenerActionPerformed

    private void jb_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_siguienteActionPerformed
        seleccion();
        this.setVisible(false);
    }//GEN-LAST:event_jb_siguienteActionPerformed

    private void rb_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_noActionPerformed
        seleccion();
    }//GEN-LAST:event_rb_noActionPerformed

    private void rb_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_siActionPerformed
        seleccion();
    }//GEN-LAST:event_rb_siActionPerformed
    private void cambiarLabel(String[] t1, String[] t2) {
        rb_tiempo1.setText("Hasta " + t1[1] + ":" + t1[2] + " min.");
        rb_tiempo2.setText("Hasta " + t2[1] + ":" + t2[2] + " min.");
        rb_tiempo3.setText("Más de lo aceptado.");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jb_detener;
    public javax.swing.JButton jb_iniciar;
    public javax.swing.JButton jb_siguiente;
    private javax.swing.ButtonGroup jbg_realizo;
    private javax.swing.ButtonGroup jbg_tiempo;
    private javax.swing.JLabel jl_cronometro;
    private javax.swing.JLabel jl_iconoCronometro;
    private javax.swing.JLabel jl_id;
    private javax.swing.JLabel jl_tarea;
    private javax.swing.JRadioButton rb_no;
    private javax.swing.JRadioButton rb_si;
    private javax.swing.JRadioButton rb_tiempo1;
    private javax.swing.JRadioButton rb_tiempo2;
    private javax.swing.JRadioButton rb_tiempo3;
    // End of variables declaration//GEN-END:variables
    public class Cronometro {

        Calendar c3 = GregorianCalendar.getInstance();

        public Cronometro() {
            t = new Timer(10, acciones);
        }
        private Timer t;
        private int h, m, s, cs;

        String tiempo;
        int count = 0;
        private ActionListener acciones = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cs++;
                if (cs == 100) {
                    cs = 0;
                    s++;
                }
                if (s == 60) {
                    s = 0;
                    m++;
                }
                if (m == 60) {
                    m = 0;
                    h++;
                }
                actualizarLabel();
            }
        };

        private void actualizarLabel() {
            c3.clear();
            c3.set(0, 0, 0, h, m, s);

            tiempo = (h <= 9 ? "0" : "") + h + ":" + (m <= 9 ? "0" : "") + m + ":" + (s <= 9 ? "0" : "") + s + ":" + (cs <= 9 ? "0" : "") + cs;
            jl_cronometro.setText(tiempo);

            if (c3.getTimeInMillis() < c1.getTimeInMillis()) {
                jl_iconoCronometro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tiempo1.png")));
            } else if ((c1.getTimeInMillis() < c3.getTimeInMillis())
                    && (c3.getTimeInMillis() < c2.getTimeInMillis())) {
                rb_tiempo2.setSelected(true);
                jl_iconoCronometro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tiempo2.png")));
            } else if (c3.getTimeInMillis() > c2.getTimeInMillis()) {
                rb_no.setSelected(true);
                rb_tiempo3.setSelected(true);
                jl_iconoCronometro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tiempo3.png")));
                botonpalyypausa();
            }
        }

        public void iniciar() {
            t.start();
        }

        public void pausar() {
            t.stop();
        }

        public void reiniciar() {
            h = 0;
            m = 0;
            s = 0;
            cs = 0;
            jl_cronometro.setText("00:00:00:00");
            jl_iconoCronometro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reloj.png")));
            rb_si.setSelected(true);
            rb_tiempo1.setSelected(true);
        }

//        public void estabelcerTiempos(String _t1, String _t2, String _t3) {
//            String separador = ":";
//
//            this.t1 = _t1.split(separador);
//            this.t2 = _t2.split(separador);
//            this.t3 = _t3.split(separador);
//        }
    }
}
