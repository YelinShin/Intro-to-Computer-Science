import java.util.Random;

// This class represents the deck of cards from which cards are dealt to players.
public class Deck
{
	public Card[] deck;
	public int cardsUsed;
	
	// This constructor builds a deck of 52 cards.
	public Deck()
	{
		deck = new Card[52];
		int k=0;
		for ( int cardSuit =0; cardSuit <= 3; cardSuit ++){
			for (int cardFace =1; cardFace <= 13; cardFace ++){
				deck[k] = new Card(cardSuit, cardFace);
				k++;
			}
		}
		cardsUsed = 0;
	}

	// This method shuffles the deck (randomizes the array of cards).
	// Hint: loop over the cards and swap each one with another card in a random position.
	public void shuffle()
	{
		Random shuffle = new Random();
		
		for (int i = 51; i > 0; i--){
		      int randomInt = shuffle.nextInt(i+1);
		      Card temp = deck[i];
		      deck[i] = deck [randomInt];
		      deck[randomInt] =temp;
		    }
		cardsUsed=0;
	}
	
	// This method takes the top card off the deck and returns it.
	public Card drawCard()
	{
		if (cardsUsed == deck.length){
			shuffle();
			cardsUsed ++;
			return deck[cardsUsed -1];
		} else {
			cardsUsed ++;
			return deck[cardsUsed -1];
		}
	}
	
	// This method returns the number of cards left in the deck.
	public int getSize()
	{
		int size = 52 - cardsUsed;
		return size; // replace this line with your code
	}
}

