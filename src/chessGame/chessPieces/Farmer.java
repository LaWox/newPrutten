package chessGame.chessPieces;

import javax.swing.*;

public class Farmer extends SchessPiece {

    public Farmer(String color){
        super(color);
        this.NAME = "Bonde";
    }

    public boolean checkMove(int startx, int startY, int endX, int endY ){
        return true;
    }
}
