/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesamiento;

/**
 *
 * @author Luis
 */
public class Punto {
    public int x;
    public int y;
    private int f=0;
    
    public Punto(){
        f = 0;
    }
    
    public Punto(int x, int y){
        this.x = x;
        this.y = y;
        f = 0;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }
}
