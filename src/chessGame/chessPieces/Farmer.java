package chessGame.chessPieces;

import javax.swing.*;

public class Farmer extends SchessPiece {

    public Farmer(String color){
        super(color);
        this.NAME = "Bonde";
        this.setImg();

    }

    public boolean checkMove(int startX, int startY, int endX, int endY){
        System.err.println(startX + " : " + startY + " : "  + endX + " : " +  endY + " : ");
        if(startY == 1 || startY == 6){
            if(this.isWhite()){
                return ((startY-endY == 2 || startY-endY == 1)  && startX == endX);
            }
            else{
                return ((startY-endY == -2 || startY-endY == -1) && startX == endX);
            }
        }
        if(this.isWhite()){
            return (startY-endY == 1 && startX == endX);
        }
        else{
            return (startY-endY == -1 && startX == endX);
        }
    }

    public boolean checkMove(int startX, int startY, int endX, int endY, boolean occupied){
        if(this.isWhite()){
            if(startY-endY == 1){
                return Math.abs(startX-endX) == 1;
            }
            return false;
        }
        else{
            if(startY-endY == -1){
                return Math.abs(startX-endX) == 1;
            }
            return false;
        }
    }
}
