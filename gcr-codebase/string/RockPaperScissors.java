import java.util.Scanner;

public class RockPaperScissors {
    //get computer choice using random
    public static String getComputerChoice() {
        int rand = (int)(Math.random() * 3);
        if (rand == 0) return "Rock";
        else if (rand == 1) return "Paper";
        return "Scissors";
    }
    // finding winner btw player & computer
    public static String determineWinner(String player, String computer) {
        if (player.equals(computer)) return "Tie";

        if ((player.equals("Rock") && computer.equals("Scissors")) ||
                (player.equals("Paper") && computer.equals("Rock")) ||
                (player.equals("Scissors") && computer.equals("Paper"))) {
            return "Player";
        }
        return "Computer";
    }
    // finding winning stats of player & computer
    public static String[][] calculateWinStats(int playerWins, int computerWins, int totalGames) {
        String[][] stats = new String[3][2];

        double playerPct = totalGames > 0 ? (playerWins * 100.0 / totalGames) : 0;
        double compPct = totalGames > 0 ? (computerWins * 100.0 / totalGames) : 0;

        stats[0][0] = "Player Wins"; stats[0][1] = String.valueOf(playerWins);
        stats[1][0] = "Computer Wins"; stats[1][1] = String.valueOf(computerWins);
        stats[2][0] = "Win Percentage";
        stats[2][1] = String.format("%.1f%% / %.1f%%", playerPct, compPct);

        return stats;
    }
    // displaying the results
    public static void displayAllResults(String[][] gameLog, String[][] stats) {
        System.out.println("\n=== Game Results ===");
        System.out.println("Game\tPlayer\tComputer\tWinner");
        System.out.println("----\t------\t--------\t------");

        for (int i = 0; i < gameLog.length; i++) {
            System.out.println((i+1) + "\t" + gameLog[i][0] + "\t" +
                    gameLog[i][1] + "\t" + gameLog[i][2]);
        }

        System.out.println("\n=== Win Statistics ===");
        System.out.println("Category\t\tValue");
        System.out.println("--------\t\t-----");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int numGames = sc.nextInt();

        String[][] gameResults = new String[numGames][3];
        int playerWins = 0, computerWins = 0;

        for (int i = 0; i < numGames; i++) {
            System.out.print("Game " + (i+1) + " - Choose (Rock/Paper/Scissors): ");
            String playerChoice = sc.next();
            String computerChoice = getComputerChoice();

            String winner = determineWinner(playerChoice, computerChoice);

            gameResults[i][0] = playerChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;

            if (winner.equals("Player")) playerWins++;
            else if (winner.equals("Computer")) computerWins++;

            System.out.println("Computer: " + computerChoice);
            System.out.println("Result: " + winner + "\n");
        }

        String[][] finalStats = calculateWinStats(playerWins, computerWins, numGames);
        displayAllResults(gameResults, finalStats);

        sc.close();
    }
}
