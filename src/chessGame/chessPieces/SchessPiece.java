package chessGame.chessPieces;

import javax.swing.*;

public abstract class SchessPiece {

    private String color;
    protected String NAME;
    Icon img;

    SchessPiece(String color) {
        this.color = color;
        this.NAME = null;
    }

    abstract public boolean checkMove(int xcurr, int ycurr, int xnext, int ynext);

    public String getColor(){
        return this.color;
    }

    public String getName(){
        return this.NAME;
    }

    public boolean isWhite(){
        return this.color.equals("white");
    }

    public String toString() {
    return this.NAME + " " + color;
    }

    public Icon getImg(){
        return this.img;
    }

    public void setImg(){
        //chessGame/chessPieces/chessIcons/Bonde-black.png
        //C:\Users\Dell\Desktop\KTH\PruttenProjekt\src\chessGame\chessPieces\chessIcons\Bonde-black.png
        //System.err.println("chessGame/chessPieces/chessIcons/" + this.NAME + "-" +  this.color + ".png");
        this.img = new ImageIcon("C:/Users/Dell/Desktop/KTH/PruttenProjekt/src/chessGame/chessPieces/chessIcons/" + this.NAME + "-" +  this.color + ".png");
    }


}


