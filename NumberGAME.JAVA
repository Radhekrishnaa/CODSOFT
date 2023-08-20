import java.util.Random;
import java.util.Scanner;

public class EnhancedNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int score = 0;
        
        boolean playAgain = true;
        
        System.out.println("Welcome to the Enhanced Number Guessing Game!");
        
        while (playAgain) {
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int numberOfAttempts = 0;
            boolean hasGuessedCorrectly = false;
            
            System.out.println("I've chosen a number between " + lowerBound + " and " + upperBound + ".");
            
            while (!hasGuessedCorrectly && numberOfAttempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;
                
                if (userGuess == numberToGuess) {
                    hasGuessedCorrectly = true;
                    score += maxAttempts - numberOfAttempts + 1;
                    System.out.println("Congratulations! You've guessed the number in " + numberOfAttempts + " attempts.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }
            }
            
            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + ".");
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }
        
        System.out.println("Game over! Your total score is: " + score);
        scanner.close();
    }
}

