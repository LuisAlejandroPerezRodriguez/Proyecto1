/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

/**
 *
 * @author luisa
 */
public class Simulator {
        //TODO implement me
    
    
    public boolean isRunning(){
        //TODO implement me
        return false;
    }
    
    public void setRunning(){
        //TODO implement me
    }
    
     public void resetRunning(){
        //TODO implement me
    }
    
    public Cell getCell(int i, int j){
       //TODO implement me
        return null;
    }
    public int  getNumberOfSquares(){
        //TODO implement me
        return 0;
    }
    
    public void randomGridCell(){
        double n = Math.random();
        //TODO implement me
    }

    void setCellState(int i, int j) {
        
       //TODO implement me
    }
//If the cell is alive in the current time step: If the cell has 2 or 3 living neighbors, then the cell 
 //       remains alive in the next time step; otherwise, it dies.
    //(A living cell dies of loneliness if it has 0 or 1 living neighbor, and of overcrowding if it has more than 3 living neighbors.)
//If the cell is dead in the current time step: If the cell has 3 living neighbors, 
    //then the cell becomes alive in the next time step; otherwise, it remains dead. 
    //(Three living cells give birth to a new living cell.)
    void update() {
       //TODO implement me
    }
    int countAliveNeigbors(int x, int y){
        //TODO implement me
          return 0;
    }
    boolean  stayAlive(boolean isAlive, int x, int y){
      
       //TODO implement me
         
        
        return false;
    }
    boolean isCellAlive(int x, int y){
                    //TODO implement me
                    return false;
    }

    void resetAll() {
         //TODO implement me
    }
    public int getCountIteration(){
        //TODO implement me
        return 0;
    }
}
