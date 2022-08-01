
package dao;
import beans.Alumno;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Yonathan Uriel Pastrana Tepectzin y Kevin Ulises Garcia Camacho
 */
public class DAOAlumno
{
 private Connection con;
 private PreparedStatement ps;
 private ResultSet rs;
 private Alumno alumno;   
 
 public ArrayList mostrar() throws ClassNotFoundException 
 {
  ArrayList<Alumno> list=new ArrayList<>();
  String sql="SELECT * FROM alumnos";
  try
  {
      con=ConexionMySQL.getConnection();
      ps=con.prepareStatement(sql);
      rs=ps.executeQuery(); // Solo para Select.
      while(rs.next())
      {
          int i = 0;
          alumno=new Alumno();
          alumno.setMatricula(rs.getString("Matricula"));
          alumno.setNombre(rs.getString("Nombre"));
          alumno.setApellidoPaterno(rs.getString("ApellidoPaterno"));
          alumno.setApellidoMaterno(rs.getString("ApellidoMaterno"));
          alumno.setDdi(rs.getInt("Ddi"));
          alumno.setDwi(rs.getInt("Dwi"));
          alumno.setEcbd(rs.getInt("Ecbd"));
          alumno.calcularPromedio();
          list.add(alumno);
      }
      rs.close();
      ps.close();
      con.close();
  }
  catch (SQLException e){ }
  return list; 
 }
 
 public boolean agregar (Alumno alumno) throws ClassNotFoundException  
 {
   String sql = "INSERT INTO alumnos VALUES('"  +
                 alumno.getMatricula()  + "',"  + 
           "'" + alumno.getNombre()     + "',"  +
           "'" + alumno.getApellidoPaterno()    + "'," +
           "'" + alumno.getApellidoMaterno()    + "'," +
                 alumno.getDdi()        + ","   +
                 alumno.getDwi()        + ","   +
                 alumno.getEcbd()       + ")";
   
   try
   {
        con=ConexionMySQL.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
        con.close();
   } catch (SQLException ex) { } 
   
   return true;          
 }       
 
 public boolean editar(Alumno alumno, String old) throws ClassNotFoundException
 {
     String sql="UPDATE alumnos SET " +
            " Matricula  = '"         + alumno.getMatricula()        + "',"  +
            " Nombre     = '"         + alumno.getNombre()           + "'," +
            " ApellidoPaterno  = '"   + alumno.getApellidoPaterno()  + "'," +
            " ApellidoMaterno  = '"   + alumno.getApellidoMaterno()  + "'," +
            " Ddi        = "          + alumno.getDdi()              + ","  +
            " Dwi        = "          + alumno.getDwi()              + ","  +
            " Ecbd        = "         + alumno.getEcbd()             +
            " WHERE Matricula = '"    + old + "'";
     
     try
     {
         con=ConexionMySQL.getConnection();
          ps=con.prepareStatement(sql);
          ps.executeUpdate();
          ps.close();
          con.close();
          
     } catch (SQLException ex) {}
     
     return true;
 }
 
 public boolean eliminar(String matricula) throws ClassNotFoundException
 {
     String sql= "DELETE FROM alumnos WHERE Matricula ='" + matricula + "'";
     
     try
     {
         con=ConexionMySQL.getConnection();
         ps=con.prepareStatement(sql);
         ps.executeUpdate();
         ps.close();
         con.close();
     } catch (SQLException e) {}
     
     return true;
 }
 
 public Alumno buscar(String matricula) throws ClassNotFoundException
    {
        String sql="SELECT * FROM alumnos WHERE Matricula = '" + matricula + "'";
        try {
                con=ConexionMySQL.getConnection();
                 ps=con.prepareStatement(sql);
                 rs=ps.executeQuery();
                while (rs.next()) 
                {
                    alumno= new Alumno();
                    alumno.setMatricula(rs.getString("Matricula"));
                    alumno.setNombre(rs.getString("Nombre"));
                    alumno.setApellidoPaterno(rs.getString("ApellidoPaterno"));
                    alumno.setApellidoMaterno(rs.getString("ApellidoMaterno"));
                    alumno.setDdi(rs.getInt("Ddi"));
                    alumno.setDwi(rs.getInt("Dwi"));
                    alumno.setEcbd(rs.getInt("Ecbd"));

                }
                rs.close();
                ps.close();
                con.close();
            }catch (SQLException e) {}
        return alumno;
    }
}
