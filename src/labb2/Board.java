package labb2;

public class Board {
    int size;
    public GamePieces[][] board_matrix;

    public Board(int size){
        this.board_matrix = new GamePieces[size][size];
        this.size=size;
    }

    public void setUp(){
        int count = 1;
        for (int j = 0; j<this.size; j++) {
            for (int i = 0; i < this.size; i++) {

                GamePieces new_piece = new GamePieces(count);
                this.board_matrix[j][i] = new_piece;
                count++;
            }

        }
        this.board_matrix[this.size-1][this.size-1] = null;
    }

    public boolean isOccupied(int i, int j) {
        return !(this.board_matrix[i][j] == null);
    }


    public void printBoard(){
        for (int j = 0; j<this.size; j++) {
            for (int i = 0; i < this.size; i++) {
                System.out.print(this.board_matrix[j][i]+ " ");
            }
            System.out.println();

        }
    }

}
