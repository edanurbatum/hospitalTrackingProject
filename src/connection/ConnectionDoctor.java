
package connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConnectionDoctor {
    
    DefaultTableModel model;
    
    public void populateTable(String sql,JTable table){
        model=(DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            ArrayList<Doctor>doctors=getDoctors(sql);
            for (Doctor doctor:doctors) {
                Object[]row={
                    doctor.getDoctorId(),doctor.getTc(),doctor.getName(),doctor.getLastName(),
                    doctor.getClinicalId(),doctor.getClinicalName(), doctor.getGender(),doctor.getResidenceAddress(),
                    doctor.getDateOfBirth(),doctor.getBirthplace(),doctor.getEmail(),doctor.getPhoneNumber()
                }; 
                model.addRow(row);
            }     
            
        } catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }        
    }
    
    public ArrayList<Doctor>getDoctors(String sql)throws SQLException{
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList<Doctor>doctors=null;
        
        try{
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            doctors=new ArrayList<Doctor>();
            
            while(resultSet.next()){
                doctors.add(new Doctor(
                        resultSet.getString("doctorId"),
                        resultSet.getString("tc"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getString("clinicalId"),
                        resultSet.getString("clinicalName"),
                        resultSet.getString("gender"),
                        resultSet.getString("residenceAddress"),
                        resultSet.getString("dateOfBirth"),
                        resultSet.getString("birthplace"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber")
                        
                ));
            }
            
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }finally{
            statement.close();
            connection.close();
        }
        return doctors;
    }    
}
