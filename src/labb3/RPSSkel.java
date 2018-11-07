package labb3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class RPSSkel extends JFrame {
    GameBoard myboard, computersboard;
    RPSModel model;
    int counter; // To count ONE ... TWO  and on THREE you play
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    JButton closebutton;

    RPSSkel () {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        closebutton = new JButton("Close");
        myboard = new GameBoard("Myself", new Action()); // Must be changed
        computersboard = new GameBoard("Computer");
        model =  new RPSModel("localhost",4713, "EttNamn" );
        JPanel boards = new JPanel();
        boards.setLayout(new GridLayout(1,2));
        boards.add(myboard);
        boards.add(computersboard);
        add(boards, BorderLayout.CENTER);
        add(closebutton, BorderLayout.SOUTH);
        setSize(300, 550);
        setVisible(true);
    }

    class Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println(model);
            System.out.println(e.getActionCommand());
            model.out.println("heej");
            model.out.flush();
            String result = model.compare(model.getCompHand(model.in),e.getActionCommand());
            System.out.println(result);
            if (result.equals("WIN")){
                myboard.wins();
                myboard.setLower(result);
                computersboard.setLower("LOSE");

            }

            else if (result.equals("LOSS")){
                computersboard.wins();
                computersboard.setLower("WIN");
                myboard.setLower(result);

            }

            else{
                computersboard.setLower(result);
                myboard.setLower(result);
            }

        }
    }

    public static void main (String[] u) {
        RPSSkel skel = new RPSSkel();




    }
}