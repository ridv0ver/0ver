package src.engine;
import javax.swing.JOptionPane;
import java.sql.*;

public class databaseMysql {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/bd0ver";
    String user = "root";
    String password = "1234";
    Connection conn;

    public databaseMysql(){
        generaConexion();
    }
    
    public Connection generaConexion(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("conexion exitosa");    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error conexion "+e);
        }
        return conn;
    }
}
