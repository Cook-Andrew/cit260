package SumoGame.cit260;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		GameController controller = new GameController();
		Player player = new Player();
		HighScore highScore = new HighScore();
		System.out.println("SUMO SHOWDOWN!\nPlease enter your name: (Press enter for default: Janken)");
		String name = null;
		name = keyboard.nextLine();
		if (name == null || name.equals("")) {
			name = "Janken"; //Janken is Japanese for Rock Paper Scissors!
		}
		player.setName(name);
		controller.menu(player, highScore);
    }
}
