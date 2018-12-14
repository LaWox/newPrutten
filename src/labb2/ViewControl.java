package labb2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewControl extends JFrame implements ActionListener {

    private Boardgame game;
    private Squares[][] board;
    private JLabel mess = new JLabel();
    private JPanel panel;
    private int n;
    private JFrame frame;

    ViewControl (Boardgame gm, int n){
        this.n = n;
        this.game=gm;
        this.frame = new JFrame("Game");
        this.board = new Squares[n][n];
        this.panel = new JPanel(new GridLayout(n,n));
        this.init();

    }

    public void actionPerformed(ActionEvent e){
        Squares square = (Squares) e.getSource();
        game.move( square.i,square.j );
        this.rePaint();

    }

    private void add_buttons(){
        for(int i=0; i<this.n; i++){
            for(int j=0; j<this.n; j++){
                this.board[i][j] = new Squares(i, j);
                this.board[i][j].addActionListener(this);
                this.panel.add(this.board[i][j]);
            }
        }
    }

    private void populateBoard(){
        for(int i=0; i<this.n; i++){
            for(int j=0; j<this.n; j++){
                this.board[i][j].setText(this.game.getStatus(i,j));
                this.panel.add(this.board[i][j]);
            }
        }
    }

    private void rePaint(){
        this.populateBoard();
        this.frame.validate();
    }

    private void init(){
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(new Dimension(500, 500));
        this.frame.setVisible(true);

        this.panel.setVisible(true);
        this.panel.setBackground(Color.BLUE);

        this.add_buttons();

        this.frame.add(this.panel);
        this.rePaint();

    }

    public static void main(String[] arg){

    }
}
