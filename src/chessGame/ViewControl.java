package chessGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(size,size));
        this.board =  new JButton[size][size];
    }

    public void actionPerformed(ActionEvent e){
        Btn clickedBtn = (Btn) e.getSource();
        int x = clickedBtn.getX();
        int y = clickedBtn.getY();
        int startX = this.game.startPos[0];
        int startY = this.game.startPos[1];

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
                clickedBtn.setBackground(clickedBtn.getColor());
                this.game.chosenPiece = null;
                this.game.counter --;
            }
            else{
                if(this.game.moveOk(x, y)){
                    this.game.makeMove(x, y);
                    clickedBtn.setIcon(this.game.chosenPiece.getImg());

                    this.game.board.matrix[game.startPos[0]][game.startPos[1]] = null;
                    this.board[startX][startY].setBackground(this.game.colorPicker(startX, startY));
                    this.board[this.game.startPos[0]][this.game.startPos[1]].setSelected(false);

                    this.game.chosenPiece = null;

                    System.err.println("moveMade");
                    this.game.counter --;
                }
                else{
                    System.err.println("no move made");
                }
            }
            //System.err.println(game.moveSucess);
        }
        //System.err.println("white's turn: " + this.game.whitesTurn);
        System.err.println("counter: " +  game.counter);
        //System.err.println("chosen piece: " +  game.chosenPiece.toString());

        this.rePaintFrame();
    }

    private void add_buttons(){
        for(int i=0; i<this.n; i++){
            for(int j=0; j<this.n; j++){
                Btn newBtn  = new Btn(i, j);
                newBtn.addActionListener(this);
                newBtn.setColor(this.game.colorPicker(i, j));
                newBtn.setBackground(newBtn.getColor());
                this.board[i][j] = newBtn;
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
                        this.board[i][j].setIcon(null);
                        this.board[i][j].setText("");
                    }
                }
            }
    }

    private void rePaintFrame(){
        this.populateBoard();
    }

    public static void main(String[] arg){
        ChessGame game = new ChessGame();
        int size = game.board.getSize();

        ViewControl vc = new ViewControl(game, size);

        vc.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vc.frame.setSize(new Dimension(700, 700));

        vc.add_buttons();

        vc.frame.add(vc.panel);

        vc.panel.setVisible(true);
        vc.frame.setVisible(true);

        vc.panel.setOpaque(true);
        vc.panel.validate();
        vc.panel.repaint();
        vc.panel.revalidate();
        vc.rePaintFrame();
        vc.frame.validate();
    }
}
