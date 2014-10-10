package vista.inicio;

public class JP_inicio extends javax.swing.JPanel {

    public JP_inicio() {
        initComponents();
        this.setSize(900, 577);
        font();
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_bienvenida = new javax.swing.JLabel();
        jb_verGuia = new javax.swing.JButton();
        jl_inicio1 = new javax.swing.JLabel();
        jl_inicio2 = new javax.swing.JLabel();
        jl_inicio3 = new javax.swing.JLabel();
        jl_iniciosub1 = new javax.swing.JLabel();
        jl_iniciosub2 = new javax.swing.JLabel();

        jl_bienvenida.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jl_bienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_bienvenida.setText("Bienvenido");

        jb_verGuia.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jb_verGuia.setText("Ver Guía");
        jb_verGuia.setToolTipText("Podrás ver como funciona el sistema ");
        jb_verGuia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jb_verGuia.setEnabled(false);
        jb_verGuia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_verGuiaActionPerformed(evt);
            }
        });

        jl_inicio1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_inicio1.setText("Aquí podrás tener tus Test de Usabilidad  y");

        jl_inicio2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_inicio2.setText("llevar un seguimiento de la ");

        jl_inicio3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_inicio3.setText("evolución de tus proyectos.");

        jl_iniciosub1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_iniciosub1.setText("EVIU");

        jl_iniciosub2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_iniciosub2.setText("(Evaluación Interactiva de Usabilidad)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jl_bienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(349, Short.MAX_VALUE)
                .addComponent(jb_verGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(340, 340, 340))
            .addComponent(jl_iniciosub1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_inicio1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_inicio2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_inicio3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_iniciosub2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jl_bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jl_iniciosub1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_iniciosub2)
                .addGap(65, 65, 65)
                .addComponent(jl_inicio1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_inicio2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_inicio3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jb_verGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jb_verGuiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_verGuiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_verGuiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jb_verGuia;
    private javax.swing.JLabel jl_bienvenida;
    private javax.swing.JLabel jl_inicio1;
    private javax.swing.JLabel jl_inicio2;
    private javax.swing.JLabel jl_inicio3;
    private javax.swing.JLabel jl_iniciosub1;
    private javax.swing.JLabel jl_iniciosub2;
    // End of variables declaration//GEN-END:variables
    private void font() {
        jl_inicio1.setFont(vista.Config.getTam_subTitulo());
        jl_inicio2.setFont(vista.Config.getTam_subTitulo());
        jl_inicio3.setFont(vista.Config.getTam_subTitulo());
        jl_iniciosub1.setFont(vista.Config.getTam_Titulo());
        jl_iniciosub2.setFont(vista.Config.getTam_Titulo());
    }
}
