package com.kodilla.royalGameOfUr;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Field {
    private Image image;
    private int row;
    private int col;
    private int fieldNumber;
    private int playerNumber;
    private int cpuNumber;

    public Field(Image image,int fieldNumber, int col, int row) {
        this.image = image;
        this.fieldNumber = fieldNumber;
        this.row = row;
        this.col = col;
    }

    public void addField(GridPane grid, Field field){
        ImageView imageView = new ImageView(field.getImage());
        grid.resize(80,80);
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);
        grid.add(imageView, field.getCol(), field.getRow());
    }

    public Image getImage() {
        return image;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getFieldNumber() {
        return fieldNumber;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public int getCpuNumber() {
        return cpuNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public void setCpuNumber(int cpuNumber) {
        this.cpuNumber = cpuNumber;
    }
}
