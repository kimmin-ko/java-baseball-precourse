package baseball;

import baseball.controller.GameController;
import baseball.view.ConsoleView;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new ConsoleView());
        gameController.startGame();
    }
}
