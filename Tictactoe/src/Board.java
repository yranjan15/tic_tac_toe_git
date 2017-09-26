public class Board
{
	private String [] [] table;
	public static int move_counter = 0;
	
	//row constants
	public final static int CENTER = 2;
	public final static int TOP = 0;
	public final static int BOTTOM = 4;
	
	//column constants
	public final static int LEFT = 0;
	public final static int MIDDLE = 2;
	public final static int RIGHT = 4;
	
	public Board()
	{
		table = new String [5] [5];
		
		//add grid seperators at each column
		for(int i = 0; i < 5; i+=2)
		{
			for(int j = 0; j <5; j++) 
			{
				if((i%2) == 0)
				{
					if((j%2) == 1)
					{
						table[i][j] = "|";
					}
					
					else 
					{
						table[i][j] = " ";
					}
				}
			}
		}
		
		//add grid seperators at each row
		for(int i = 1; i < 5; i+=2)
		{
			for(int j = 0; j <5; j++) 
			{
				if((i%2) == 1)
				{
					table[i][j] = "-";
				}
				
				else 
				{
					table[i][j] = " ";
				}
			}
		}
	}
	
	public void printBoard() 
	{
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++) 
			{
				System.out.print(table[i][j]);
			}
			
			System.out.println();
		}
	}
	
	public String getWinsymbol()
	{
		//8 cases
		//check every row for a win
		for(int i = 0; i < 5; i+=2)
		{
			if(table[i][LEFT].equals(table[i][MIDDLE]))
			{
				if(table[i][MIDDLE].equals(table[i][RIGHT]))
				{
					if(!table[i][LEFT].equals(" "))
					{
						return table[i][LEFT];
					}
				}
			}
		}
		
		//check every column for a win
		for(int i = 0; i < 5; i+=2)
		{
			if(table[LEFT][i].equals(table[CENTER][i]))
			{
				if(table[CENTER][i].equals(table[BOTTOM][i]))
				{
					if(!table[LEFT][i].equals(" "))
					{
						return table[LEFT][i];
					}
				}
			}
			

		}
		
		//check first diagonal
		if(table[TOP][LEFT].equals(table[CENTER][MIDDLE]))
		{
			if(table[CENTER][MIDDLE].equals(table[BOTTOM][RIGHT]))
			{
				if(!table[TOP][LEFT].equals(" "))
				{
					return table[TOP][LEFT];
				}
			}
		}
		
		//check second diagonal
		if(table[TOP][RIGHT].equals(table[CENTER][MIDDLE]))
		{
			if(table[CENTER][MIDDLE].equals(table[BOTTOM][LEFT]))
			{
				if(!table[TOP][RIGHT].equals(" "))
				{
					return table[TOP][RIGHT];
				}
			}
		}
		
		//last case for compiler
		return "";
	}
	
	public boolean checkWin()
	{
		//8 cases
		//check every row for a win
		for(int i = 0; i < 5; i+=2)
		{
			if(table[i][LEFT].equals(table[i][MIDDLE]))
			{
				if(table[i][MIDDLE].equals(table[i][RIGHT]))
				{
					if(!table[i][LEFT].equals(" "))
					{
						return true;
					}
				}
			}
		}
		
		//check every column for a win
		for(int i = 0; i < 5; i+=2)
		{
			if(table[LEFT][i].equals(table[CENTER][i]))
			{
				if(table[CENTER][i].equals(table[BOTTOM][i]))
				{
					if(!table[LEFT][i].equals(" "))
					{
						return true;
					}
				}
			}
			

		}
		
		//check first diagonal
		if(table[TOP][LEFT].equals(table[CENTER][MIDDLE]))
		{
			if(table[CENTER][MIDDLE].equals(table[BOTTOM][RIGHT]))
			{
				if(!table[TOP][LEFT].equals(" "))
				{
					return true;
				}
			}
		}
		
		//check second diagonal
		if(table[TOP][RIGHT].equals(table[CENTER][MIDDLE]))
		{
			if(table[CENTER][MIDDLE].equals(table[BOTTOM][LEFT]))
			{
				if(!table[TOP][RIGHT].equals(" "))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	//move is a two letter symbol
	public boolean makeMove(String move, String symbol)
	{
		int r_index;
		int c_index;
		
		//set row index
		if(move.substring(0,1).equals("C"))
		{
			r_index = CENTER;
		}
		
		else if(move.substring(0,1).equals("T"))
		{
			r_index = TOP;
		}
		
		else
		{
			r_index = BOTTOM;
		}
		
		//set column index
		if(move.substring(1,2).equals("L"))
		{
			c_index = LEFT;
		}
		
		else if(move.substring(1,2).equals("M"))
		{
			c_index = MIDDLE;
		}
		
		else
		{
			c_index = RIGHT;
		}
		
		if(table[r_index][c_index].equals(" "))
		{
			table[r_index][c_index] = symbol;
			move_counter++;
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
}