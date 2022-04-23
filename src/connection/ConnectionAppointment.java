
package connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConnectionAppointment {
    DefaultTableModel model;
    
    public void populateTable(String sql,JTable table){
        model=(DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            ArrayList<Appointment>appointments=getAppointments(sql);
            for (Appointment appointment:appointments) {
                Object[]row={
                    appointment.getAppointmentId(),appointment.getTc(),appointment.getName(),
                    appointment.getLastName(),appointment.getClinicalId(),appointment.getClinicalName(),
                    appointment.getDoctorId(),appointment.getAppointmentDate(),appointment.getAppointmentTime(),
                    appointment.getPatientId(),appointment.getResult()
                }; 
                model.addRow(row);
            }     
            
        } catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }        
    }
    
    public ArrayList<Appointment>getAppointments(String sql)throws SQLException{
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList<Appointment>appointments=null;
        
        try{
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            appointments=new ArrayList<Appointment>();
            
            while(resultSet.next()){
                appointments.add(new Appointment(
                        resultSet.getString("appointmentId"),
                        resultSet.getString("tc"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getString("clinicalId"),
                        resultSet.getString("clinicalName"),
                        resultSet.getString("doctorId"),
                        resultSet.getString("appointmentDate"),
                        resultSet.getString("appointmentTime"),
                        resultSet.getString("patientId"),
                        resultSet.getString("result")
                        
                ));
            }
            
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }finally{
            statement.close();
            connection.close();
        }
        return appointments;
    }
}
