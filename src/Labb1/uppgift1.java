package Labb1;

import java.awt.*;
import javax.swing.*;

public class uppgift1 extends JFrame {
    JFrame window;
    JPanel panel;

    public uppgift1(){
        this.window=new JFrame("Jussi K, Platon W");
        this.panel=new JPanel();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.green);
        window.setSize(new Dimension(500, 700));
        //window.add(panel);
        window.setVisible(true);

    }

   public static void main(String[] arg){
        uppgift1 run = new uppgift1();
    }
}
