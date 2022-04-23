
package connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConnectionLaboratory {
    DefaultTableModel model;
    
    public void populateTable(String sql,JTable table){
        model=(DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            ArrayList<Laboratory>doctors=getLaboratory(sql);
            for (Laboratory laboratory:doctors) {
                Object[]row={
                    laboratory.getId(),laboratory.getLaboratoryResult(),laboratory.getPatientTc(),
                    laboratory.getDoctorId(),laboratory.getResultDate()
                }; 
                model.addRow(row);
            }     
            
        } catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }        
    }
    
    public ArrayList<Laboratory>getLaboratory(String sql)throws SQLException{
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList<Laboratory>laboratoryList=null;
        
        try{
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            laboratoryList=new ArrayList<Laboratory>();
            
            while(resultSet.next()){
                laboratoryList.add(new Laboratory(
                        resultSet.getInt("laboratoryId"),
                        resultSet.getString("laboratoryResult"),
                        resultSet.getString("patientTc"),
                        resultSet.getInt("doctorId"),
                        resultSet.getString("resultDate")
                        
                ));
            }
            
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }finally{
            statement.close();
            connection.close();
        }
        return laboratoryList;
    }
}
