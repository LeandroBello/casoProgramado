/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author chelvivil
 */
public class ConexionUsuario 
{
String arregloInformacionConsultada[]=new String[3];
    
    Connection conexion = null;
    public ConexionUsuario() {
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
            System.out.println("Conexión Realizada");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
     public boolean registrarUsuario(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = conexion.createStatement();
                ejecuto = cmd.execute("INSERT INTO usuario(cedula,nombre,usuario,contrasena) VALUES ('"+informacion[0]+"','"+informacion[1]+"','"+informacion[2]+"','"+informacion[3]+"')");
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
      public boolean consultarUsuario(String usuario)
    {//JOptionPane.showMessageDialog(null,"entro al conexion:"+usuario);
       
        ResultSet rs = null;
        Statement cmd = null;
        boolean existe=false;
        try {
                cmd = conexion.createStatement();
                rs = cmd.executeQuery("SELECT * FROM usuario WHERE usuario ='"+usuario+"'");//siglaCurso
                
                while (rs.next()) 
                {JOptionPane.showMessageDialog(null,"entro al conexion:"+usuario);
                   this.arregloInformacionConsultada[1] = rs.getString("cedula");
                   this.arregloInformacionConsultada[2]=""+ rs.getInt("contrasena");
                   this.arregloInformacionConsultada[0]=rs.getString("nombre");
                   //JOptionPane.showMessageDialog(null,arregloInformacionConsultada[1]);//prueba valor
                   // JOptionPane.showMessageDialog(null,arregloInformacionConsultada[2]);//prueba valor
                   //  JOptionPane.showMessageDialog(null,arregloInformacionConsultada[0]);//prueba valor
                   //************************************
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
      
    public boolean modificar(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = conexion.createStatement();
                ejecuto = cmd.execute("UPDATE usuario SET cedula='"+informacion[0]+"'"+",nombre='"+ informacion[1]+"'"+",usuario='"+informacion[2]+"'"+",contrasena='"+informacion[3]+"'"+"WHERE cedula='"+ informacion[0]+"'");
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
                ejecuto = cmd.execute("DELETE FROM usuario WHERE cedula='"+informacion[0]+"'");
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
    
   
     public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }   
}
