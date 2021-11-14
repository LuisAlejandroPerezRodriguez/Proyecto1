
package gameoflife;

import java.awt.Color;

public class Cell {
    
    private boolean celula; //atributos
    
    public Cell(boolean state){
        this.celula=state;
    }
    
    public boolean isAlive(){
        return celula;
    }
    
    public void setState(boolean state){
        celula=state;   
    } 
    
    public Color getColor(){ 
       if(celula==true)
           return Color.GREEN;
       else 
           return Color.black;
    }
    
}
