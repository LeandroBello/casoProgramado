/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;

/**
 *
 * @author Leandro
 */
public class GUI_Botones extends javax.swing.JPanel {

    /**
     * Creates new form GUI_Botones
     */
    public GUI_Botones() {
        initComponents();
    }

    public void agregarEventos(ActionListener controlador) 
    {
        this.jbtn_Consultar.addActionListener(controlador);
        this.jbtn_Agregar.addActionListener(controlador);
        this.jbtn_Modificar.addActionListener(controlador);
        this.jbtn_Eliminar.addActionListener(controlador);
    }

    public void habilitarAgregar() 
    {
        this.jbtn_Agregar.setEnabled(true);
        this.jbtn_Eliminar.setEnabled(false);
        this.jbtn_Modificar.setEnabled(false);
        this.jbtn_Consultar.setEnabled(false);
    }

    public void habilitarEliminar() {
        this.jbtn_Eliminar.setEnabled(true);
        this.jbtn_Modificar.setEnabled(true);

    }

    public void habilitarBotones() 
    {
        this.jbtn_Agregar.setEnabled(false);
        this.jbtn_Eliminar.setEnabled(true);
        this.jbtn_Modificar.setEnabled(true);
        this.jbtn_Consultar.setEnabled(true);
    }

    public void habilitarOpciones() 
    {
        this.jbtn_Agregar.setEnabled(false);
        this.jbtn_Eliminar.setEnabled(false);
        this.jbtn_Modificar.setEnabled(false);
        this.jbtn_Consultar.setEnabled(false);
    }

    public void estadoInicial() {
        this.jbtn_Consultar.setEnabled(false);

        this.jbtn_Agregar.setEnabled(false);
        this.jbtn_Eliminar.setEnabled(false);
        this.jbtn_Modificar.setEnabled(false);
    }

      public void habilitarTodo()
      {
        this.jbtn_Consultar.setEnabled(true);

        this.jbtn_Agregar.setEnabled(true);
        this.jbtn_Eliminar.setEnabled(true);
        this.jbtn_Modificar.setEnabled(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtn_Consultar = new javax.swing.JButton();
        jbtn_Agregar = new javax.swing.JButton();
        jbtn_Modificar = new javax.swing.JButton();
        jbtn_Eliminar = new javax.swing.JButton();

        jbtn_Consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        jbtn_Consultar.setActionCommand("Consultar");

        jbtn_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        jbtn_Agregar.setActionCommand("Agregar");

        jbtn_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificar.png"))); // NOI18N
        jbtn_Modificar.setActionCommand("Modificar");

        jbtn_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        jbtn_Eliminar.setActionCommand("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jbtn_Consultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtn_Agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtn_Modificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtn_Eliminar)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_Consultar)
                    .addComponent(jbtn_Agregar)
                    .addComponent(jbtn_Modificar)
                    .addComponent(jbtn_Eliminar))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtn_Agregar;
    private javax.swing.JButton jbtn_Consultar;
    private javax.swing.JButton jbtn_Eliminar;
    private javax.swing.JButton jbtn_Modificar;
    // End of variables declaration//GEN-END:variables
}
