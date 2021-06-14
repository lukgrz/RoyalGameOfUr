package com.kodilla.royalGameOfUr;
import javafx.application.Application;
import javafx.stage.Stage;

public class TheGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Board board = new Board();

        board.createBoard(primaryStage);
        board.createChekersCpu();
        board.createPlayerChekers();


    }
}