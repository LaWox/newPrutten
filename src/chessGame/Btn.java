package chessGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Btn extends JButton implements ActionListener{

    private int x;
    private int y;
    private boolean selected;
    private Color color;

    public Btn(int row, int col){
        this.x = row;
        this.y = col;
        this.selected = false;
        //this.addActionListener(this);
    }

    public Color getColor(){
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getGridX(){
        return this.x;
    }

    public int getGridY(){
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

