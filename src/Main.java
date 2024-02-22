import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        var words = new Words();
        words.setWord(5);
        var word = new Word(words.wordChar);
        var scan = new Scanner(System.in);
        System.out.println(Arrays.toString(words.wordChar));
        for (int i = 6; i > 0; i--) {
            if(i == 1){System.out.println("You have " + i + " try");}
            else {System.out.println("You have " + i + " tries");}
            System.out.print("Guess the word: ");
            var res = scan.next();
            if (res.length() != 5) {
                System.out.println("Word should be of length 5");
                i++;
            }
            if (!word.compare(res.toLowerCase())) {
                continue;
            }
            word.printStatus(res.toLowerCase());
            if (word.isGameOver()) {
                promptNewGame(scan, words);
                break;
            }

        }
        if (!word.isGameOver()) {
            System.out.println("You lost! \uD83D\uDE22");
            promptNewGame(scan, words);
        }
    }


    public static void promptNewGame(Scanner scanner, Words words) {
        System.out.println("Do you want to start again?(yes/no)");
        String response = scanner.next();
        if (response.equalsIgnoreCase("yes")) {
            words.setWord(5);
            playGame();
        } else {
            System.exit(0);
        }
    }
}
