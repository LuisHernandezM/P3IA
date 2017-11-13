/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesamiento;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Luis
 */
public class Mapa {
    private Archivo ar = new Archivo();
    private ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
    private final String[] terreno={"Montaña","Tierra","Agua","Arena","Bosque"};
    private final Color[] background={new Color(77,58,58),new Color(250,191,143),new Color(0,175,255),Color.yellow,new Color(150,210,80)};
    
    public Mapa(String dir){
        map = ar.leerArchivo(dir);
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
                //grid[i][j].addMouseListener(new java.awt.event.MouseAdapter() );
                mapa.add(grid[i][j]);
            }
            System.out.println();
        }
        mapa.updateUI();
        return grid;
    }
    
    
}
