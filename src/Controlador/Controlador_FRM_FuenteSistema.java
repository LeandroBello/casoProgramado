/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.FRM_MenuPrincipal;
import Vista.FRM_FuenteSistema;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class Controlador_FRM_FuenteSistema implements ActionListener {

    FRM_FuenteSistema fRM_FuenteSistema;//Instancias.
    FRM_MenuPrincipal fRM_MenuPrincipal;//Instancias

    public Controlador_FRM_FuenteSistema(FRM_FuenteSistema control)//Metodo constructor de la principal!!!!
    {
        this.fRM_FuenteSistema = control;

    }

    public void actionPerformed(ActionEvent e) //Escuchador de eventos..
    {
        if (e.getActionCommand().equals("Entrar")) {
            System.err.println("Entrar");
            System.err.println("Valor de la fuente: " + fRM_FuenteSistema.setValorFuenteSistema());
            // fRM_MenuPrincipal = new FRM_MenuPrincipal(fRM_MenuPrincipal);//Presenta problemas
            try {
                fRM_MenuPrincipal = new FRM_MenuPrincipal(fRM_FuenteSistema);//Referencia manda la clase por parametro.
                //JOptionPane.showMessageDialog(null,"ksksksksksks");
            } catch (Exception ex) {
                Logger.getLogger(Controlador_FRM_FuenteSistema.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
