package com.kodilla.royalGameOfUr;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Board {
    GridPane grid = new GridPane();

    FlowPane playerDices = new FlowPane();
    FlowPane cpuDices = new FlowPane();
    Button rollButton = new Button("ROLL DICES");

    List<Field> fieldList = new ArrayList<>();

    Image image1 = new Image ("file:src/main/resources/board/field1.png");
    Image image2 = new Image ("file:src/main/resources/board/field2.png");
    Image image3 = new Image ("file:src/main/resources/board/field3.png");
    Image image4 = new Image ("file:src/main/resources/board/field4.png");
    Image image5 = new Image ("file:src/main/resources/board/field5.png");
    Image image6 = new Image ("file:src/main/resources/board/field6.png");

    public void createBoard(Stage primaryStage, Player player, CPUPlayer cpu) {
        Pane pane  = new Pane();
        Pane pane1 = new Pane();
        pane.setPrefSize(80,320);
        grid.add(pane,0,2,1,5);
        pane1.setPrefSize(80,80);
        grid.add(pane1,1,1);

        fieldList.add(new Field(image1, 1,1,2));
        fieldList.add(new Field(image2, 2,2,2));
        fieldList.add(new Field(image3, 3,3,2));
        fieldList.add(new Field(image4, 4,4,2));
        fieldList.add(new Field(image5, 5,5,2));
        fieldList.add(new Field(image6, 6,6,2));
        fieldList.add(new Field(image1, 7,7,2));
        fieldList.add(new Field(image2, 8,8,2));
        fieldList.add(new Field(image3, 9,1,3));
        fieldList.add(new Field(image4, 10,2,3));
        fieldList.add(new Field(image5, 11,3,3));
        fieldList.add(new Field(image6, 12,4,3));
        fieldList.add(new Field(image6, 13,5,3));
        fieldList.add(new Field(image6, 14,6,3));
        fieldList.add(new Field(image6, 15,7,3));
        fieldList.add(new Field(image6, 16,8,3));
        fieldList.add(new Field(image6, 17,1,4));
        fieldList.add(new Field(image6, 18,2,4));
        fieldList.add(new Field(image6, 19,3,4));
        fieldList.add(new Field(image6, 20,4,4));
        fieldList.add(new Field(image6, 21,5,4));
        fieldList.add(new Field(image6, 22,6,4));
        fieldList.add(new Field(image6, 23,7,4));
        fieldList.add(new Field(image6, 24,8,4));

        fieldList.get(0).setPlayerNumber(4);
        fieldList.get(1).setPlayerNumber(3);
        fieldList.get(2).setPlayerNumber(2);
        fieldList.get(3).setPlayerNumber(1);
        fieldList.get(4).setPlayerNumber(0);
        fieldList.get(5).setPlayerNumber(14);
        fieldList.get(6).setPlayerNumber(13);
        fieldList.get(7).setPlayerNumber(12);
        fieldList.get(8).setPlayerNumber(5);
        fieldList.get(8).setCpuNumber(5);
        fieldList.get(9).setPlayerNumber(6);
        fieldList.get(9).setCpuNumber(6);
        fieldList.get(10).setPlayerNumber(7);
        fieldList.get(10).setCpuNumber(7);
        fieldList.get(11).setPlayerNumber(8);
        fieldList.get(11).setCpuNumber(8);
        fieldList.get(12).setPlayerNumber(9);
        fieldList.get(12).setCpuNumber(9);
        fieldList.get(13).setPlayerNumber(10);
        fieldList.get(13).setCpuNumber(10);
        fieldList.get(14).setPlayerNumber(11);
        fieldList.get(14).setCpuNumber(11);
        fieldList.get(15).setPlayerNumber(12);
        fieldList.get(15).setCpuNumber(12);
        fieldList.get(16).setCpuNumber(4);
        fieldList.get(17).setCpuNumber(3);
        fieldList.get(18).setCpuNumber(2);
        fieldList.get(19).setCpuNumber(1);
        fieldList.get(20).setCpuNumber(0);
        fieldList.get(21).setCpuNumber(14);
        fieldList.get(22).setCpuNumber(13);
        fieldList.get(23).setCpuNumber(12);

        for (Field field:
             fieldList) {
            field.addField(grid,field);
        }

        for (int i = 0;i<7;i++) {
            Cheker playerCheker = new Cheker();
            playerCheker.image = player.chekerImage;
            playerCheker.setField(fieldList.get(4));
            playerCheker.setCol(playerCheker.getField().getCol());
            playerCheker.setRow(playerCheker.getField().getRow());
            ImageView playerChekerImageView = new ImageView(playerCheker.image);
            playerChekerImageView.setFitHeight(80);
            playerChekerImageView.setFitWidth(80);
            grid.add(playerChekerImageView,playerCheker.getCol(),playerCheker.getRow());

        }

        playerDices = player.playerDiceView();
        cpuDices = cpu.playerDiceView();
        grid.add(playerDices,0,0,5,1);
        grid.add(cpuDices,0,7,5,1);

        grid.add(rollButton,5,0);
        rollButton.setOnAction((e)-> {
            playerDices.getChildren().removeAll(playerDices.getChildren());
            playerDices = player.playerDiceView();
            grid.add(playerDices,0,0,5,1);
        });

        primaryStage.setResizable(false);
        grid.setGridLinesVisible(true);

        Scene scene = new Scene(grid, 800, 600, Color.CHOCOLATE);
        primaryStage.setTitle("Royal game of Ur");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
