package labb3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class RPSModel {
    String hands[];
    Socket sock;
    BufferedReader in;
    PrintWriter out;
    String name;

    public RPSModel(String host, int port, String name){
        this.hands = new String[]{"STEN", "SAX", "PASE"};
        this.sock = getSocket(host, port);
        this.in = getInStream(this.sock);
        this.out = getOutputStream(this.sock);
        this.name=name;
        startGame();
    }


    public String compare(String compHand, String playerHand){
        if(!compHand.equals(playerHand)){
            if(playerHand.equals("STEN")){
                if(compHand.equals("PASE")){
                    return "LOSS";
                }
                else{
                    return "WIN";
                }
            }

            if(playerHand.equals("SAX")){
                if(compHand.equals("STEN")){
                    return "LOSS";
                }
                else{
                    return "WIN";
                }
            }

            if(playerHand.equals("PASE")){
                if(compHand.equals("SAX")){
                    return "LOSS";
                }
                else{
                    return "WIN";
                }
            }

        }
        else{
            return "DRAW";
        }
        return null;
    }

    public String getCompHand(BufferedReader in){
        try{
            return in.readLine();
        }
        catch(IOException e){
            System.err.println(e);
        }
        return null;
    }

    private Socket getSocket(String host, int port){
        try {
            Socket sock = new Socket(host, port);
            return sock;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private BufferedReader getInStream(Socket sock){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            return in;
        }
        catch(IOException e){
            System.err.print(e);
        }

        return null;
    }

    private PrintWriter getOutputStream(Socket sock){
        try{
            PrintWriter ut = new PrintWriter(sock.getOutputStream());
            return ut;
        }
        catch(IOException e){
            System.err.println(e);
        }
        return null;
    }

    private void startGame(){
        try {
            this.out.println(this.name);
            this.out.flush();
            this.in.readLine(); }
        catch(IOException e) {}
    }

    public String toString(){
        return "Hej hej";
    }

    public static void main(String[] args){
        RPSModel model = new RPSModel("localhost", 4713, "EttNamn");
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(model.sock.getInputStream()));
            PrintWriter ut = new PrintWriter(model.sock.getOutputStream());


            Scanner inputHand = new Scanner(System.in);
            String compHand;
            while(true){
                String hand = model.hands[inputHand.nextInt()];
                ut.println(hand);
                ut.flush();
                compHand = in.readLine();
                System.err.println("Player:" + hand + "  " + "Computer: " + compHand);
                System.err.println(model.compare(compHand, hand));
            }
        }
        catch(IOException e){
            System.err.println(e);
        }




    }
}
