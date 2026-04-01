import java.util.Scanner;

public class DeckOfCards {

    // Method to initialize the deck with suits and ranks
    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index] = rank + " of " + suit;
                index++;
            }
        }
        return deck;
    }

    // Method to shuffle the deck using the swap logic
    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            // Generate a random index between i and n-1
            int randomCardNumber = i + (int) (Math.random() * (n - i));

            // Swap current card with the random card
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    // Method to distribute n cards to x players
    public static String[][] distributeCards(String[] deck, int numPlayers, int cardsPerPlayer) {
        if (numPlayers * cardsPerPlayer > deck.length) {
            System.out.println("Error: Not enough cards in the deck!");
            return null;
        }

        String[][] players = new String[numPlayers][cardsPerPlayer];
        int deckIndex = 0;

        for (int p = 0; p < numPlayers; p++) {
            for (int c = 0; c < cardsPerPlayer; c++) {
                players[p][c] = deck[deckIndex++];
            }
        }
        return players;
    }

    // Method to print the players and their cards
    public static void displayHands(String[][] players) {
        if (players == null) return;

        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + "'s Hand:");
            System.out.println("-------------------------");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("- " + players[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialization
        String[] myDeck = initializeDeck();
        System.out.println("Deck initialized with " + myDeck.length + " cards.");

        // Shuffle
        myDeck = shuffleDeck(myDeck);
        System.out.println("Deck shuffled successfully.");

        // Distribution Input
        System.out.print("Enter number of players: ");
        int x = sc.nextInt();
        System.out.print("Enter number of cards per player: ");
        int n = sc.nextInt();

        // Process and Display
        String[][] playerHands = distributeCards(myDeck, x, n);
        displayHands(playerHands);

        sc.close();
    }
}