

package ModeloConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class ConexionEstudiante 
{
    String arregloInformacionConsultada[]=new String[2];
    
    Connection conexion = null;
    public ConexionEstudiante()
    {
        realizarConexion();
   
    }
    public void realizarConexion()
    {
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/conexion";//verificar....
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada Estudiante");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
     public boolean registrarEstudiante(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = conexion.createStatement();
                
                ejecuto = cmd.execute("INSERT INTO estudiante(cedula,nombre,direccion) VALUES ('"+informacion[0]+"','"+informacion[1]+"','"+informacion[2]+"')");
                JOptionPane.showMessageDialog(null,"Se registró correctamente");
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public boolean modificar(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = conexion.createStatement();
           //    ejecuto = cmd.execute("UPDATE estudiantes SET cedula='"+arreglo[0]+"',nombre='"+arreglo[1]+"',direccion='"+arreglo[2]+"' WHERE cedula='"+arreglo[0]+"'");//Comillas sencillas es como un serializavle en la clase

                ejecuto = cmd.execute("UPDATE estudiante SET cedula='"+informacion[0]+"',nombre='"+ informacion[1]+"',direccion='"+informacion[2]+"'WHERE cedula='"+ informacion[0]+"'");
                JOptionPane.showMessageDialog(null,"Se modificó correctamente");
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public boolean eliminar(String informacion[]){
       ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = conexion.createStatement();
                ejecuto = cmd.execute("DELETE FROM estudiante WHERE cedula='"+informacion[0]+"'");
                JOptionPane.showMessageDialog(null,"Se eliminó correctamente");
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        } 
    }
    
    public boolean consultarEstudiante(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean existe=false;
        try {
                cmd = conexion.createStatement();
                rs = cmd.executeQuery("SELECT * FROM estudiante WHERE cedula ='"+cedula+"'");
                
                while (rs.next()) 
                {
                   this.arregloInformacionConsultada[0] = rs.getString("nombre");
                    
                   this.arregloInformacionConsultada[1]=rs.getString("direccion");
                     existe=true;
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            existe=false;
        }
        return existe;
    }
     public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }    
   
    
}
