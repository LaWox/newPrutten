package chessGame.chessPieces;

import javax.swing.*;

public class King extends SchessPiece{


    King(String color){
        super(color);
        this.NAME="Kung";

    }


    protected boolean checkMove(int xcurr, int ycurr, int xnext, int ynext){
        return true;

    }
}
