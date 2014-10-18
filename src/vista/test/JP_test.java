package vista.test;

import javax.swing.Timer;

public class JP_test extends javax.swing.JPanel {

    private final String nomProyecto;
    private final String nomTest;
    private final vista.Eviu Eviu;
    
    private java.util.ArrayList<String> respuestas = new java.util.ArrayList();//contiene Json

    private int count = 0;//cuenta numero de preguntas
    private int countcronometro = 0;// para saber si ya se inicio el cronometro del test
    private final Cronometro cronometro = new Cronometro();

    public JP_test(String nomProyecto, String nomTest, vista.Eviu Eviu) {
        this.nomProyecto = nomProyecto;
        this.nomTest = nomTest;
        this.Eviu = Eviu;
        this.setSize(900, 577);
        initComponents();
        font();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_nomProyecto = new javax.swing.JLabel();
        jl_nomTest = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jp_contenedor = new javax.swing.JPanel();
        jl_crono = new javax.swing.JLabel();
        jl_digitosCronometro = new javax.swing.JLabel();
        jb_guardar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();

        jl_nomProyecto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_nomProyecto.setText(nomProyecto);

        jl_nomTest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_nomTest.setText(nomTest);

        jp_contenedor.setLayout(new javax.swing.BoxLayout(jp_contenedor, javax.swing.BoxLayout.PAGE_AXIS));

        addComponentePregunta();

        jScrollPane1.setViewportView(jp_contenedor);

        jl_crono.setText("Duración del Test:");

        jl_digitosCronometro.setText("00:00:00:00");

        jb_guardar.setText("Guardar");
        jb_guardar.setEnabled(false);
        jb_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_guardarActionPerformed(evt);
            }
        });

        jb_cancelar.setText("Cancelar");
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(604, 604, 604)
                .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_nomProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_crono)
                                .addGap(18, 18, 18)
                                .addComponent(jl_digitosCronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jl_nomTest, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jl_nomProyecto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_nomTest)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_crono)
                    .addComponent(jl_digitosCronometro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        Eviu.pintarPanel_ProyectoAbierto(nomProyecto);
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_guardarActionPerformed
        org.json.simple.JSONArray perfil = Eviu.getPerfil();
        org.json.simple.JSONArray lst_respuestas = lstRespuestas();
        String tiempodeencuesta = jl_digitosCronometro.getText();

        boolean guardar = controlador.Archivos.guardarRespuestas(nomProyecto,nomTest,perfil,lst_respuestas,tiempodeencuesta);
        if(guardar){
            javax.swing.JOptionPane.showMessageDialog(null,"Las respuestas de han guardado Exitosamente");
        }else{
            javax.swing.JOptionPane.showMessageDialog(null,"Error al guardar las Respuestas");
        }
        Eviu.pintarPanel_ProyectoAbierto(nomProyecto);
    }//GEN-LAST:event_jb_guardarActionPerformed
    private org.json.simple.JSONArray lstRespuestas(){
        org.json.simple.JSONArray respuestaTEMPORAL = new org.json.simple.JSONArray();
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        for(String respuesta:respuestas){//respuestas es el ArrayList<String>
            try{
                Object obj = parser.parse(respuesta);
                org.json.simple.JSONObject res = (org.json.simple.JSONObject)obj;
                respuestaTEMPORAL.add(res);
            }catch(org.json.simple.parser.ParseException e){
                System.out.println("Error en el parser en la clase JP_test.java  <<"+e);
            }
        }
        return respuestaTEMPORAL;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_guardar;
    private javax.swing.JLabel jl_crono;
    private javax.swing.JLabel jl_digitosCronometro;
    private javax.swing.JLabel jl_nomProyecto;
    private javax.swing.JLabel jl_nomTest;
    private javax.swing.JPanel jp_contenedor;
    // End of variables declaration//GEN-END:variables
    private void font() {
        jl_nomTest.setFont(vista.Config.getTam_subTitulo());
        jl_nomProyecto.setFont(vista.Config.getTam_Titulo());
    }


    private void addComponentePregunta() {
        /*
        Se tienen 4 tipos de preguntas y aqui se añaden a la "ventana".
        Las respuesta de cada pregunta se guardan en un JSON que se encuentra 
        en el comando de cada boton de pregunta llamado siguiente
            jb_siguiente.getActionCommand()
        
        En esta funcion tambien cacho los eventos de dicos botones.
        
        
        */
        final java.util.ArrayList<controlador.modelos.Pregunta> Preguntas
                = controlador.LeerDatos.getPreguntas(nomProyecto, nomTest);

        for (controlador.modelos.Pregunta pregunta : Preguntas) {
            String _id = pregunta.getInt_id();
            String _pregunta = pregunta.getStr_pregunta();
            boolean _medirportiempo = pregunta.isBoolean_seMediraPorTiempo();
            boolean _estadodeanimo = pregunta.isBoolean_seTomaranCuentaElEstadoDeAnimo();
            String[] t1 = pregunta.getT1();
            String[] t2 = pregunta.getT2();

            /*Si es unapregunta que se evaluara con tiempo */
            if (_medirportiempo) {
                /*Si es una pregunta que tomara en cuenta el estado de animo */
                if (_estadodeanimo) {
                    final JP_pta JP_pta = new JP_pta(_id, _pregunta, t1, t2);
                    jp_contenedor.add(JP_pta);

                    JP_pta.jb_iniciar.addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            if (countcronometro == 0) {
                                countcronometro = 1;
                                cronometro.iniciar();
                            }
                        }
                    });
                    JP_pta.jb_siguiente.addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {

                            respuestas.add(JP_pta.jb_siguiente.getActionCommand());
                            
                            count++;
                            if (count >= Preguntas.size()) {
                                cronometro.pausar();
                                jb_guardar.setEnabled(true);
                            }
                        }
                    });
                }else {//no se contara estado de animo
                    final JP_pt JP_pt = new JP_pt(_id, _pregunta, t1, t2);
                    jp_contenedor.add(JP_pt);
                    
                    JP_pt.jb_iniciar.addActionListener(new java.awt.event.ActionListener(){
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e){
                            if(countcronometro==0){
                                countcronometro=1;
                                cronometro.iniciar();
                            }
                        }
                    });
                    JP_pt.jb_siguiente.addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            respuestas.add(JP_pt.jb_siguiente.getActionCommand());
                            count++;
                            if (count >= Preguntas.size()) {
                                cronometro.pausar();
                                jb_guardar.setEnabled(true);
                            }
                        }
                    });
                }
            } else {/* SIN TIEMPO */
//
                if (_estadodeanimo) {
                    final JP_pa JP_pa = new JP_pa( _id, _pregunta, t1, t2);
                    jp_contenedor.add(JP_pa);

                    JP_pa.jb_siguiente.addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            if(countcronometro==0){
                                countcronometro=1;
                                cronometro.iniciar();
                            }
                            respuestas.add(JP_pa.jb_siguiente.getActionCommand());
                            count++;
                            if (count >= Preguntas.size()) {
                                cronometro.pausar();
                                jb_guardar.setEnabled(true);
                            }
                        }
                    });
                } 
                else {
                    final JP_p JP_p = new JP_p( _id, _pregunta, t1, t2);
                    jp_contenedor.add(JP_p);

                    JP_p.jb_siguiente.addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            if(countcronometro==0){
                                countcronometro=1;
                                cronometro.iniciar();
                            }
                            respuestas.add(JP_p.jb_siguiente.getActionCommand());
                            count++;
                            if (count >= Preguntas.size()) {
                                cronometro.pausar();
                                jb_guardar.setEnabled(true);
                            }
                        }
                    });
                }

            }

        }

    }

    public class Cronometro {

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

            tiempo = (h <= 9 ? "0" : "") + h + ":" + (m <= 9 ? "0" : "") + m + ":" + (s <= 9 ? "0" : "") + s + ":" + (cs <= 9 ? "0" : "") + cs;
            jl_digitosCronometro.setText(tiempo);

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
            jl_digitosCronometro.setText("00:00:00:00");

        }

    }
}
