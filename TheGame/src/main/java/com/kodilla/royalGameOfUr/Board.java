package com.kodilla.royalGameOfUr;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Board {
    private FlowPane dices = new FlowPane(Orientation.HORIZONTAL);
    private Image board = new Image("file:src/main/resources/board1.png");
    GridPane grid = new GridPane();

    public void createBoard(Stage primaryStage) {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(board, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        primaryStage.setResizable(false);
        grid.setBackground(background);
        grid.setGridLinesVisible(true);

        Scene scene = new Scene(grid, 800, 600, Color.CHOCOLATE);

        primaryStage.setTitle("Royal game of Ur");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void playerView(Player player) {
        grid.add(player.playerDiceView(),0,0);

        player.rollPlayerDices();
    }

    public void cpuView(CPUPlayer cpu) {
        Pane pane  = new Pane();
        pane.setPrefSize(0,100);
        grid.add(pane, 0,2);
        grid.add(cpu.playerDiceView(), 0,1);
        cpu.rollPlayerDices();

    }
}
