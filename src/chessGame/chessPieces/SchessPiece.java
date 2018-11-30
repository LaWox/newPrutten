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

    abstract public boolean checkMove(int xcurr, int ycurr, int xnext, int ynext);

    public String getColor(){
        return this.color;
    }

    public String getName(){
        return this.NAME;
    }

    public boolean isWhite(){
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
        //chessGame/chessPieces/chessIcons/Bonde-black.png
        this.img = new ImageIcon("chessGame/chessPieces/chessIcons" + this.NAME + "-" +  this.color + ".png");
    }


}


