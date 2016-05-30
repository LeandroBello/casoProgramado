/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.MetodosLogin;
import Vista.FRM_LoginUsuario;
import Vista.FRM_MenuPrincipal;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class Controlador_FRM_LoginUsuario implements ActionListener {

    FRM_LoginUsuario fRM_LoginUsuario;
    MetodosLogin metodosLogin;
    FRM_MenuPrincipal fRM_MenuPrincipal;
    Controlador_FRM_RegistroUsuarios controlador_FRM_RegistroUsuarios;

    public Controlador_FRM_LoginUsuario(FRM_LoginUsuario fRM_LoginUsuario, FRM_MenuPrincipal fRM_MenuPrincipal) //Constructor recibe parámetros valores.
    {
        
        this.fRM_MenuPrincipal = fRM_MenuPrincipal;
        this.fRM_LoginUsuario = fRM_LoginUsuario;
        metodosLogin = new MetodosLogin();

    }

    public boolean visible() {
        return metodosLogin.verificarAdmin();
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("Login"))
        {
            if (metodosLogin.consultarUsuario(fRM_LoginUsuario.devolverinformacion())) 
            {
                //JOptionPane.showMessageDialog(null,"");
            // this.controlador_FRM_RegistroUsuarios.setPrimeraVez(1);//Valor agregado para iniciar la pantalla
            JOptionPane.showMessageDialog(null, "Bienvenido al Sistema " + fRM_LoginUsuario.devolverNombreUsuario());

                fRM_LoginUsuario.setVisible(false);
                fRM_MenuPrincipal.setVisible(true);
            } else 
            {
                JOptionPane.showMessageDialog(null, "El Usuario o la Contraseña es incorrecta");
            }

            

        }
    }

}
