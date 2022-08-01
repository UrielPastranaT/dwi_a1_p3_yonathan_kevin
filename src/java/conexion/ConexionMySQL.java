package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




/**
 *
 * @author Yonathan Uriel Pastrana Tepectzin y Kevin Ulises Garcia Camacho
 */
public class ConexionMySQL 
{
    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/dwi_2022_ejemplo1", "root", "");
    }
    
    public static void main(String args[]) throws SQLException, ClassNotFoundException
    {
        ConexionMySQL.getConnection();
        System.out.println("Éxitoso");
    }
}
