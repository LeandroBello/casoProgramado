package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.ArchivosUsuario;
import ModeloConexion.ConexionUsuario;
import Modelo.MetodosCursosXML;
import Modelo.MetodosUsuarioArchivos;
import Vista.FRM_MenuPrincipal;
import Vista.FRM_RegistroUsuario;
import Vista.GUI_Botones;
import Vista.FRM_RegistroCursos;

import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 *
 */
public class Controlador_FRM_RegistroUsuarios implements ActionListener {

    FRM_RegistroCursos fRM_RegistroCursos;
    FRM_MenuPrincipal fRM_MenuPrincipal;
    FRM_RegistroUsuario fRM_RegistroUsuario;
    MetodosUsuarioArchivos MetodosUsuarioArchivos;
    ArchivosUsuario archivoUsuario;
    ConexionUsuario conexionUsuario;
    GUI_Botones gUI_Botones;
    MetodosCursosXML metodosCursosXML;
    public int primeraVez = 0;

    public Controlador_FRM_RegistroUsuarios(FRM_RegistroUsuario mantenimientoRegistroUsuarios, FRM_MenuPrincipal control) {
        this.fRM_RegistroUsuario = mantenimientoRegistroUsuarios;
        this.fRM_MenuPrincipal = control;

        switch (control.seleccionarFuenteDelSistema()) {
            case 1:

                MetodosUsuarioArchivos = new MetodosUsuarioArchivos();
                archivoUsuario = new ArchivosUsuario();
                break;

            case 2:

                break;

            case 3:
                conexionUsuario = new ConexionUsuario();
                break;
        }

    }

    public void setPrimeraVez(int numero) {
        this.primeraVez = numero;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("consultaRapida")) {
            switch (fRM_MenuPrincipal.seleccionarFuenteDelSistema()) {
                case 1://Archivos...

                    if (MetodosUsuarioArchivos.consultarUsuario(fRM_RegistroUsuario.devolverUsuario())) //0 usuario
                    {
                        fRM_RegistroUsuario.mostrarInformacionArchivoUsuario(MetodosUsuarioArchivos.getArregloInformacion());
                        fRM_RegistroUsuario.mostrarMensaje("Existe Usuarios.");
                        fRM_RegistroUsuario.habilitarBotones();//Habilita los botones de interación

                    } else {
                        fRM_RegistroUsuario.limpiarInterfaz();
                        fRM_RegistroUsuario.habilitarAgregar();//habilita el agregar.
                    }

                    break;
                case 3://BASES DE DATOS...
                    /* if (conexionUsuario.consultarUsuario(fRM_RegistroUsuario.devolverUsuario())) 
                    {
                        fRM_RegistroUsuario.mostrarInformacion(conexionUsuario.getArregloInformacion());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el el usuario");
                    }*/
                    if (conexionUsuario.consultarUsuario(fRM_RegistroUsuario.devolverUsuario())) //0 usuario
                    {
                        fRM_RegistroUsuario.mostrarInformacion(conexionUsuario.getArregloInformacion());
                        fRM_RegistroUsuario.mostrarMensaje("Existe usuarios.");
                        fRM_RegistroUsuario.habilitarBotones();//Habilita los botones de interación

                    } else {
                        fRM_RegistroUsuario.limpiarInterfaz();
                        fRM_RegistroUsuario.habilitarAgregar();//habilita el agregar.
                    }

                    break;
            }
        }

