package chessGame;

import chessGame.chessPieces.*;
import java.util.Scanner;

public class ChessGame extends Boardgame{
    ChessBoard board;
    SchessPiece chosenPiece;
    int[] startPos;
    boolean moveSucess;
    boolean whitesTurn;
    int counter;

    ChessGame(){
        this.board = new ChessBoard();
        this.board.setUp();
        this.startPos = new int[2];
        this.moveSucess = false;
        this.whitesTurn = true;
        this.counter = 0;
    }

    public void setStartPos(int x,  int y){  //sätter den valda startPositionen
        this.startPos[0] = x;
        this.startPos[1] = y;
    }


    public boolean startOk(int x, int y){  // ser till att startRutan har en pjäs på sig och att den pjäsen har rätt färg
        return this.whitesTurn && (this.board.isOccupied(x,y) && this.board.matrix[x][y].isWhite());
    }

    public boolean moveOk(int endX, int endY){
        if(this.board.isOccupied(endX, endY)){
        }
        if(this.board.isOccupied(endX, endY) && this.chosenPiece.getName().equals("Bonde")){
                Farmer farmer  = (Farmer) this.chosenPiece;
                return farmer.checkMove(this.startPos[0], this.startPos[1], endX, endY, true);
            }
        else{
            return this.chosenPiece.checkMove(startPos[0], startPos[1], endX, endY);
        }
    }

    public void makeMove(int x, int y){     //utför drag ifall drag giltigt, assignar moveSuccess därefter
        try{
            if(moveOk(x, y)){
                int startX = this.startPos[0];
                int startY = this.startPos[1];
                this.board.matrix[x][y] = this.board.matrix[startX][startY];
                this.board.matrix[startX][startY] = null;
                this.moveSucess  = true;

            }
            else{
                this.moveSucess = false;
            }
            this.whitesTurn = !this.whitesTurn;
        }
        catch (IndexOutOfBoundsException e){
            this.moveSucess = false;
        }

    }


    public String getMessage(){
        if(moveSucess){
            return "move Completed";
        }
        else{
            return "move invalid";
        }
    }


    public SchessPiece getStatus(int x, int y){
        if(this.board.isOccupied(x,y)){
            return this.board.matrix[x][y];
        }
        else{
            return null;
        }

    }

    public static void main(String[] args){
        ChessGame game = new ChessGame();
        //game.board.setUp();
        Scanner input = new Scanner(System.in);
        while(true){
            game.board.printBoard();

            System.out.println("------------------------------" + "\n");
            System.out.println("Skriv in start och slutPlats");
            game.startPos[0] = input.nextInt();
            game.startPos[1] = input.nextInt();
            System.err.println(game.board.matrix[game.startPos[0]][game.startPos[1]]);
            game.chosenPiece = game.board.matrix[game.startPos[0]][game.startPos[1]];
            int endY = input.nextInt();
            int endX = input.nextInt();
            game.makeMove(endX,endY);
            System.err.println(game.getMessage());
        }

    }
}
