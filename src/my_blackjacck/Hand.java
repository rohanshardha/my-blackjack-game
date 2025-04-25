package my_blackjacck;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> handCards = new ArrayList<>();

    private int calculateHandValue() {
        int total = 0;
        int aceCount = 0;
        for (Card card : handCards) {
            total += (card.getCardValue() > 10) ? 10 : card.getCardValue();
            if (card.getCardValue() == 1) {
                aceCount++;
            }
        }
        // Promoting an ace to an 11 if needed
        if (aceCount >= 1 & total <= 11) {
            total+=10;
        }
        return total;
    }

    public boolean handIsBusted() {
        return calculateHandValue() > 21;
    }

    public int getHandValue() {
        return calculateHandValue();
    }
    

    @Override
    public String toString() {
        String output = "Hand Cards:\n";
        for (Card card : handCards) {
            output += card + "\n"; // Each card already prints nicely
        }
        output += "Hand value: " + calculateHandValue();
        return output;
    }

    public ArrayList<Card> getHandCards() {
        return handCards;
    }
}
