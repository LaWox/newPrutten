package chessGame.chessPieces;

public class Runner extends SchessPiece {

    public Runner(String color){
        super(color);
        this.NAME = "Löpare";
        this.setImg();
    }

    public boolean checkMove(int startx, int startY, int endX, int endY ){
        try{
            return (Math.abs(startY-endY) / Math.abs(startx-endX))==1;
        }
        //ogiltigt drag ifall derivatan blir 0
        catch (ArithmeticException e ){
            return false;
        }

    }
}
