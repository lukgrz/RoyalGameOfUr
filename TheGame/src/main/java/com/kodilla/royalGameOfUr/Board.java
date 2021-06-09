package com.kodilla.royalGameOfUr;

import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class Board {
    GridPane grid = new GridPane();

    List<Field> fieldsList = new ArrayList<>();
    FlowPane dices = new FlowPane(Orientation.HORIZONTAL);
    FlowPane dicesCpu = new FlowPane(Orientation.HORIZONTAL);
    Label moveInfo = new Label("");
    Label moveInfoCpu = new Label("");
    List<Cheker> chekersPlayer = new ArrayList<>();
    List<Cheker> chekersCpu = new ArrayList<>();
    Button rollButton = new Button("ROLL DICES");
    int move;
    int moveCpu;

    Image image1 = new Image("file:src/main/resources/board/field1.png");
    Image image2 = new Image("file:src/main/resources/board/field2.png");
    Image image3 = new Image("file:src/main/resources/board/field3.png");
    Image image4 = new Image("file:src/main/resources/board/field4.png");
    Image image5 = new Image("file:src/main/resources/board/field5.png");
    Image image6 = new Image("file:src/main/resources/board/field6.png");

    public void createBoard(Stage primaryStage) {
        for (int i = 0; i < 10; i++) {
            ColumnConstraints column = new ColumnConstraints(100);
            grid.getColumnConstraints().add(column);
        }

        for (int i = 0; i < 7; i++) {
            RowConstraints row = new RowConstraints(100);
            grid.getRowConstraints().add(row);
        }

        Rectangle rectangle = new Rectangle(800, 300, Color.BLUE);
        grid.add(rectangle, 1, 2, 8, 3);

        primaryStage.setResizable(false);
        grid.setGridLinesVisible(true);

        Scene scene = new Scene(grid, 1000, 700, Color.CHOCOLATE);
        primaryStage.setTitle("Royal game of Ur");
        primaryStage.setScene(scene);
        primaryStage.show();

        fieldsList.add(new Field(new ImageView(image1), 1, 2, 5, 0, true));
        fieldsList.add(new Field(new ImageView(image1), 2, 2, 4, 0, true));
        fieldsList.add(new Field(new ImageView(image1), 3, 2, 3, 0, true));
        fieldsList.add(new Field(new ImageView(image1), 4, 2, 2, 0, true));
        fieldsList.add(new Field(new ImageView(), 5, 2, 1, 0, true));
        fieldsList.add(new Field(new ImageView(), 6, 2, 16, 0, true));
        fieldsList.add(new Field(new ImageView(image1), 7, 2, 15, 0, true));
        fieldsList.add(new Field(new ImageView(image1), 8, 2, 14, 0, true));
        fieldsList.add(new Field(new ImageView(image1), 1, 3, 6, 6, true));
        fieldsList.add(new Field(new ImageView(image1), 2, 3, 7, 7, true));
        fieldsList.add(new Field(new ImageView(image1), 3, 3, 8, 8, true));
        fieldsList.add(new Field(new ImageView(image1), 4, 3, 9, 9, true));
        fieldsList.add(new Field(new ImageView(image1), 5, 3, 10, 10, true));
        fieldsList.add(new Field(new ImageView(image1), 6, 3, 11, 11, true));
        fieldsList.add(new Field(new ImageView(image1), 7, 3, 12, 12, true));
        fieldsList.add(new Field(new ImageView(image1), 8, 3, 13, 13, true));
        fieldsList.add(new Field(new ImageView(image1), 1, 4, 0, 5, true));
        fieldsList.add(new Field(new ImageView(image1), 2, 4, 0, 4, true));
        fieldsList.add(new Field(new ImageView(image1), 3, 4, 0, 3, true));
        fieldsList.add(new Field(new ImageView(image1), 4, 4, 0, 2, true));
        fieldsList.add(new Field(new ImageView(), 5, 4, 0, 1, true));
        fieldsList.add(new Field(new ImageView(), 6, 4, 0, 14, true));
        fieldsList.add(new Field(new ImageView(image1), 7, 4, 0, 15, true));
        fieldsList.add(new Field(new ImageView(image1), 8, 4, 0, 16, true));

        for (Field field : fieldsList) {
            grid.add(field.getImageView(), field.getCol(), field.getRow());
            field.getImageView().setFitHeight(90);
            field.getImageView().setFitWidth(90);
            grid.setHalignment(field.getImageView(), HPos.CENTER);
        }

        grid.add(moveInfo, 4, 0);
        grid.add(moveInfoCpu, 4, 6);

        grid.add(rollButton, 5, 0);
        rollButton.setOnAction((e) -> {
            rollPlayerDices();
            rollButton.setDisable(true);
        });
    }

    public void createPlayerChekers () {
        for (int i = 0; i < 7; i++) {
            ImageView chekerPlayerImage = new ImageView(new Image("file:src/main/resources/chekerBlue.png"));
            chekerPlayerImage.setFitHeight(80);
            chekerPlayerImage.setFitWidth(80);
            Cheker cheker = new Cheker();
            cheker.setFieldNumber(1);
            cheker.setField(getByPlayerNumber(cheker.getFieldNumber()));
            cheker.setImage(new Image("file:src/main/resources/chekerBlue.png"));
            chekersPlayer.add(cheker);
            cheker.setCol(cheker.getField().getCol());
            cheker.setRow(cheker.getField().getRow());
            grid.add(cheker, cheker.getCol(), cheker.getRow());

            cheker.setOnMouseClicked((e) -> {
                playerMove(cheker);
                rollButton.setDisable(false);
            });
        }
    }

    public void createChekersCpu (){
        ImageView chekerPlayerImage = new ImageView(new Image("file:src/main/resources/chekerRed.png"));
        chekerPlayerImage.setFitHeight(80);
        chekerPlayerImage.setFitWidth(80);
        Cheker cheker = new Cheker();
        cheker.setFieldNumber(1);
        cheker.setField(getByCpuNumber(cheker.getFieldNumber()));
        cheker.setImage(new Image("file:src/main/resources/chekerRed.png"));
        chekersCpu.add(cheker);
        cheker.setCol(cheker.getField().getCol());
        cheker.setRow(cheker.getField().getRow());
        grid.add(cheker, cheker.getCol(), cheker.getRow());
    }

    public void rollPlayerDices() {
        move = 0;
        grid.getChildren().remove(dices);
        dices = new FlowPane();
        for (int i = 0; i < 4; i++) {
            Dice dice = new Dice();
            dice.rollDice();
            ImageView diceImageView = new ImageView(dice.getDiceImage());
            diceImageView.setFitWidth(100);
            diceImageView.setFitHeight(100);
            dices.getChildren().add(diceImageView);
            move += dice.getPoints();
        }
        moveInfo.setText("You throw " + move);
        grid.add(dices, 0, 0, 4, 1);
    }

    public void rollCpuDices (){
        moveCpu = 0;
        grid.getChildren().remove(dicesCpu);
        dicesCpu = new FlowPane();
        for (int i = 0; i < 4; i++) {
            Dice dice = new Dice();
            dice.rollDice();
            ImageView diceImageView = new ImageView(dice.getDiceImage());
            diceImageView.setFitWidth(100);
            diceImageView.setFitHeight(100);
            dicesCpu.getChildren().add(diceImageView);
            moveCpu += dice.getPoints();
        }
        moveInfoCpu.setText("CPU throw " + moveCpu);
        grid.add(dicesCpu, 0, 6, 4, 1);
    }

    public void cpuMove(Cheker cheker){}

    public void playerMove(Cheker cheker) {
        if (checkFiledAvaliable(cheker) == true) {
            cheker.getField().setAvalaible(true);
            cheker.setFieldNumber(cheker.getFieldNumber() + move);
            cheker.setField(getByPlayerNumber(cheker.getFieldNumber()));
            grid.getChildren().remove(cheker);
            cheker.setCol(cheker.getField().getCol());
            cheker.setRow(cheker.getField().getRow());
            cheker.getField().setAvalaible(false);
            grid.add(cheker, cheker.getCol(), cheker.getRow());
            move = 0;
            rollCpuDices();
            moveInfo.setText("Throw your dices");
        } else moveInfo.setText("Choose another cheker\n" +
                "You throw " + move);
    }

    private Field getByPlayerNumber(int fieldNumber) {
        return fieldsList.stream()
                .filter(f -> f.getPlayerNumber() == fieldNumber)
                .findAny().get();
    }

    private Field getByCpuNumber(int fieldNumber) {
        return fieldsList.stream()
                .filter(f -> f.getCpuNumber() == fieldNumber)
                .findAny().get();
    }

    boolean checkFiledAvaliable(Cheker cheker){
        return getByPlayerNumber(cheker.getFieldNumber()+move).isAvalaible();
    }
}

