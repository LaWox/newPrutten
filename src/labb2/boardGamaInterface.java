package labb2;

public interface boardGamaInterface {
    boolean move(int i, int j); //ger true om draget gick bra, annars false
    String getStatus(int i, int j); // returnera innehåll på ruta (i,j)
    String getMessage(); // returnera OK (eller liknande) eller felmeddelande avseende senaste drag
}
