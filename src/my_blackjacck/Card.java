package my_blackjacck;

class Card {
    private String suit;  //{"Hearts", "Diamonds", "Spades", "Clubs"}
    private int cardValue;  // 1-13 corresponding to Ace, 2-10, Jack(11), Queen(12), King(13)

    // Default constructor
    public Card(String suit, int cardValue) {
        this.suit = suit;
        this.cardValue = cardValue;
    }



    public int getCardValue() {
        return cardValue;
    }


    @Override
    public String toString() {
        return cardValue + " of " + suit;
    }
    
}