// This is the main program for the blackjack game.
public class Blackjack
{
	// This method should:
	//	- Ask the user how many people want to play (up to 3, not including the dealer).
	//	- Create an array of players.
	//	- Create a Blackjack window.
	// 	- Play rounds until the players want to quit the game.
	//	- Close the window.
	public static void main(String[] args)
	{
		int playersnum = 0;
		
		
		System.out.println("Welcome to blackjack program" + "\n");
		playersnum = GIO.readInt("How many players are going to play?");
		
		while (playersnum < 0 || playersnum > 4){
			GIO.displayMessage("number of player should more than 0, less than 4");
			playersnum = GIO.readInt("How many players are going to play?");
		}
		
		String[] playername = new String [playersnum+1];
		boolean[] isdealer = new boolean [playersnum+1];
		Player[] players = new Player [playersnum+1];
		
		
		playername[0] = "Dealer";
		isdealer[0] = true;
		
		for (int i = 1; i < playersnum+1; i++)
		{
			String a = GIO.readString("What is this player's name?");
			playername[i] = a;
			isdealer[i] = false;
		}
		
		
		for (int i = 0; i < playersnum+1; i++)
		{
			players[i] = new Player(playername[i], isdealer[i]);
		}
		
		BlackjackWindow window = new BlackjackWindow(players);
		window.redraw();
		
		int count =0;
		do{
			playRound(players, window);
			
			boolean moreround = GIO.readBoolean("do you want to play more round?");
			if (moreround == true){
				count ++;
			}
		}while (count == playersnum);
		
		window.close();
		return;
		
		
	}

	// This method executes an single round of play (for all players).  It should:
	//	- Create and shuffle a deck of cards.
	//	- Start the round (deal cards) for each player, then the dealer.
	//	- Allow each player to play, then the dealer.
	//	- Finish the round (announce results) for each player.
	public static void playRound(Player[] players, BlackjackWindow window)
	{
		Deck myDeck = new Deck();
		myDeck.shuffle();
		
		for (int i = 1; i< players.length; i++){
			players[i].startRound(myDeck, window);
		}
		
		players[0].startRound(myDeck, window);
		
		for (int i = 1; i < players.length; i++)
		{
			players[i].playRound(myDeck, window);
		}
		
		players[0].playRound(myDeck, window);
		
		for (int i = 1; i < players.length; i++)
		{
			players[i].finishRound(players[0].getHand().getScore(), window);
		}
		
		players[0].finishRound(players[0].getHand().getScore(), window);


		
	}
}
