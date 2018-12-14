package chessGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewControl extends JFrame implements ActionListener {

    private ChessGame game;
    private JButton[][] board;
    private JPanel contentPanel;
    private JLabel mess;
    private JLabel titel;
    private JPanel panel;
    private int n;
    private JFrame frame;
    private GridBagConstraints c;

    ViewControl(ChessGame gm, int size){
        this.game=gm;
        this.n = size;

        //MainFrame
        this.frame = new JFrame("Game");

        // Content
        this.titel = new JLabel(this.game.gameName);
        this.panel = new JPanel(new GridLayout(size,size));

        // Panel to Store Content
        this.contentPanel = new JPanel(new GridBagLayout());
        this.c = new GridBagConstraints();

        // Messege
        this.mess = new JLabel("Ett spännande meddelande");

        // Stores Btns
        this.board =  new JButton[size][size];
    }

    // TODO: Skapa layouten här istället för att ha allt i main
    private void initGame(){

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
                this.mess.setText("Dåligt val");
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

                    this.mess.setText("Draget genomfördes");;
                    this.game.counter --;
                }
                else{
                    this.mess.setText("Inget drag");;
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

        // Add Titel
        vc.c.gridheight = 1;
        vc.c.gridwidth = 2;

        vc.c.gridx = 0;
        vc.c.gridy = 0;

        vc.contentPanel.add(vc.titel, vc.c);

        // Add Board
        vc.c.gridheight = 4;
        vc.c.gridwidth = 4;

        vc.c.gridx = 0;
        vc.c.gridy = 1;

        vc.contentPanel.add(vc.panel, vc.c);

        // Add messegePanel
        vc.c.gridheight = 1;
        vc.c.gridwidth = 2;

        vc.c.gridx = 2;
        vc.c.gridy = 5;

        vc.contentPanel.add(vc.mess, vc.c);

        // Add all in main Frame
        vc.frame.add(vc.contentPanel);

        vc.frame.setVisible(true);

        vc.rePaintFrame();

    }
}
