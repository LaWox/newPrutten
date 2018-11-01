package labb2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewControl extends JFrame implements ActionListener {

    private Boardgame game;
    private JButton[][] board;
    private JLabel mess = new JLabel();
    private JPanel panel;
    private int n;

    ViewControl (Boardgame gm, int n){
        this.n=n;
        this.game=gm;
        this.board= new JButton[n][n];
        this.panel=new JPanel(new GridLayout(n,n));

    }

    private void add_buttons(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                this.board[i][j]=new JButton("");
                this.panel.add(this.board[i][j]);
            }
        }

    }

    public static void main(String[] arg){
        ViewControl vc = new ViewControl()
    }
}
