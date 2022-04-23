
package connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConnectionPatient {
    DefaultTableModel model;
    
    public void populateTable(String sql,JTable table){
        model=(DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            ArrayList<Patient>patients=getPatients(sql);
            for (Patient patient:patients) {
                Object[]row={
                    patient.getPatientId(),patient.getTc(),patient.getName(),patient.getLastName(),
                    patient.getResidenceAddress(),patient.getDateOfBirth(),patient.getBirthplace(),
                    patient.getGender(),patient.getEmail(),patient.getPhoneNumber(),patient.getBloodType()
                }; 
                model.addRow(row);
            }     
            
        } catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }        
    }
    
    public ArrayList<Patient>getPatients(String sql)throws SQLException{
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList<Patient>patients=null;
        
        try{
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            patients=new ArrayList<Patient>();
            
            while(resultSet.next()){
                patients.add(new Patient(
                        resultSet.getString("patientId"),
                        resultSet.getString("tc"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getString("residenceAddress"),
                        resultSet.getString("dateOfBirth"),
                        resultSet.getString("birthplace"),
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("bloodType")
                        
                ));
            }
            
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }finally{
            statement.close();
            connection.close();
        }
        return patients;
    }
}
