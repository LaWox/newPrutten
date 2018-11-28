package chessGame.chessPieces;

import javax.swing.*;

public class Runner extends SchessPiece {

    Runner(String color){
        super(color);
        this.NAME = "Löpare";

    }

    public boolean checkMove(int startx, int startY, int endX, int endY ){
        return true;
    }
}
