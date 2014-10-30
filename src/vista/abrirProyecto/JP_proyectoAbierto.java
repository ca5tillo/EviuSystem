/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.abrirProyecto;

import controlador.modelos.Categoria;
import controlador.modelosRespuestas.Obj_respuestas;
import controlador.modelosRespuestas.Perfil;
import controlador.modelosRespuestas.Respuestas;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public final class JP_proyectoAbierto extends javax.swing.JPanel {

    vista.Eviu Eviu;
    JP_iconoTest JP_iconoTest;
    String str_nomProyecto;
    String str_nomTest;

    public JP_proyectoAbierto(String nombreProyecto, vista.Eviu Eviu) {
        str_nomProyecto = nombreProyecto;
        initComponents();
        this.Eviu = Eviu;
        this.setSize(900, 577);
        font();
        seticonoTest();
        jl_nVersion.setText("" + controlador.LeerDatos.getVersion(str_nomProyecto));
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmiPop_eliminarProyecto = new javax.swing.JMenuItem();
        jl_nomProyecto = new javax.swing.JLabel();
        jl_subtitulo = new javax.swing.JLabel();
        jb_abrir = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jb_nuevoTest = new javax.swing.JButton();
        jb_verAvances = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jb_nuevaVersion = new javax.swing.JButton();
        jl_nVersion = new javax.swing.JLabel();
        jb_crearReporte = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jp_contenedor = new javax.swing.JPanel();
        jb_eliminarProyecto = new javax.swing.JButton();

        jmiPop_eliminarProyecto.setText("Eliminar Proyecto");
        jmiPop_eliminarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPop_eliminarProyectoActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmiPop_eliminarProyecto);

        jl_nomProyecto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_nomProyecto.setText("Proyecto: "+str_nomProyecto);

        jl_subtitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_subtitulo.setText("Tienes los siguientes Tests en este Proyecto.");

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

        jb_nuevoTest.setText("Nuevo Test");
        jb_nuevoTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_nuevoTestActionPerformed(evt);
            }
        });

        jb_verAvances.setText("Ver Avances");
        jb_verAvances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_verAvancesActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Versión de tu proyecto");

        jb_nuevaVersion.setText("Nueva Version");
        jb_nuevaVersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_nuevaVersionActionPerformed(evt);
            }
        });

        jl_nVersion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_nVersion.setText("n");

        jb_crearReporte.setText("Crear Reporte");
        jb_crearReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_crearReporteActionPerformed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 24));

        jp_contenedor.setComponentPopupMenu(jPopupMenu1);
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.LEADING);
        flowLayout2.setAlignOnBaseline(true);
        jp_contenedor.setLayout(flowLayout2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        jb_eliminarProyecto.setText("Eliminar Proyecto");
        jb_eliminarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_eliminarProyectoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(jl_nVersion, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jb_nuevoTest, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jb_verAvances, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jb_crearReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jb_nuevaVersion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jb_eliminarProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(184, 184, 184)
                                .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jb_abrir, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jl_nomProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jl_subtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jl_nomProyecto)
                .addGap(18, 18, 18)
                .addComponent(jl_subtitulo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jb_nuevoTest)
                        .addGap(18, 18, 18)
                        .addComponent(jb_verAvances)
                        .addGap(18, 18, 18)
                        .addComponent(jb_crearReporte)
                        .addGap(123, 123, 123)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jl_nVersion)
                        .addGap(18, 18, 18)
                        .addComponent(jb_nuevaVersion))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb_abrir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jb_eliminarProyecto)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        Eviu.pintarPanelInicio();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_abrirActionPerformed
        
        vista.perfil.JD_perfil.main(Eviu, str_nomProyecto);
        Eviu.pintarPanel_test(str_nomProyecto, str_nomTest);
    }//GEN-LAST:event_jb_abrirActionPerformed

    private void jb_crearReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_crearReporteActionPerformed
        /*
         Codigo de Rafa
         */
    }//GEN-LAST:event_jb_crearReporteActionPerformed

    private void jb_verAvancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_verAvancesActionPerformed
