/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Leandro
 */import  Controlador.Controlador_FRM_MantenimientoCursos;
public class GUI_InformacionCursos extends javax.swing.JPanel {
Controlador_FRM_MantenimientoCursos controlador_FRM_MantenimientoCursos;
    /**
     * Creates new form GUI_InformacionCursos
     */
    public GUI_InformacionCursos() 
    {
        initComponents();
        cargarCreditos();
    }
    public void agregarEvento(Controlador_FRM_MantenimientoCursos controlador_FRM_MantenimientoCursos)
    {
    this.jbtn_ConsultaRapida.addActionListener(controlador_FRM_MantenimientoCursos);
    }
    public void cargarCreditos()
    {
        this.jcb_Creditos.removeAllItems();
        for(int contador=0;contador<10;contador++)
        {
            this.jcb_Creditos.addItem(""+contador);
        }
        this.jcb_Creditos.setSelectedIndex(4);
    }
    public String[] devolverInformacion()
    {
        String arreglo[];
        arreglo=new String[4];
        arreglo[0]=this.jt_Sigla.getText();
        arreglo[1]=this.jt_Nombre.getText();
        arreglo[2]=""+this.jcb_Creditos.getSelectedIndex();
        arreglo[3]=this.jt_Horario.getText();
        
        return arreglo;
    
    }
    public String devolverSigla()
    {
        return this.jt_Sigla.getText();
    }
    public void mostrarInformacion(String arreglo[])
    {
        this.jt_Nombre.setText(arreglo[0]);
        this.jcb_Creditos.setSelectedIndex(Integer.parseInt(arreglo[1]));
        this.jt_Horario.setText(arreglo[2]);
    }
    public void mostrarInformacionXML(String arreglo[])
    {
        this.jt_Nombre.setText(arreglo[1]);
        this.jcb_Creditos.setSelectedIndex(Integer.parseInt(arreglo[2]));
        this.jt_Horario.setText(arreglo[3]);
    }
    
    public void habilitarOpciones(){
    this.jt_Nombre.setEnabled(true);
        this.jcb_Creditos.setEnabled(true);
    this.jt_Horario.setEnabled(true);

    }
    public void limpiarInterfaz(){
    this.jt_Sigla.setText("");
        this.jt_Nombre.setText("");
    this.jt_Horario.setText("");
    this.jcb_Creditos.setSelectedIndex(4);

    
    }
    
    public void desahabilitarSigla(){
    
    this.jt_Sigla.setEnabled(false);
    
    }
    
    public void estadoInicial(){
    this.jt_Sigla.setEnabled(true);
        this.jt_Horario.setEnabled(false);
    this.jt_Nombre.setEnabled(false);
    this.jcb_Creditos.setEnabled(false);

            
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Sigla = new javax.swing.JLabel();
        jl_Nombre = new javax.swing.JLabel();
        jl_Creditos = new javax.swing.JLabel();
        jl_Horario = new javax.swing.JLabel();
        jt_Sigla = new javax.swing.JTextField();
        jt_Nombre = new javax.swing.JTextField();
        jt_Horario = new javax.swing.JTextField();
        jcb_Creditos = new javax.swing.JComboBox<>();
        jbtn_ConsultaRapida = new javax.swing.JButton();

        jl_Sigla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jl_Sigla.setText("Sigla");

        jl_Nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jl_Nombre.setText("Nombre");

        jl_Creditos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jl_Creditos.setText("Créditos");

        jl_Horario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jl_Horario.setText("Horario");

        jcb_Creditos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcb_Creditos.setMaximumRowCount(10);
        jcb_Creditos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" }));

        jbtn_ConsultaRapida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        jbtn_ConsultaRapida.setActionCommand("ConsultaRapida");
        jbtn_ConsultaRapida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_ConsultaRapidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_Nombre)
                    .addComponent(jl_Creditos)
                    .addComponent(jl_Horario)
                    .addComponent(jl_Sigla))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtn_ConsultaRapida))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jt_Nombre)
                        .addComponent(jt_Horario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcb_Creditos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn_ConsultaRapida)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_Sigla)
                            .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_Nombre)
                    .addComponent(jt_Nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcb_Creditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_Creditos))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jt_Horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_Horario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_ConsultaRapidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_ConsultaRapidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtn_ConsultaRapidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtn_ConsultaRapida;
    private javax.swing.JComboBox<String> jcb_Creditos;
    private javax.swing.JLabel jl_Creditos;
    private javax.swing.JLabel jl_Horario;
    private javax.swing.JLabel jl_Nombre;
    private javax.swing.JLabel jl_Sigla;
    private javax.swing.JTextField jt_Horario;
    private javax.swing.JTextField jt_Nombre;
    private javax.swing.JTextField jt_Sigla;
    // End of variables declaration//GEN-END:variables
}
