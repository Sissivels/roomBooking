
package tablas;

//import com.mysql.jdbc.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
    private final String base = "com";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mariadb://localhost:3306/" + base;
    private Connection con = null;
    
    public Connection getConexion()
    {
        
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            
        } catch(SQLException e)
        {
            System.err.println(e);
        } //catch (ClassNotFoundException ex) {
           // Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
       // }
      return con;  
    }

    public void close() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Connection closed");
        }
    }
}
