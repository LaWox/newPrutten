package labb2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewControl extends JFrame{

    private Boardgame game;
    private JButton[][] board;
    private JLabel mess = new JLabel();
    private JPanel panel;
    private int n;
    private JFrame frame;

    ViewControl (Boardgame gm, int n){
        this.n = n;
        //this.game=gm;
        this.frame = new JFrame("Game");
        this.board = new JButton[n][n];
        this.panel = new JPanel(new GridLayout(n,n));

    }

    private void add_buttons(){
        for(int i=0; i<this.n; i++){
            for(int j=0; j<this.n; j++){
                this.board[i][j] = new JButton("");
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

    public static void main(String[] arg){
        ViewControl vc = new ViewControl(null, 4);
        vc.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vc.frame.setSize(new Dimension(500, 500));
        vc.frame.setVisible(true);

        vc.panel.setVisible(true);
        vc.panel.setBackground(Color.BLUE);

        vc.add_buttons();

        vc.frame.add(vc.panel);
        vc.rePaint();
        vc.frame.validate();
    }
}
