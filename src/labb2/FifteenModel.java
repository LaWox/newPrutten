package labb2;

public class FifteenModel implements Boardgame {

    private int size = 4;
    private Board new_board;
    private boolean moveCompleted;

    public FifteenModel(){
        this.new_board= new Board(size);
        this.new_board.setUp();
        this.scramble(10000);
        this.moveCompleted = false;
    }

    public boolean move(int i, int j) {
        try{
            if (this.new_board.isOccupied(i, j)){
                for (int k=-1; k<=1; k+=2){
                    try{
                        if( !(new_board.isOccupied(i, j+k))){
                            this.new_board.board_matrix[i][j+k]=this.new_board.board_matrix[i][j];
                            this.new_board.board_matrix[i][j]=null;
                            this.moveCompleted = true;
                            return true;
                        }
                    }
                    catch(IndexOutOfBoundsException e){

                    }

                    try{
                        if( !(new_board.isOccupied(i+k, j))) {
                            this.new_board.board_matrix[i+k][j]=this.new_board.board_matrix[i][j];
                            this.new_board.board_matrix[i][j]=null;
                            this.moveCompleted = true;
                            return true;
                        }
                    }
                    catch (IndexOutOfBoundsException e){

                    }
                }
            }
        }

        catch(IndexOutOfBoundsException e){

        }

        this.moveCompleted = false;
        return false;
    }

    public String getMessage() {
        if(this.moveCompleted){
            return "moveOK";
        }
        else{
            return "invalid move";
        }
    }

    public String getStatus(int i, int j) {
        if(this.new_board.isOccupied(i, j)){
            return String.valueOf(this.new_board.board_matrix[i][j].value);
        }
        else{
            return null;
        }
    }

    public static void main(String[] args){
        FifteenModel new_fifteenModel = new FifteenModel();
        new_fifteenModel.new_board.printBoard();
        new_fifteenModel.move(2, 2);
        new_fifteenModel.new_board.printBoard();

    }

    public void scramble(int noRuns){
        //scrambles the board
        int row;
        int col;
        for(int i = 0; i < noRuns; i ++){
            row = (int) Math.floor(Math.random()*4);
            col = (int) Math.floor(Math.random()*4);
            this.move(row, col);
        }
    }
}

