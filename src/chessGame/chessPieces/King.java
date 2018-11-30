package chessGame.chessPieces;

import javax.swing.*;

public class King extends SchessPiece{


    public King(String color){
        super(color);
        this.NAME="Kung";

    }


    public boolean checkMove(int xcurr, int ycurr, int xnext, int ynext){
        if(xcurr==xnext && Math.abs((ycurr-ynext)) == 1)
            return true;
        else if (ycurr==ynext && Math.abs((xcurr-xnext)) == 1){
            return true;
        }
        else {
            return (Math.abs(ycurr-ynext)==1 && Math.abs(xcurr-xnext)==1);
        }
    }
}
