package com.example.tic_tac_toe;

import android.widget.ImageButton;

public class SelectedBtn {
    private int pos;
    private String tag;
    SelectedBtn(int pos,String tag){
        this.pos = pos;
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public int getPos() {
        return pos;
    }

    @Override
    public String toString() {
        return "SelectedBtn{" +
                "pos=" + pos +
                ", tag='" + tag + '\'' +
                '}';
    }
}
