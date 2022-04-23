
package admin;

import connection.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SecretaryRegisters extends javax.swing.JFrame {

    ConnectionSecretary connectionSecretary=new ConnectionSecretary();
    String querySecretary="select * from secretary";
    
    public SecretaryRegisters() {
        initComponents();
        connectionSecretary.populateTable(querySecretary, tblSecretaries);
    }

    public void add(){
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;
        
        try{
            connection=dbHelper.getConnection();
            String query="INSERT INTO secretary (tc,name,lastName,gender,residenceAddress,dateOfBirth,birthplace,email,phoneNumber) VALUES (?,?,?,?,?,?,?,?,?)";
            statement=connection.prepareStatement(query);
            
            statement.setString(1, tbxTc.getText());
            statement.setString(2, tbxName.getText());
            statement.setString(3, tbxLastName.getText());
            statement.setString(4, tbxGender.getText());
            statement.setString(5, tbxAddress.getText());
            statement.setString(6, tbxDateOfBirth.getText());
            statement.setString(7, tbxBirthPlace.getText());
            statement.setString(8, tbxMail.getText());
            statement.setString(9, tbxPhoneNumber.getText());
            
            statement.executeUpdate();           
            connectionSecretary.populateTable(querySecretary, tblSecretaries);
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
        
        ArrayList<Secretary>secretaries=connectionSecretary.getSecretaries(query);
        for (Secretary secretary:secretaries) {
            tbxShowId.setText(secretary.getSecretaryId());
            tbxShowTc.setText(secretary.getTc());
            tbxShowName.setText(secretary.getName());
            tbxShowLastName.setText(secretary.getLastName());
            tbxShowGender.setText(secretary.getGender());
            tbxShowAddress.setText(secretary.getResidenceAddress());
            tbxShowDateOfBirth.setText(secretary.getDateOfBirth());
            tbxShowBirthPlace.setText(secretary.getBirthplace());
            tbxShowMail.setText(secretary.getEmail());
            tbxShowPhoneNumber.setText(secretary.getPhoneNumber());         
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
            
            connectionSecretary.populateTable(querySecretary, tblSecretaries);
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
       String query="select * from secretary where tc='"+tc+"'";
       try {
            ArrayList<Secretary>secretaries=connectionSecretary.getSecretaries(query);
            for (Secretary secretary:secretaries) {
                
                tbxUpdateId.setText(secretary.getSecretaryId());
                tbxUpdateName.setText(secretary.getName());
                tbxUpdateLastName.setText(secretary.getLastName());
                tbxUpdateGender.setText(secretary.getGender());
                tbxUpdateAddress.setText(secretary.getResidenceAddress());
                tbxUpdateDateOfBirth.setText(secretary.getDateOfBirth());
                tbxUpdateBirthPlace.setText(secretary.getBirthplace());
                tbxUpdateMail.setText(secretary.getEmail());
                tbxUpdatePhoneNumber.setText(secretary.getPhoneNumber());                
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
            
            connectionSecretary.populateTable(querySecretary, tblSecretaries);
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
            
            connectionSecretary.populateTable(querySecretary, tblSecretaries);
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
    public void clean(){
        tbxTc.setText("");
        tbxName.setText("");
        tbxLastName.setText("");
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSecretaries = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblShowId = new javax.swing.JLabel();
        lblShowTc = new javax.swing.JLabel();
        lblShowName = new javax.swing.JLabel();
        lblShowLastName = new javax.swing.JLabel();
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
        tbxShowGender = new javax.swing.JTextField();
        tbxShowDateOfBirth = new javax.swing.JTextField();
        tbxShowBirthPlace = new javax.swing.JTextField();
        tbxShowMail = new javax.swing.JTextField();
        tbxShowPhoneNumber = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbxShowAddress = new javax.swing.JTextArea();
        btnComeBack2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
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
        btnAddSecretary = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbxAddress = new javax.swing.JTextArea();
        tbxBirthPlace = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
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
        btnUpdateSecretary = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbxUpdateAddress = new javax.swing.JTextArea();
        tbxUpdateBirthPlace = new javax.swing.JTextField();
        btnDeleteSecretary = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tbxUpdateId = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(210, 210, 234));

        tblSecretaries.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSecretaries.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSecretariesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSecretaries);

        lblShowId.setText("Id");

        lblShowTc.setText("Tc");

        lblShowName.setText("İsim");

        lblShowLastName.setText("Soyisim");

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
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblShowId)
                        .addComponent(lblShowMail)
                        .addComponent(lblShowName)
                        .addComponent(lblShowTc)
                        .addComponent(lblShowPhoneNumber)
                        .addComponent(lblShowBirthPlace)
                        .addComponent(lblShowDateOfBirth))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblShowLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblShowAddress)
                                .addComponent(lblShowGender)))
                        .addGap(45, 45, 45)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbxShowTc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowGender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowDateOfBirth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowBirthPlace, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowMail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxShowPhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
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
                    .addComponent(tbxShowGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblShowGender))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblShowAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShowDateOfBirth)
                    .addComponent(tbxShowDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShowBirthPlace)
                    .addComponent(tbxShowBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShowMail)
                    .addComponent(tbxShowMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShowPhoneNumber)
                    .addComponent(tbxShowPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        btnComeBack2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btnComeBack2.setText("GERİ DÖN");
        btnComeBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComeBack2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnComeBack2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnComeBack2)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sekreter Kayıtları", jPanel2);

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

        btnAddSecretary.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnAddSecretary.setText("KAYIT EKLE");
        btnAddSecretary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSecretaryActionPerformed(evt);
            }
        });

        tbxAddress.setColumns(20);
        tbxAddress.setRows(5);
        jScrollPane3.setViewportView(tbxAddress);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblPhoneNumber)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tbxPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblMail)
                                        .addComponent(lblLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblName)
                                    .addComponent(lblTc)
                                    .addComponent(lblGender)
                                    .addComponent(lblDateOfBirth)
                                    .addComponent(lblBirthPlace))
                                .addGap(106, 106, 106)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tbxLastName)
                                    .addComponent(tbxName)
                                    .addComponent(tbxTc)
                                    .addComponent(tbxMail)
                                    .addComponent(tbxDateOfBirth)
                                    .addComponent(tbxGender)
                                    .addComponent(tbxBirthPlace, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblAddress)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(btnAddSecretary)))
                .addContainerGap(50, Short.MAX_VALUE))
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
                    .addComponent(lblGender)
                    .addComponent(tbxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnAddSecretary)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Yeni Sekreter Kaydı Ekle", jPanel1);

        jPanel7.setBackground(new java.awt.Color(200, 200, 224));

        lblTc1.setText("Tc");

        lblNameUpdate.setText("İsim");

        lblLastNameUpdate.setText("Soyisim");

        lblGenderUpdate.setText("Cinsiyet");

        lblAddressUpdate.setText("Adres");

        lblDateOfBirthUpdate.setText("Doğum Tarihi");

        lblBirthPlaceUpdate.setText("Doğum Yeri");

        lblMailUpdate.setText("Mail");

        lblPhoneNumberUpdate.setText("Telefon Numarası");

        btnUpdateSecretary.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnUpdateSecretary.setText("GÜNCELLE");
        btnUpdateSecretary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSecretaryActionPerformed(evt);
            }
        });

        tbxUpdateAddress.setColumns(20);
        tbxUpdateAddress.setRows(5);
        jScrollPane4.setViewportView(tbxUpdateAddress);

        btnDeleteSecretary.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnDeleteSecretary.setText("SİL");
        btnDeleteSecretary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSecretaryActionPerformed(evt);
            }
        });

        jLabel1.setText("Id");

        btnSearch.setText("Ara");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(tbxUpdateTc, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblAddressUpdate)
                                        .addComponent(lblPhoneNumberUpdate)
                                        .addComponent(lblMailUpdate)
                                        .addComponent(lblBirthPlaceUpdate)
                                        .addComponent(lblDateOfBirthUpdate)
                                        .addComponent(lblGenderUpdate)
                                        .addComponent(lblLastNameUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNameUpdate)
                                        .addComponent(jLabel1))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(lblTc1)
                                        .addGap(73, 73, 73)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbxUpdatePhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbxUpdateMail, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbxUpdateBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbxUpdateDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbxUpdateGender, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbxUpdateLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbxUpdateName, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbxUpdateId, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnUpdateSecretary)
                        .addGap(70, 70, 70)
                        .addComponent(btnDeleteSecretary, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxUpdateTc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTc1)
                    .addComponent(btnSearch))
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
                    .addComponent(lblGenderUpdate)
                    .addComponent(tbxUpdateGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDateOfBirthUpdate)
                    .addComponent(tbxUpdateDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBirthPlaceUpdate)
                    .addComponent(tbxUpdateBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMailUpdate)
                    .addComponent(tbxUpdateMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhoneNumberUpdate)
                    .addComponent(tbxUpdatePhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddressUpdate)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateSecretary)
                    .addComponent(btnDeleteSecretary))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(275, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sekreter Kaydı Güncelle/Sil", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSecretariesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSecretariesMouseClicked
        String selectedTc=(tblSecretaries.getValueAt(tblSecretaries.getSelectedRow(), 1).toString());
        String query="select * from secretary where tc='"+selectedTc+"'";
        try {
            getDetail(query);
        } catch (SQLException ex) {
            Logger.getLogger(SecretaryRegisters.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblSecretariesMouseClicked

    private void btnAddSecretaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSecretaryActionPerformed
        add();
    }//GEN-LAST:event_btnAddSecretaryActionPerformed

    private void btnUpdateSecretaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSecretaryActionPerformed
        if(!(tbxUpdateName.getText().equals(""))) {
            String query="UPDATE secretary SET name= ? WHERE tc=?";
            update(query,tbxUpdateName);
        }
        if(!(tbxUpdateLastName.getText().equals(""))) {
            String query="UPDATE secretary SET lastName= ? WHERE tc=?";
            update(query,tbxUpdateLastName);
        }
        if(!(tbxUpdateGender.getText().equals(""))) {
            String query="UPDATE secretary SET gender= ? WHERE tc=?";
            update(query,tbxUpdateGender);
        }
        if(!(tbxUpdateAddress.getText().equals(""))) {
            String query="UPDATE secretary SET residanceAddress= ? WHERE tc=?";
            updateAddress(query,tbxUpdateAddress);
        }
        if(!(tbxUpdateDateOfBirth.getText().equals(""))) {
            String query="UPDATE secretary SET dateOfBirth= ? WHERE tc=?";
            update(query,tbxUpdateDateOfBirth);
        }
        if(!(tbxUpdateBirthPlace.getText().equals(""))) {
            String query="UPDATE secretary SET birthPlace= ? WHERE tc=?";
            update(query,tbxUpdateBirthPlace);
        }
        if(!(tbxUpdateMail.getText().equals(""))) {
            String query="UPDATE secretary SET email= ? WHERE tc=?";
            update(query,tbxUpdateMail);
        }
        if(!(tbxUpdatePhoneNumber.getText().equals(""))) {
            String query="UPDATE secretary SET phoneNumber= ? WHERE tc=?";
            update(query,tbxUpdatePhoneNumber);
        }
        
        
    }//GEN-LAST:event_btnUpdateSecretaryActionPerformed

    private void btnDeleteSecretaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSecretaryActionPerformed
        String query="DELETE from secretary WHERE tc= (?)";
        delete(query);
    }//GEN-LAST:event_btnDeleteSecretaryActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String selectedTc=tbxUpdateTc.getText();
        getValues(selectedTc);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnComeBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComeBack2ActionPerformed
        new AdminOperations().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnComeBack2ActionPerformed


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
            java.util.logging.Logger.getLogger(SecretaryRegisters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecretaryRegisters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecretaryRegisters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecretaryRegisters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SecretaryRegisters().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSecretary;
    private javax.swing.JButton btnComeBack2;
    private javax.swing.JButton btnDeleteSecretary;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateSecretary;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
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
    private javax.swing.JTable tblSecretaries;
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
