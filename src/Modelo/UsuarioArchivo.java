package Modelo;

import java.io.Serializable;


public class UsuarioArchivo implements Serializable{
    
    
    private String nombreUsuario;
    private String nombreCompletoUsuario;
    private String contrasena;
    private String cedula;

    public UsuarioArchivo(String nombreUsuario, String nombreCompletoUsuario, String contraseña, String cedula) {
        this.nombreUsuario = nombreUsuario;
        this.nombreCompletoUsuario = nombreCompletoUsuario;
        this.contrasena = contraseña;
        this.cedula = cedula;
    }
    
    
    
     public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreCompletoUsuario() {
        return nombreCompletoUsuario;
    }

    public void setNombreCompletoUsuario(String nombreCompletoUsuario) {
        this.nombreCompletoUsuario = nombreCompletoUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

   
    public String getInformacion()
    {
        return "Cedula "+cedula+" Nombre Usuario"+ nombreUsuario +"Nombre Completo"+nombreCompletoUsuario+"Contraseña"+contrasena;
    }
}
