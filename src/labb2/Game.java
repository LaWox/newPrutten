package labb2;

public class Game implements boardGamaInterface {

    int size = 4;
    Board new_board;

    public Game(){
        this.new_board= new Board(size);
        this.new_board.setUp();
    }

    public boolean move(int i, int j) {
        if (this.new_board.isOccupied(i, j)){
            for (int k=-1; k<=1; k+=2){
                try{
                   if( !(new_board.isOccupied(i, j+k)))
                    {
                       this.new_board.board_matrix[i][j+k]=this.new_board.board_matrix[i][j];
                       this.new_board.board_matrix[i][j]=null;
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                try{
                    new_board.isOccupied(i+k, j);
                    if( !(new_board.isOccupied(i+k, j)))
                    {
                        this.new_board.board_matrix[i+k][j]=this.new_board.board_matrix[i][j];
                        this.new_board.board_matrix[i][j]=null;
                    }
                }
                catch (IndexOutOfBoundsException e){
                }

            }
        }

        return false;
    }

    public String getMessage() {
        return null;
    }

    public String getStatus(int i, int j) {
        return null;
    }

    public static void main(String[] args){
        Game new_game=new Game();
        new_game.new_board.printBoard();
        new_game.move(2, 2);
        new_game.new_board.printBoard();

    }
}

