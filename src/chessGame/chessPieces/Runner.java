package chessGame.chessPieces;

import javax.swing.*;

public class Runner extends SchessPiece {

    public Runner(String color){
        super(color);
        this.NAME = "Löpare";
        this.setImg();
    }

    public boolean checkMove(int startx, int startY, int endX, int endY ){
        return true;
    }
}
