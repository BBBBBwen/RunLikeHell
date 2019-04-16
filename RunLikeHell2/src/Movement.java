public abstract class Movement {
   protected char currentDirection;  
   protected Cell currentCell;
   protected Grid grid;
   
   public Movement(Grid grid)
   {
	   this.grid = grid;
   }
   public abstract Cell move();
   public void setKey(char d)
   {
	   currentDirection = d;
   }
   public char getKey()
   {
      return currentDirection;	    
   }
   public void setCell(Cell c)
   {
	   currentCell = c;
   }
   public Cell getCell()
   {
      return currentCell;	    
   }
}
