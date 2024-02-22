import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Word {
    private final Character[] chars;
    private final Status[] status;
    private ConsoleColor[] color;
    public boolean gameOver;

    public Word(Character[] word) {
        this.chars = word;
        this.status = new Status[word.length];
        this.color = new ConsoleColor[word.length];
        this.resetStatus();
    }



    private void resetStatus() {
        Arrays.fill(this.status, Status.MISSING);
    }
//    private void ResetColor() {
//        Arrays.fill(this.color, ConsoleColor.RESET);
//    }

    public Status[] getStatus() {
        return this.status;
    }
    public boolean IsGameOver(){
        return gameOver;
    }
    public void printStatus(String word) {
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            String temp = String.valueOf(word.toString().charAt(i));
            System.out.print(color[i] + temp + "\u001B[0m");
            if (status[i] == Status.CORRECT) {
                count++;
            }
        }
        if (count == chars.length) {
            System.out.println("\nYou guessed it");
            gameOver = true;
        } else {
            System.out.println();
//            System.out.println(Arrays.toString(status));
        }
    }


    public boolean compare(String guess) {
        if (gameOver) {
            return true;
        }
        if (guess.length() != chars.length) {
            System.out.println("Word should be of length " + chars.length);
            return false;
        }
        this.resetStatus();
        Map<Character, Integer> charCount = new HashMap<>();
        for (Character c : chars) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            char temp = guess.charAt(i);
            if (temp == chars[i]) {
                status[i] = Status.CORRECT;
                color[i] = ConsoleColor.GREEN;
                charCount.put(temp, charCount.get(temp) - 1);
            } else if (charCount.getOrDefault(temp, 0) > 0) {
                status[i] = Status.WRONGPOS;
                color[i] = ConsoleColor.YELLOW;
                charCount.put(temp, charCount.get(temp) - 1);
            } else {
                status[i] = Status.MISSING;
                color[i] = ConsoleColor.RED;
            }
        }

        return true;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
