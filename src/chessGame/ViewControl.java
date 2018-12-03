package chessGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import chessGame.chessPieces.*;
public class ViewControl extends JFrame implements ActionListener {

    private Boardgame game;
    private Btn[][] board;
    private JLabel mess = new JLabel();
    private JPanel panel;
    private int n;
    private JFrame frame;


    ViewControl(ChessGame gm, int size){
        this.game=gm;
        this.n = size;
        this.frame = new JFrame("Game");
        this.board = new Btn[size][size];
        this.panel = new JPanel(new GridLayout(size,size));

    }

    public void actionPerformed(ActionEvent e){
        System.out.println(this);
    }

    private void add_buttons(){
        for(int i=0; i<this.n; i++){
            for(int j=0; j<this.n; j++){
                this.board[i][j] = new Btn(i, j);
                this.panel.add(this.board[i][j]);
            }
        }

    }

    private void populateBoard(){
        for(int i=0; i<this.n; i++){
            for(int j=0; j<this.n; j++){
                try{
                    if(this.game.getStatus(i, j) instanceof SchessPiece){
                        this.board[i][j].setIcon(((SchessPiece) this.game.getStatus(i, j)).getImg());
                        System.err.println(this.game.getStatus(i,j).toString());
                        this.panel.add(this.board[i][j]);
                    }

                }
                catch (NullPointerException e){
                    this.board[i][j].setText(" hej ");
                    this.panel.add(this.board[i][j]);
                }

            }
        }
    }

    private void rePaint(){
        this.populateBoard();
        //this.frame.validate();
    }

    public static void main(String[] arg){
        ChessGame game = new ChessGame();
        int size = game.board.getSize();
        ViewControl vc = new ViewControl(game, size);
        vc.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vc.frame.setSize(new Dimension(800, 800));
        vc.frame.setVisible(true);

        vc.panel.setVisible(true);

        vc.add_buttons();

        vc.frame.add(vc.panel);
        vc.populateBoard();

        vc.frame.validate();
    }
}
