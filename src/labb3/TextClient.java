package labb3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TextClient {

    public TextClient(){

    }

    public static void main(String[] arg) {
        try {
            Socket socket = new Socket("localhost", 4713);
            BufferedReader in = new BufferedReader
                    (new InputStreamReader(socket.getInputStream()));
            PrintWriter ut = new PrintWriter(socket.getOutputStream());
            ut.println("Charlotta");
            ut.flush();
            System.out.println(in.readLine());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
