/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesamiento;

import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Luis Hernandez
 */
public class AEstrella extends Thread{
    Punto ini;
    Punto fin;
    Personaje p;
    Mapa m;
    JTextField txtPuntos;
    ScrollPane spArbol;
    JPanel panel;
    ArrayList<Punto> open;
    ArrayList<Punto> closed;
    Punto pt;
    DefaultMutableTreeNode dm;
    
    public AEstrella    (Punto ini, Punto fin, Personaje p, Mapa m, JTextField txtPuntos,
                        ScrollPane spArbol, JPanel panel){
        this.ini=ini;
        this.fin=fin;
        this.p=p;
        this.m=m;
        this.txtPuntos=txtPuntos;
        this.spArbol=spArbol;
        this.panel=panel;
        open = new ArrayList<Punto>();
        closed = new ArrayList<Punto>();
        open.add(ini);
        pt=new Punto();
        dm = new DefaultMutableTreeNode("Camino:");
    }
    
    @Override
    public void run(){
        while(true){
            int index = min(open);
            pt = open.get(index);
            open.remove(index);
            JLabel jl = m.getEtiqueta(pt.y, pt.x, panel);
            if(jl.getText().contains(" ")){
                jl.setText(jl.getText().replace(" ", "o"));
            }else if(jl.getText().contains("o")){
                // Do nothing
            }else{
                jl.setText(jl.getText()+"o");
            }
            panel.updateUI();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(AEstrella.class.getName()).log(Level.SEVERE, null, ex);
            }
            p.setPuntos(p.getPuntos()+p.getCostoOf(m.getMap().get(pt.y).get(pt.x)));
            txtPuntos.setText(p.getPuntos()+"");
            DefaultMutableTreeNode padre=new DefaultMutableTreeNode();
            DefaultMutableTreeNode aux = arbolSearch(dm,new DefaultMutableTreeNode(pt.x+","+pt.y).getUserObject().toString());
            if (aux!=null){
                padre=aux;
            }else{
                padre=new DefaultMutableTreeNode(pt.x+","+pt.y);
                dm.add(padre);
            }
            // Arriba
            if (pt.y>0){
                Punto up = new Punto(pt.x,pt.y-1);
                if (p.validar(m.getMap().get(up.y).get(up.x))==true){
                    DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(up.x+","+up.y);
                    padre.add(hijo);
                    up.setF(p.getCostoOf(m.getMap().get(up.y).get(up.x))+distancia(up));
                    if (up.x == fin.x && up.y == fin.y){
                        closed.add(up);
                        jl = m.getEtiqueta(up.y, up.x, panel);
                        jl.setText(jl.getText()+"o");
                        p.setPuntos(p.getPuntos()+p.getCostoOf(m.getMap().get(up.y).get(up.x)));
                        txtPuntos.setText(p.getPuntos()+"");
                        this.stop();
                    }else if(search(open,up)!=-1 || search(closed,up)!=-1){
                        // Do Nothing/Add Sentences
                    }else{
                        open.add(up);
                    }
                }
            }
            // Abajo
            if (pt.y<m.getMap().size()-1){
                Punto down = new Punto(pt.x,pt.y+1);
                if (p.validar(m.getMap().get(down.y).get(down.x))==true){
                    DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(down.x+","+down.y);
                    padre.add(hijo);
                    down.setF(p.getCostoOf(m.getMap().get(down.y).get(down.x))+distancia(down));
                    if (down.x == fin.x && down.y == fin.y){
                        closed.add(down);
                        jl = m.getEtiqueta(down.y, down.x, panel);
                        jl.setText(jl.getText()+"o");
                        p.setPuntos(p.getPuntos()+p.getCostoOf(m.getMap().get(down.y).get(down.x)));
                        txtPuntos.setText(p.getPuntos()+"");
                        this.stop();;
                    }else if(search(open,down)!=-1 || search(closed,down)!=-1){
                        // Do Nothing
                    }else{
                        open.add(down);
                    }
                }
            }
            // Derecha
            if (pt.x<m.getMap().get(0).size()-1){
                Punto right = new Punto(pt.x+1,pt.y);
                if (p.validar(m.getMap().get(right.y).get(right.x))==true){
                    DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(right.x+","+right.y);
                    padre.add(hijo);
                    right.setF(p.getCostoOf(m.getMap().get(right.y).get(right.x))+distancia(right));
                    if (right.x == fin.x && right.y == fin.y){
                        closed.add(right);
                        jl = m.getEtiqueta(right.y, right.x, panel);
                        jl.setText(jl.getText()+"o");
                        p.setPuntos(p.getPuntos()+p.getCostoOf(m.getMap().get(right.y).get(right.x)));
                        txtPuntos.setText(p.getPuntos()+"");
                        this.stop();
                    }else if(search(open,right)!=-1 || search(closed,right)!=-1){
                        // Do Nothing
                    }else{
                        open.add(right);
                    }
                }
            }
            // Izquierda
            if (pt.x>0){
                Punto left = new Punto(pt.x-1,pt.y);
                if (p.validar(m.getMap().get(left.y).get(left.x))==true){
                    DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(left.x+","+left.y);
                    padre.add(hijo);
                    left.setF(p.getCostoOf(m.getMap().get(left.y).get(left.x))+distancia(left));
                    if (left.x == fin.x && left.y == fin.y){
                        closed.add(left);
                        jl = m.getEtiqueta(left.y, left.x, panel);
                        jl.setText(jl.getText()+"o");
                        p.setPuntos(p.getPuntos()+p.getCostoOf(m.getMap().get(left.y).get(left.x)));
                        txtPuntos.setText(p.getPuntos()+"");
                        this.stop();
                    }else if(search(open,left)!=-1 || search(closed,left)!=-1){
                        // Do Nothing
                    }else{
                        open.add(left);
                    }
                }
            }
            closed.add(pt);
            spArbol.removeAll();
            JTree arbol = new JTree(dm);
            spArbol.add(arbol);
        }
    }
        // Camino optimo
        /*DefaultMutableTreeNode lastNode = arbolSearch(dm,fin.x+","+fin.y);
        Enumeration e = lastNode.pathFromAncestorEnumeration(dm);
        while(e.hasMoreElements()){
            DefaultMutableTreeNode d = (DefaultMutableTreeNode)e.nextElement();
            String aux = d.getUserObject().toString();
            if (aux == "Camino:"){
                // Do Nothing
            }else{
                int i=aux.indexOf(",");
                int x = Integer.parseInt(aux.substring(0, i-1));
                int y = Integer.parseInt(aux.substring(i+1, aux.length()-1));
                JLabel jl = m.getEtiqueta(y, x, panel);
                jl.setText(jl.getText().replace("o", "x"));
                panel.updateUI();
            }
        }*/
    
    public int min(ArrayList<Punto> al){
        int indice=-1;
        int minimo=999999999;
        for (int i=0; i<al.size();i++){
            if (al.get(i).getF()<minimo){
                minimo=al.get(i).getF();
                indice=i;
            }
        }
        return indice;
    }
    
    public int distancia(Punto act){
        return Math.abs(act.x-fin.x)+Math.abs(act.y+fin.y);
    }
    
    public int search(ArrayList<Punto> lista, Punto p){
        int index = -1;
        for (int i=0; i<lista.size(); i++){
            if(lista.get(i).x==p.x && lista.get(i).y==p.y){
                index=i;
            }
        }
        return index;
    }
    
    public DefaultMutableTreeNode arbolSearch(DefaultMutableTreeNode arbol, String search){
        //int index = -1;
        DefaultMutableTreeNode nodo;
        Enumeration e = arbol.breadthFirstEnumeration();
        while(e.hasMoreElements()){
            nodo = (DefaultMutableTreeNode) e.nextElement();
            if (search.equals(nodo.getUserObject().toString())){
                return nodo;
            }
        }
        return null;
    }
}
