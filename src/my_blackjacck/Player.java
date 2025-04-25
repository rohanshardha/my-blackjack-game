package my_blackjacck;

class Player {
    private String name;
    private Hand hand;
    private int potValue;

    public Player(String name, int potValue) {
        this.name = name;
        this.potValue = potValue;
        this.hand = new Hand();
    }

    boolean computerAI() {
        int computerHandValue = hand.getHandValue();

        if (computerHandValue < 16) {
            return true;
        } else if (computerHandValue>= 16 && computerHandValue <= 18) {
            return Math.random() < 0.3; // 30% chance of computer taking a new card 
        } else {
            return false;
        }
    }    

    // Getters, Setters and toString
    public String getName() {
        return name;
    }

    public int getPotValue() {
        return potValue;
    }
    

    public void setPotValue(int potValue) {
        this.potValue = potValue;
    }
    public Hand getHand() {
        return hand;
    }

    

    @Override
    public String toString() {
        return name + " is playing with $" + potValue + "\n" + hand;
    }

    
}
