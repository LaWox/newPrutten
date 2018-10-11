package Labb1;
import javax.swing.*;
import java.awt.*;

public class uppgift3 extends uppgift1 {

    public uppgift3(){
        super();
        MyButton button = new MyButton(Color.red, Color.lightGray, "test1", "test2");
        this.panel.add(button.myBtn);
        this.window.add(panel);
        this.window.validate();

    }

    public static void main(String[] arg ){
        uppgift3 run = new uppgift3();

    }


}
