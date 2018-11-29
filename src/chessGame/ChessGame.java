package chessGame;

public class ChessGame {
    ChessBoard board;

    ChessGame(){
        this.board = new ChessBoard();
        this.board.setUp();
    }

    public String getStatus(int x, int y){
        return this.board.matrix[x][y].toString();
    }

    public static void main(String[] args){
        ChessGame game = new ChessGame();
        game.board.printBoard();
    }
}
