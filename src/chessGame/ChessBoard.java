package chessGame;
import chessGame.chessPieces.SchessPiece;

public class ChessBoard {

    SchessPiece[][] board;

    ChessBoard(){
        this.board = new SchessPiece[8][8];
    }

    private void setUp(){
    }

    public boolean isOccupied(int x, int y){
        return (this.board[x][y] == null);
    }

    public void printBoard(){
        for (int j = 0; j<this.board.length; j++) {
            for (int i = 0; i < this.board.length; i++) {
                System.out.println(this.board[j][i]+ " ");
            }
            System.out.println();

        }
    }


}
