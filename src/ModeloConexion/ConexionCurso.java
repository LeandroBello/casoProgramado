


package ModeloConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class ConexionCurso {
    String arregloInformacionConsultada[]=new String[3];
    
    Connection conexion = null;
    public ConexionCurso()
    {
        realizarConexion();
     
    }
    public void realizarConexion()
    {
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/conexion";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada CURSO");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
     public boolean registrarCurso(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = conexion.createStatement();
                ejecuto = cmd.execute("INSERT INTO curso(siglaCurso,nombreCurso,creditos,horario) VALUES ('"+informacion[0]+"','"+informacion[1]+"','"+informacion[2]+"','"+informacion[3]+"')");
                JOptionPane.showMessageDialog(null,"El curso se registró correctamente");
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
 //              ejecuto = cmd.execute("UPDATE cursos SET sigla='"+informacion[0]+"',nombre='"+informacion[1]+"',creditos='"+informacion[2]+"',horario='"+informacion[3]+"' WHERE sigla='"+informacion[0]+"'");//Comillas sencillas es como un serializavle en la clase

                ejecuto = cmd.execute("UPDATE curso SET siglaCurso='"+informacion[0]+"',nombreCurso='"+ informacion[1]+"',creditos='"+informacion[2]+"',horario='"+informacion[3]+"'WHERE siglaCurso='"+ informacion[0]+"'");
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
                ejecuto = cmd.execute("DELETE FROM curso WHERE siglaCurso='"+informacion[0]+"'");
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        } 
    }
    
    public boolean consultarCurso(String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean existe=false;
        try {
                cmd = conexion.createStatement();
                rs = cmd.executeQuery("SELECT * FROM curso WHERE siglaCurso ='"+sigla+"'");
                
                while (rs.next()) 
                {
                   this.arregloInformacionConsultada[0] = rs.getString("nombreCurso");
                   this.arregloInformacionConsultada[2]=rs.getString("horario");
                   this.arregloInformacionConsultada[1]=""+ rs.getInt("creditos");
                   
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
