import java.util.ArrayList;
public class Hand
{
	public ArrayList<Card> hand;// define fields here

	// This constructor builds a hand (with no cards, initially).
	public Hand()
	{
		hand = new ArrayList<Card>();
	}
	
	// This method retrieves the size of this hand.
	public int getNumberOfCards()
	{
		return hand.size();
		 // replace this line with your code
	}

	// This method retrieves a particular card in this hand.  The card number is zero-based.
	public Card getCard(int index)
	{
		return hand.get(index); // replace this line with your code
	}

	// This method takes a card and places it into this hand.
	public void addCard(Card newcard)
	{
		hand.add(newcard);
	}

	// This method computes the score of this hand.
	public int getScore()
	{
		int sum =0;
		for(int i=0; i<hand.size(); i++){
			sum += hand.get(i).getValue();
		}
		return sum; // replace this line with your code
	}

	// This methods discards all cards in this hand.
	public void discardAll()
	{
		hand.clear();
	}
}
