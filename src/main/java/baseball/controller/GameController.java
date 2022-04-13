package baseball.controller;

import baseball.domain.NumberValidator;
import baseball.view.View;

public class GameController {

    private final View view;

    public GameController(View view) {
        this.view = view;
    }

    public void startGame() {
        String inputNumber;
        do {
            inputNumber = view.requestInputNumber();
            NumberValidator.validate(inputNumber);
        } while (!inputNumber.equals("2"));
    }

}