package chessGame.chessPieces;

import javax.swing.*;

public class Queen extends SchessPiece {

    public Queen(String color){
        super(color);
        this.NAME="Drottning";
        this.setImg();
    }

    public boolean checkMove(int xcurr, int ycurr, int xnext, int ynext){
        if (xcurr==xnext && ycurr!=ynext){
            return true;
        }
        else if (ycurr==ynext && xcurr!=xnext){
            return true;
        }
        else{
            return ((Math.abs(ycurr-ynext) / Math.abs(xcurr-xnext))==1);
        }

    }




}
