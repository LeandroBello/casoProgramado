/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloConexion.ConexionEstudiante;
import Modelo.MetodosEstudianteArchivos;
import Modelo.MetodosEstudianteXML;
import Modelo.MetodosUsuarioArchivos;
import Vista.FRM_RegistroEstudiantes;
import Vista.FRM_MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener {

    FRM_RegistroEstudiantes fRM_RegistroEstudiantes;
    FRM_MenuPrincipal fRM_MenuPrincipal;
    ConexionEstudiante conexionEstudiante;//BASES DE DATOS..
    MetodosEstudianteArchivos metodosEstudianteArchivos;//archivos
    MetodosEstudianteXML metodosEstudianteXML;//xml

    public Controlador_FRM_MantenimientoEstudiantes(FRM_RegistroEstudiantes mantenimientoEstudiantes, FRM_MenuPrincipal control) {
        this.fRM_RegistroEstudiantes = mantenimientoEstudiantes;
        this.fRM_MenuPrincipal = control;

        metodosEstudianteXML = new MetodosEstudianteXML(mantenimientoEstudiantes);
        metodosEstudianteArchivos = new MetodosEstudianteArchivos();
        conexionEstudiante = new ConexionEstudiante();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ConsultaRapida")) {
            switch (fRM_MenuPrincipal.seleccionarFuenteDelSistema()) {
                case 1:
                    // JOptionPane.showMessageDialog(null, "Prueba Archivos planos");
                    if (metodosEstudianteArchivos.consultarEstudiante(fRM_RegistroEstudiantes.devolverCedula())) //0 usuario
                    {
                        fRM_RegistroEstudiantes.mostrarInformacion(metodosEstudianteArchivos.getArregloInformacion());
                        fRM_RegistroEstudiantes.mostrarMensaje("Se encontraron el Estudiante.");
                        fRM_RegistroEstudiantes.habilitarBotones();//Habilita los botones de interación

                    } else {
                        fRM_RegistroEstudiantes.limpiarInterfaz();
                        fRM_RegistroEstudiantes.habilitarAgregar();//habilita el agregar.
                    }

                    break;
                case 2:
                    if (metodosEstudianteXML.consultarInformacionDelXml(fRM_RegistroEstudiantes.devolverCedula())) //0 usuario
                    {
                        fRM_RegistroEstudiantes.mostrarInformacion(metodosEstudianteXML.getArregloInformacion());
                        fRM_RegistroEstudiantes.mostrarMensaje("Se encontraron el Estudiante.");
                        fRM_RegistroEstudiantes.habilitarBotones();//Habilita los botones de interación

                    } else {
                        fRM_RegistroEstudiantes.limpiarInterfaz();
                        fRM_RegistroEstudiantes.habilitarAgregar();//habilita el agregar.
                    }
                    break;
                case 3:

                    if (conexionEstudiante.consultarEstudiante(fRM_RegistroEstudiantes.devolverCedula())) //0 usuario
                    {
                        fRM_RegistroEstudiantes.mostrarInformacion(conexionEstudiante.getArregloInformacion());
                        fRM_RegistroEstudiantes.mostrarMensaje("Se encontraron el Estudiante.");
                        fRM_RegistroEstudiantes.habilitarBotones();//Habilita los botones de interación

                    } else {
                        fRM_RegistroEstudiantes.limpiarInterfaz();
                        fRM_RegistroEstudiantes.habilitarAgregar();//habilita el agregar.
                    }
                    break;
            }

        }
        if (e.getActionCommand().equals("Consultar")) {
            switch (fRM_MenuPrincipal.seleccionarFuenteDelSistema())
            {
                case 1:
                    if (metodosEstudianteArchivos.consultarEstudiante(fRM_RegistroEstudiantes.devolverCedula())) {
                        fRM_RegistroEstudiantes.mostrarInformacion(metodosEstudianteArchivos.getArregloInformacion());
                        fRM_RegistroEstudiantes.mostrarMensaje("Se encontro el Estudiante.");
                        fRM_RegistroEstudiantes.habilitarBotones();
                    } else {
                        fRM_RegistroEstudiantes.mostrarMensaje("No se encontro el Estudiante.");
                        fRM_RegistroEstudiantes.mostrarMensaje("Proceda a agregar el Estudiante.");
                        fRM_RegistroEstudiantes.limpiarInterfaz();
                        fRM_RegistroEstudiantes.habilitarAgregar();

                    }

                    break;

                case 2:
                    if (metodosEstudianteXML.consultarInformacionDelXml(fRM_RegistroEstudiantes.devolverCedula())) {
                        fRM_RegistroEstudiantes.mostrarInformacionXML(metodosEstudianteXML.getArregloInformacion());
                        fRM_RegistroEstudiantes.mostrarMensaje("Información encontrada con la cédula : " + fRM_RegistroEstudiantes.devolverCedula());
                        fRM_RegistroEstudiantes.habilitarBotones();
                    } else {
                        fRM_RegistroEstudiantes.mostrarMensaje("No se encontro el Estudiante.");
                        fRM_RegistroEstudiantes.mostrarMensaje("Proceda a agregar el Estudiante.");
                        fRM_RegistroEstudiantes.limpiarInterfaz();
                        fRM_RegistroEstudiantes.habilitarAgregar();
                    }

                    break;

                case 3:

                    if (conexionEstudiante.consultarEstudiante(fRM_RegistroEstudiantes.devolverCedula())) {
                        fRM_RegistroEstudiantes.mostrarInformacion(conexionEstudiante.getArregloInformacion());
                        fRM_RegistroEstudiantes.mostrarMensaje("Información encontrada con la cédula : " + fRM_RegistroEstudiantes.devolverCedula());
                        fRM_RegistroEstudiantes.habilitarBotones();
                    } else {

                        fRM_RegistroEstudiantes.mostrarMensaje("No se encontro el Estudiante.");
                        fRM_RegistroEstudiantes.mostrarMensaje("Proceda a agregar el Estudiante.");
                        fRM_RegistroEstudiantes.limpiarInterfaz();
                        fRM_RegistroEstudiantes.habilitarAgregar();
                    }
                    break;

            }
        }
        if (e.getActionCommand().equals("Agregar")) {
            switch (fRM_MenuPrincipal.seleccionarFuenteDelSistema()) {
                case 1:
                    if (metodosEstudianteArchivos.consultarEstudiante(fRM_RegistroEstudiantes.devolverCedula())) {
                        fRM_RegistroEstudiantes.mostrarMensaje("El estudiante ya esta agregado en los archivos");
                    } else {
                        metodosEstudianteArchivos.agregarEstudiante(fRM_RegistroEstudiantes.devolverInformacion());
                        metodosEstudianteArchivos.mostrarInformacion();
                        fRM_RegistroEstudiantes.mostrarMensaje("Se agrego el estudiante con éxito.");
                    }
                    break;

                case 2:
                    if (metodosEstudianteXML.consultarInformacionDelXml(fRM_RegistroEstudiantes.devolverCedula())) {
                        fRM_RegistroEstudiantes.mostrarMensaje("El estudiante ya esta agregado en los archivos XML");
                    } else {
                        metodosEstudianteXML.guardarArchivoXML(fRM_RegistroEstudiantes.devolverInformacion());
                        fRM_RegistroEstudiantes.mostrarMensaje("Información agregada al archivo XML de forma correcta.");
                    }
                    break;

                case 3:
                    if (conexionEstudiante.consultarEstudiante(fRM_RegistroEstudiantes.devolverCedula())) {
                        fRM_RegistroEstudiantes.mostrarMensaje("El estudiante ya esta agregado en la base de datos");
                    } else {
                        conexionEstudiante.registrarEstudiante(fRM_RegistroEstudiantes.devolverInformacion());

                        fRM_RegistroEstudiantes.mostrarMensaje("Información agregada a ala base de datos de forma correcta.");
                    }
                    break;
            }
        }
        if (e.getActionCommand().equals("Modificar")) {
            switch (fRM_MenuPrincipal.seleccionarFuenteDelSistema()) {
                case 1:
                    if (metodosEstudianteArchivos.consultarEstudiante(fRM_RegistroEstudiantes.devolverCedula()) == false) {
                        fRM_RegistroEstudiantes.mostrarMensaje("El estudiante no esta en los Archivos.");

                    } else {

                        metodosEstudianteArchivos.modificarEstudiante(fRM_RegistroEstudiantes.devolverInformacion());
                        fRM_RegistroEstudiantes.mostrarMensaje("Se modifico el estudiante con éxito.");
                    }
                    break;

                case 2:
                    if (metodosEstudianteXML.consultarInformacionDelXml(fRM_RegistroEstudiantes.devolverCedula()) == false) {
                        fRM_RegistroEstudiantes.mostrarMensaje("El estudiante no esta en los Archivos XML.");

                    } else {
                        metodosEstudianteXML.modificarInformacionDelXml(fRM_RegistroEstudiantes.devolverInformacion());
                        fRM_RegistroEstudiantes.mostrarMensaje("Información modificada en el archivo XML de forma correcta.");
                    }
                    break;

                case 3:
                    if (conexionEstudiante.consultarEstudiante(fRM_RegistroEstudiantes.devolverCedula()) == false) {
                        fRM_RegistroEstudiantes.mostrarMensaje("El estudiante no esta en la base de datos.");

                    } else {
                        conexionEstudiante.modificar(fRM_RegistroEstudiantes.devolverInformacion());
                        fRM_RegistroEstudiantes.mostrarMensaje("Información modificada en la base de dato de forma correcta.");
                    }
                    break;
            }
        }
        if (e.getActionCommand().equals("Eliminar")) {
            switch (fRM_MenuPrincipal.seleccionarFuenteDelSistema()) {
                case 1:
                    if (metodosEstudianteArchivos.consultarEstudiante(fRM_RegistroEstudiantes.devolverCedula()) == false) {
                        fRM_RegistroEstudiantes.mostrarMensaje("El estudiante no esta en los registros para Eliminar.");
                        fRM_RegistroEstudiantes.limpiarInterfaz();

                    } else {

                        metodosEstudianteArchivos.eliminarEstudiante(fRM_RegistroEstudiantes.devolverInformacion());
                        fRM_RegistroEstudiantes.mostrarMensaje("Información eliminada en de los archivos de forma correcta.");
                        fRM_RegistroEstudiantes.limpiarInterfaz();
                    }
                    break;

                case 2:

                    if (metodosEstudianteXML.consultarInformacionDelXml(fRM_RegistroEstudiantes.devolverCedula()) == false) {
                        fRM_RegistroEstudiantes.mostrarMensaje("El estudiante no esta en los registros para Eliminar.");
                        fRM_RegistroEstudiantes.limpiarInterfaz();

                    } else {
                        metodosEstudianteXML.eliminarInformacionDelXml(fRM_RegistroEstudiantes.devolverCedula());
                        fRM_RegistroEstudiantes.mostrarMensaje("Información eliminada del archivo XML de forma correcta.");
                        fRM_RegistroEstudiantes.limpiarInterfaz();
                    }
                    break;

                case 3:
                    if (conexionEstudiante.consultarEstudiante(fRM_RegistroEstudiantes.devolverCedula()) == false) {
                        fRM_RegistroEstudiantes.mostrarMensaje("El estudiante no esta en los registros para Eliminar.");
                        fRM_RegistroEstudiantes.limpiarInterfaz();
                    } else {
                        conexionEstudiante.eliminar(fRM_RegistroEstudiantes.devolverInformacion());
                        fRM_RegistroEstudiantes.mostrarMensaje("Información eliminada en la base de datos de forma correcta.");
                        fRM_RegistroEstudiantes.limpiarInterfaz();
                    }
                    break;
            }
        }

    }

}
