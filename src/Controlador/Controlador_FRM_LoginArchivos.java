package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.MetodosUsuarioArchivos;
import Modelo.Usuarios;

import Vista.FRM_LoginArchivos;
import Vista.FRM_MenuPrincipal;
import Vista.FRM_RegistroUsuario;

import javax.swing.JOptionPane;

public class Controlador_FRM_LoginArchivos implements ActionListener {

    FRM_LoginArchivos fRM_LoginArchivos;
    MetodosUsuarioArchivos metodoUsuariosArchivos;
    FRM_RegistroUsuario fRM_RegistroUsuario;
    FRM_MenuPrincipal fRM_MenuPrincipal;

    public Controlador_FRM_LoginArchivos(FRM_LoginArchivos login, FRM_MenuPrincipal principal) throws Exception {

        this.fRM_LoginArchivos = login;
        fRM_RegistroUsuario = new FRM_RegistroUsuario(principal);
        metodoUsuariosArchivos = new MetodosUsuarioArchivos();
        this.fRM_MenuPrincipal = principal;

        if (metodoUsuariosArchivos.verificarExistenciaDeArchivoDeUsuarios()) {
            login.hacerLogin();//Accede al FRM_MenuPrincipal.
        } else {
            login.noHacerLogin();// No le deja pasar si existe usuarios.

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Entrar")) {
            //consultarUsuario();
            //System.out.println("LLegó al controlador Login Archivos");
            if (consultarUsuario()) 
//            {
                fRM_MenuPrincipal.setVisible(true);
            }
        }
    

    public boolean consultarUsuario() {
        boolean encontro = false;
        if (metodoUsuariosArchivos.consultarUsuarioLogin(fRM_LoginArchivos.devolverNombreUsuario(), fRM_LoginArchivos.devolverContrasena()))//CONSULTA LA CONTRASEÑA Y USUARIO
        {
            encontro = true;
            JOptionPane.showMessageDialog(null, "Bienvenido al Sistema " + fRM_LoginArchivos.getJtNombreUsuario());
            fRM_MenuPrincipal.setVisible(true);
            fRM_LoginArchivos.setVisible(false);

        } else {
            encontro = false;
            JOptionPane.showMessageDialog(null, "El Usuario o la Contraseña es incorrecta");

        }
        return encontro;
    }

}
