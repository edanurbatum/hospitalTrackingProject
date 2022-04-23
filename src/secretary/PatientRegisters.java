
package secretary;

import connection.ConnectionPatient;
import connection.DbHelper;
import connection.Patient;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PatientRegisters extends javax.swing.JFrame {

    ConnectionPatient connectionPatient=new ConnectionPatient();
    String queryForPatients="select * from patient";
    
    public PatientRegisters() {
        initComponents();
        connectionPatient.populateTable(queryForPatients, tblPatients);
    }

    public void add(){
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;
        
        try{
            String bloodType=String.valueOf(cbxBloodType.getSelectedItem());
            
            connection=dbHelper.getConnection();
            String query="INSERT INTO patient (tc,name,lastName,residenceAddress,dateOfBirth,birthplace,gender,email,phoneNumber,bloodType) VALUES (?,?,?,?,?,?,?,?,?,?)";
            statement=connection.prepareStatement(query);
            
            statement.setString(1, tbxTc.getText());
            statement.setString(2, tbxName.getText());
            statement.setString(3, tbxLastName.getText());           
            statement.setString(4, tbxAddress.getText());
            statement.setString(5, tbxDateOfBirth.getText());
            statement.setString(6, tbxBirthPlace.getText());
            statement.setString(7, tbxGender.getText());
            statement.setString(8, tbxMail.getText());
            statement.setString(9, tbxPhoneNumber.getText());
            statement.setString(10, bloodType);
            
            statement.executeUpdate();           
            connectionPatient.populateTable(queryForPatients, tblPatients);
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
        
        ArrayList<Patient>patients=connectionPatient.getPatients(query);
        for (Patient patient:patients) {
            tbxShowId.setText(patient.getPatientId());
            tbxShowTc.setText(patient.getTc());
            tbxShowName.setText(patient.getName());
            tbxShowLastName.setText(patient.getLastName());
            tbxShowAddress.setText(patient.getResidenceAddress());
            tbxShowDateOfBirth.setText(patient.getDateOfBirth());
            tbxShowBirthPlace.setText(patient.getBirthplace());
            tbxShowGender.setText(patient.getGender());
            tbxShowMail.setText(patient.getEmail());
            tbxShowPhoneNumber.setText(patient.getPhoneNumber()); 
            tbxShowBloodType.setText(patient.getBloodType());        
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
            
            connectionPatient.populateTable(queryForPatients, tblPatients);
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
       String query="select * from patient where tc='"+tc+"'";
       try {
            ArrayList<Patient>patients=connectionPatient.getPatients(query);
            for (Patient patient:patients) {
                
                tbxUpdateId.setText(patient.getPatientId());
                tbxUpdateName.setText(patient.getName());
                tbxUpdateLastName.setText(patient.getLastName());
                tbxUpdateAddress.setText(patient.getResidenceAddress());
                tbxUpdateDateOfBirth.setText(patient.getDateOfBirth());
                tbxUpdateBirthPlace.setText(patient.getBirthplace());
                tbxUpdateGender.setText(patient.getGender());
                tbxUpdateMail.setText(patient.getEmail());
                tbxUpdatePhoneNumber.setText(patient.getPhoneNumber());               
                break;
            }     
         
        }catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
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
            
            connectionPatient.populateTable(queryForPatients, tblPatients);
            JOptionPane.showMessageDialog(null, "Kayıt güncellendi, tablo güncellendi.");
           
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
            
            connectionPatient.populateTable(queryForPatients, tblPatients);
            JOptionPane.showMessageDialog(null, "Kayıt güncellendi, tablo güncellendi.");
            //cleanUpdateTbx();
           
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
    public void clean(){
        tbxTc.setText("");
        tbxName.setText("");
        tbxLastName.setText("");
        tbxAddress.setText("");
        tbxDateOfBirth.setText("");
        tbxBirthPlace.setText("");
        tbxGender.setText("");
        tbxMail.setText("");
        tbxPhoneNumber.setText("");
    }
    public void cleanUpdateTbx(){
        tbxUpdateId.setText("");
        tbxUpdateTc.setText("");
        tbxUpdateName.setText("");
        tbxUpdateLastName.setText("");
        tbxUpdateAddress.setText("");
        tbxUpdateDateOfBirth.setText("");
        tbxUpdateBirthPlace.setText("");
        tbxUpdateGender.setText("");
        tbxUpdateMail.setText("");
        tbxUpdatePhoneNumber.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatients = new javax.swing.JTable();
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
        tbxShowBloodType = new javax.swing.JTextField();
        tbxShowGender = new javax.swing.JTextField();
        tbxShowDateOfBirth = new javax.swing.JTextField();
        tbxShowBirthPlace = new javax.swing.JTextField();
        tbxShowMail = new javax.swing.JTextField();
        tbxShowPhoneNumber = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbxShowAddress = new javax.swing.JTextArea();
        btnComeBack = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lblTc1 = new javax.swing.JLabel();
        lblNameUpdate = new javax.swing.JLabel();
        lblLastNameUpdate = new javax.swing.JLabel();
        lblGenderUpdate = new javax.swing.JLabel();
        lblAddressUpdate = new javax.swing.JLabel();
        lblDateOfBirthUpdate = new javax.swing.JLabel();
        lblBirthPlaceUpdate = new javax.swing.JLabel();
        lblMailUpdate = new javax.swing.JLabel();
        lblPhoneNumberUpdate = new javax.swing.JLabel();
        tbxUpdateTc = new javax.swing.JTextField();
        tbxUpdateName = new javax.swing.JTextField();
        tbxUpdateLastName = new javax.swing.JTextField();
        tbxUpdateGender = new javax.swing.JTextField();
        tbxUpdateDateOfBirth = new javax.swing.JTextField();
        tbxUpdateMail = new javax.swing.JTextField();
        tbxUpdatePhoneNumber = new javax.swing.JTextField();
        btnUpdateDoctor = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbxUpdateAddress = new javax.swing.JTextArea();
        tbxUpdateBirthPlace = new javax.swing.JTextField();
        btnDeleteDoctor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tbxUpdateId = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        lblUpdateBloodType = new javax.swing.JLabel();
        cbxUpdateBloodType = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblTc = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblDateOfBirth = new javax.swing.JLabel();
        lblBirthPlace = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        tbxTc = new javax.swing.JTextField();
        tbxName = new javax.swing.JTextField();
        tbxLastName = new javax.swing.JTextField();
        tbxGender = new javax.swing.JTextField();
        tbxDateOfBirth = new javax.swing.JTextField();
        tbxMail = new javax.swing.JTextField();
        tbxPhoneNumber = new javax.swing.JTextField();
        btnAddDoctor = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbxAddress = new javax.swing.JTextArea();
        tbxBirthPlace = new javax.swing.JTextField();
        lblBloodType = new javax.swing.JLabel();
        cbxBloodType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(210, 210, 234));

        tblPatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tc", "İsim", "Soyisim"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPatients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPatientsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPatients);
        if (tblPatients.getColumnModel().getColumnCount() > 0) {
            tblPatients.getColumnModel().getColumn(0).setResizable(false);
            tblPatients.getColumnModel().getColumn(1).setResizable(false);
            tblPatients.getColumnModel().getColumn(2).setResizable(false);
            tblPatients.getColumnModel().getColumn(3).setResizable(false);
        }

        lblShowId.setText("Id");

        lblShowTc.setText("Tc");

        lblShowName.setText("İsim");

        lblShowLastName.setText("Soyisim");

        lblShowBranch.setText("Kan Grubu");

        lblShowGender.setText("Cinsiyet");

        lblShowAddress.setText("Adres");

        lblShowDateOfBirth.setText("Doğum Tarihi");

        lblShowBirthPlace.setText("Doğum Yeri");

        lblShowMail.setText("Mail");

        lblShowPhoneNumber.setText("Telefon Numarası");

        tbxShowAddress.setColumns(20);
        tbxShowAddress.setRows(5);
        jScrollPane2.setViewportView(tbxShowAddress);

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
                    .addComponent(lblShowBranch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbxShowTc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowGender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowPhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowDateOfBirth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowBirthPlace, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowMail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowBloodType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(lblShowGender)
                    .addComponent(tbxShowGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShowDateOfBirth)
                    .addComponent(tbxShowDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShowBirthPlace)
                    .addComponent(tbxShowBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxShowMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblShowMail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxShowPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblShowPhoneNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShowBranch)
                    .addComponent(tbxShowBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblShowAddress))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnComeBack)
                .addGap(120, 120, 120))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(btnComeBack)
                .addContainerGap(401, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hasta Kayıtları", jPanel2);

        jPanel8.setBackground(new java.awt.Color(200, 200, 224));

        lblTc1.setText("Tc");

        lblNameUpdate.setText("İsim");

        lblLastNameUpdate.setText("Soyisim");

        lblGenderUpdate.setText("Cinsiyet");

        lblAddressUpdate.setText("Adres");

        lblDateOfBirthUpdate.setText("Doğum Tarihi");

        lblBirthPlaceUpdate.setText("Doğum Yeri");

        lblMailUpdate.setText("Mail");

        lblPhoneNumberUpdate.setText("Telefon Numarası");

        btnUpdateDoctor.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnUpdateDoctor.setText("GÜNCELLE");
        btnUpdateDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDoctorActionPerformed(evt);
            }
        });

        tbxUpdateAddress.setColumns(20);
        tbxUpdateAddress.setRows(5);
        jScrollPane4.setViewportView(tbxUpdateAddress);

        btnDeleteDoctor.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnDeleteDoctor.setText("SİL");
        btnDeleteDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDoctorActionPerformed(evt);
            }
        });

        jLabel1.setText("Id");

        btnSearch.setText("Ara");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblUpdateBloodType.setText("Kan Grubu");

        cbxUpdateBloodType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 Rh+", "0 Rh-", "A Rh+", "A Rh-", "B Rh+", "B Rh-", "AB Rh+", "AB Rh-", " " }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(tbxUpdateTc, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblAddressUpdate)
                                        .addComponent(lblPhoneNumberUpdate)
                                        .addComponent(lblMailUpdate)
                                        .addComponent(lblBirthPlaceUpdate)
                                        .addComponent(lblDateOfBirthUpdate)
                                        .addComponent(lblGenderUpdate)
                                        .addComponent(lblLastNameUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNameUpdate)
                                        .addComponent(jLabel1)
                                        .addComponent(lblUpdateBloodType))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(lblTc1)
                                        .addGap(73, 73, 73)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tbxUpdatePhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(tbxUpdateMail, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(tbxUpdateBirthPlace, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(tbxUpdateDateOfBirth, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(tbxUpdateGender, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(tbxUpdateLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(tbxUpdateName, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(tbxUpdateId, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(cbxUpdateBloodType, javax.swing.GroupLayout.Alignment.TRAILING, 0, 199, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(btnUpdateDoctor)
                        .addGap(82, 82, 82)
                        .addComponent(btnDeleteDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxUpdateTc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTc1)
                    .addComponent(btnSearch))
                .addGap(25, 25, 25)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tbxUpdateId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameUpdate)
                    .addComponent(tbxUpdateName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastNameUpdate)
                    .addComponent(tbxUpdateLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenderUpdate)
                    .addComponent(tbxUpdateGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDateOfBirthUpdate)
                    .addComponent(tbxUpdateDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBirthPlaceUpdate)
                    .addComponent(tbxUpdateBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMailUpdate)
                    .addComponent(tbxUpdateMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhoneNumberUpdate)
                    .addComponent(tbxUpdatePhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUpdateBloodType)
                    .addComponent(cbxUpdateBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddressUpdate))
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteDoctor)
                    .addComponent(btnUpdateDoctor))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(436, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kayıt Güncelle/Sil", jPanel6);

        jPanel5.setBackground(new java.awt.Color(209, 209, 224));

        lblTc.setText("Tc");

        lblName.setText("İsim");

        lblLastName.setText("Soyisim");

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

        lblBloodType.setText("Kan Grubu");

        cbxBloodType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 Rh+", "0 Rh-", "A Rh+", "A Rh-", "B Rh+", "B Rh-", "AB Rh+", "AB Rh-", " " }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName)
                            .addComponent(lblTc)
                            .addComponent(lblDateOfBirth)
                            .addComponent(lblBirthPlace)
                            .addComponent(lblMail))
                        .addGap(106, 106, 106)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tbxLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                .addComponent(tbxName)
                                .addComponent(tbxTc)
                                .addComponent(tbxDateOfBirth))
                            .addComponent(tbxBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbxMail, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(lblGender)
                                    .addGap(130, 130, 130))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(lblPhoneNumber)
                                    .addGap(85, 85, 85)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBloodType)
                                    .addComponent(lblAddress))
                                .addGap(118, 118, 118)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbxPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbxGender, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddDoctor)
                .addGap(168, 168, 168))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tbxTc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(tbxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(tbxLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDateOfBirth)
                    .addComponent(tbxDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBirthPlace)
                    .addComponent(tbxBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMail)
                    .addComponent(tbxMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhoneNumber)
                    .addComponent(tbxPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(tbxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBloodType)
                    .addComponent(cbxBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAddDoctor)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(480, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Yeni Kayıt Ekle", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPatientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPatientsMouseClicked
        String selectedTc=(tblPatients.getValueAt(tblPatients.getSelectedRow(), 1).toString());
        String query="select * from patient where tc='"+selectedTc+"'";
        try {
            getDetail(query);
        } catch (SQLException ex) {
            Logger.getLogger(PatientRegisters.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblPatientsMouseClicked

    private void btnAddDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDoctorActionPerformed
        add();
    }//GEN-LAST:event_btnAddDoctorActionPerformed

    private void btnDeleteDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDoctorActionPerformed
        String query="DELETE from patient WHERE tc= (?)";
        delete(query);
    }//GEN-LAST:event_btnDeleteDoctorActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String selectedTc=tbxUpdateTc.getText();
        getValues(selectedTc);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnComeBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComeBackActionPerformed
        new SecretaryOperations().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnComeBackActionPerformed

    private void btnUpdateDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDoctorActionPerformed
        if(!(tbxUpdateName.getText().equals(""))) {
            String query="UPDATE patient SET name= ? WHERE tc=?";
            update(query,tbxUpdateName);
        }
        
        if(!(tbxUpdateLastName.getText().equals(""))) {
            String query="UPDATE patient SET lastName= (?) WHERE tc=?";
            update(query,tbxUpdateLastName);
        }
        
        if(!(tbxUpdateAddress.getText().equals(""))) {
            String query="UPDATE patient SET residenceAddress= ? WHERE tc=?";
            updateAddress(query,tbxUpdateAddress);
        }
        if(!(tbxUpdateDateOfBirth.getText().equals(""))) {
            String query="UPDATE patient SET dateOfBirth= ? WHERE tc=?";
            update(query,tbxUpdateDateOfBirth);
        }
        if(!(tbxUpdateBirthPlace.getText().equals(""))) {
            String query="UPDATE patient SET birthPlace= ? WHERE tc=?";
            update(query,tbxUpdateBirthPlace);
        }
        if(!(tbxUpdateGender.getText().equals(""))) {
            String query="UPDATE patient SET gender= ? WHERE tc=?";
            update(query,tbxUpdateGender);
        }      
        if(!(tbxUpdateMail.getText().equals(""))) {
            String query="UPDATE patient SET email= ? WHERE tc=?";
            update(query,tbxUpdateMail);
        }
        if(!(tbxUpdatePhoneNumber.getText().equals(""))) {
            String query="UPDATE patient SET phoneNumber= ? WHERE tc=?";
            update(query,tbxUpdatePhoneNumber);
        }
    }//GEN-LAST:event_btnUpdateDoctorActionPerformed

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
            java.util.logging.Logger.getLogger(PatientRegisters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientRegisters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientRegisters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientRegisters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientRegisters().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDoctor;
    private javax.swing.JButton btnComeBack;
    private javax.swing.JButton btnDeleteDoctor;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateDoctor;
    private javax.swing.JComboBox<String> cbxBloodType;
    private javax.swing.JComboBox<String> cbxUpdateBloodType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddressUpdate;
    private javax.swing.JLabel lblBirthPlace;
    private javax.swing.JLabel lblBirthPlaceUpdate;
    private javax.swing.JLabel lblBloodType;
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
    private javax.swing.JLabel lblUpdateBloodType;
    private javax.swing.JTable tblPatients;
    private javax.swing.JTextArea tbxAddress;
    private javax.swing.JTextField tbxBirthPlace;
    private javax.swing.JTextField tbxDateOfBirth;
    private javax.swing.JTextField tbxGender;
    private javax.swing.JTextField tbxLastName;
    private javax.swing.JTextField tbxMail;
    private javax.swing.JTextField tbxName;
    private javax.swing.JTextField tbxPhoneNumber;
    private javax.swing.JTextArea tbxShowAddress;
    private javax.swing.JTextField tbxShowBirthPlace;
    private javax.swing.JTextField tbxShowBloodType;
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
