package vista.inicio;

import vista.Eviu;

public class JP_inicio extends javax.swing.JPanel {
    Eviu Eviu;
    public JP_inicio(Eviu Eviu) {
        this.Eviu = Eviu;
        initComponents();
        this.setSize(900, 577);
        font();
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_bienvenida = new javax.swing.JLabel();
        jl_iniciosub1 = new javax.swing.JLabel();
        jl_iniciosub2 = new javax.swing.JLabel();
        jp_nuevoProyecto = new javax.swing.JPanel();
        jl_nuevoProyecto = new javax.swing.JLabel();
        jp_abrir = new javax.swing.JPanel();
        jl_abrir = new javax.swing.JLabel();
        jp_importar = new javax.swing.JPanel();
        jl_importar = new javax.swing.JLabel();
        jp_ayuda = new javax.swing.JPanel();
        jl_ayuda = new javax.swing.JLabel();

        jl_bienvenida.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jl_bienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_bienvenida.setText("Bienvenido");

        jl_iniciosub1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_iniciosub1.setText("EVIU");

        jl_iniciosub2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_iniciosub2.setText("(Evaluación Interactiva de Usabilidad)");

        jl_nuevoProyecto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_nuevoProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        jl_nuevoProyecto.setToolTipText("Crear Proyecto");
        jl_nuevoProyecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_nuevoProyectoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jl_nuevoProyectoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jl_nuevoProyectoMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jp_nuevoProyectoLayout = new javax.swing.GroupLayout(jp_nuevoProyecto);
        jp_nuevoProyecto.setLayout(jp_nuevoProyectoLayout);
        jp_nuevoProyectoLayout.setHorizontalGroup(
            jp_nuevoProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_nuevoProyectoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_nuevoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_nuevoProyectoLayout.setVerticalGroup(
            jp_nuevoProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_nuevoProyectoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_nuevoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jl_abrir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/abrir.png"))); // NOI18N
        jl_abrir.setToolTipText("Abrir Proyecto");
        jl_abrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_abrirMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jl_abrirMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jl_abrirMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jp_abrirLayout = new javax.swing.GroupLayout(jp_abrir);
        jp_abrir.setLayout(jp_abrirLayout);
        jp_abrirLayout.setHorizontalGroup(
            jp_abrirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_abrirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_abrir, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_abrirLayout.setVerticalGroup(
            jp_abrirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_abrirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_abrir, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jl_importar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_importar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/importar.png"))); // NOI18N
        jl_importar.setToolTipText("Importar Respuestas");
        jl_importar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_importarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jl_importarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jl_importarMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jp_importarLayout = new javax.swing.GroupLayout(jp_importar);
        jp_importar.setLayout(jp_importarLayout);
        jp_importarLayout.setHorizontalGroup(
            jp_importarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_importarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_importar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_importarLayout.setVerticalGroup(
            jp_importarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_importarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_importar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jl_ayuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_ayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ayuda.png"))); // NOI18N
        jl_ayuda.setToolTipText("Importar Respuestas");
        jl_ayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_ayudaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jl_ayudaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jl_ayudaMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jp_ayudaLayout = new javax.swing.GroupLayout(jp_ayuda);
        jp_ayuda.setLayout(jp_ayudaLayout);
        jp_ayudaLayout.setHorizontalGroup(
            jp_ayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_ayudaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_ayudaLayout.setVerticalGroup(
            jp_ayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_ayudaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jl_bienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(103, 103, Short.MAX_VALUE)
                .addComponent(jp_nuevoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jp_abrir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jp_importar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jp_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jl_iniciosub2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_iniciosub1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jl_bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_nuevoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp_abrir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp_importar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addComponent(jl_iniciosub1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_iniciosub2)
                .addGap(64, 64, 64))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jl_abrirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_abrirMouseEntered
         
         jp_abrir.setBackground(vista.Config.colorDeSeleccionado());
    }//GEN-LAST:event_jl_abrirMouseEntered

    private void jl_abrirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_abrirMouseExited
        
        jp_abrir.setBackground(null);
    }//GEN-LAST:event_jl_abrirMouseExited

    private void jl_nuevoProyectoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_nuevoProyectoMouseExited
        jp_nuevoProyecto.setBackground(null);
    }//GEN-LAST:event_jl_nuevoProyectoMouseExited

    private void jl_nuevoProyectoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_nuevoProyectoMouseEntered
        jp_nuevoProyecto.setBackground(vista.Config.colorDeSeleccionado());
    }//GEN-LAST:event_jl_nuevoProyectoMouseEntered

    private void jl_importarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_importarMouseExited
        jp_importar.setBackground(null);
    }//GEN-LAST:event_jl_importarMouseExited

    private void jl_importarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_importarMouseEntered
        jp_importar.setBackground(vista.Config.colorDeSeleccionado());
    }//GEN-LAST:event_jl_importarMouseEntered

    private void jl_nuevoProyectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_nuevoProyectoMouseClicked
        Eviu.jmi_nuevoProyectoActionPerformed();
    }//GEN-LAST:event_jl_nuevoProyectoMouseClicked

    private void jl_abrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_abrirMouseClicked
        Eviu.jmi_abrirProyectoActionPerformed();
    }//GEN-LAST:event_jl_abrirMouseClicked

    private void jl_importarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_importarMouseClicked
        Eviu.jmi_importarRespuestasActionPerformed();
    }//GEN-LAST:event_jl_importarMouseClicked

    private void jl_ayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_ayudaMouseClicked
        Eviu.abrirJD__Ayuda();
    }//GEN-LAST:event_jl_ayudaMouseClicked

    private void jl_ayudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_ayudaMouseExited
        jp_ayuda.setBackground(null);
    }//GEN-LAST:event_jl_ayudaMouseExited

    private void jl_ayudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_ayudaMouseEntered
        jp_ayuda.setBackground(vista.Config.colorDeSeleccionado());
    }//GEN-LAST:event_jl_ayudaMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jl_abrir;
    private javax.swing.JLabel jl_ayuda;
    private javax.swing.JLabel jl_bienvenida;
    private javax.swing.JLabel jl_importar;
    private javax.swing.JLabel jl_iniciosub1;
    private javax.swing.JLabel jl_iniciosub2;
    private javax.swing.JLabel jl_nuevoProyecto;
    private javax.swing.JPanel jp_abrir;
    private javax.swing.JPanel jp_ayuda;
    private javax.swing.JPanel jp_importar;
    private javax.swing.JPanel jp_nuevoProyecto;
    // End of variables declaration//GEN-END:variables
    private void font() {
        jl_iniciosub1.setFont(vista.Config.getTam_Titulo());
        jl_iniciosub2.setFont(vista.Config.getTam_Titulo());
    }
}
