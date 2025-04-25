package my_blackjacck;

import java.util.Scanner;

class Blackjack {
    static int totalGames = 0;
    static int wins = 0;
    public static void main(String[] args) {

        Blackjack controller = new Blackjack();
        controller.playBlackJack();
    }

    void playBlackJack() {
        Scanner scanner = new Scanner(System.in);


        // Taking player details
        System.out.print("What is your name?\n");
        String playerName = scanner.nextLine();

        System.out.print("How much money do you want to start with?\n");
        int playerPot = scanner.nextInt();
        scanner.nextLine(); // Removing return character from buffer

        // Initializing player and computer
        Player player = new Player(playerName, playerPot);
        Player computer = new Player("Computer", playerPot);

        // Controller for another round or quit
        String anotherRound;
        

        do {

            int bet = 0;
            int attempts = 0;

            // Ask player to place a valid bet (max 3 attempts for placing a valid bat or the program will terminate)
            while (attempts < 3) {
                System.out.println("You have $" + player.getPotValue());
                System.out.print("How much do you want to  bet (minimum $10): $");
                bet = scanner.nextInt();
                scanner.nextLine(); // Remove return character from buffer

                if (bet >= 10 && bet <= player.getPotValue()) {
                    break;
                } else {
                    System.out.println("Invalid bet. Please enter a value between $10 and $" + player.getPotValue());
                    attempts++;
                }
            }

            if (attempts == 3) {
                System.out.println("Sorry! You are not ready to play!");
                return;
            }

            // Creating and populating deck
            Deck deck = new Deck();

            // Reset hands
            player.getHand().getHandCards().clear();
            computer.getHand().getHandCards().clear();

            // Dealing initial cards
            deck.deal(player);
            deck.deal(player);
            deck.deal(computer);
            deck.deal(computer);

            System.out.println(player.getName() + " Your " + player.getHand());

            // Player's turn
            System.out.print("Do you want another card? ");
            String hitMe = scanner.nextLine();
            while (hitMe.equalsIgnoreCase("yes")) {
                deck.deal(player);
                System.out.println(player.getHand());
                if (player.getHand().handIsBusted()) {
                    System.out.println("You are busted! You lost!");
                    player.setPotValue(player.getPotValue() - bet);
                    break;
                }
                System.out.print("Do you want another card? ");
                hitMe = scanner.nextLine();
            }

            // Computer's turn if player hasn't busted
            if (!player.getHand().handIsBusted()) {
                while (computer.computerAI()) {
                    deck.deal(computer);
                    System.out.println("Dealer requested a card");
                    if (computer.getHand().handIsBusted()) {
                        System.out.println("Dealer's " + computer.getHand());
                        System.out.println("Congrats! You won!");
                        wins++;
                        player.setPotValue(player.getPotValue() + bet);
                        break;
                    }
                }

                // Score comparison if neither busted
                if (!computer.getHand().handIsBusted()) {
                    System.out.println("Dealer's " + computer.getHand());
                    int playerScore = player.getHand().getHandValue();
                    int computerScore = computer.getHand().getHandValue();

                    System.out.println("Final scores:");
                    System.out.println(player.getName() + ": " + playerScore);
                    System.out.println("Computer: " + computerScore);

                    if (playerScore > computerScore) {
                        System.out.println("Congrats! You win!");
                        wins++;
                        player.setPotValue(player.getPotValue() + bet);
                    } else if (computerScore > playerScore) {
                        System.out.println("Oh no! You lost!");
                        player.setPotValue(player.getPotValue() - bet);
                    } else {
                        System.out.println("It's a tie!");
                        // pot unchanged
                    }
                }
            }

            totalGames++;
            // Check if player wants to continue
            if (player.getPotValue() <= 10) {
                System.out.println("You're out of money. Game over!");
                break;
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            anotherRound = scanner.nextLine();

        } while (anotherRound.equalsIgnoreCase("yes")&& player.getPotValue() >= 10);

        System.out.println("Thanks for playing, " + player.getName() + "! You won " + wins + " out of " + totalGames + " games and you are leaving with $" + player.getPotValue() + "!");
        scanner.close();
        

    }
}
