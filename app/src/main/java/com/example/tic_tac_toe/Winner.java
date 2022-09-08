package com.example.tic_tac_toe;

public class Winner {
    private boolean won;
    private int pos;
    private String symbol;

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public boolean isWon() {
        return won;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPos() {
        return pos;
    }
}
