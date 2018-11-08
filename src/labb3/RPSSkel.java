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
    String[] numbersInText;

    RPSSkel () {
        numbersInText = new String[]{"One!", "Two!"};
        counter = 0;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        closebutton = new JButton("Close");
        closebutton.addActionListener(new Close());

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

    class Close implements ActionListener {

        public void actionPerformed(ActionEvent e){
            model.out.println("");
            model.out.flush();
            System.exit(0);
        }
    }

    class Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //System.out.println(model);
            //System.out.println(e.getActionCommand());
            if(counter == 0){
                myboard.resetColor();
                computersboard.resetColor();
                myboard.setUpper("RPS");
                computersboard.setUpper("RPS");
            }
            counter ++;

            model.out.println("En input");
            model.out.flush();
            String compHand = model.getCompHand(model.in);
            String result = model.compare(compHand, e.getActionCommand());
            //System.out.println(result);

            if(counter == 3){
                myboard.setUpper(e.getActionCommand());
                computersboard.setUpper(compHand);

                myboard.markPlayed(e.getActionCommand());
                computersboard.markPlayed(compHand);

                counter = 0;

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

            else{
                myboard.setLower(numbersInText[counter-1]);
                computersboard.setLower(numbersInText[counter-1]);
            }


        }
    }

    public static void main (String[] u) {
        RPSSkel skel = new RPSSkel();




    }
}
