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
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Board {
    GridPane grid = new GridPane();

    List<Field> fieldsList = new ArrayList<>();
    FlowPane dices = new FlowPane(Orientation.HORIZONTAL);
    FlowPane dicesCpu = new FlowPane(Orientation.HORIZONTAL);
    Label moveInfo = new Label("");
    Label chekersInHomePlayer = new Label("");
    Label chekersFinishPlayer = new Label("");
    Label moveInfoCpu = new Label("");
    Label chekersInHomeCpu = new Label("");
    Label getChekersFinishCpu = new Label("");
    List<Cheker> chekersPlayer = new ArrayList<>();
    List<Cheker> chekersCpu = new ArrayList<>();
    Button rollButton = new Button("ROLL DICES");
    int move;
    int moveCpu;

    Image imageBack = new Image("file:src/main/resources/lion1.png");

    public void createBoard(Stage primaryStage) {
        for (int i = 0; i < 10; i++) {
            ColumnConstraints column = new ColumnConstraints(100);
            grid.getColumnConstraints().add(column);
        }

        for (int i = 0; i < 7; i++) {
            RowConstraints row = new RowConstraints(100);
            grid.getRowConstraints().add(row);
        }

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBack, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        grid.setBackground(background);
        grid.add(new ImageView(new Image("file:src/main/resources/board1.png")),1,3);
        grid.setGridLinesVisible(true);


        primaryStage.setResizable(false);
        Scene scene = new Scene(grid, 1000, 700, Color.BLACK);
        primaryStage.setTitle("Royal game of Ur");
        primaryStage.setScene(scene);
        primaryStage.show();

        fieldsList.add(new Field(1, 2, 5, 0, true));
        fieldsList.add(new Field(2, 2, 4, 0, true));
        fieldsList.add(new Field(3, 2, 3, 0, true));
        fieldsList.add(new Field(4, 2, 2, 0, true));
        fieldsList.add(new Field(5, 2, 1, 0, true));
        fieldsList.add(new Field(6, 2, 16, 0, true));
        fieldsList.add(new Field(7, 2, 15, 0, true));
        fieldsList.add(new Field(8, 2, 14, 0, true));
        fieldsList.add(new Field(1, 3, 6, 6, true));
        fieldsList.add(new Field(2, 3, 7, 7, true));
        fieldsList.add(new Field(3, 3, 8, 8, true));
        fieldsList.add(new Field(4, 3, 9, 9, true));
        fieldsList.add(new Field(5, 3, 10, 10, true));
        fieldsList.add(new Field(6, 3, 11, 11, true));
        fieldsList.add(new Field(7, 3, 12, 12, true));
        fieldsList.add(new Field(8, 3, 13, 13, true));
        fieldsList.add(new Field(1, 4, 0, 5, true));
        fieldsList.add(new Field(2, 4, 0, 4, true));
        fieldsList.add(new Field(3, 4, 0, 3, true));
        fieldsList.add(new Field(4, 4, 0, 2, true));
        fieldsList.add(new Field(5, 4, 0, 1, true));
        fieldsList.add(new Field(6, 4, 0, 14, true));
        fieldsList.add(new Field(7, 4, 0, 15, true));
        fieldsList.add(new Field(8, 4, 0, 16, true));

        grid.add(moveInfo, 4, 0);
        moveInfo.setTextFill(Color.WHITE);
        moveInfo.setStyle("-fx-border-color:red; -fx-background-color: brown;");
        grid.add(chekersInHomePlayer,5,1);
        chekersInHomePlayer.setTextFill(Color.WHITE);
        chekersInHomePlayer.setStyle("-fx-border-color:red; -fx-background-color: brown;");
        grid.add(chekersFinishPlayer,6,1);
        chekersFinishPlayer.setTextFill(Color.WHITE);
        chekersFinishPlayer.setStyle("-fx-border-color:red; -fx-background-color: brown;");

        grid.add(moveInfoCpu, 4, 6);
        moveInfoCpu.setStyle("-fx-border-color:red; -fx-background-color: brown;");
        grid.add(rollButton, 5, 0);
        rollButton.setOnAction((e) -> rollPlayerDices());
    }

    public void createPlayerChekers() {
        for (int i = 0; i < 7; i++) {
            Cheker cheker = new Cheker();
            cheker.setFieldNumber(1);
            cheker.setField(getByPlayerNumber(cheker.getFieldNumber()));
            cheker.setImage(new Image("file:src/main/resources/cheker1.png"));
            chekersPlayer.add(cheker);
            cheker.setCol(cheker.getField().getCol());
            cheker.setRow(cheker.getField().getRow());
            grid.add(cheker, cheker.getCol(), cheker.getRow());
            cheker.setDisable(true);
            GridPane.setHalignment(cheker, HPos.CENTER);
            cheker.setOnMouseClicked((e) -> playerMove(cheker));
        }
        chekersInHomePlayer.setText("Chekers in home: \n" + numberOfChekersAtHome(1,chekersPlayer));
        chekersFinishPlayer.setText("Chekers finished \n" + numberOfChekersFinished(chekersPlayer));
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
        if (move == 0) {
            lostTurnPlayer();
        } else if (isAnyMovePlayer() != true) {
            lostTurnPlayer();
        } else {
            moveInfo.setText("You throw " + move);
            enableChkeres();
            rollButton.setDisable(true);
        }
        grid.add(dices, 0, 0, 4, 1);
    }

    public void specialField() {
        rollButton.setDisable(false);
        moveInfo.setText("You have got\n extra throw");
    }

    public int numberOfChekersAtHome(int fieldNumber, List<Cheker> chekersList){
        int result = 0;
        for (Cheker cheker:chekersList){
            if (cheker.getFieldNumber() == fieldNumber){
                result++;
            }
        }
        return result;
    }

    public int numberOfChekersFinished(List<Cheker> chekersList){
        return 7-chekersList.size();
    }

    public void playerMove(Cheker cheker) {
        if (checkFieldAvaliablePlayer(cheker) == true) {
            cheker.getField().setAvalaible(true);
            cheker.setFieldNumber(cheker.getFieldNumber() + move);
            cheker.setField(getByPlayerNumber(cheker.getFieldNumber()));
            grid.getChildren().remove(cheker);
            cheker.setCol(cheker.getField().getCol());
            cheker.setRow(cheker.getField().getRow());
            cheker.getField().setAvalaible(false);
            grid.add(cheker, cheker.getCol(), cheker.getRow());
            move = 0;
            disableChkeres();

            if (cheker.getFieldNumber() == 16) {
                cheker.setDisable(true);
                cheker.getField().setAvalaible(true);
                chekersPlayer.remove(cheker);
            }
            if (chekersPlayer.size()==0) {
                moveInfo.setText("you won the game");
            }
            if (cheker.getFieldNumber()==5||cheker.getFieldNumber()==9||cheker.getFieldNumber()==15) {
                specialField();
            }else{
                rollCpuDices();
                chooseChekerCpu();
                moveInfo.setText("Throw your dices");
            }

        } else { moveInfo.setText("Choose another\n cheker\n" +
                "You throw " + move);
        }
        chekersInHomePlayer.setText("Cheker in home: \n" + numberOfChekersAtHome(1, chekersPlayer));
        chekersFinishPlayer.setText("Chekers finished \n" + numberOfChekersFinished(chekersPlayer));
    }

    public void lostTurnPlayer () {
        moveInfo.setText("You lost your turn");
        rollCpuDices();
        chooseChekerCpu();
        disableChkeres();
    }

    public void createChekersCpu() {
        for (int i = 0; i < 7; i++) {
            Cheker cheker = new Cheker();
            cheker.setFieldNumber(1);
            cheker.setField(getByCpuNumber(cheker.getFieldNumber()));
            cheker.setImage(new Image("file:src/main/resources/cheker2.png"));
            chekersCpu.add(cheker);
            cheker.setCol(cheker.getField().getCol());
            cheker.setRow(cheker.getField().getRow());
            GridPane.setHalignment(cheker,HPos.CENTER);
            grid.add(cheker, cheker.getCol(), cheker.getRow());
        }
    }

    public void rollCpuDices () {
        rollButton.setDisable(false);
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

    public void chooseChekerCpu() {
        Random random = new Random();
        cpuMove(chekersCpu.get(random.nextInt(chekersCpu.size())));
    }

    public void cpuMove(Cheker cheker) {
        ;
        if (checkFiledAvaliableCpu(cheker) == true) {
            cheker.getField().setAvalaible(true);
            cheker.setFieldNumber(cheker.getFieldNumber() + moveCpu);
            cheker.setField(getByCpuNumber(cheker.getFieldNumber()));
            grid.getChildren().remove(cheker);
            cheker.setCol(cheker.getField().getCol());
            cheker.setRow(cheker.getField().getRow());
            cheker.getField().setAvalaible(false);
            grid.add(cheker, cheker.getCol(), cheker.getRow());
            moveCpu = 0;
        } else chooseChekerCpu();
    }

    public void enableChkeres(){
        for (Cheker cheker:chekersPlayer){
            cheker.setDisable(false);
        }
    }

    public void disableChkeres() {
        for (Cheker cheker : chekersPlayer) {
            cheker.setDisable(true);
        }
    }

    public boolean isAnyMovePlayer() {
        int numberOfAvaliableMoves = 0;
        boolean result = false;
        for (Cheker cheker:chekersPlayer) {
            if (checkFieldAvaliablePlayer(cheker)==true) {
                numberOfAvaliableMoves++;
            }
        }
        result = numberOfAvaliableMoves>0;
        return result;
    }

    public Field getByPlayerNumber(int fieldNumber) {
        return fieldsList.stream()
                .filter(f -> f.getPlayerNumber() == fieldNumber)
                .findAny().get();
    }

    public Field getByCpuNumber(int fieldNumber) {
        return fieldsList.stream()
                .filter(f -> f.getCpuNumber() == fieldNumber)
                .findAny().get();
    }

    public boolean checkFieldAvaliablePlayer(Cheker cheker) {
        if (cheker.getFieldNumber() + move <= 16) {
            return getByPlayerNumber(cheker.getFieldNumber() + move).isAvalaible();
        } else
            return false;
    }

    public boolean checkFiledAvaliableCpu(Cheker cheker){
        return getByCpuNumber(cheker.getFieldNumber()+moveCpu).isAvalaible();
    }
}

