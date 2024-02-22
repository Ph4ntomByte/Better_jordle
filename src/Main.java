import java.util.Arrays;
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
        while (true) {
            System.out.print("Guess: ");
            var res = scan.next();
            if (!word.compare(res)) {
                continue;
            }
            word.printStatus(res);
            if (word.isGameOver()) {
                promptNewGame(scan, words);
                break;
            }
        }
    }


    public static void promptNewGame(Scanner scanner, Words words) {
        System.out.println("Do you want to start again? (yes/no)");
        String response = scanner.next();
        if (response.equalsIgnoreCase("yes")) {
            words.setWord(5);
            playGame();
        } else {
            System.exit(0);
        }
    }
}
