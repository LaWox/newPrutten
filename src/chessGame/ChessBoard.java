package chessGame;
import chessGame.chessPieces.*;

public class ChessBoard {

    public static int size = 8;
    SchessPiece[][] matrix;

    ChessBoard(){
        this.matrix = new SchessPiece[size][size];
    }

    public int getSize(){
        return size;
    }

    public void setUp(){
        for(int row = 0; row < 2; row ++){
            for(int col = 0; col < 8; col ++){
                if(row == 1){
                    this.matrix[row][col] = new Farmer("black");
                    this.matrix[size-2][col] = new Farmer("white");
                }
                else {
                    if(col == 0){
                        this.matrix[row][col] = this.matrix[row][7-col] = new Tower("black");
                        this.matrix[7-row][col] = this.matrix[7-row][7-col] = new Tower("white");
                    }
                    else if(col == 1){
                        this.matrix[row][col] = this.matrix[row][7-col] = new Horse("black");
                        this.matrix[7-row][col] = this.matrix[7-row][7-col] = new Horse("white");
                    }
                    else if(col == 2){
                        this.matrix[row][col] = this.matrix[row][7-col] = new Runner("black");
                        this.matrix[7-row][col] = this.matrix[7-row][7-col] = new Runner("white");
                    }
                    else if(col == 3){
                        this.matrix[row][col] = new King("black");
                        this.matrix[7-row][col] = new King("white");

                        this.matrix[row][7-col] = new Queen("black");
                        this.matrix[7-row][7-col] = new Queen("white");
                    }
                }
            }
        }


    }

    public boolean isOccupied(int x, int y){
        return (!(this.matrix[x][y] == null));
    }

    public void printBoard(){
        for (int j = 0; j<size; j++) {
            for (int i = 0; i < size; i++) {
                System.out.print(this.matrix[j][i]+ " : ");
            }
            System.out.println();

        }
    }

}
