package Labb1;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class Labb1X extends MyButton {

    public Labb1X(Color c1, Color c2, String s1, String s2){
        super(c1, c2, s1, s2);
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String in1;
        String in2;
        Labb1X newBtn;
        uppgift1 window = new uppgift1();

        int noBtns = input.nextInt();
        Labb1X[] btnList = new Labb1X[noBtns];

        for(int i = 0; i < noBtns; i ++){
            in1 = input.next();
            in2 = input.next();
            newBtn = new Labb1X(Color.yellow, Color.PINK, in1, in2);
            newBtn.validate();
            System.out.println(newBtn.toString());
            btnList[i] = newBtn;
        }
        for (Labb1X btn: btnList) {
            window.panel.add(btn.myBtn);
        }

        window.panel.validate();
    }
}
