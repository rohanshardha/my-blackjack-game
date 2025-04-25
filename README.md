# Java Blackjack Game 

A simple, console-based Blackjack game implemented in Java using Object-Oriented Programming principles.

## Project Structure

```
blackjack/
└── src/
    └── my_blackjack/
        ├── BlackjackController.java  // Main entry point
        ├── Player.java               // Represents a player with a name and pot
        ├── Card.java                 // Represents a single card (suit + value)
        ├── Deck.java                 // Represents the deck of 52 shuffled cards
        └── Game.java                 // Manages game logic, turns, betting, etc.
```

## Features

- Object-Oriented design with clear separation of concerns
- Simulates a full game of Blackjack between a player and a computer dealer
- Includes betting, pot management, and a game replay loop
- Clean console prompts for player interaction

## How to Run

### 1. Compile the code:

```
javac -d out src/my_blackjack/*.java
```

### 2. Run the game:

```
java -cp out my_blackjack.BlackjackController
```

Make sure you run from the blackjack root directory.

## Requirements

- Java 8 or higher
- A terminal or command line interface

## Concepts Used

- Classes and Objects
- Inheritance (if extended)
- Encapsulation
- Static variables and methods
- User input with Scanner
- Basic game loop logic