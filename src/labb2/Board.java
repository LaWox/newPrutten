package labb2;

public class Board {
    int size;
    public GamePieces[][] board;

    public Board(int size){
        this.board = new GamePieces[size][size];
    }
}
