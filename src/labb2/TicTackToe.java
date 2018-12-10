package labb2;

public class TicTackToe implements Boardgame{

    private int size;
    private String[][] board;
    private boolean moveCompleted;
    private int x;
    private int y;
    private boolean turn;
    private int count;

    public TicTackToe(int size) {
        this.board= new String[size][size];
        this.moveCompleted = false;
        this.x=x;
        this.y=y;
        this.size=size;
        this.turn=true;
        this.count=0;

    }

    public void setXY(int x, int y){
        this.x=x;
        this.y=y;
    }

    public boolean move(int i, int j){
        String playerSymb = turn ? "X" : "O";

        if (this.count<this.size*2){
            if(getStatus(i,j)== null){
                setStatus(i, j, playerSymb);
                turn=!turn;
                this.count++;
                return true;
            }
        }
        else {
            if (count%2==1){
                if( endingTile(i, j)){
                    setStatus(i, j, playerSymb);
                    setStatus(x, y, null);
                    count++;
                    turn=!turn;
                    return true;
                }
            }
            else{
                if( chooseTile(i, j)){
                    count++;
                    return true;
                }
            }

        }
    return false;
    }

    public boolean endingTile(int i, int j){
        if(getStatus(i, j)==null){
            if (Math.abs(x+y-i-j)<3 ){
                return true;
            }
        }
        return false;
    }

    public boolean chooseTile(int i, int j){
        if(getStatus(i,j)==null){
            return false;
        }
        if(getStatus(i, j).equals("X") && turn){
            setXY(i, j);
            return true;
        }
        else if (getStatus(i, j).equals("O") && !turn ){
            setXY(i, j);
            return true;
        }

        return false;
    }

    public String getStatus(int i, int j){
        return this.board[i][j];
    }

    public String getMessage(){
       if(turn) {
           return "Spelare1's tur";
       }

       else {
           return "Spelare2's tur";
       }
    }

    public void setStatus(int i, int j, String value){
        this.board[i][j]=value;
    }

    public static void main(String[] a){
        TicTackToe tick= new TicTackToe(3);
        ViewControl view = new ViewControl(tick, tick.size);

    }
}
