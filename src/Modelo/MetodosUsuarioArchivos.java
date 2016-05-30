package Modelo;

import java.util.ArrayList;


public class MetodosUsuarioArchivos {
    
    private ArrayList <UsuarioArchivo> arrayUsuario;
    String arregloInformacionConsultada[]=new String[3];
    
    ArchivosUsuario archivoUsuario;

    public MetodosUsuarioArchivos() {
        arrayUsuario = new ArrayList<UsuarioArchivo>();
        archivoUsuario = new ArchivosUsuario();
        cargarArchivoAlArray();
    }
    
   
    public void cargarArchivoAlArray()
    {
        UsuarioArchivo arregloTemporalUsuario[]=archivoUsuario.devolverInformacionDelArchivoComoArreglo();
        
        for(int contador=0; contador<arregloTemporalUsuario.length; contador++){
            arrayUsuario.add((UsuarioArchivo)arregloTemporalUsuario[contador]);
            System.out.println("Se cargo un usuario del archivo al arrayUsuario.");
        }
    }
    
    public void escribirInformacionArchivo(){
        archivoUsuario.crearArchivo();
        for(int contador=0; contador<arrayUsuario.size(); contador++){
            archivoUsuario.ingresarInformacionAlArchivoUsuario(arrayUsuario.get(contador));
        }
        System.out.println("Se envió a escribir la informacion al archivo usuario.");
    }
    
    public void agregarUsuario(String informacion[]){
        UsuarioArchivo temporal = new UsuarioArchivo(informacion[0], informacion[1], informacion[2], informacion[3]);
        arrayUsuario.add(temporal);
        escribirInformacionArchivo();
    }
    
  
    public boolean consultarUsuario(String nombreUsuario){
        boolean existente=false;
        for(int contador=0; contador<arrayUsuario.size(); contador++){
            if(arrayUsuario.get(contador).getNombreUsuario().equals(nombreUsuario)){
                arregloInformacionConsultada[0]=arrayUsuario.get(contador).getNombreCompletoUsuario();
                arregloInformacionConsultada[1]=arrayUsuario.get(contador).getContrasena();
                arregloInformacionConsultada[2]=arrayUsuario.get(contador).getCedula();
                existente =true;
            }
        }
        return existente;
       
    }

    
    public boolean consultarUsuarioLogin(String nombreUsuario, String contrasena){
        boolean existente=false;
        for(int contador=0; contador<arrayUsuario.size(); contador++){
            if(arrayUsuario.get(contador).getNombreUsuario().equals(nombreUsuario)&&arrayUsuario.get(contador).getContrasena().equals(contrasena)){
                arregloInformacionConsultada[0]=arrayUsuario.get(contador).getNombreCompletoUsuario();
                arregloInformacionConsultada[1]=arrayUsuario.get(contador).getContrasena();
                arregloInformacionConsultada[2]=arrayUsuario.get(contador).getCedula();
                existente =true;
            }
        }
        return existente;
    }
    
    public void modificarUsuario(String arreglo[]){
        for(int contador=0; contador<arrayUsuario.size(); contador++){
            if(arrayUsuario.get(contador).getNombreUsuario().equals(arreglo[0])){
                arrayUsuario.get(contador).setNombreCompletoUsuario(arreglo[1]);
                arrayUsuario.get(contador).setContrasena(arreglo[2]);
                arrayUsuario.get(contador).setCedula(arreglo[3]);
                escribirInformacionArchivo();
            }
        }
    }
    
    public void eliminarUsuario(String arreglo[]){
        for(int contador=0; contador<arrayUsuario.size(); contador++){
            if(arrayUsuario.get(contador).getNombreUsuario().equals(arreglo[0])){
                arrayUsuario.remove(contador);
                escribirInformacionArchivo();
            }
        }
    }
    public String[] getArregloInformacion(){
        return this.arregloInformacionConsultada;
    }
    
    public boolean verificarExistenciaDeArchivoDeUsuarios()
    {
       return archivoUsuario.verificarExistenciaDeArchivoDeUsuarios();
    }
}
