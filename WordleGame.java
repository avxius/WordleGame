import java.util.Scanner;


public class WordleGame {
    // Word to be guessed
    private String targetWord;
    // Number of attempts left
    private int attempt;
    // Scanner object for input
    private static Scanner scan = new Scanner(System.in);

    //constructor
    public WordleGame(String targetWord) {
        this.targetWord = targetWord;
        this.attempt = 6;
    }




    // Method to guess the word and get feedback
    public String guessWord(String guess) {
        // Process guess and provide feedback
        // ...
        //ONLY CODE I AM HELPING WITH
        //What this for loop is doing --> Uses the charAt method to check one character from the string
        //at index i. The program provides feedback based the individual character
        String feedback = "";


        for (int i = 0; i < guess.length(); i++) {
            char letter = guess.charAt(i);
            if (letter == targetWord.charAt(i)) {
                feedback += "🟩"; // Correct letter and position
            } else if (targetWord.contains(String.valueOf(letter))) {
                feedback += "🟨"; // Correct letter, wrong position
            } else {
                feedback += "⬜"; // Incorrect letter
            }
        }
        return feedback;
    }


    // Method to check if game is over
    public boolean isGameOver() {
        return attempt == 0;
    }


    // Method to check if word is guessed correctly
    public boolean isWordGuessed(String guess) {
        // Check if the guess matches the target word
        return guess.equals(targetWord);
    }


    // Method to validate the guess
    private boolean isValidGuess(String guess) {
        return guess.matches("[a-zA-Z]+");
    }


    public void playGame()
    {
        while (!isGameOver()) {
            System.out.print("Enter your guess: ");
            String guess = scan.nextLine();

            if (isValidGuess(guess)) {
                attempt--;
                String result = guessWord(guess);

                if (isWordGuessed(guess)) {
                    System.out.println("nice you guessed the word correctly ");
                    break;
                } else {
                    System.out.println(result + "\nincorrect You have " + attempt + " attempts left.");
                }

            } else {
                System.out.println("Guess is incorrect.");
            }
        }

        if (isGameOver()) {
            System.out.println("You ran out of attempts, Game Over.");
        }




    }



}






