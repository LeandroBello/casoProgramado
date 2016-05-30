/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ModeloConexion.ConexionCurso;
import Modelo.MetodosCursosArchivos;

import Modelo.MetodosCursosXML;
import Modelo.MetodosEstudianteXML;

import Vista.FRM_RegistroCursos;
import Vista.FRM_MenuPrincipal;

import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class Controlador_FRM_MantenimientoCursos implements ActionListener {

    FRM_RegistroCursos fRM_RegistroCursos;
    FRM_MenuPrincipal fRM_MenuPrincipal;
    ConexionCurso conexionCurso;
    MetodosCursosXML metodosCursosXML;
    MetodosCursosArchivos metodosCursosArchivos;

    public Controlador_FRM_MantenimientoCursos(FRM_RegistroCursos mantenimientoCursos, FRM_MenuPrincipal control) {
        this.fRM_RegistroCursos = mantenimientoCursos;
        this.fRM_MenuPrincipal = control;

        metodosCursosXML = new MetodosCursosXML(mantenimientoCursos);
        metodosCursosArchivos = new MetodosCursosArchivos();
        conexionCurso = new ConexionCurso();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ConsultaRapida")) {
            switch (fRM_MenuPrincipal.seleccionarFuenteDelSistema()) {
                case 1:

                    if (metodosCursosArchivos.consultarCurso(fRM_RegistroCursos.devolverSigla())) //0 usuario
                    {
                        fRM_RegistroCursos.mostrarInformacion(metodosCursosArchivos.getArregloInformacion());
                        fRM_RegistroCursos.mostrarMensaje("Se encontro el Curso.");
                        fRM_RegistroCursos.habilitarBotones();//Habilita los botones de interación

                    } else {
                        fRM_RegistroCursos.limpiarInterfaz();
                        fRM_RegistroCursos.habilitarAgregar();//habilita el agregar.
                    }

                    break;
                case 3:

                    if (conexionCurso.consultarCurso(fRM_RegistroCursos.devolverSigla())) //0 usuario
                    {
                        fRM_RegistroCursos.mostrarInformacion(conexionCurso.getArregloInformacion());
                        fRM_RegistroCursos.mostrarMensaje("Se encontro el curso.");
                        fRM_RegistroCursos.habilitarBotones();//Habilita los botones de interación

                    } else {
                        fRM_RegistroCursos.limpiarInterfaz();
                        fRM_RegistroCursos.habilitarAgregar();//habilita el agregar.
                    }
                    break;
            }

        }

        if (e.getActionCommand().equals("Consultar")) {
            switch (fRM_MenuPrincipal.seleccionarFuenteDelSistema()) {
                case 1:
                    if (metodosCursosArchivos.consultarCurso(fRM_RegistroCursos.devolverSigla())) {
                        fRM_RegistroCursos.mostrarInformacion(metodosCursosArchivos.getArregloInformacion());
                        fRM_RegistroCursos.mostrarMensaje("Se encontro el Curso.");
                        fRM_RegistroCursos.habilitarBotones();
                    } else {
                        fRM_RegistroCursos.mostrarMensaje("No se encontro el Curso.");
                        fRM_RegistroCursos.limpiarInterfaz();
                        fRM_RegistroCursos.habilitarAgregar();

                    }

                    break;

                case 2:
                    if (metodosCursosXML.consultarInformacionDelXml(fRM_RegistroCursos.devolverSigla())) {
                        fRM_RegistroCursos.mostrarInformacionXML(metodosCursosXML.getArregloInformacion());
                        fRM_RegistroCursos.mostrarMensaje("Información encontrada con la cédula : " + fRM_RegistroCursos.devolverSigla());
                        fRM_RegistroCursos.habilitarBotones();

                    } else {
                        fRM_RegistroCursos.mostrarMensaje("No se encontro el Curso.");
                        fRM_RegistroCursos.limpiarInterfaz();
                        fRM_RegistroCursos.habilitarAgregar();

                    }

                    break;

                case 3:

                    if (conexionCurso.consultarCurso(fRM_RegistroCursos.devolverSigla())) {
                        fRM_RegistroCursos.mostrarInformacion(conexionCurso.getArregloInformacion());
                        fRM_RegistroCursos.mostrarMensaje("Información encontrada con la cédula : " + fRM_RegistroCursos.devolverSigla());

                    } else {
                        fRM_RegistroCursos.mostrarMensaje("No se encontro el Curso.");
                        fRM_RegistroCursos.limpiarInterfaz();
                        fRM_RegistroCursos.habilitarAgregar();
                    }
                    break;
            }
        }
        if (e.getActionCommand().equals("Agregar")) {
            switch (fRM_MenuPrincipal.seleccionarFuenteDelSistema()) {
                case 1:
                    if (metodosCursosArchivos.consultarCurso(fRM_RegistroCursos.devolverSigla())) {
                        fRM_RegistroCursos.mostrarMensaje("El curso ya esta agregado en los archivos");

                    } else {
                        metodosCursosArchivos.agregarCurso(fRM_RegistroCursos.devolverInformacion());
                        fRM_RegistroCursos.mostrarMensaje("Se agrego el curso con éxito.");
                        fRM_RegistroCursos.habilitarBotones();
                    }
                    break;

                case 2:
                    if (metodosCursosXML.consultarInformacionDelXml(fRM_RegistroCursos.devolverSigla())) {
                        fRM_RegistroCursos.mostrarMensaje("El curso ya esta agregado en los archivos XML");
                    } else {
                        metodosCursosXML.guardarEnXML(fRM_RegistroCursos.devolverInformacion());
                        fRM_RegistroCursos.mostrarMensaje("Se agrego el curso con éxito.");
                        fRM_RegistroCursos.habilitarBotones();

                    }
                    break;

                case 3:
                    if (conexionCurso.consultarCurso(fRM_RegistroCursos.devolverSigla())) {
                        fRM_RegistroCursos.mostrarMensaje("El curso ya esta agregado en la base de datos");
                    } else {
                        conexionCurso.registrarCurso(fRM_RegistroCursos.devolverInformacion());
                        fRM_RegistroCursos.mostrarMensaje("Se agrego el curso con éxito.");
                        fRM_RegistroCursos.habilitarBotones();

                    }
                    break;
            }
        }
        if (e.getActionCommand().equals("Modificar")) {
            switch (fRM_MenuPrincipal.seleccionarFuenteDelSistema()) {
                case 1:
                    if (metodosCursosArchivos.consultarCurso(fRM_RegistroCursos.devolverSigla()) == false) {
                        fRM_RegistroCursos.mostrarMensaje("El estudiante no esta en los Archivos.");

                    } else {
                        metodosCursosArchivos.modificarCurso(fRM_RegistroCursos.devolverInformacion());
                        fRM_RegistroCursos.mostrarMensaje("Se modifico el curso con éxito.");
                        fRM_RegistroCursos.limpiarInterfaz();

                    }
                    break;

                case 2:
                    if (metodosCursosXML.consultarInformacionDelXml(fRM_RegistroCursos.devolverSigla()) == false) {
                        fRM_RegistroCursos.mostrarMensaje("El estudiante no esta en los Archivos XML.");

                    } else {
                        metodosCursosXML.modificarInformacionDelXml(fRM_RegistroCursos.devolverInformacion());
                        fRM_RegistroCursos.mostrarMensaje("Información modificada en el archivo XML de forma correcta.");
                        fRM_RegistroCursos.limpiarInterfaz();
                    }
                    break;

                case 3:
                    if (conexionCurso.consultarCurso(fRM_RegistroCursos.devolverSigla()) == false) {
                        fRM_RegistroCursos.mostrarMensaje("El estudiante no esta en la base de datos.");

                    } else {
                        conexionCurso.modificar(fRM_RegistroCursos.devolverInformacion());
                        fRM_RegistroCursos.mostrarMensaje("Información modificada en la base de datos de forma correcta.");
                        fRM_RegistroCursos.limpiarInterfaz();
                        fRM_RegistroCursos.estadoInicial();
                    }
                    break;
            }
        }
        if (e.getActionCommand().equals("Eliminar")) {
            switch (fRM_MenuPrincipal.seleccionarFuenteDelSistema()) {
                case 1:

                    if (metodosCursosArchivos.consultarCurso(fRM_RegistroCursos.devolverSigla()) == false) {
                        fRM_RegistroCursos.mostrarMensaje("El curso no esta en los registros para Eliminar.");
                        fRM_RegistroCursos.limpiarInterfaz();
                        fRM_RegistroCursos.estadoInicial();
                    } else {
                        metodosCursosArchivos.eliminarCurso(fRM_RegistroCursos.devolverInformacion());
                        fRM_RegistroCursos.mostrarMensaje("Información eliminada del archivo de forma correcta.");
                        fRM_RegistroCursos.limpiarInterfaz();
                        fRM_RegistroCursos.estadoInicial();

                    }
                    break;

                case 2:
                    if (metodosCursosXML.consultarInformacionDelXml(fRM_RegistroCursos.devolverSigla()) == false) {
                        fRM_RegistroCursos.mostrarMensaje("El curso no esta en los registros para Eliminar.");
                        fRM_RegistroCursos.limpiarInterfaz();
                        fRM_RegistroCursos.estadoInicial();
                    } else {
                        metodosCursosXML.eliminarInformacionDelXml(fRM_RegistroCursos.devolverSigla());
                        fRM_RegistroCursos.mostrarMensaje("Información eliminada del archivo XML de forma correcta.");
                        fRM_RegistroCursos.limpiarInterfaz();
                        fRM_RegistroCursos.estadoInicial();
                    }
                    break;

                case 3:
                    if (conexionCurso.consultarCurso(fRM_RegistroCursos.devolverSigla()) == false) {
                        fRM_RegistroCursos.mostrarMensaje("El curso no esta en los registros para Eliminar.");
                        fRM_RegistroCursos.limpiarInterfaz();
                        fRM_RegistroCursos.estadoInicial();
                    } else {
                        conexionCurso.eliminar(fRM_RegistroCursos.devolverInformacion());
                        fRM_RegistroCursos.mostrarMensaje("Información eliminada de la base de datos de forma correcta.");
                        fRM_RegistroCursos.limpiarInterfaz();
                        fRM_RegistroCursos.estadoInicial();
                    }
                    break;
            }
        }

    }

}
