package chessGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewControl extends JFrame implements ActionListener {

    private ChessGame game;
    private JButton[][] board;
    private int n;
    private JFrame frame;
    private JPanel main_panel;

    ViewControl(ChessGame gm, int size){
        this.game=gm;
        this.n = size;

        this.frame = new JFrame(game.gameName);

        // Stores Btns
        this.board =  new JButton[size][size];

        // Panel
        this.main_panel=new JPanel(new GridLayout(size,size));

        //Initiate
        this.init();
    }

    public void actionPerformed(ActionEvent e){
        Btn clickedBtn = (Btn) e.getSource();
        int x = clickedBtn.getGridX();
        int y = clickedBtn.getGridY();
        int startX = this.game.startPos[0];
        int startY = this.game.startPos[1];

        if(game.counter == 0){
            this.game.moveSucess = false;
            if(this.game.startOk(x , y)){
                game.setStartPos(x, y);
                clickedBtn.setBackground(Color.green);
                clickedBtn.setSelected(true);
                game.chosenPiece = game.getStatus(x, y);
                game.counter ++;
            }
            else{
                JOptionPane.showMessageDialog(this.frame, this.game.getMessage());
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

                    this.game.counter --;
                }
                else{
                    JOptionPane.showMessageDialog(this.frame, this.game.getMessage());
                }
            }
        }
        this.rePaintFrame();
    }

    private void add_buttons(){
        for(int i=0; i<this.n; i++){
            for(int j=0; j<this.n; j++){
                Btn newBtn  = new Btn(i, j);
                newBtn.setVisible(true);
                newBtn.addActionListener(this);
                //For mac:
                newBtn.setOpaque(true);

                newBtn.setColor(this.game.colorPicker(i, j));
                newBtn.setBackground(newBtn.getColor());
                this.board[i][j] = newBtn;
                this.main_panel.add(this.board[i][j]);
            }
        }
    }

    private void populateBoard(){
        for(int i=0; i<this.n; i++){
            for(int j=0; j<this.n; j++){
                    if(this.game.getStatus(i, j) != null){
                        this.board[i][j].setIcon(this.game.getStatus(i, j).getImg());
                        this.main_panel.add(this.board[i][j]);
                    }
                    else{
                        this.board[i][j].setIcon(null);
                        this.board[i][j].setText("");
                        this.main_panel.add(this.board[i][j]);
                    }
                }
            }
    }

    private void rePaintFrame(){
        this.populateBoard();
        this.frame.validate();
    }

    private void init(){
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(new Dimension(700, 700));
        //vc.frame.setLayout(new GridLayout(size, size));
        this.frame.setVisible(true);

        this.add_buttons();

        this.frame.add(this.main_panel);

        this.rePaintFrame();
    }

    public static void main(String[] arg){
        ChessGame game = new ChessGame();
        int size = game.board.getSize();
        ViewControl vc = new ViewControl(game, size);
    }
}
