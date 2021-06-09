package com.kodilla.royalGameOfUr;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Field extends Node {
    private ImageView imageView;
    private int row;
    private int col;
    private int playerNumber;
    private int cpuNumber;
    private boolean isAvalaible;

    public Field(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Field(ImageView imageView, int col, int row, int playerNumber, int cpuNumber, boolean isAvalaible) {
        this.imageView = imageView;
        this.row = row;
        this.col = col;
        this.playerNumber = playerNumber;
        this.cpuNumber = cpuNumber;
        this.isAvalaible = isAvalaible;
    }

    public boolean isAvalaible() {
        return isAvalaible;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public int getCpuNumber() {
        return cpuNumber;
    }

    public void setAvalaible(boolean avalaible) {
        isAvalaible = avalaible;
    }
}
