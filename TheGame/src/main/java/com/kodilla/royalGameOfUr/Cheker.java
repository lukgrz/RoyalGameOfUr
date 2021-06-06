package com.kodilla.royalGameOfUr;

import javafx.scene.image.Image;

public class Cheker {
    private Field field = null;
    private int col;
    private int row;
    private int points;
    Image image;


    public void setField(Field field) {
        this.field = field;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPoints() {
        return points;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Field getField() {
        return field;
    }
}
