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
    //atributos
   int numberOfSquares;
   private  Cell[][] celulas;
   private boolean correr=false;
   private int count=0;
    
  public Simulator(int numberOfSquares){
      this.numberOfSquares = numberOfSquares;
      this.celulas=new Cell[numberOfSquares][numberOfSquares]; 
      for (int i=0;i<this.numberOfSquares;i++){
         
         for(int j=0;j<this.numberOfSquares;j++){
         celulas[i][j]=new Cell(false);
         }
      }
      
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
  
          if (i >= 0 && i < this.numberOfSquares && j >= 0 && j < this.numberOfSquares )
              return this.celulas[i][j]; 
          
            else return null;
    }
    public int  getNumberOfSquares(){
       
        return this.numberOfSquares;
    }
    
    public void randomGridCell(){
        double n = Math.random();

      
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
    public void update() {
       
          Cell[][] nuevacelula = new Cell[this.numberOfSquares][numberOfSquares];
      if (this.correr) {
         ++this.count;

         for(int i = 0; i < this.celulas.length; ++i) {
            for(int j = 0; j < this.celulas.length; ++j) {
               Cell celulaactual = this.celulas[i][j];
               boolean vivir = this.stayAlive(celulaactual.isAlive(), i, j);
               nuevacelula[i][j] = new Cell(vivir);
            }
         }

         this.celulas = nuevacelula;}}
        
     
    int countAliveNeigbors(int x, int y){
        int vecinos=0;
        for(int i = -1; i < 2; ++i) {
         if (this.isCellAlive(x + i, y - 1)) {
            ++vecinos;
         }

         if (this.isCellAlive(x + i, y + 1)) {
            ++vecinos;
         }
      }

      if (this.isCellAlive(x + 1, y)) {
         ++vecinos;
      }

      if (this.isCellAlive(x - 1, y)) {
         ++vecinos;
      }

      return vecinos;
    }
    boolean  stayAlive(boolean isAlive, int x, int y){
      
      int count = this.countAliveNeigbors(x, y);
      if (isAlive) {
         if (count == 2 || count == 3) {
            return true;
         }
      } else if (count == 3) {
         return true;
      }
            
        return false;
    }
    
    
    
    boolean isCellAlive(int x, int y){
                    //TODO implement me
                    Cell c = this.getCell(x, y);
      return c != null && c.isAlive();
    }

    void resetAll() {
         for (int i=0;i<this.celulas.length;i++){
         
         for(int j=0;j<this.celulas.length;j++){
         this.celulas[i][j].setState(false);
         }
         }
    }
    public int getCountIteration(){
        
        return count;
    }
}
