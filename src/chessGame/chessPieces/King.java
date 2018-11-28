package chessGame.chessPieces;

import javax.swing.*;

public class King extends SchessPiece{

    static Icon image =new ImageIcon("hej");

    King(String color){
        super(color);
        this.NAME="Kung";

    }


    protected boolean checkMove(int xcurr, int ycurr, int xnext, int ynext){
        return true;

    }
}
