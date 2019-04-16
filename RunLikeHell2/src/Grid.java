
public class Grid {
	final int multiplier = 3;
	int passCell;
	int mapCell;
	Cell[] passable;
	Cell[][] map;

	public Grid(int size) {
		mapCell = 5 + 2 * size;
		passCell = (multiplier + size) * (7 + 3 * size);
		passable = new Cell[passCell];
		map = new Cell[mapCell][mapCell];
		int n = 0;
		for (int i = 0; i < mapCell; i++) {
			for (int j = 0; j < mapCell; j++) {
				if ((i % 2 == 0) || (j % 2 == 0 && i % 2 != 0)) {
					map[i][j] = new Cell(i, j);
					passable[n++] = map[i][j];
				}
			}
		}
	}
	
	public Cell[] getPassable() {
		return passable;
	}
	
	public Cell[][] getMap() {
		return map;
	}
	
	public Cell getCell(int X, int Y)
	{
		return map[Y][X];
	}
	
	public Cell getCell(Cell cell,char direction) {
		if (direction == ' ') return cell;
		   if (direction == 'U')
		   {
			   if (cell.getX() % multiplier == 0 && cell.getY() >0)
			      return map[cell.getY()-1][cell.getX()];
			   return cell;
		   }
		   else if (direction == 'D')
		   {
			   if (cell.getX() % multiplier == 0 && cell.getY() < mapCell)
			      return map[cell.getY()+1][cell.getX()];
			   return cell;
		   }
		   else if (direction == 'L')
		   {
			   if (cell.getY() % multiplier == 0 && cell.getX() >0)
			      return map[cell.getY()][cell.getX()-1];
			   return cell;
		   }
		   else if (direction == 'R')
		   {
			   if (cell.getY() % multiplier == 0 && cell.getX() < mapCell)
			      return map[cell.getY()][cell.getX()+1];
			   return cell;
		   }
		   return null;
	}
	
	public char chasingStrategy(Cell from,Cell to) {
		if (from.getY() == to.getY())
	    {
			if (from.getX() < to.getX())
				return 'R';
			else if (from.getX() > to.getX())
		        return 'L';
			else if (from.getY() > 0)
				return 'U';
			else
				return 'D';
	    }
		else if (from.getX() == to.getX())
		{
			if (from.getY() < to.getY())
				return 'D';
			else if (from.getY() > to.getY())
		        return 'U';
			else if (from.getY() > 0)
				return 'L';
			else
				return 'R';
		}
		return ' ';
	}
}
