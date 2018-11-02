package labb2;

import javax.swing.*;

public class Squares extends JButton {

    private JButton button;
    private int i;
    private int j;


    public Squares(int i, int j){
        this.button= new JButton();
        this.i=i;
        this.j=j;
    }
    public String toString(){
        return String.valueOf(i)+" "+ String.valueOf(j);
    }
}