//        respuestas();
        grafia();
    }//GEN-LAST:event_jb_verAvancesActionPerformed

    private void respuestas() {
        ArrayList<Obj_respuestas> getRespuestas
                = controlador.LeerDatos.getRespuestas(str_nomProyecto, str_nomTest);
        String ss = "";
        for (Obj_respuestas a : getRespuestas) {
            String ID = a.getID();
            String version = a.getVersion();
            String tiempodeencuesta = a.getTiempodeencuesta();
            ss += "\nID: " + ID;
            ss += "\n\t version: " + version;
            ss += "\n\t tiempodeencuesta: " + tiempodeencuesta;
            java.util.ArrayList<controlador.modelosRespuestas.Perfil> perfil = a.getPerfil();

            java.util.ArrayList<controlador.modelosRespuestas.Respuestas> respuestas = a.getRespuestas();
            ss += "\n\t\t-----PERFIL-----";
            for (Perfil perfil1 : perfil) {
                String categoria = perfil1.getCategoria();
                String opcion = perfil1.getOpcion();

                ss += "\n\t\t\t" + opcion;
            }
            ss += "\n\t\t-----RESPUESTAS-----";
            for (Respuestas respuestas1 : respuestas) {
                String id_pregunta = respuestas1.getId_pregunta();
                String pregunta = respuestas1.getPregunta();
                String realizo = respuestas1.getRealizo();
                String tiempo = respuestas1.getTiempo();
                String animo = respuestas1.getAnimo();
                String nota = respuestas1.getNota();

                ss += "\n\t\t\tpregunta: " + pregunta;
                ss += "\n\t\t\t\trealizo: " + realizo;
                ss += "\n\t\t\t\ttiempo: " + tiempo;
                ss += "\n\t\t\t\tanimo: " + animo;
                ss += "\n\t\t\t\tnota: " + nota;
            }
        }
        controlador.Archivos.reporte(ss);
    }

    private void grafia() {
        JFreeChart Grafica;
        DefaultCategoryDataset Datos = new DefaultCategoryDataset();
        
        /*CREO LA BASE DE LA GRAFICA*/
        java.util.ArrayList<controlador.modelos.Categoria> perfil = new java.util.ArrayList();
        perfil = controlador.LeerDatos.getPerfil(str_nomProyecto);
        for (Categoria cat : perfil) {
            String categoria = cat.getCategoria();
            java.util.ArrayList<String> opciones = cat.getOpciones();
            for (String opcion : opciones) {
                Datos.addValue(0, categoria, opcion);
            }
        }
        /* FIN DE CREO LA BASE DE LA GRAFICA*/
        
        /* INCREMENTO LOS VALORES */
        /*TIENES QUE SELECCINAR UN TEST PARA QUE str_nomTest TENGA UN VALOR */
        ArrayList<Obj_respuestas> getRespuestas
                = controlador.LeerDatos.getRespuestas(str_nomProyecto, str_nomTest);
        for (Obj_respuestas a : getRespuestas) {
            
            java.util.ArrayList<controlador.modelosRespuestas.Perfil> 
                    lst_perfil = a.getPerfil();

            for (Perfil perfil1 : lst_perfil) {
                String categoria = perfil1.getCategoria();
                String opcion = perfil1.getOpcion();
                
                Datos.incrementValue(1, categoria, opcion);
            }
        }

        Grafica = ChartFactory.createBarChart("Grafica del Perfiles",
                "Opciones", "Número", Datos,
                PlotOrientation.VERTICAL, true, true, false);

        ChartPanel Panel = new ChartPanel(Grafica);
        JFrame Ventana = new JFrame("JFreeChart");
        Ventana.getContentPane().add(Panel);
        Ventana.pack();
        Ventana.setVisible(true);
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void jb_nuevoTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_nuevoTestActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                final vista.crearProyecto.JD_crearPT dialog = new vista.crearProyecto.JD_crearPT(
                        new javax.swing.JFrame(), true, str_nomProyecto);

                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        dialog.dispose();

                    }
                });

                dialog.setVisible(true);
                seticonoTest();
                jp_contenedor.updateUI();
            }
        });

    }//GEN-LAST:event_jb_nuevoTestActionPerformed

    private void jb_nuevaVersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_nuevaVersionActionPerformed
        controlador.LeerDatos.setVersion(str_nomProyecto);
        jl_nVersion.setText("" + controlador.LeerDatos.getVersion(str_nomProyecto));
    }//GEN-LAST:event_jb_nuevaVersionActionPerformed

    private void jb_eliminarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_eliminarProyectoActionPerformed
        eliminarProyecto();
    }//GEN-LAST:event_jb_eliminarProyectoActionPerformed

    private void jmiPop_eliminarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPop_eliminarProyectoActionPerformed
        eliminarProyecto();
    }//GEN-LAST:event_jmiPop_eliminarProyectoActionPerformed

    public void eliminarProyecto() {
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = javax.swing.JOptionPane.showOptionDialog(this,
                "Esta seguro de Eliminar el Proyecto " + str_nomProyecto,
                "Mensaje de confirmacion",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == javax.swing.JOptionPane.YES_OPTION) {
            boolean eliminar = controlador.Archivos.eliminarProyecto(str_nomProyecto);
            if (eliminar) {
                javax.swing.JOptionPane.showMessageDialog(null,
                        "El Proyecto ha sido Eliminado satisfactoriamente");
                Eviu.pintarPanelInicio();
            } else {
                javax.swing.JOptionPane.showMessageDialog(null,
                        "No se pudo Eliminar el Proyecto ");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_abrir;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_crearReporte;
    private javax.swing.JButton jb_eliminarProyecto;
    private javax.swing.JButton jb_nuevaVersion;
    private javax.swing.JButton jb_nuevoTest;
    private javax.swing.JButton jb_verAvances;
    private javax.swing.JLabel jl_nVersion;
    private javax.swing.JLabel jl_nomProyecto;
    private javax.swing.JLabel jl_subtitulo;
    private javax.swing.JMenuItem jmiPop_eliminarProyecto;
    private javax.swing.JPanel jp_contenedor;
    // End of variables declaration//GEN-END:variables
    private void font() {
        jl_subtitulo.setFont(vista.Config.getTam_subTitulo());
        jl_nomProyecto.setFont(vista.Config.getTam_Titulo());
    }

    public void seticonoTest() {
        jp_contenedor.removeAll();
        jp_contenedor.updateUI();
        java.util.ArrayList<String> lst_Tests = controlador.Archivos.getTests(str_nomProyecto);
        for (String test : lst_Tests) {
            jp_contenedor.add(new JP_iconoTest(test, this));
        }

    }

    public JP_iconoTest getJP_iconoTest() {
        return JP_iconoTest;
    }

    public void setJP_iconoTest(JP_iconoTest JP_iconoTest) {
        this.JP_iconoTest = JP_iconoTest;
    }

    public String getStr_nomTest() {
        return str_nomTest;
    }

    public void setStr_nomTest(String str_nomTest) {
        this.str_nomTest = str_nomTest;
    }

    public void activarBotonAbrir() {
        jb_abrir.setEnabled(true);
    }

    public String getStr_nomProyecto() {
        return str_nomProyecto;
    }

}
