package chessGame;

public abstract class Boardgame {

    abstract boolean moveOk(int x, int y); //ger true om draget gick bra, annars false
    abstract Object getStatus(int i, int j); // returnera innehåll på ruta (i,j)
    abstract String getMessage(); // returnera OK (eller liknande) eller felmeddelande avseende senaste drag
}
