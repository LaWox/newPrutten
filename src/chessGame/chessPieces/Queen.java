package chessGame.chessPieces;

import javax.swing.*;

public class Queen extends SchessPiece {

    static Icon image =new ImageIcon("hej");

    public Queen(String color){
        super(color);
        this.NAME="Drottning";


    }

    protected boolean checkMove(int xcurr, int ycurr, int xnext, int ynext){
        return true;

    }




}
