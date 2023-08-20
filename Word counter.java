import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Word Counter");
        System.out.println("1. Enter text");
        System.out.println("2. Provide a file path");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        
        scanner.nextLine(); // Consume newline
        
        String inputText = "";
        
        if (choice == 1) {
            System.out.print("Enter the text: ");
            inputText = scanner.nextLine();
        } else if (choice == 2) {
            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();
            inputText = readFile(filePath);
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }
        
        if (inputText.isEmpty()) {
            System.out.println("No text provided.");
        } else {
            int wordCount = countWords(inputText);
            System.out.println("Total words: " + wordCount);
        }
        
        scanner.close();
    }
    
    public static String readFile(String filePath) {
        // Code to read the file and return its content as a string
        return ""; // Placeholder
    }
    
    public static int countWords(String text) {
        String[] words = text.split("[\\s.,;!?]+");
        return words.length;
    }
}
