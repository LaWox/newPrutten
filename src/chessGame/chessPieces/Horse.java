package chessGame.chessPieces;

import javax.swing.*;

public class Horse extends SchessPiece {

    Horse(String color){
        super(color);
        this.NAME = "Häst";
    }

    public boolean checkMove(int startx, int startY, int endX, int endY ){
        return true;
    }
}
