// This class represents one blackjack player (or the dealer)
public class Player
{
	private String playerName;
	private boolean isDelaer;
	private Hand hand;
	
	// This constructor creates a player.
	// If isDealer is true, this Player object represents the dealer.
	public Player(String playerName, boolean isDealer)
	{
		this.playerName = playerName;
		this.isDelaer = isDealer;
	}

	// This method retrieves the player's name.
	public String getName()
	{
		return this.playerName; // replace this line with your code
	}

	// This method retrieves the player's hand of cards.
	public Hand getHand()
	{
		return this.hand;
		// replace this line with your code
	}
	
	// This method deals two cards to the player (one face down if this is the dealer).
	// The window input should be used to redraw the window whenever a card is dealt.
	public void startRound(Deck deck, BlackjackWindow window)
	{
		if (isDelaer = true){
			Card one = deck.drawCard();
			one.turnFaceUp();
			window.redraw();
			Card two = deck.drawCard();
			two.turnFaceDown();
			window.redraw();
		}else{
			Card one = deck.drawCard();
			one.turnFaceUp();
			window.redraw();
			Card two = deck.drawCard();
			two.turnFaceUp();
			window.redraw();
		}
		
	}

	// This method executes gameplay for one player.
	// If this player is the dealer:
	//	- hits until score is at least 17
	// If this is an ordinary player:
	//	- repeatedly asks the user if they want to hit (draw another card)
	//	  until either the player wants to stand (not take any more cards) or
	//	  his/her score exceeds 21 (busts).
	// The window input should be used to redraw the window whenever a card is dealt or turned over.
	public void playRound(Deck deck, BlackjackWindow window)
	{
		if(isDelaer = true ){
			while (hand.getScore() < 17){
				Card newcard = deck.drawCard();
				hand.addCard(newcard);
				window.redraw();
			}
		} else{
			boolean hitorstand = GIO.readBoolean(playerName + ", are you going to hit or stand?");
			
				while (hitorstand != true){
					Card newcard = deck.drawCard();
					hand.addCard(newcard);
					window.redraw();
				
					if (hand.getScore() < 21){
						hitorstand = GIO.readBoolean("are you going to hit or stand?");
					} else if (hand.getScore() > 21){
						GIO.displayMessage(playerName + " busted. You lose this round");	
						window.redraw();
						break;
					}
				}
		}
	}

	// This method informs the player about whether they won, lost, or pushed.
	// It also discards the player's cards to prepare for the next round.
	// The window input should be used to redraw the window after cards are discarded.
	public void finishRound(int dealerScore, BlackjackWindow window){
		if (isDelaer == false)
		{
			if (hand.getScore() > 21)
				GIO.displayMessage(playerName + ", you have lost.");
				
			else if ((dealerScore > 21) || (hand.getScore() > dealerScore))
				GIO.displayMessage(playerName + ", you have won!");
			
			else if (hand.getScore() == dealerScore)
				GIO.displayMessage(playerName + ", you have pushed.");
		}
		
		hand.discardAll();
		window.redraw();
		
		
	}	
		
}
