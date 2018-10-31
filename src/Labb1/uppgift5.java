package Labb1;
import java.awt.*;

public class uppgift5 extends uppgift1 {
    MyButton btn;
    static Color c1 = Color.PINK;
    static Color c2 = Color.CYAN;

    public uppgift5(){
        super();
    }

    public static void main(String[] args){
        uppgift5 run = new uppgift5();
        run.createBtns(args);
    }

    public void createBtns(String[] args){
        int noBtns = Integer.parseInt(args[0]);
        for(int i = 0; i < noBtns; i++){
            MyButton newBtn = new MyButton(c1, c2, args[i+1], args[i+2]);
            //System.err.println(args[i+1] + " : " + args[i+2]);
            System.err.println(newBtn);
            this.panel.add(newBtn.myBtn);
        }
        this.window.add(this.panel);
        this.window.validate();

    }
}
