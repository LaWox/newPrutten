package labb2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Squares extends JButton {

    private JButton button;
    public int i;
    public int j;


    public Squares(int i, int j){
        this.button= new JButton();
        this.i=i;
        this.j=j;
    }
    /*public String toString(){
        return String.valueOf(i)+" "+ String.valueOf(j);
    }*/

   /*public void actionPerformed(ActionEvent e){
        System.err.println("hej");
    }*/
}
