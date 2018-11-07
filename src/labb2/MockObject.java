package labb2;

public class MockObject implements Boardgame {

    private Board board;
    private int size;

    MockObject(int size){
        this.board=new Board(size);
        this.board.setUp();
        this.size=size;

    }

    public boolean move(int i, int j) {
        try {
            //this.board[i][j];
            this.getMessage();
            System.out.println("The move was a succes!");
            return true;
        }
        catch (IndexOutOfBoundsException e) {
            this.getMessage();
            System.out.println("Index error");
            return false;
         }
     }


    public String getStatus(int i, int j) {
        try{
            return String.valueOf(this.board.board_matrix[i][j].value);
        }

        catch(IndexOutOfBoundsException e){
             return null;
        }
    }

    public String getMessage(){
        return "Your move was processed";

    }
}
