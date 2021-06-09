package com.kodilla.royalGameOfUr;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice {
    private int points;
    List<Image> diceImages = new ArrayList<>();
    Image diceImage;

    Image image1 = new Image("file:src/main/resources/dice/01.png");
    Image image2 = new Image("file:src/main/resources/dice/02.png");
    Image image3 = new Image("file:src/main/resources/dice/03.png");
    Image image4 = new Image("file:src/main/resources/dice/11.png");
    Image image5 = new Image("file:src/main/resources/dice/12.png");
    Image image6 = new Image("file:src/main/resources/dice/13.png");

    public Dice() {
    }

    public Dice(int points, Image diceImage) {
        this.points = points;
        this.diceImage = diceImage;
    }

    public Dice rollDice() {
        Random random  = new Random();
        diceImages.add(image1);
        diceImages.add(image2);
        diceImages.add(image3);
        diceImages.add(image4);
        diceImages.add(image5);
        diceImages.add(image6);

        points = random.nextInt(2);
        if (points == 0) {
            diceImage = diceImages.get(random.nextInt(2));
        }else {
            diceImage = diceImages.get(3+ random.nextInt(2));
        }

        return new Dice(points,diceImage);
    }

    public Image getDiceImage() {
        return diceImage;
    }

    public int getPoints() {
        return points;
    }
}

