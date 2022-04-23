
package connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConnectionPrescription {
    DefaultTableModel model;
    
    public void populateTable(String sql,JTable table){
        model=(DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            ArrayList<Prescription>prescriptions=getPrescriptions(sql);
            for (Prescription prescription:prescriptions) {
                Object[]row={
                    prescription.getPrescriptionId(),prescription.getPrescription(),prescription.getPatientTc(),
                    prescription.getDoctorId(),prescription.getPrescriptionDate()
                }; 
                model.addRow(row);
            }     
            
        } catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }        
    }
    
    public ArrayList<Prescription>getPrescriptions(String sql)throws SQLException{
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList<Prescription>prescriptions=null;
        
        try{
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            prescriptions=new ArrayList<Prescription>();
            
            while(resultSet.next()){
                prescriptions.add(new Prescription(
                        resultSet.getInt("prescriptionId"),
                        resultSet.getString("prescription"),
                        resultSet.getString("patientTc"),
                        resultSet.getInt("doctorId"),
                        resultSet.getString("prescriptionDate")
                        
                ));
            }
            
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }finally{
            statement.close();
            connection.close();
        }
        return prescriptions;
    }
}
