/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesamiento;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Luis
 */
public class Mapa {
    private Archivo ar = new Archivo();
    private int edit = 0;
    private ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
    private final String[] terreno={"Montaña","Tierra","Agua","Arena","Bosque"};
    private final Color[] background={new Color(77,58,58),new Color(250,191,143),new Color(0,175,255),Color.yellow,new Color(150,210,80)};
    
    public Mapa(String dir){
        map = ar.leerArchivo(dir);
        
    }

    public int getEdit() {
        return edit;
    }

    public void setEdit(int edit) {
        this.edit = edit;
    }
    
    public JLabel[][] cargarMapa(JPanel mapa) {
        int filas = ar.getFilas();
        int col = ar.getCol();
        int con;
        mapa.setLayout(new GridLayout(filas,col));
        JLabel[][] grid = new JLabel[filas][col];
        for (int i=0; i<filas; i++){
            for (int j=0; j<col; j++){
                con = map.get(i).get(j);
                System.out.print(con);
                grid[i][j]=new JLabel();
                grid[i][j].setText(" ");
                grid[i][j].setToolTipText(terreno[con]);
                grid[i][j].setBackground(background[con]);
                grid[i][j].setOpaque(true);
                grid[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt){
                        if (edit==1){
                            int indice=-1;
                            JLabel jl = new JLabel();
                            jl = (JLabel) evt.getSource();
                            for (int i=0;i<background.length;i++){
                                if (jl.getBackground()==background[i]){
                                    indice=i;
                                }
                            }
                            if (indice==background.length-1){
                                indice=0;
                            }else{
                                indice++;
                            }
                            jl.setBackground(background[indice]);
                            jl.setToolTipText(terreno[indice]);
                            mapa.updateUI();
                        }
                    }
                });
                mapa.add(grid[i][j]);
            }
            System.out.println();
        }
        mapa.updateUI();
        return grid;
    }
    
    public void guardarMapa(JPanel mapa) throws IOException{
        int filas = ar.getFilas();
        int col = ar.getCol();
        int c=-1;
        JLabel jl = new JLabel();
        int i=0; int j=0;
        for (int aux=0; aux<filas*col-1; aux++){
            if (j==col){
                j = 0;
                i++;
            }
            jl = (JLabel) mapa.getComponent(aux);
            for (int color=0; color<background.length; color++){
                if (jl.getBackground()==background[color]){
                    c=color;
                }
            }
            map.get(i).set(j, c);
        }
        
        ar.guardarArchivo(map, "filename.txt");
    }
}
