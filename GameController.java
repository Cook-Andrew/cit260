package SumoGame.cit260;

import java.util.ArrayList;
import java.util.Scanner;

public class GameController {
    /* TODO: add Rock Paper Scissors combat*/
    /** Variables */
    private ArrayList<Npc> enemyList = new ArrayList<Npc>();
    private int wrestlerIndex; //this tracks the enemy in the ArrayList, the score derives from it

    /** Constructors */
    public GameController(){
        //initialize the variables in a default constructor
        wrestlerIndex = 0;
        //the list of Npc objects to go into the enemyList ArrayList
        Npc stone = new Npc("The Stone");
        enemyList.add(stone);
        Npc pebble = new Npc("The Pebble");
        enemyList.add(pebble);
        Npc boulder = new Npc("The Boulder");
        enemyList.add(boulder);
        Npc ronA = new Npc("Savage Ron");
        enemyList.add(ronA);
        Npc morty = new Npc("The Mortician");
        enemyList.add(morty);
        Npc bulk = new Npc("Bulk Bogan");
        enemyList.add(bulk);
        Npc cain = new Npc("Cain");
        enemyList.add(cain);
        Npc stung = new Npc("Stung");
        enemyList.add(stung);
        Npc hugo = new Npc("Hugo Placeholder");
        enemyList.add(hugo);
        Npc andy = new Npc("Andre the Little Person");
        andy.setTagline("Anybody want a peanut?");
        enemyList.add(andy);
        Npc g = new Npc("Tripple G");
        enemyList.add(g);
        Npc ronB = new Npc("Ron SeeYa");
        enemyList.add(ronB);
        Npc vinny = new Npc("Vince White");
        enemyList.add(vinny);
    }

    /** Methods */
    //creates a health bar printed at the beginning of combat
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

    //a menu for choosing whether to start the game or load the highscore file
    public void menu(Player player, HighScore highScore) {//because the player and highScores objects were created in the main.class, they have to be passed through
        Scanner selection = new Scanner(System.in);
        try { //because we are using int's for the menu selection, we must use exceptions to prevent crashes if the player inputs a string
            System.out.println("\nPress 1 to start a new game, press 2 to view the high score, press 3 to exit.");
            int choice = selection.nextInt();
            if (choice == 1) {
                newGame(player, highScore);
            } else if (choice == 2) {
                displayHighScores(player, highScore);
            } else if (choice == 3) {
                System.exit(0);
            } else {
                System.out.println("Please make a selection.");
                menu(player, highScore);
            }
        } catch (Exception exception) {
            System.out.println("Please make a selection.");
            menu(player, highScore);
        }
    }

    //the new game method, is actually more like the 'new challenger approaches' method
    public void newGame(Player player, HighScore highScore) { //notice the objects must be passed to EVERY method, even though newGame does not use the highScore. It will error when returning to the menu otherwise.
        if (wrestlerIndex == enemyList.size()) {
            System.out.println("\nYou beat every enemy!"); //add easter egg here!
            String checkScore = highScore.checkScore(player, wrestlerIndex);
            System.out.println(checkScore);
            wrestlerIndex = 0;
            menu(player, highScore);
        }
        Npc enemy = enemyList.get(wrestlerIndex);
        String tagline = enemy.getTagline();
        System.out.print(tagline);
        combat(player, enemy, highScore);
    }

    //a method for displaying the highScore file
    public void displayHighScores(Player player, HighScore highScore) {
        highScore.printTable();
        menu(player, highScore);
    }

    //this method calls both the player and Npc classes attack() methods to compare the results for a rock paper scissors showdown!
    public void combat(Player player, Npc enemy, HighScore highScore) {
        int playerHealth = player.getHealth();
        String playerName = player.getName();
        int enemyHealth = enemy.getHealth();
        String enemyName = enemy.getName();
        while (enemyHealth >= 0) {
            if (playerHealth <= 0) {
                String checkScore = highScore.checkScore(player, wrestlerIndex);
                System.out.println(checkScore);
                wrestlerIndex = 0;
                menu(player, highScore);
            }
            displayHealth(playerName, enemyName, playerHealth, enemyHealth);
            int playerChoice = player.attack();
            int enemyChoice = enemy.attack();
            // rock paper scissors code here
                //rock is 1, paper is 2, scissors is 3
            switch (playerChoice - enemyChoice) {
                case -2:
                    //player wins
                    enemyHealth -= 10;
                    break;
                case -1:
                    //player loses
                    playerHealth -= 5;
                    break;
                case 0:
                    //tie
                    enemyHealth -= 5;
                    break;
                case 1:
                    //win
                    enemyHealth -= 10;
                    break;
                case 2:
                    //lose
                    playerHealth -= 5;
                    break;
            }
            enemyHealth -= 5; /** This is for debugging while
             rock paper scissors is unfinished */
        }
        //set the player health
        player.setHealth(playerHealth);
        wrestlerIndex += 1;
        newGame(player, highScore);
    }
}
