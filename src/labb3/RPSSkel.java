package labb3;

import Labb1.MyButton;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import javax.sound.sampled.*;

public class RPSSkel extends JFrame {
    GameBoard myboard, computersboard;
    RPSModel model;
    int counter; // To count ONE ... TWO  and on THREE you play
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    JButton closebutton;
    String[] numbersInText;
    AudioInputStream audio;
    Clip clip;

    MyButton soundBtn;
    private boolean playSound;

    RPSSkel () {
        numbersInText = new String[]{"One!", "Two!"};
        counter = 0;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        soundBtn = new MyButton(Color.green, Color.red, "SOund/ON", "Sound/OFF");
        soundBtn.myBtn.addActionListener(new ToggleSound());
        playSound = true;


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
        add(soundBtn.getBtn(), BorderLayout.NORTH);

        setSize(300, 550);
        setVisible(true);

        try{
            this.clip = AudioSystem.getClip();
        }
        catch (Exception e){
            System.err.println(e);
        }
    }

    class Close implements ActionListener {

        public void actionPerformed(ActionEvent e){
            model.out.println("");
            model.out.flush();
            System.exit(0);
        }
    }

    class ToggleSound implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            playSound = !playSound;
        }
    }

    class Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //System.out.println(model);
            //System.out.println(e.getActionCommand());
            if(counter == 0){
                clip.close();
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

                if(playSound){
                    audio = Sound.getSound(result);
                    try{
                        clip.open(audio);
                        clip.start();
                    }
                    catch (Exception ex){
                        System.err.println(ex);
                    }
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

class Sound {

    public static AudioInputStream getSound(String gameState){
        File soundFile = new File("C:\\Users\\Dell\\Desktop\\KTH\\PruttenProjekt\\src\\labb3\\" + gameState + ".wav");
        try{
            return AudioSystem.getAudioInputStream(soundFile);
        }
        catch (Exception e){
            System.err.println(e);
        }
        return null;
    }

}
