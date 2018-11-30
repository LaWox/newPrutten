package chessGame;

import chessGame.chessPieces.*;
import java.util.Scanner;

public class ChessGame implements Boardgame{
    ChessBoard board;
    SchessPiece chosenPiece;
    int[] startPos;

    ChessGame(){
        this.board = new ChessBoard();
        this.board.setUp();
        this.startPos = new int[2];
    }

    public boolean move(int endX, int endY){
        if(this.board.isOccupied(endX, endY) && this.chosenPiece.getName().equals("Bonde")){
                Farmer farmer  = (Farmer) this.chosenPiece;
                return farmer.checkMove(this.startPos[0], this.startPos[1], endX, endY, true);
            }
        else{
            return this.chosenPiece.checkMove(startPos[0], startPos[1], endX, endY);
        }
    }



    public String getMessage(){
        return "hej";
    }

    public String getStatus(int x, int y){
        return this.board.matrix[x][y].toString();
    }

    public static void main(String[] args){
        ChessGame game = new ChessGame();
        Scanner input = new Scanner(System.in);
        while(true){
            game.board.printBoard();
            int startX = input.nextInt();
            int startY = input.nextInt();

        }

    }
}
