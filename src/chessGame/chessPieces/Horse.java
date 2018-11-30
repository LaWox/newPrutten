package chessGame.chessPieces;

import javax.swing.*;

public class Horse extends SchessPiece {

    public Horse(String color){
        super(color);
        this.NAME = "Häst";
    }

    public boolean checkMove(int startX, int startY, int endX, int endY ){
        if(Math.abs(startX - endX) == 2){
            return Math.abs(startY-endY) == 1;
        }
        else if(Math.abs(startY-endY) == 2){
            return Math.abs(startX-endX) == 1;
        }
        return false;
    }
}
