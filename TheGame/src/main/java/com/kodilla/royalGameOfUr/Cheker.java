package com.kodilla.royalGameOfUr;

import javafx.scene.image.ImageView;

public class Cheker extends ImageView {
    private Field field;
    private int fieldNumber;
    private int col;
    private int row;

    public void setField(Field field) {
        this.field = field;
    }

    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Field getField() {
        return field;
    }

    public int getFieldNumber() {
        return fieldNumber;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
