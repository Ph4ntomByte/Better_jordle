![alt text](pic/Word_Guess_Game.png)

A console‑based 5‑letter word‑guessing game in Java. Similar to Wordle, you have unlimited attempts to guess the secret word; each guess produces colored feedback:

- 🟩 **Green** – correct letter in correct position  
- 🟨 **Yellow** – correct letter in wrong position  
- 🟥 **Red** – letter not in the word  

---

## 🚀 Features

- Guess any 5‑letter word  
- Unlimited attempts until solved  
- ANSI‑colored feedback in the console  
- Handles duplicate letters correctly  

---

## 🛠️ Getting Started

### Prerequisites

- Java 11 or higher  
- (Optional) Maven or another build tool  

### Clone & Build

```bash
git clone https://github.com/Ph4ntomByte/word-guess-game.git
cd word-guess-game
javac *.java
```

_or, with Maven:_

```bash
mvn compile
```

### Run

```bash
java Game
```

_or, with Maven:_

```bash
mvn exec:java -Dexec.mainClass="Game"
```

---

## 🎮 Usage

1. The program selects a random 5‑letter secret word.  
2. Enter your guess (exactly 5 letters) and press **Enter**.  
3. Observe the colored output:  
   ```
   Enter your guess: CRANE
   🟥 C  🟨 R  🟩 A  🟥 N  🟥 E
   ```  
4. Repeat until all letters are green.  

---

## 📐 How It Works

1. **Reset** all letter statuses to `MISSING`.  
2. Build a frequency map of letters in the secret word.  
3. **First pass**: mark exact matches (`CORRECT`, green) and decrement their counts.  
4. **Second pass**: for remaining positions, if a guessed letter still appears in the map → `WRONGPOS` (yellow), otherwise → `MISSING` (red).  
5. Print the guess with ANSI colors via the `ConsoleColor` enum.  
6. If all positions are `CORRECT`, the game ends.  

---

## 📂 Code Structure

- **`Word.java`**  
  Encapsulates the secret word, status array, color array, and comparison logic.  
- **`Status.java`**  
  Enumeration of letter statuses: `CORRECT`, `WRONGPOS`, `MISSING`.  
- **`ConsoleColor.java`**  
  ANSI escape codes for GREEN, YELLOW, RED, and RESET.  
- **`Game.java`**  
  Main driver: selects the word, reads user input, invokes `Word.compare()` and `Word.printStatus()`.  

---

## 🔧 Customization

- **Word length**: modify the `Character[]` in `Word.java` for any length.  
- **Word list**: swap out the dictionary in `Game.java`.  
- **Attempt limit**: enforce a maximum number of guesses by adding a counter loop.  
- **Colors**: change ANSI codes in `ConsoleColor.java` for custom themes.  

---

## 🤝 Contributing

1. Fork the repo  
2. Create a feature branch (`git checkout -b feature/my-change`)  
3. Commit your changes (`git commit -m "feat: add …"`)  
4. Push to your branch (`git push origin feature/my-change`)  
5. Open a Pull Request  

---

## 📄 License

This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.
