package labb2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewControl extends JFrame implements ActionListener{

    private Boardgame game;
    private Squares[][] board;
    private JLabel mess = new JLabel();
    private JPanel panel;
    private int n;
    private JFrame frame;
    private JLabel label;

    ViewControl (Boardgame gm, int n){
        this.n = n;
        this.game=gm;
        this.frame = new JFrame("Game");
        this.board = new Squares[n][n];
        this.panel = new JPanel(new GridLayout(n,n));
        //this.label=new JLabel("");
        //this.label.setLayout(new GridLayout(1,1));




    }

    public void actionPerformed(ActionEvent e){
        Object btn = e.getSource();
        if(btn instanceof Squares){
            //System.err.println(((Squares) btn).i + " " + ((Squares) btn).j);
            this.game.move(((Squares) btn).i, ((Squares) btn).j);
            //this.label.setText(this.game.getMessage());
            JOptionPane.showMessageDialog(null, this.game.getMessage());
            rePaint();


        }
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

    public static void main(String[] arg){
        int size = 4;
        FifteenModel gm = new FifteenModel(size);
        ViewControl vc = new ViewControl(gm, size);
        vc.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vc.frame.setSize(new Dimension(500, 500));
        vc.frame.setVisible(true);

        vc.panel.setVisible(true);
        vc.panel.setBackground(Color.BLUE);


        vc.add_buttons();
        //vc.panel.add(vc.label);
        vc.frame.add(vc.panel);



        vc.rePaint();

    }
}
