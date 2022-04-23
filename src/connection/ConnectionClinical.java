
package connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ConnectionClinical {
    DefaultTableModel model;
    
    public void populateTable(String sql,JTable table){
        model=(DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            ArrayList<Clinical>clinicals=getClinical(sql);
            for (Clinical clinical:clinicals) {
                Object[]row={
                    clinical.getClinicalId(),clinical.getClinicalName()
                }; 
                model.addRow(row);
            }     
            
        } catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }        
    }
    
    public ArrayList<Clinical>getClinical(String sql)throws SQLException{
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList<Clinical>clinicals=null;
        
        try{
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            clinicals=new ArrayList<Clinical>();
            
            while(resultSet.next()){
                clinicals.add(new Clinical(
                        resultSet.getString("clinicalId"),
                        resultSet.getString("clinicalName")
                        
                ));
            }
            
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }finally{
            statement.close();
            connection.close();
        }
        return clinicals;
    }
}
