// This class represents one playing card.
public class Card
{
	// Card suits (provided for your convenience - use is optional)
	public static final int SPADES   = 0;
	public static final int HEARTS   = 1;
	public static final int CLUBS    = 2;
	public static final int DIAMONDS = 3;

	// Card faces (provided for your convenience - use is optional)
	public static final int ACE      = 1;
	public static final int TWO      = 2;
	public static final int THREE    = 3;
	public static final int FOUR     = 4;
	public static final int FIVE     = 5;
	public static final int SIX      = 6;
	public static final int SEVEN    = 7;
	public static final int EIGHT    = 8;
	public static final int NINE     = 9;
	public static final int TEN      = 10;
	public static final int JACK     = 11;
	public static final int QUEEN    = 12;
	public static final int KING     = 13;


	private int suit;
	private int face;
	private boolean faceup;
	

	// This constructor builds a card with the given suit and face, turned face down.
	public Card(int cardSuit, int cardFace)
	{
		this.suit = cardSuit;
		this.face = cardFace;
		this.faceup = false;
	}

	// This method retrieves the suit (spades, hearts, etc.) of this card.
	public int getSuit()
	{
		return this.suit;
	}
	
	// This method retrieves the face (ace through king) of this card.
	public int getFace()
	{
		return this.face; // replace this line with your code
	}
	
	// This method retrieves the numerical value of this card
	// (usually same as card face, except 1 for ace and 10 for jack/queen/king)
	public int getValue()
	{
		int value;
		if (face == 11 || face == 12 || face == 13){
			value = 10;
		}else if (face ==1){
			value = 1;
		} else {
			value = face;
		}
		return value; // replace this line with your code
	}

	// This method determines whether the front of the card should be visible.
	public boolean isFaceUp()
	{
		return this.faceup;  // replace this line with your code
	}

	// This method records that the front of the card should be visible.
	public void turnFaceUp()
	{
		this.faceup = true;
	}
	
	// This method records that only the back of the card should be visible.
	public void turnFaceDown()
	{
		this.faceup = false;
	}
}
