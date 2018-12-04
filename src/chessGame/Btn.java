package chessGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Btn extends JButton implements ActionListener{

    int x;
    int y;
    boolean selected;

    public Btn(int row, int col){
        this.x = row;
        this.y = col;
        this.selected = false;
        this.addActionListener(this);
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public boolean isSelected(){
        return this.selected;
    }

    public void actionPerformed(ActionEvent e){
        System.err.println(this);
    }

    public void setSelected(boolean selected){
        this.selected = selected;
    }

    public String toString(){
        return this.x + " : " + this.y;
    }
}

