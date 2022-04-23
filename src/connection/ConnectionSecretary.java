
package connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConnectionSecretary {
    DefaultTableModel model;
    
    public void populateTable(String sql,JTable table){
        model=(DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            ArrayList<Secretary>secretaries=getSecretaries(sql);
            for (Secretary secretary:secretaries) {
                Object[]row={
                    secretary.getSecretaryId(),secretary.getTc(),secretary.getName(),secretary.getLastName(),
                    secretary.getGender(),secretary.getResidenceAddress(),secretary.getDateOfBirth(),
                    secretary.getBirthplace(),secretary.getEmail(),secretary.getPhoneNumber()
                }; 
                model.addRow(row);
            }     
            
        } catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }        
    }
    
    public ArrayList<Secretary>getSecretaries(String sql)throws SQLException{
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList<Secretary>secretaries=null;
        
        try{
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            secretaries=new ArrayList<Secretary>();
            
            while(resultSet.next()){
                secretaries.add(new Secretary(
                        resultSet.getString("secretaryId"),
                        resultSet.getString("tc"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
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
        return secretaries;
    }
}
