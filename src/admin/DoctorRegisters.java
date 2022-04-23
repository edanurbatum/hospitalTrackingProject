
package admin;

import connection.ConnectionDoctor;
import connection.DbHelper;
import connection.Doctor;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DoctorRegisters extends javax.swing.JFrame {
    
    ConnectionDoctor connectionDoctor=new ConnectionDoctor();
    String queryForDoctors="select * from doctor";
    
    public DoctorRegisters() {
        initComponents();
        connectionDoctor.populateTable(queryForDoctors, tblDoctors);
    }

    
    public void add(){
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;
        
        try{
            connection=dbHelper.getConnection();
            String query="INSERT INTO doctor (tc,name,lastName,clinicalId,clinicalName,gender,residenceAddress,dateOfBirth,birthplace,email,phoneNumber) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            statement=connection.prepareStatement(query);
            
            statement.setString(1, tbxTc.getText());
            statement.setString(2, tbxName.getText());
            statement.setString(3, tbxLastName.getText());
            statement.setString(4, tbxClinicalId.getText());
            statement.setString(5, tbxShowClinicalName.getText());
            statement.setString(6, tbxGender.getText());
            statement.setString(7, tbxAddress.getText());
            statement.setString(8, tbxDateOfBirth.getText());
            statement.setString(9, tbxBirthPlace.getText());
            statement.setString(10, tbxMail.getText());
            statement.setString(11, tbxPhoneNumber.getText());
            
            statement.executeUpdate();           
            connectionDoctor.populateTable(queryForDoctors, tblDoctors);
            JOptionPane.showMessageDialog(null, "Kayıt eklendi, tablo güncellendi.");
            clean();
            
        }catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }finally{
            try{
               statement.close();
               connection.close();            
               
       }catch(SQLException exception){
            }           
        }
    }
    
     public void getDetail(String query) throws SQLException{
        
        ArrayList<Doctor>doctors=connectionDoctor.getDoctors(query);
        for (Doctor doctor:doctors) {
            tbxShowId.setText(doctor.getDoctorId());
            tbxShowTc.setText(doctor.getTc());
            tbxShowName.setText(doctor.getName());
            tbxShowLastName.setText(doctor.getLastName());
            tbxShowClinicalId.setText(doctor.getClinicalId());
            tbxShowClinicalName.setText(doctor.getClinicalName());
            tbxShowGender.setText(doctor.getGender());
            tbxShowAddress.setText(doctor.getResidenceAddress());
            tbxShowDateOfBirth.setText(doctor.getDateOfBirth());
            tbxShowBirthPlace.setText(doctor.getBirthplace());
            tbxShowMail.setText(doctor.getEmail());
            tbxShowPhoneNumber.setText(doctor.getPhoneNumber());         
        }
    }
     
    public void update(String query, JTextField textField){      
            
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;

        try{
            
            connection=dbHelper.getConnection();

            statement=connection.prepareStatement(query);
            statement.setString(1,textField.getText());
            statement.setString(2,tbxUpdateTc.getText());
            statement.executeUpdate();
            
            connectionDoctor.populateTable(queryForDoctors, tblDoctors);
            JOptionPane.showMessageDialog(null, "Kayıt güncellendi, tablo güncellendi.");
            cleanUpdateTbx();
           
            }catch(SQLException exception){
                dbHelper.showErrorMessage(exception);
            }finally{
                try{
                   statement.close();
                   connection.close(); 
                }catch(SQLException exception){
                }           
            }             
    }
    
    public void updateAddress(String query, JTextArea textArea){      
            
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;

        try{
            
            connection=dbHelper.getConnection();

            statement=connection.prepareStatement(query);
            statement.setString(1,textArea.getText());
            statement.setString(2,tbxUpdateTc.getText());
            statement.executeUpdate();
            
            connectionDoctor.populateTable(queryForDoctors, tblDoctors);
            JOptionPane.showMessageDialog(null, "Kayıt güncellendi, tablo güncellendi.");
            cleanUpdateTbx();
           
            }catch(SQLException exception){
                dbHelper.showErrorMessage(exception);
            }finally{
                try{
                   statement.close();
                   connection.close(); 
                }catch(SQLException exception){
                }           
            }             
    }
    
   
    public void delete(String query) {                                          
        
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;
        
        try{
            connection=dbHelper.getConnection();
                   
            statement=connection.prepareStatement(query);
            statement.setString(1, tbxUpdateTc.getText());
            statement.executeUpdate();
            
            connectionDoctor.populateTable(queryForDoctors, tblDoctors);
            JOptionPane.showMessageDialog(null, "Kayıt silindi, tablo güncellendi.");
            cleanUpdateTbx();
            
            
        }catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }finally{
            try{
               statement.close();
               connection.close();               
            }catch(SQLException exception){
                
            }           
        }        
    }
    
    public void getValues(String tc){
       String query="select * from doctor where tc='"+tc+"'";
       try {
            ArrayList<Doctor>doctors=connectionDoctor.getDoctors(query);
            for (Doctor doctor:doctors) {
                
                tbxUpdateId.setText(doctor.getDoctorId());
                tbxUpdateName.setText(doctor.getName());
                tbxUpdateLastName.setText(doctor.getLastName());
                tbxUpdateClinicalId.setText(doctor.getClinicalId());
                tbxUpdateClinicalName.setText(doctor.getClinicalName());
                tbxUpdateGender.setText(doctor.getGender());
                tbxUpdateAddress.setText(doctor.getResidenceAddress());
                tbxUpdateDateOfBirth.setText(doctor.getDateOfBirth());
                tbxUpdateBirthPlace.setText(doctor.getBirthplace());
                tbxUpdateMail.setText(doctor.getEmail());
                tbxUpdatePhoneNumber.setText(doctor.getPhoneNumber());                
                break;
            }     
         
        }catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }
    }

    
    public void clean(){
        tbxTc.setText("");
        tbxName.setText("");
        tbxLastName.setText("");
        tbxClinicalName.setText("");
        tbxGender.setText("");
        tbxAddress.setText("");
        tbxDateOfBirth.setText("");
        tbxBirthPlace.setText("");
        tbxMail.setText("");
        tbxPhoneNumber.setText("");
    }
    public void cleanUpdateTbx(){
        tbxUpdateId.setText("");
        tbxUpdateTc.setText("");
        tbxUpdateName.setText("");
        tbxUpdateLastName.setText("");
        tbxUpdateClinicalName.setText("");
        tbxUpdateGender.setText("");
        tbxUpdateAddress.setText("");
        tbxUpdateDateOfBirth.setText("");
        tbxUpdateBirthPlace.setText("");
        tbxUpdateMail.setText("");
        tbxUpdatePhoneNumber.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblTc = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblBranch = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblDateOfBirth = new javax.swing.JLabel();
        lblBirthPlace = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        tbxTc = new javax.swing.JTextField();
        tbxName = new javax.swing.JTextField();
        tbxLastName = new javax.swing.JTextField();
        tbxClinicalName = new javax.swing.JTextField();
        tbxGender = new javax.swing.JTextField();
        tbxDateOfBirth = new javax.swing.JTextField();
        tbxMail = new javax.swing.JTextField();
        tbxPhoneNumber = new javax.swing.JTextField();
        btnAddDoctor = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbxAddress = new javax.swing.JTextArea();
        tbxBirthPlace = new javax.swing.JTextField();
        tbxClinicalId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblTc1 = new javax.swing.JLabel();
        lblNameUpdate = new javax.swing.JLabel();
        lblLastNameUpdate = new javax.swing.JLabel();
        lblBranchUpdate = new javax.swing.JLabel();
        lblGenderUpdate = new javax.swing.JLabel();
        lblAddressUpdate = new javax.swing.JLabel();
        lblDateOfBirthUpdate = new javax.swing.JLabel();
        lblBirthPlaceUpdate = new javax.swing.JLabel();
        lblMailUpdate = new javax.swing.JLabel();
        lblPhoneNumberUpdate = new javax.swing.JLabel();
        tbxUpdateTc = new javax.swing.JTextField();
        tbxUpdateName = new javax.swing.JTextField();
        tbxUpdateLastName = new javax.swing.JTextField();
        tbxUpdateClinicalName = new javax.swing.JTextField();
        tbxUpdateGender = new javax.swing.JTextField();
        tbxUpdateDateOfBirth = new javax.swing.JTextField();
        tbxUpdateMail = new javax.swing.JTextField();
        tbxUpdatePhoneNumber = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbxUpdateAddress = new javax.swing.JTextArea();
        tbxUpdateBirthPlace = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tbxUpdateId = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        tbxUpdateClinicalId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnUpdateDoctor = new javax.swing.JButton();
        btnDeleteDoctor = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoctors = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblShowId = new javax.swing.JLabel();
        lblShowTc = new javax.swing.JLabel();
        lblShowName = new javax.swing.JLabel();
        lblShowLastName = new javax.swing.JLabel();
        lblShowBranch = new javax.swing.JLabel();
        lblShowGender = new javax.swing.JLabel();
        lblShowAddress = new javax.swing.JLabel();
        lblShowDateOfBirth = new javax.swing.JLabel();
        lblShowBirthPlace = new javax.swing.JLabel();
        lblShowMail = new javax.swing.JLabel();
        lblShowPhoneNumber = new javax.swing.JLabel();
        tbxShowId = new javax.swing.JTextField();
        tbxShowTc = new javax.swing.JTextField();
        tbxShowName = new javax.swing.JTextField();
        tbxShowLastName = new javax.swing.JTextField();
        tbxShowClinicalName = new javax.swing.JTextField();
        tbxShowGender = new javax.swing.JTextField();
        tbxShowDateOfBirth = new javax.swing.JTextField();
        tbxShowBirthPlace = new javax.swing.JTextField();
        tbxShowMail = new javax.swing.JTextField();
        tbxShowPhoneNumber = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbxShowAddress = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        tbxShowClinicalId = new javax.swing.JTextField();
        btnComeBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(209, 209, 224));

        lblTc.setText("Tc");

        lblName.setText("İsim");

        lblLastName.setText("Soyisim");

        lblBranch.setText("Klinik Adı");

        lblGender.setText("Cinsiyet");

        lblAddress.setText("Adres");

        lblDateOfBirth.setText("Doğum Tarihi");

        lblBirthPlace.setText("Doğum Yeri");

        lblMail.setText("Mail");

        lblPhoneNumber.setText("Telefon Numarası");

        btnAddDoctor.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnAddDoctor.setText("KAYIT EKLE");
        btnAddDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDoctorActionPerformed(evt);
            }
        });

        tbxAddress.setColumns(20);
        tbxAddress.setRows(5);
        jScrollPane3.setViewportView(tbxAddress);

        jLabel3.setText("Klinik Id");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(lblTc)
                    .addComponent(lblGender)
                    .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDateOfBirth)
                    .addComponent(jLabel3)
                    .addComponent(lblBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBirthPlace)
                    .addComponent(lblMail)
                    .addComponent(lblPhoneNumber)
                    .addComponent(lblAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tbxName, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addComponent(tbxTc, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addComponent(tbxLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addComponent(tbxClinicalName, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addComponent(tbxGender, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addComponent(tbxClinicalId))
                    .addComponent(tbxDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxMail, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnAddDoctor)))
                .addGap(56, 56, 56))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTc)
                    .addComponent(tbxTc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(tbxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(tbxLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxClinicalId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxClinicalName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBranch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDateOfBirth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBirthPlace))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMail)
                    .addComponent(tbxMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhoneNumber)
                    .addComponent(tbxPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnAddDoctor)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Yeni Doktor Kaydı Ekle", jPanel3);

        jPanel7.setBackground(new java.awt.Color(200, 200, 224));

        lblTc1.setText("Tc");

        lblNameUpdate.setText("İsim");

        lblLastNameUpdate.setText("Soyisim");

        lblBranchUpdate.setText("Klinik Adı");

        lblGenderUpdate.setText("Cinsiyet");

        lblAddressUpdate.setText("Adres");

        lblDateOfBirthUpdate.setText("Doğum Tarihi");

        lblBirthPlaceUpdate.setText("Doğum Yeri");

        lblMailUpdate.setText("Mail");

        lblPhoneNumberUpdate.setText("Telefon Numarası");

        tbxUpdateAddress.setColumns(20);
        tbxUpdateAddress.setRows(5);
        jScrollPane4.setViewportView(tbxUpdateAddress);

        jLabel1.setText("Id");

        btnSearch.setText("Ara");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel4.setText("Klinik Id");

        btnUpdateDoctor.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnUpdateDoctor.setText("GÜNCELLE");
        btnUpdateDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDoctorActionPerformed(evt);
            }
        });

        btnDeleteDoctor.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnDeleteDoctor.setText("SİL");
        btnDeleteDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDoctorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnUpdateDoctor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeleteDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblAddressUpdate)
                                .addComponent(lblPhoneNumberUpdate)
                                .addComponent(lblBirthPlaceUpdate)
                                .addComponent(lblDateOfBirthUpdate)
                                .addComponent(lblNameUpdate)
                                .addComponent(jLabel1)
                                .addComponent(lblLastNameUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblBranchUpdate)
                                .addComponent(jLabel4)
                                .addComponent(lblMailUpdate)
                                .addComponent(lblGenderUpdate))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(lblTc1)
                                .addGap(73, 73, 73)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tbxUpdateId, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(tbxUpdateName, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(tbxUpdateLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(tbxUpdateClinicalName, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(tbxUpdateGender, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(tbxUpdateDateOfBirth, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(tbxUpdateBirthPlace, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(tbxUpdateMail, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(tbxUpdatePhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(tbxUpdateClinicalId)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tbxUpdateTc, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxUpdateTc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(lblTc1))
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tbxUpdateId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameUpdate)
                    .addComponent(tbxUpdateName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastNameUpdate)
                    .addComponent(tbxUpdateLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxUpdateClinicalId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBranchUpdate)
                    .addComponent(tbxUpdateClinicalName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxUpdateGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGenderUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxUpdateDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDateOfBirthUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxUpdateBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBirthPlaceUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxUpdateMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMailUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhoneNumberUpdate)
                    .addComponent(tbxUpdatePhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddressUpdate)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateDoctor)
                    .addComponent(btnDeleteDoctor))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kayıt Güncelle/Sil", jPanel6);

        jPanel2.setBackground(new java.awt.Color(210, 210, 234));

        tblDoctors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tc", "İsim", "Soyisim"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDoctors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDoctorsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDoctors);

        lblShowId.setText("Id");

        lblShowTc.setText("Tc");

        lblShowName.setText("İsim");

        lblShowLastName.setText("Soyisim");

        lblShowBranch.setText("Klinik Adı");

        lblShowGender.setText("Cinsiyet");

        lblShowAddress.setText("Adres");

        lblShowDateOfBirth.setText("Doğum Tarihi");

        lblShowBirthPlace.setText("Doğum Yeri");

        lblShowMail.setText("Mail");

        lblShowPhoneNumber.setText("Telefon Numarası");

        tbxShowAddress.setColumns(20);
        tbxShowAddress.setRows(5);
        jScrollPane2.setViewportView(tbxShowAddress);

        jLabel2.setText("Klinik Id");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblShowName)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblShowId)
                        .addComponent(lblShowTc))
                    .addComponent(lblShowGender)
                    .addComponent(lblShowBirthPlace)
                    .addComponent(lblShowMail)
                    .addComponent(lblShowPhoneNumber)
                    .addComponent(lblShowAddress)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblShowLastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblShowDateOfBirth, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2)
                    .addComponent(lblShowBranch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbxShowTc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowClinicalName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowGender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowPhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowDateOfBirth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowBirthPlace, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowMail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowClinicalId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShowId)
                    .addComponent(tbxShowId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShowTc)
                    .addComponent(tbxShowTc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShowName)
                    .addComponent(tbxShowName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShowLastName)
                    .addComponent(tbxShowLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tbxShowClinicalId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShowBranch)
                    .addComponent(tbxShowClinicalName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShowGender)
                    .addComponent(tbxShowGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShowDateOfBirth)
                    .addComponent(tbxShowDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShowBirthPlace)
                    .addComponent(tbxShowBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShowMail)
                    .addComponent(tbxShowMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShowPhoneNumber)
                    .addComponent(tbxShowPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblShowAddress))
                .addContainerGap())
        );

        btnComeBack.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btnComeBack.setText("GERİ DÖN");
        btnComeBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComeBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnComeBack)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnComeBack))
        );

        jTabbedPane1.addTab("Doktor Kayıtları", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
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

    private void btnAddDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDoctorActionPerformed
        add();
    }//GEN-LAST:event_btnAddDoctorActionPerformed

    private void tblDoctorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDoctorsMouseClicked
        String selectedTc=(tblDoctors.getValueAt(tblDoctors.getSelectedRow(), 1).toString());
        String query="select * from doctor where tc='"+selectedTc+"'";
        try {
            getDetail(query);
        } catch (SQLException ex) {
            Logger.getLogger(DoctorRegisters.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblDoctorsMouseClicked

    private void btnUpdateDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDoctorActionPerformed
        if(!(tbxUpdateName.getText().equals(""))) {
            String query="UPDATE doctor SET name= ? WHERE tc=?";
            update(query,tbxUpdateName);
        }  
        if(!(tbxUpdateLastName.getText().equals(""))) {
            String query="UPDATE doctor SET lastName= ? WHERE tc=?";
            update(query,tbxUpdateLastName);
        }
        if(!(tbxUpdateClinicalId.getText().equals(""))) {
            String query="UPDATE doctor SET clinicalId= ? WHERE tc=?";
            update(query,tbxUpdateClinicalId);
        }
        if(!(tbxUpdateClinicalName.getText().equals(""))) {
            String query="UPDATE doctor SET clinicalName= ? WHERE tc=?";
            update(query,tbxUpdateClinicalName);
        }
        if(!(tbxUpdateGender.getText().equals(""))) {
            String query="UPDATE doctor SET gender= ? WHERE tc=?";
            update(query,tbxUpdateGender);
        }
        if(!(tbxUpdateAddress.getText().equals(""))) {
            String query="UPDATE doctor SET residenceAddress= ? WHERE tc=?";
            updateAddress(query,tbxUpdateAddress);
        }
        if(!(tbxUpdateDateOfBirth.getText().equals(""))) {
            String query="UPDATE doctor SET dateOfBirth= ? WHERE tc=?";
            update(query,tbxUpdateDateOfBirth);
        }
        if(!(tbxUpdateBirthPlace.getText().equals(""))) {
            String query="UPDATE doctor SET birthplace= ? WHERE tc=?";
            update(query,tbxUpdateBirthPlace);
        }
        if(!(tbxUpdateMail.getText().equals(""))) {
            String query="UPDATE doctor SET email= ? WHERE tc=?";
            update(query,tbxUpdateMail);
        }
        if(!(tbxUpdatePhoneNumber.getText().equals(""))) {
            String query="UPDATE doctor SET phoneNumber= ? WHERE tc=?";
            update(query,tbxUpdatePhoneNumber);
        }
        
    }//GEN-LAST:event_btnUpdateDoctorActionPerformed

    private void btnDeleteDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDoctorActionPerformed
        String query="DELETE from doctor WHERE tc= (?)";
        delete(query);
    }//GEN-LAST:event_btnDeleteDoctorActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String selectedTc=tbxUpdateTc.getText();
        getValues(selectedTc);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnComeBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComeBackActionPerformed
        new AdminOperations().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnComeBackActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DoctorRegisters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorRegisters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorRegisters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorRegisters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorRegisters().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDoctor;
    private javax.swing.JButton btnComeBack;
    private javax.swing.JButton btnDeleteDoctor;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateDoctor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddressUpdate;
    private javax.swing.JLabel lblBirthPlace;
    private javax.swing.JLabel lblBirthPlaceUpdate;
    private javax.swing.JLabel lblBranch;
    private javax.swing.JLabel lblBranchUpdate;
    private javax.swing.JLabel lblDateOfBirth;
    private javax.swing.JLabel lblDateOfBirthUpdate;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGenderUpdate;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblLastNameUpdate;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblMailUpdate;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameUpdate;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPhoneNumberUpdate;
    private javax.swing.JLabel lblShowAddress;
    private javax.swing.JLabel lblShowBirthPlace;
    private javax.swing.JLabel lblShowBranch;
    private javax.swing.JLabel lblShowDateOfBirth;
    private javax.swing.JLabel lblShowGender;
    private javax.swing.JLabel lblShowId;
    private javax.swing.JLabel lblShowLastName;
    private javax.swing.JLabel lblShowMail;
    private javax.swing.JLabel lblShowName;
    private javax.swing.JLabel lblShowPhoneNumber;
    private javax.swing.JLabel lblShowTc;
    private javax.swing.JLabel lblTc;
    private javax.swing.JLabel lblTc1;
    private javax.swing.JTable tblDoctors;
    private javax.swing.JTextArea tbxAddress;
    private javax.swing.JTextField tbxBirthPlace;
    private javax.swing.JTextField tbxClinicalId;
    private javax.swing.JTextField tbxClinicalName;
    private javax.swing.JTextField tbxDateOfBirth;
    private javax.swing.JTextField tbxGender;
    private javax.swing.JTextField tbxLastName;
    private javax.swing.JTextField tbxMail;
    private javax.swing.JTextField tbxName;
    private javax.swing.JTextField tbxPhoneNumber;
    private javax.swing.JTextArea tbxShowAddress;
    private javax.swing.JTextField tbxShowBirthPlace;
    private javax.swing.JTextField tbxShowClinicalId;
    private javax.swing.JTextField tbxShowClinicalName;
    private javax.swing.JTextField tbxShowDateOfBirth;
    private javax.swing.JTextField tbxShowGender;
    private javax.swing.JTextField tbxShowId;
    private javax.swing.JTextField tbxShowLastName;
    private javax.swing.JTextField tbxShowMail;
    private javax.swing.JTextField tbxShowName;
    private javax.swing.JTextField tbxShowPhoneNumber;
    private javax.swing.JTextField tbxShowTc;
    private javax.swing.JTextField tbxTc;
    private javax.swing.JTextArea tbxUpdateAddress;
    private javax.swing.JTextField tbxUpdateBirthPlace;
    private javax.swing.JTextField tbxUpdateClinicalId;
    private javax.swing.JTextField tbxUpdateClinicalName;
    private javax.swing.JTextField tbxUpdateDateOfBirth;
    private javax.swing.JTextField tbxUpdateGender;
    private javax.swing.JTextField tbxUpdateId;
    private javax.swing.JTextField tbxUpdateLastName;
    private javax.swing.JTextField tbxUpdateMail;
    private javax.swing.JTextField tbxUpdateName;
    private javax.swing.JTextField tbxUpdatePhoneNumber;
    private javax.swing.JTextField tbxUpdateTc;
    // End of variables declaration//GEN-END:variables
}
