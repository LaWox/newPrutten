package chessGame.chessPieces;

import javax.swing.*;

public abstract class SchessPiece {

    private String color;
    static String name;
    static Icon image;

    SchessPiece(String color) {
        this.color = color;



    }

    abstract protected boolean checkMove(int xcurr, int ycurr, int xnext, int ynext);

    protected String getColor(){
        return this.color;
    }

    protected String getName(){
        return name;
    }

    protected boolean isWhite(){
        if (color.equals("white")){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString() {
    return name + " " + color;
    }



}


