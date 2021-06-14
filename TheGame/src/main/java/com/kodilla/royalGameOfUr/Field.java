package com.kodilla.royalGameOfUr;

import javafx.scene.Node;

public class Field extends Node {
    private int row;
    private int col;
    private int playerNumber;
    private int cpuNumber;
    private boolean isAvaliableForPlayer;
    private boolean isAvaliableForCpu;

    public Field(int col, int row, int playerNumber, int cpuNumber, boolean isAvalaibleForPlayer,
                 boolean isAvaliableForCpu) {
        this.row = row;
        this.col = col;
        this.playerNumber = playerNumber;
        this.cpuNumber = cpuNumber;
        this.isAvaliableForPlayer = isAvalaibleForPlayer;
        this.isAvaliableForCpu = isAvaliableForCpu;
    }

    public boolean isAvaliableForPlayer() {
        return isAvaliableForPlayer;
    }

    public boolean isAvaliableForCpu() {
        return isAvaliableForCpu;
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

    public void setAvaliableForPlayer(boolean avaliableForPlayer) {
        isAvaliableForPlayer = avaliableForPlayer;
    }

    public void setAvaliableForCpu(boolean avaliableForCpu) {
        isAvaliableForCpu = avaliableForCpu;
    }

}
