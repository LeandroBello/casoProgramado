/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import Controlador.Controlador_FRM_LoginUsuario;
import Controlador.Controlador_FRM_RegistroUsuarios;
import java.sql.DriverManager;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class FRM_LoginUsuario extends javax.swing.JFrame {

    /**
     * Creates new form FRM_LoginUsuario
     */
    Controlador_FRM_LoginUsuario controlador_FRM_LoginUsuario;
   
    FRM_MenuPrincipal fRM_MenuPrincipal;
    public FRM_LoginUsuario(FRM_MenuPrincipal fRM_MenuPrincipal) 
    {
        initComponents();
        setVisible(false);
          this.setLocation(310, 130);
        this.fRM_MenuPrincipal=fRM_MenuPrincipal;
        controlador_FRM_LoginUsuario = new Controlador_FRM_LoginUsuario(this,fRM_MenuPrincipal);
        
        agregarEvento();
    }

   
    public boolean verificarExistenciaDeBasesDedatosUsuarios(){
    return controlador_FRM_LoginUsuario.visible();
    }
    
    public void agregarEvento(){
        this.btn_Login.addActionListener(controlador_FRM_LoginUsuario);
    }
    
     
    public String devolverNombreUsuario()
    {
        return jt_UsuarioLogin.getText();
    }
    
    public String devolverContrasena()
    {
       return jt_PasswordUsuario.getText();
    }
     public String [] devolverinformacion()
     {
        String arreglo[];
        arreglo= new String[2];
        
        arreglo[0]=jt_UsuarioLogin.getText();
        arreglo[1]=jt_PasswordUsuario.getText();
        return arreglo;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jt_UsuarioLogin = new javax.swing.JTextField();
        btn_Login = new javax.swing.JButton();
        jt_PasswordUsuario = new javax.swing.JPasswordField();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña");

        btn_Login.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Login.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Login)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(jLabel1)
                            .addGap(43, 43, 43)
                            .addComponent(jt_UsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(jt_PasswordUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jt_UsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jt_PasswordUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPasswordField jt_PasswordUsuario;
    private javax.swing.JTextField jt_UsuarioLogin;
    // End of variables declaration//GEN-END:variables
}
