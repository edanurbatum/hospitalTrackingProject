
package doctor;

import login.HomePage;


public class DoctorOperations extends javax.swing.JFrame {
 
    public DoctorOperations() {
        initComponents();
    }
    
 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnComeBack = new javax.swing.JButton();
        btnAppointments1 = new javax.swing.JButton();
        btnShowAppointments = new javax.swing.JButton();
        btnAddPrescription = new javax.swing.JButton();
        btnShowAppointments1 = new javax.swing.JButton();
        btnAppointments = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        btnComeBack.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btnComeBack.setText("GERİ DÖN");
        btnComeBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComeBackActionPerformed(evt);
            }
        });

        btnAppointments1.setBackground(new java.awt.Color(255, 255, 255));
        btnAppointments1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnAppointments1.setText("Laboratuvar Sonucu Gir ");
        btnAppointments1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAppointments1ActionPerformed(evt);
            }
        });

        btnShowAppointments.setBackground(new java.awt.Color(255, 255, 255));
        btnShowAppointments.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnShowAppointments.setText("Laboratuvar Sonuçları");
        btnShowAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAppointmentsActionPerformed(evt);
            }
        });

        btnAddPrescription.setBackground(new java.awt.Color(255, 255, 255));
        btnAddPrescription.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnAddPrescription.setText("Reçete Yaz");
        btnAddPrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPrescriptionActionPerformed(evt);
            }
        });

        btnShowAppointments1.setBackground(new java.awt.Color(255, 255, 255));
        btnShowAppointments1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnShowAppointments1.setText("Reçeteler");
        btnShowAppointments1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAppointments1ActionPerformed(evt);
            }
        });

        btnAppointments.setBackground(new java.awt.Color(255, 255, 255));
        btnAppointments.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnAppointments.setText("Randevular");
        btnAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAppointmentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnComeBack)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAppointments1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnShowAppointments1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnShowAppointments, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                        .addComponent(btnAddPrescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAppointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(btnAddPrescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnShowAppointments1)
                .addGap(35, 35, 35)
                .addComponent(btnAppointments1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnShowAppointments)
                .addGap(28, 28, 28)
                .addComponent(btnAppointments)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(btnComeBack)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComeBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComeBackActionPerformed
        new HomePage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnComeBackActionPerformed

    private void btnAppointments1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppointments1ActionPerformed
        new AddLaboratoryResult().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAppointments1ActionPerformed

    private void btnShowAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAppointmentsActionPerformed
        new ViewLaboratoryResults().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnShowAppointmentsActionPerformed

    private void btnAddPrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPrescriptionActionPerformed
        new AddPrescription().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddPrescriptionActionPerformed

    private void btnShowAppointments1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAppointments1ActionPerformed
        new ViewPrescriptions().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnShowAppointments1ActionPerformed

    private void btnAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppointmentsActionPerformed
        new ViewAppointments().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAppointmentsActionPerformed

  
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
            java.util.logging.Logger.getLogger(DoctorOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorOperations().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPrescription;
    private javax.swing.JButton btnAppointments;
    private javax.swing.JButton btnAppointments1;
    private javax.swing.JButton btnComeBack;
    private javax.swing.JButton btnShowAppointments;
    private javax.swing.JButton btnShowAppointments1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
