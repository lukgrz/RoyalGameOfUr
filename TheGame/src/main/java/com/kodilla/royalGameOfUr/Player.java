package com.kodilla.royalGameOfUr;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Cheker> chekers;
    List<Dice> diceList = new ArrayList<>();
    private int move;
    boolean active;
    Image chekerImage = new Image("file:src/main/resources/chekerBlue.png");

    public void rollPlayerDices () {
        for (int n = 0; n < 4; n++) {
            Dice dice = new Dice();
            diceList.add(dice.rollDice());
            move = dice.getPoints();
        }
    }

    public void addCheker(Cheker cheker){
        chekers.add(cheker);
    }

    public FlowPane playerDiceView () {
        Player player = new Player();
        FlowPane dices = new FlowPane();
        player.rollPlayerDices();
        for (int n=0; n<4;n++) {
            Image diceImage = player.getDiceList().get(n).getDiceImage();
            ImageView diceImageView = new ImageView(diceImage);
            diceImageView.setFitHeight(80);
            diceImageView.setFitWidth(80);
            dices.getChildren().add(diceImageView);
        }
        return dices;
    }

    public List<Dice> getDiceList() {
        return diceList;
    }
}
