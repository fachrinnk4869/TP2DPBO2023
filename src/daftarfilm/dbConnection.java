/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daftarfilm;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
/**
 *
 * @author Fachri Najm
 */
public class dbConnection {
    private Statement stmt = null;
    private Connection conn = null;
    
    public dbConnection(){
        String ConnAddress = "jdbc:mysql://localhost/film_artis";
        String user = "root";
        String pass = "";
        connect(ConnAddress, user, pass);
    }
    private void connect(String ConnAddress, String user, String pass){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(ConnAddress, user, pass);
            stmt = conn.createStatement();
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    // for select query
    public ResultSet selectQuery(String sql){
        try {
            stmt.executeQuery(sql);
            return stmt.getResultSet();
        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    // for INSERT, UPDATE, DELETE
    public int updateQuery(String sql){
        try {
            return stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public Statement getStmt() {
      return stmt;
    }
    
}
