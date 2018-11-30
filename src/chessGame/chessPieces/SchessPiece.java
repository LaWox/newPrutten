package chessGame.chessPieces;

import javax.swing.*;

public abstract class SchessPiece {

    private String color;
    protected String NAME;
    Icon img;

    SchessPiece(String color) {
        this.color = color;
        this.NAME="";
        this.setImg();
    }

    abstract protected boolean checkMove(int xcurr, int ycurr, int xnext, int ynext);

    protected String getColor(){
        return this.color;
    }

    protected String getName(){
        return this.NAME;
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
    return this.NAME + " " + color;
    }

    private void setImg(){
        this.img = new ImageIcon("path" + this.NAME + "-" +  this.color + ".fileType");
    }


}


