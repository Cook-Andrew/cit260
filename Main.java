package SumoGame.cit260;

public class Main {

    public static void main(String[] args) {
	GameController controller = new GameController();
	Player player = new Player();
	HighScore highScore = new HighScore();
	controller.menu(player, highScore);
    }
}
