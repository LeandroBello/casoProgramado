/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.FRM_RegistroEstudiantes;
import Vista.FRM_RegistroCursos;
import Vista.FRM_RegistroMatricula;
import Vista.FRM_MenuPrincipal;
import Vista.FRM_RegistroUsuario;

import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class Controlador_FRM_MenuPrincipal implements ActionListener {

    FRM_RegistroEstudiantes registroEstudiante;
    FRM_RegistroCursos registroCurso;
    FRM_RegistroMatricula matricula;
    FRM_MenuPrincipal control;
    FRM_RegistroUsuario usuario;

    public Controlador_FRM_MenuPrincipal(FRM_MenuPrincipal control) {

        registroEstudiante = new FRM_RegistroEstudiantes(control);
        registroCurso = new FRM_RegistroCursos(control);
        this.control = control;

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Salir")) {
            System.exit(0);
        }
        if (e.getActionCommand().equals("Estudiante")) {
            //   JOptionPane.showMessageDialog(null,"llegamos hasta estudiante");
            this.registroEstudiante.setVisible(true);//Abre la ventana.

        }
        if (e.getActionCommand().equals("Curso")) {
            this.registroCurso.setVisible(true);//Abre la ventana.
        }
        if (e.getActionCommand().equals("Matricula")) {
            matricula = new FRM_RegistroMatricula(registroEstudiante, registroCurso, control);
            this.matricula.setVisible(true);//Abre la ventana.
        }
        if (e.getActionCommand().equals("Usuario")) {
            usuario = new FRM_RegistroUsuario(control);
            this.usuario.setVisible(true);//Abre la ventana.
            System.out.println("apreto");
        }

    }
}
