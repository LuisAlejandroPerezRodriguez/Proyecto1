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

   private  Cell[][] celulas;
   private boolean correr=false;
   private int count;
    
  public Simulator(int numberOfSquares){
      celulas=new Cell[numberOfSquares][numberOfSquares]; 
      for (int i=0;i<this.celulas.length;i++){
         
         for(int j=0;i<this.celulas.length;j++){
         celulas[i][j]=new Cell(false);
         }
      }
      this.count=0;
  }    
    public boolean isRunning(){
        return correr;
    }
    
    public void setRunning(){
        this.correr=true;
    }
    
     public void resetRunning(){
        this.correr=false;
    }
    
    public Cell getCell(int i, int j){
  
        return this.celulas[i][j];
    }
    public int  getNumberOfSquares(){
       
        return this.celulas.length;
    }
    
    public void randomGridCell(){
        double n = Math.random();
        //TODO implement me
    }

    void setCellState(int i, int j) {
       this.celulas[i][j].setState(true);
       
    }
//If the cell is alive in the current time step: If the cell has 2 or 3 living neighbors, then the cell 
 //       remains alive in the next time step; otherwise, it dies.
    //(A living cell dies of loneliness if it has 0 or 1 living neighbor, and of overcrowding if it has more than 3 living neighbors.)
//If the cell is dead in the current time step: If the cell has 3 living neighbors, 
    //then the cell becomes alive in the next time step; otherwise, it remains dead. 
    //(Three living cells give birth to a new living cell.)
    void update() {
       this.count++;
       Cell[][] nuevacelula=new Cell[getNumberOfSquares()][getNumberOfSquares()];
       for (int i=0;i<this.celulas.length;i++){
         
         for(int j=0;i<this.celulas.length;j++){
         nuevacelula[i][j]=new Cell(false);
         }
      }
          for (int i=0;i<this.celulas.length;i++){
         
         for(int j=0;i<this.celulas.length;j++){
         int vecinos=countAliveNeigbors(i,j);
         if(this.celulas[i][j].isAlive() && vecinos>2 && vecinos<4){
          nuevacelula[i][j].setState(true);
         }
         else if(this.celulas[i][j].isAlive() && vecinos<2){
         nuevacelula[i][j].setState(false);
         }
         else  if(this.celulas[i][j].isAlive() && vecinos>3){
           nuevacelula[i][j].setState(false);
           }
            else if(!(this.celulas[i][j].isAlive()) && vecinos==3){
            nuevacelula[i][j].setState(true);
             }
            else {
                nuevacelula[i][j].setState(false);  
            }
         
         
         }
           }
          
         for (int i=0;i<this.celulas.length;i++){
         
         for(int j=0;i<this.celulas.length;j++){
         this.celulas[i][j]=nuevacelula[i][j];
         }
      }
        
    }
    int countAliveNeigbors(int x, int y){
        int vecinos=0;
        for (int i=x-1;i<=x+1;i++){
         
         for(int j=y-1;i<=y+1;j++){
         if(i>=0&&j>=0 &&i<=celulas.length &&j<=celulas.length  && !(i==x && j==y)&&this.celulas[i][j].isAlive() ){ vecinos++;}
         }
      }
        
          return vecinos;
    }
    boolean  stayAlive(boolean isAlive, int x, int y){
      
       //TODO implement me
         
        
        return false;
    }
    boolean isCellAlive(int x, int y){
                    //TODO implement me
                    return this.celulas[x][y].isAlive();
    }

    void resetAll() {
         for (int i=0;i<this.celulas.length;i++){
         
         for(int j=0;i<this.celulas.length;j++){
         this.celulas[i][j].setState(false);
         }
         }
    }
    public int getCountIteration(){
        
        return count;
    }
}