        if (e.getActionCommand().equals("Consultar")) {
            switch (fRM_MenuPrincipal.seleccionarFuenteDelSistema()) {
                case 1:
                    if (MetodosUsuarioArchivos.consultarUsuario(fRM_RegistroUsuario.devolverUsuario())) //0 usuario
                    {
                        fRM_RegistroUsuario.mostrarInformacionArchivoUsuario(MetodosUsuarioArchivos.getArregloInformacion());
                        fRM_RegistroUsuario.mostrarMensaje("Existe Usuarios.");
                    } else {
                        fRM_RegistroUsuario.mostrarMensaje("No se encontr5aron datos del usuario.");
                        fRM_RegistroUsuario.mostrarMensaje("Proceda a agregar el usuario.");
                    }
                    break;

                case 2:

                    if (metodosCursosXML.consultarInformacionDelXml(fRM_RegistroCursos.devolverSigla())) {
                        metodosCursosXML.modificarInformacionDelXml(metodosCursosXML.getArregloInformacion());
                        fRM_RegistroCursos.mostrarMensaje("Información encontrada : " + fRM_RegistroCursos.devolverSigla());

                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el Curso");
                    }
                    break;

                case 3:

                    if (conexionUsuario.consultarUsuario(fRM_RegistroUsuario.devolverUsuario())) {
                        fRM_RegistroUsuario.mostrarInformacion(conexionUsuario.getArregloInformacion());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el Curso");
                    }
                    break;

            }
        }
        if (e.getActionCommand().equals("Agregar")) {
            switch (fRM_MenuPrincipal.seleccionarFuenteDelSistema()) {
                case 1:
                    if (primeraVez == 0)//***************************Sie es la primera vez a la hora de registrar usuario cierra la ventana logn y se abre de una vez munu principal
                    {

                        fRM_RegistroUsuario.setVisible(false);
                        fRM_MenuPrincipal.setVisible(true);
                        MetodosUsuarioArchivos.agregarUsuario(fRM_RegistroUsuario.devolverInformacionVersion2());
                        fRM_RegistroUsuario.mostrarMensaje("Se agrego el usuario con éxito.");
                    }

                    MetodosUsuarioArchivos.agregarUsuario(fRM_RegistroUsuario.devolverInformacionVersion2());
                    fRM_RegistroUsuario.mostrarMensaje("Se agrego el usuario con éxito.");

                    break;

                case 2:
//                                       metodosCursosXML.guardarEnXML(mantenimientoCursos.devolverInformacion());
//            mantenimientoCursos.mostrarMensaje("Información agregada al archivo XML de forma correcta.");
//
                    break;

                case 3:
                    conexionUsuario.registrarUsuario(fRM_RegistroUsuario.devolverInformacion());
                    fRM_RegistroUsuario.mostrarMensaje("Información agregada a la base de datos de forma correcta.");

                    break;
            }
        }
        if (e.getActionCommand().equals("Modificar")) {
            switch (fRM_MenuPrincipal.seleccionarFuenteDelSistema()) {
                case 1:
                    MetodosUsuarioArchivos.modificarUsuario(fRM_RegistroUsuario.devolverInformacionVersion2());

                    fRM_RegistroUsuario.mostrarMensaje("Se modifico el usuario con éxito.");
                    break;

                case 2:
//                     metodosCursosXML.modificarInformacionDelXml(mantenimientoCursos.devolverInformacion());
//                    mantenimientoCursos.mostrarMensaje("Información modificada en el archivo XML de forma correcta.");

                    break;

                case 3:
                    conexionUsuario.modificar(fRM_RegistroUsuario.devolverInformacion());
                    fRM_RegistroUsuario.mostrarMensaje("Información modificada en la base de datos de forma correcta.");

                    break;
            }
        }
        if (e.getActionCommand().equals("Eliminar")) {
            switch (fRM_MenuPrincipal.seleccionarFuenteDelSistema()) {
                case 1:
                    MetodosUsuarioArchivos.eliminarUsuario(fRM_RegistroUsuario.devolverInformacionVersion2());
                    fRM_RegistroUsuario.mostrarMensaje("Se elimino el usuario con éxito.");
                    break;

                case 2:
//                     metodosCursosXML.eliminarInformacionDelXml(mantenimientoCursos.devolverSigla());
//            mantenimientoCursos.mostrarMensaje("Información eliminada del archivo XML de forma correcta.");

                    break;

                case 3:
                    conexionUsuario.eliminar(fRM_RegistroUsuario.devolverInformacion());
                    fRM_RegistroUsuario.mostrarMensaje("Información eliminada de la base de datos de forma correcta.");

                    break;
            }
        }
    }
}
