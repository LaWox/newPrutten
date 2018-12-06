package chessGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import chessGame.chessPieces.*;
public class ViewControl extends JFrame implements ActionListener {

    private ChessGame game;
    private JButton[][] board;
    private JLabel mess = new JLabel();
    private JPanel panel;
    private int n;
    private JFrame frame;


    ViewControl(ChessGame gm, int size){
        this.game=gm;
        this.n = size;
        this.frame = new JFrame("Game");
        this.board =  new JButton[size][size];
        this.panel = new JPanel(new GridLayout(size,size));

    }

    public void actionPerformed(ActionEvent e){
        Btn clickedBtn = (Btn) e.getSource();
        int x = clickedBtn.getX();
        int y = clickedBtn.getY();

        System.err.println("counter: " +  game.counter);
        if(game.counter == 0){
            if(this.game.startOk(x , y)){
                game.setStartPos(x, y);
                clickedBtn.setBackground(Color.green);
                clickedBtn.setSelected(true);
                game.chosenPiece = game.getStatus(x, y);
                game.counter ++;

            }
            else{
                System.err.println("dåligt val");
            }
        }
        else{
            if(clickedBtn.isSelected()){
                clickedBtn.setSelected(false);
                clickedBtn.setBackground(Color.white);
                game.chosenPiece = null;
                game.counter --;

            }
            else{
                if(game.moveOk(x, y)){
                    game.makeMove(x, y);
                    clickedBtn.setIcon(null);
                    game.counter --;
                }
                else{
                    System.err.println("no move made");
                }
            }
            System.err.println(game.moveSucess);
        }
        //this.rePaint();
    }

    private void add_buttons(){
        for(int i=0; i<this.n; i++){
            for(int j=0; j<this.n; j++){
                this.board[i][j] = new Btn(i, j);
                this.board[i][j].addActionListener(this);
                this.board[i][j].setBackground(Color.white);
                this.panel.add(this.board[i][j]);
            }
        }
    }

    private void populateBoard(){
        for(int i=0; i<this.n; i++){
            for(int j=0; j<this.n; j++){
                    if(this.game.getStatus(i, j) != null){
                        this.board[i][j].setIcon(this.game.getStatus(i, j).getImg());
                    }
                    else{
                        this.board[i][j].setText("");
                    }
                }
            }
    }


    private void rePaint(){
        this.populateBoard();
        this.frame.repaint();
        this.frame.validate();
    }

    public static void main(String[] arg){
        ChessGame game = new ChessGame();
        int size = game.board.getSize();
        ViewControl vc = new ViewControl(game, size);
        vc.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vc.frame.setSize(new Dimension(700, 700));

        vc.frame.setVisible(true);
        vc.panel.setVisible(true);

        vc.add_buttons();
        vc.frame.add(vc.panel);
        vc.populateBoard();
        vc.rePaint();
    }
}
