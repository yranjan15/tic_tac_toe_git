import java.util.Scanner;

public class Tictactoe {

	public static void main(String [] args)
	{
		Player player1;
		Player player2;
		Board game;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter symbol for player 1");
		String symbol = input.next();
		
		while(!symbol.equals("x") && !symbol.equals("o"))
		{
			System.out.println("Player 1 chose an invalid symbol. Enter a valid symbol");
			symbol = input.next();
		}
		
		player1 = new Player(symbol);
		
		if(symbol.equals("x"))
		{
			symbol = "o";
		}
		
		else
		{
			symbol = "x";
		}
		
		player2 = new Player(symbol);
		game = new Board();
		game.printBoard();
		while((Board.move_counter < 5) || !game.checkWin())
		{
			//player 1 turn
			if((Board.move_counter%2) == 0)
			{
				System.out.println("Enter a move player 1");
				System.out.println("Row T-top C-center B-bottom");
				System.out.println("Column L-left M-middle R-right");
				
				String move = input.next();
				
				while(!player1.playerMove(move, game))
				{
					System.out.println("Enter a valid move player 1");
					System.out.println("Row T-top C-center B-bottom");
					System.out.println("Column L-left M-middle R-right");
					
					move = input.next();
				}
			}
			
			else
			{
				System.out.println("Enter a move player 2");
				System.out.println("Row T-top C-center B-bottom");
				System.out.println("Column L-left M-middle R-right");
				
				String move = input.next();
				
				while(!player2.playerMove(move, game))
				{
					System.out.println("Enter a valid move player 2");
					System.out.println("Row T-top C-center B-bottom");
					System.out.println("Column L-left M-middle R-right");
					
					move = input.next();
				}
			}
			
			//print board after making move
			game.printBoard();
			
			//no more moves are allowed in the game
			if(Board.move_counter == 9)
			{
				break;
			}
		}
		
		if(game.checkWin())
		{
			String win = game.getWinsymbol();
			
			if(win.equals(player1.getSymbol()))
			{
				System.out.println("Player 1 wins");
			}
			
			else
			{
				System.out.println("Player 2 wins");
			}
		}
		
		else
		{
			System.out.println("Game is a Draw!");
		}
			
	}
}
