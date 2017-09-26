public class Player
{
	private String symbol;
	
	public Player(String s)
	{
		symbol = s;
	}
	
	public String getSymbol()
	{
		return symbol;
	}
	
	public boolean playerMove(String move, Board b)
	{
		if(move.length() != 2)
		{
			return false;
		}
		
		String l1 = move.substring(0,1);
		String l2 = move.substring(1,2);
		
		if(!l1.equals("C") && !l1.equals("T") && !l1.equals("B"))
		{
			return false;
		}
		
		if(!l2.equals("L") && !l2.equals("M") && !l2.equals("R"))
		{
			return false;
		}
		
		boolean result;
		
		result = b.makeMove(move, symbol);
		
		return result;
	}
}