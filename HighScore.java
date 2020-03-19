package SumoGame.cit260;

import java.io.*;
import java.util.Scanner;

public class HighScore {
    /** Variables */
    private File file = new File("highscores.txt");

    /** Constructors */
    public HighScore() {

    }

    /** Methods */
    public String checkScore(Player player, int score) {
        String name = player.getName();
        try {
            Scanner scoreTable = new Scanner(file);
            String line = scoreTable.nextLine().trim();
            int value = Integer.parseInt(line);
            if (score > value) {
                PrintWriter file = new PrintWriter("highscores.txt");
                file.println(score);
                file.println(" - " + name);
                file.close();
                return "\nNew high score!";
            }
            return "";
        } catch (FileNotFoundException exception) {
            try {
                PrintWriter file = new PrintWriter("highscores.txt");
                file.println(score);
                file.println(" - " + name);
                file.close();
                return "\nNew high score!";
            } catch (FileNotFoundException exceptionTwo) {
                return "\nCould not create highs core table.";
            }
        }
    }
    public void printTable() {
        try {
            Scanner scoreTable = new Scanner(file);
            while(scoreTable.hasNextLine( ) ) {
                String line = scoreTable.nextLine();
                System.out.print(line);
            }
        } catch (FileNotFoundException exception) {
            System.out.println("High score file not found.");
        }
    }
}
