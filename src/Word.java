import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Word {
    private final Character[] chars;
    private final Status[] status;
//    private final ConsoleColor[] color;
    public boolean gameOver;

    public Word(Character[] word, ConsoleColor[] color) {
        this.chars = word;
        this.status = new Status[word.length];
//        this.color = color;
        this.resetStatus();
    }

    private void resetStatus() {
        Arrays.fill(this.status, Status.MISSING);
    }

    public Status[] getStatus() {
        return this.status;
    }
    public boolean IsGameOver(){
        return gameOver;
    }
    public void printStatus() {
        int count = 0;
        for (int i = 0; i < chars.length; i++)
        {
            if (status[i] == Status.CORRECT){
                count++;
            }
        }
        if (count == chars.length){
            System.out.println("You guessed it");
            gameOver = true;
        } else {
            System.out.println(Arrays.toString(status));
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
                charCount.put(temp, charCount.get(temp) - 1);
            } else if (charCount.getOrDefault(temp, 0) > 0) {
                status[i] = Status.WRONGPOS;
                charCount.put(temp, charCount.get(temp) - 1);
            } else {
                status[i] = Status.MISSING;
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
