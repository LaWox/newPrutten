package chessGame.chessPieces;

import javax.swing.*;

public class Tower extends SchessPiece {


    static Icon image =new ImageIcon("hej");

    Tower(String color){
        super(color);
        this.NAME="Torn";


    }

    protected boolean checkMove(int xcurr, int ycurr, int xnext, int ynext){

        return true;

    }

    public static void main(String[] arg){
        Tower t = new Tower("white");
        System.out.println(t);
        System.out.println((t.isWhite()));
    }



}