package SumoGame.cit260;

import java.util.ArrayList;
import java.util.Scanner;

public class GameController {
    /** Variables */
    private ArrayList<Npc> enemyList = new ArrayList<Npc>();
    private int wrestlerIndex;

    /** Constructors */
    public GameController(){
        wrestlerIndex = 0;
    }

    /** Methods */
    public void displayHealth(String playerName, String npcName, int playerHealth, int npcHealth) {
        System.out.print("\n" + playerName + ":\t");
        for(int i = playerHealth; i > 0; i -= 10) {
            if (i >= 10) {
                System.out.print("█");
            } else {
                System.out.print("░");
            }
        }
        System.out.print("\n" + npcName + ":\t");
        for(int i = npcHealth; i > 0; i -= 10) {
            if (i >= 10) {
                System.out.print("█");
            } else {
                System.out.print("░");
            }
        }
    }

    //public ArrayList<Npc> nextWrestler() {
    //    return enemyList[wrestlerIndex];
    //}

    public void menu(Player player, HighScore highScore) {
        Scanner selection = new Scanner(System.in);
        System.out.println("\nPress 1 to start a new game, press 2 to view the high scores.");
        int choice = selection.nextInt();
        if (choice == 1) {
            newGame(player, highScore);
        } else if (choice == 2) {
            displayHighScores(player, highScore);
        } else {
            System.out.println("Please make a selection.");
            menu(player, highScore);
        }
    }

    public void newGame(Player player, HighScore highScore) {
        Npc enemy = new Npc(); //from the arrayList
        String tagline = enemy.getTagline();
        System.out.println(tagline);
        combat(player, enemy, highScore);
    }

    public void displayHighScores(Player player, HighScore highScore) {
        String result = highScore.printTable();
        System.out.println(result);
        menu(player, highScore);
    }

    public void combat(Player player, Npc enemy, HighScore highScore) {
        int playerHealth = player.getHealth();
        String playerName = player.getName();
        int enemyHealth = enemy.getHealth();
        String enemyName = enemy.getName();
        while (enemyHealth >= 0) {
            if (playerHealth <= 0) {
                String checkScore = highScore.checkScore();
                System.out.println(checkScore);
                menu(player, highScore);
            }
            displayHealth(playerName, enemyName, playerHealth, enemyHealth);
            //int playerChoice = player.attack();
            //int enemyChoice = enemy.attack();
            // rock paper scissors code here
        }
        wrestlerIndex += 1;
        newGame(player, highScore);
    }
}
