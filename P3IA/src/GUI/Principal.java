/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Procesamiento.AEstrella;
import Procesamiento.Mapa;
import Procesamiento.Personaje;
import Procesamiento.Punto;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Point;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Luis
 */
public class Principal extends javax.swing.JFrame {
    Mapa m;
    JLabel[][] pos;
    Punto ini=new Punto();
    Punto fin=new Punto();
    Personaje p;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        btnAct.doClick();   // Actualiza el mapa al cargar el JFrame
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        btnAct = new javax.swing.JButton();
        cbEditar = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        btnResolver = new javax.swing.JButton();
        spArbol = new java.awt.ScrollPane();
        jLabel1 = new javax.swing.JLabel();
        txtPuntos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbLista = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder("MAPA"));
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );

        btnAct.setText("Recargar");
        btnAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActActionPerformed(evt);
            }
        });

        cbEditar.setText("Editar");
        cbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEditarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnResolver.setText("Resolver con A*");
        btnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolverActionPerformed(evt);
            }
        });

        jLabel1.setText("Puntos:");

        txtPuntos.setEditable(false);

        jLabel2.setText("Personaje:");

        cbLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Humano", "Mono", "Pulpo", "Sasquatch" }));
        cbLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbLista, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbEditar)
                                .addGap(37, 37, 37)
                                .addComponent(btnGuardar)
                                .addGap(82, 82, 82)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 30, Short.MAX_VALUE))
                            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spArbol, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(btnAct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAct)
                    .addComponent(btnGuardar)
                    .addComponent(cbEditar)
                    .addComponent(jLabel1)
                    .addComponent(txtPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spArbol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResolver)
                    .addComponent(jLabel2)
                    .addComponent(cbLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActActionPerformed
        // Recarga el mapa
        m = new Mapa("filename.txt");
        panel.removeAll();
        pos = m.cargarMapa(panel);
        spArbol.removeAll();
        txtPuntos.setText("0");
    }//GEN-LAST:event_btnActActionPerformed

    private void panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseClicked

    }//GEN-LAST:event_panelMouseClicked

    private void cbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEditarActionPerformed
        // Permite editar el mapa, deshabilita otros botones para evitar inconsistencias
        btnGuardar.setEnabled(true);
        cbEditar.setEnabled(false);
        btnAct.setEnabled(false);
        m.setEdit(1);
    }//GEN-LAST:event_cbEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Guarda el mapa en el archivo y vuelve a recargar el mapa desde el archivo
        // deshabilita y habilita botones para evitar inconsistencias
        try {
            m.guardarMapa(panel);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        pos = m.cargarMapa(panel);
        
        btnGuardar.setEnabled(false);
        cbEditar.setSelected(false);
        cbEditar.setEnabled(true);
        btnAct.setEnabled(true);
        
        panel.updateUI();
        btnAct.doClick();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolverActionPerformed
        // Corre el algoritmo A* una vez que se seleccionaron punto inicial y final
        // y el personaje a utilizar
        inicioFin();
        setPersonaje(cbLista.getSelectedItem().toString());
        AEstrella algoritmo = new AEstrella(ini,fin,p,m,txtPuntos,spArbol,panel);
        algoritmo.start();
    }//GEN-LAST:event_btnResolverActionPerformed

    private void cbListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbListaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbListaActionPerformed

    /*
    Metodo que detecta el punto inicial y final recorriendo el panel por completo
    la funcion se ve un poco rara por que el metodo getComponentAt de JPanel
    causa errores (posiblemente por el GridLayout)
    */
    public void inicioFin(){
        int col=m.getAr().getCol();
        int filas = m.getAr().getFilas();
        int i=0;  int j=0;
        for (Component jc: panel.getComponents()){
            if (jc instanceof JLabel){
                if (j==col){
                    ++i;
                    j=0;
                }
                if (((JLabel) jc).getText()=="F"){
                    fin.x=j;
                    fin.y=i;
                }else if (((JLabel) jc).getText()=="Io"){
                    ini.x=j;
                    ini.y=i;
                }else{
                    // Nothing
                }
                ++j;
            }
        }
    }
    
    /*
    Metodo para inicializar al personaje seleccionado, el personaje por default 
    es el humano como se puede apreciar en la interfaz grafica
    */
    public void setPersonaje(String nombre){
        int[] costos=new int[5];
        if (nombre=="Humano"){
            costos[0]=1000000;  // Costo Mountain
            costos[1]=1;        // Costo Land
            costos[2]=2;        // Costo Water
            costos[3]=3;        // Costo Sand
            costos[4]=4;        // Costo Forest
            p = new Personaje(costos); 
            txtPuntos.setText(p.getPuntos()+"");//Textbox del puntaje
        }else if (nombre=="Mono"){
            costos[0]=1000000;
            costos[1]=2;
            costos[2]=4;
            costos[3]=3;
            costos[4]=1;
            p = new Personaje(costos); 
            txtPuntos.setText(p.getPuntos()+"");
        }else if (nombre=="Pulpo"){
            costos[0]=1000000;
            costos[1]=2;
            costos[2]=1;
            costos[3]=1000000;
            costos[4]=3;
            p = new Personaje(costos); 
            txtPuntos.setText(p.getPuntos()+"");
        }else if (nombre=="Sasquatch"){
            costos[0]=15;
            costos[1]=4;
            costos[2]=1000000;
            costos[3]=1000000;
            costos[4]=4;
            p = new Personaje(costos); 
            txtPuntos.setText(p.getPuntos()+"");
        }else{
            JOptionPane.showMessageDialog(null, "Selecciona un Personaje");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAct;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnResolver;
    private javax.swing.JCheckBox cbEditar;
    private javax.swing.JComboBox<String> cbLista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panel;
    private java.awt.ScrollPane spArbol;
    private javax.swing.JTextField txtPuntos;
    // End of variables declaration//GEN-END:variables
}
