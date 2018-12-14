package chessGame;

import chessGame.chessPieces.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Scanner;

public class ChessGame extends Boardgame{
    ChessBoard board;
    SchessPiece chosenPiece;
    int[] startPos;
    boolean moveSucess;
    private boolean whitesTurn;
    int counter;
    String gameName;

    ChessGame(){
        this.board = new ChessBoard();
        this.startPos = new int[2];
        this.moveSucess = false;
        this.whitesTurn = true;
        this.counter = 0;
        this.chosenPiece = null;
        this.gameName = "Chess";
    }

    public void setStartPos(int x,  int y){  //sätter den valda startPositionen
        this.startPos[0] = x;
        this.startPos[1] = y;
    }

    public boolean startOk(int x, int y){  // ser till att startRutan har en pjäs på sig och att den pjäsen har rätt färg
        return (this.board.isOccupied(x,y)) && (this.whitesTurn == this.board.matrix[x][y].isWhite());
    }

    public boolean moveOk(int endX, int endY){
        // kollar ifall något är ivägen
        if(!this.pathClear(this.startPos[0], this.startPos[1], endX, endY)){
            return false;
        }

        // Kan inte flytta till plats där pjäs av samma färg står
        if(this.board.isOccupied(endX, endY) && this.getStatus(endX, endY).isWhite() == this.whitesTurn){
            return false;
        }

        // specialFall för Bonde
        if(this.board.isOccupied(endX, endY) && this.chosenPiece instanceof Farmer){
                Farmer farmer  = (Farmer) this.chosenPiece;
                return farmer.checkMove(this.startPos[1], this.startPos[0], endY, endX, true);
            }

        // Kallar på checkMove för varje pjäs
        else{
            return this.chosenPiece.checkMove(startPos[1], startPos[0], endY, endX);
        }
    }

    public boolean makeMove(int x, int y){     //utför drag ifall drag giltigt, assignar moveSuccess därefter
        try{
            if(moveOk(x, y)){
                int startX = this.startPos[0];
                int startY = this.startPos[1];
                this.board.matrix[x][y] = this.board.matrix[startX][startY];
                this.board.matrix[startX][startY] = null;
                this.moveSucess  = true;
                this.whitesTurn = !this.whitesTurn;
                return true;
            }
            else{
                this.moveSucess = false;
                return false;
            }
        }
        catch (IndexOutOfBoundsException e){
            this.moveSucess = false;
            return false;
        }

    }

    private boolean pathClear(int startX, int startY, int endX, int endY){
        if(this.chosenPiece instanceof Horse){
            return true;
        }
        int dX = endX - startX;
        int dY = endY - startY;

        System.err.println("dx: " + dX+  "dy: " + dY);
        int magnitude = (Math.abs(dX) <= Math.abs(dY)) ? Math.abs(dY): Math.abs(dX);

        System.err.println("mag" + magnitude);
        int xDir = (dX == 0) ? 0: dX/Math.abs(dX);
        int yDir = (dY == 0) ? 0: dY/Math.abs(dY);

        System.err.println("xdir: " + xDir + " yDir: " + yDir);

        for(int i = 1; i < magnitude; i++){
            System.err.println(startX+(xDir*i) + " : " + startY+(yDir*i));
            if(this.board.isOccupied(startX+(xDir*i), startY+(yDir*i))){
                System.err.println("pathObstruction");
                return false;
            }
        }
        return true;
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

    public Color colorPicker(int x, int y){
        if(x % 2 == 0 && y % 2 == 0){
            return Color.lightGray;
        }
        else if(x % 2 != 0 && y % 2 != 0){
            return Color.lightGray;
        }
        else{
            return Color.white;
        }
    }

    /*
    public void takeAction(ActionEvent e){
        Btn clickedBtn = (Btn) e.getSource();
        int x = clickedBtn.getX();
        int y = clickedBtn.getY();
        int startX = this.startPos[0];
        int startY = this.startPos[1];

        if(counter == 0){
            if(this.startOk(x , y)){
                this.setStartPos(x, y);
                clickedBtn.setBackground(Color.green);
                clickedBtn.setSelected(true);
                this.chosenPiece = this.getStatus(x, y);
                this.counter ++;
            }
            else{
                System.err.println("dåligt val");
            }
        }
        else{
            if(clickedBtn.isSelected()){
                clickedBtn.setSelected(false);
                clickedBtn.setBackground(clickedBtn.getColor());
                this.chosenPiece = null;
                this.counter --;
            }
            else{
                if(this.moveOk(x, y)){
                    this.makeMove(x, y);
                    clickedBtn.setIcon(this.chosenPiece.getImg());

                    this.board.matrix[this.startPos[0]][this.startPos[1]] = null;
                    this.board[startX][startY].setBackground(this.colorPicker(startX, startY));
                    this.board[this.startPos[0]][this.startPos[1]].setSelected(false);

                    this.chosenPiece = null;

                    System.err.println("moveMade");
                    this.counter --;
                }
                else{
                    System.err.println("no move made");
                }
            }
            //System.err.println(game.moveSucess);
        }
        //System.err.println("white's turn: " + this.game.whitesTurn);
        System.err.println("counter: " +  this.counter);
        //System.err.println("chosen piece: " +  game.chosenPiece.toString());

        this.rePaintFrame();
    }
    */
}
