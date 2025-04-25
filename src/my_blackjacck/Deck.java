package my_blackjacck;

import java.util.ArrayList;

class Deck {
    private Card[] deckCards = new Card[52];
    private ArrayList<Integer> usedCards = new ArrayList<>();
    public Deck() {
        populateDeck();
    }

    // Populates the deck with 52 unique cards
    void populateDeck() {
        String[] deckSuits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        int deckIndex = 0;
        for (String suit : deckSuits) {
            for (int numCard = 1; numCard <= 13; numCard++) {
                deckCards[deckIndex] = new Card(suit, numCard);
                deckIndex++;
            }
        }
    }

    // Deals a card to the given player
    void deal(Player player) {
        // This is an example of tight coupling 
        // Ttry to make this method more frlexible by just returning a card object and then add it to player's hand

        int dealtCardIndex;

        // Keep generating random indexes until we find one that hasn't been used
        do {
            dealtCardIndex = (int)(Math.random() * 52); // 0 to 51
        } while (usedCards.contains(dealtCardIndex));

        // Retrieve the card from the deck
        Card dealtCard = deckCards[dealtCardIndex];

        // Add it to the player's hand
        player.getHand().getHandCards().add(dealtCard);

        // Track the card as used
        usedCards.add(dealtCardIndex);
        
    }

}
