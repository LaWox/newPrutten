package labb3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;

class RPSSkel extends JFrame {
    GameBoard myboard, computersboard;
    int counter; // To count ONE ... TWO  and on THREE you play
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    JButton closebutton;

    RPSSkel () {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        closebutton = new JButton("Close");
        myboard = new GameBoard("Myself"); // Must be changed
        computersboard = new GameBoard("Computer");
        JPanel boards = new JPanel();
        boards.setLayout(new GridLayout(1,2));
        boards.add(myboard);
        boards.add(computersboard);
        add(boards, BorderLayout.CENTER);
        add(closebutton, BorderLayout.SOUTH);
        setSize(300, 550);
        setVisible(true);
    }

    public static void main (String[] u) {
        new RPSSkel();
    }
}