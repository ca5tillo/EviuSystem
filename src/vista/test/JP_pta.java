package vista.test;

import javax.swing.Timer;

public class JP_pta extends javax.swing.JPanel {

    Cronometro cronometro = new Cronometro();
    String id = "d";
    String tarea = "d";
    int t1[] = new int[4];
    int t2[] = new int[4];
    java.util.Calendar c1 = java.util.GregorianCalendar.getInstance();
    java.util.Calendar c2 = java.util.GregorianCalendar.getInstance();

    public JP_pta(String id, String tarea, String[] t1, String[] t2) {
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

        rb_desepcionado.setActionCommand("desepcionado");
        rb_enojado.setActionCommand("enojado");
        rb_feliz.setActionCommand("feliz");
        rb_impaciente.setActionCommand("impaciente");
        rb_na.setActionCommand("n-a");
        rb_no.setActionCommand("no");
        rb_si.setActionCommand("si");

        cambiarLabel(t1, t2);
        jb_iniciar.setActionCommand("iniciar");
    }

    public JP_pta() {
        initComponents();

        jb_iniciar.setActionCommand("iniciar");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbg_tiempo = new javax.swing.ButtonGroup();
        jbg_realizo = new javax.swing.ButtonGroup();
        jbg_animo = new javax.swing.ButtonGroup();
        jl_id = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        rb_na = new javax.swing.JRadioButton();
        rb_si = new javax.swing.JRadioButton();
        rb_desepcionado = new javax.swing.JRadioButton();
        rb_no = new javax.swing.JRadioButton();
        rb_tiempo3 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        rb_feliz = new javax.swing.JRadioButton();
        rb_impaciente = new javax.swing.JRadioButton();
        rb_tiempo2 = new javax.swing.JRadioButton();
        rb_tiempo1 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        rb_enojado = new javax.swing.JRadioButton();
        jl_tarea = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jl_cronometro = new javax.swing.JLabel();
        jb_detener = new javax.swing.JButton();
        jb_iniciar = new javax.swing.JButton();
        jl_iconoCronometro = new javax.swing.JLabel();
        jb_siguiente = new javax.swing.JButton();

        jl_id.setText(id);

        jLabel8.setText("Observaciones (Opcional)");

        jLabel7.setText("Estado de animo.");

        jTextArea1.setColumns(17);
        jTextArea1.setRows(5);
        jTextArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea1FocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jbg_animo.add(rb_na);
        rb_na.setSelected(true);
        rb_na.setText("N/A");
        rb_na.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_naActionPerformed(evt);
            }
        });

        jbg_realizo.add(rb_si);
        rb_si.setSelected(true);
        rb_si.setText("Si");
        rb_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_siActionPerformed(evt);
            }
        });

        jbg_animo.add(rb_desepcionado);
        rb_desepcionado.setText("Desepcionado");
        rb_desepcionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_desepcionadoActionPerformed(evt);
            }
        });

        jbg_realizo.add(rb_no);
        rb_no.setText("No");
        rb_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_noActionPerformed(evt);
            }
        });

        jbg_tiempo.add(rb_tiempo3);
        rb_tiempo3.setText("jRadioButton1");

        jLabel6.setText("Se Realizo la tarea.");

        jbg_animo.add(rb_feliz);
        rb_feliz.setText("Feliz");
        rb_feliz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_felizActionPerformed(evt);
            }
        });

        jbg_animo.add(rb_impaciente);
        rb_impaciente.setText("Impaciente");
        rb_impaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_impacienteActionPerformed(evt);
            }
        });

        jbg_tiempo.add(rb_tiempo2);
        rb_tiempo2.setText("jRadioButton1");

        jbg_tiempo.add(rb_tiempo1);
        rb_tiempo1.setSelected(true);
        rb_tiempo1.setText("Menos de 6 min.");

        jLabel3.setText("Tiempos");

        jbg_animo.add(rb_enojado);
        rb_enojado.setText("Enojado");
        rb_enojado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_enojadoActionPerformed(evt);
            }
        });

        jl_tarea.setText(tarea);

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

        jb_siguiente.setText("Siguiente");
        jb_siguiente.setEnabled(false);
        jb_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_siguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rb_tiempo2)
                                    .addComponent(rb_tiempo1)
                                    .addComponent(rb_tiempo3)
                                    .addComponent(jLabel8)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rb_impaciente)
                                    .addComponent(rb_feliz)
                                    .addComponent(rb_desepcionado)
                                    .addComponent(rb_enojado)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rb_si)
                                        .addGap(18, 18, 18)
                                        .addComponent(rb_no))
                                    .addComponent(rb_na))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_id)
                        .addGap(18, 18, 18)
                        .addComponent(jl_tarea, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jb_siguiente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                        .addComponent(rb_tiempo3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_feliz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_impaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_desepcionado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_enojado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_na)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jb_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jb_detenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_detenerActionPerformed
        cronometro.pausar();
        cronometro.reiniciar();
        jb_iniciar.setEnabled(true);
//        jb_pausar.setEnabled(false);
        jb_detener.setEnabled(false);
        jb_siguiente.setEnabled(false);
    }//GEN-LAST:event_jb_detenerActionPerformed

    private void jb_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_iniciarActionPerformed
        botonPlay_y_pausa();
    }//GEN-LAST:event_jb_iniciarActionPerformed

    private void jb_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_siguienteActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jb_siguienteActionPerformed

    private void rb_felizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_felizActionPerformed
        setCommandaBotonsiguiente();
    }//GEN-LAST:event_rb_felizActionPerformed

    private void rb_impacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_impacienteActionPerformed
        setCommandaBotonsiguiente();
    }//GEN-LAST:event_rb_impacienteActionPerformed

    private void rb_desepcionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_desepcionadoActionPerformed
        setCommandaBotonsiguiente();
    }//GEN-LAST:event_rb_desepcionadoActionPerformed

    private void rb_enojadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_enojadoActionPerformed
        setCommandaBotonsiguiente();
    }//GEN-LAST:event_rb_enojadoActionPerformed

    private void rb_naActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_naActionPerformed
        setCommandaBotonsiguiente();
    }//GEN-LAST:event_rb_naActionPerformed

    private void rb_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_siActionPerformed
        setCommandaBotonsiguiente();
    }//GEN-LAST:event_rb_siActionPerformed

    private void rb_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_noActionPerformed
        setCommandaBotonsiguiente();
    }//GEN-LAST:event_rb_noActionPerformed

    private void jTextArea1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea1FocusLost
        setCommandaBotonsiguiente();
    }//GEN-LAST:event_jTextArea1FocusLost
    private void botonPlay_y_pausa() {
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

            setCommandaBotonsiguiente();
        }
    }

    private void setCommandaBotonsiguiente() {
        String tiempo_ = jl_cronometro.getText();
        String realizo = jbg_realizo.getSelection().getActionCommand();
        String animo = jbg_animo.getSelection().getActionCommand();

        org.json.simple.JSONObject respuesta = new org.json.simple.JSONObject();
        respuesta.put("id_pregunta", jl_id.getText());
        respuesta.put("pregunta", jl_tarea.getText());
        respuesta.put("realizo", realizo);
        respuesta.put("tiempo", tiempo_);
        respuesta.put("animo", animo);
        respuesta.put("nota", jTextArea1.getText());

        jb_siguiente.setActionCommand("" + respuesta);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jb_detener;
    public javax.swing.JButton jb_iniciar;
    public javax.swing.JButton jb_siguiente;
    private javax.swing.ButtonGroup jbg_animo;
    private javax.swing.ButtonGroup jbg_realizo;
    private javax.swing.ButtonGroup jbg_tiempo;
    private javax.swing.JLabel jl_cronometro;
    private javax.swing.JLabel jl_iconoCronometro;
    private javax.swing.JLabel jl_id;
    private javax.swing.JLabel jl_tarea;
    private javax.swing.JRadioButton rb_desepcionado;
    private javax.swing.JRadioButton rb_enojado;
    private javax.swing.JRadioButton rb_feliz;
    private javax.swing.JRadioButton rb_impaciente;
    private javax.swing.JRadioButton rb_na;
    private javax.swing.JRadioButton rb_no;
    private javax.swing.JRadioButton rb_si;
    private javax.swing.JRadioButton rb_tiempo1;
    private javax.swing.JRadioButton rb_tiempo2;
    private javax.swing.JRadioButton rb_tiempo3;
    // End of variables declaration//GEN-END:variables
    private void cambiarLabel(String[] t1, String[] t2) {
        rb_tiempo1.setText("Hasta " + t1[1] + ":" + t1[2] + " min.");
        rb_tiempo2.setText("Hasta " + t2[1] + ":" + t2[2] + " min.");
        rb_tiempo3.setText("Mas de lo aceptado.");
    }

    public class Cronometro {

        java.util.Calendar c3 = java.util.GregorianCalendar.getInstance();

        public Cronometro() {
            t = new Timer(10, acciones);
        }
        private Timer t;
        private int h, m, s, cs;

        String tiempo;
        private java.awt.event.ActionListener acciones = new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
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
                botonPlay_y_pausa();
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

    }
}
