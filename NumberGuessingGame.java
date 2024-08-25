import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private int score = 0;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.startGame();
    }

    public void startGame() {
        System.out.println("Welcome to the Number Guessing Game!");
        
        boolean playAgain = true;

        while (playAgain) {
            playRound();

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thank you for playing! Your final score is: " + score);
    }

    private void playRound() {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; // Generates a random number between 1 and 100
        int attempts = 0;
        int maxAttempts = 7; // Limiting the number of attempts
        boolean hasGuessedCorrectly = false;

        System.out.println("I have generated a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

        while (attempts < maxAttempts && !hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Your guess is too low.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Your guess is too high.");
            } else {
                System.out.println("Congratulations! You guessed the correct number.");
                hasGuessedCorrectly = true;
                score++;
            }

            if (!hasGuessedCorrectly && attempts < maxAttempts) {
                System.out.println("You have " + (maxAttempts - attempts) + " attempts left.");
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
        }

        System.out.println("Your current score is: " + score);
    }
}
