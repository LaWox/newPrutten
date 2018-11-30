package chessGame.chessPieces;

import javax.swing.*;

public class Tower extends SchessPiece {


    public Tower(String color){
        super(color);
        this.NAME="Torn";
    }

    public boolean checkMove(int xcurr, int ycurr, int xnext, int ynext){
        if (xcurr==xnext && ycurr!=ynext){
            return true;
        }
        return (ycurr==ynext && xcurr!=xnext);
    }

    public static void main(String[] arg){
        Tower t = new Tower("white");
        System.out.println(t);
        System.out.println((t.isWhite()));
    }



}
