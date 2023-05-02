
package dbprogramming3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Lab15 {
    public static void main(String[] args) {
        String URL="jdbc:mysql://localhost:3306/mydb3";
        String username="root";
        String password="mysql@sit";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, username, password);
            Statement statement = con.createStatement();
            String sql="select * from student";
            ResultSet results=statement.executeQuery(sql);
            ResultSetMetaData rsMetaData=results.getMetaData();
            System.out.println(rsMetaData.getColumnCount());
            
            for(int i=1;i<=rsMetaData.getColumnCount();i++){
                System.out.println(rsMetaData.getColumnName(i));
            }
            statement.execute(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Lab9.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Lab9.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
