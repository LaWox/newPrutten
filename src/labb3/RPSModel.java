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

    public RPSModel(String host, int port){
        this.hands = new String[]{"STEN", "SAX", "PASE"};
        this.sock = getSocket(host, port);
        this.in = getInStream(this.sock);
        this.out = getOutputStream(this.sock);
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

    public Socket getSocket(String host, int port){
        try {
            Socket sock = new Socket(host, port);
            return sock;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public BufferedReader getInStream(Socket sock){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            return in;
        }
        catch(IOException e){
            System.err.print(e);
        }

        return null;
    }

    public PrintWriter getOutputStream(Socket sock){
        try{
            PrintWriter ut = new PrintWriter(sock.getOutputStream());
            return ut;
        }
        catch(IOException e){
            System.err.println(e);
        }
        return null;
    }

    public static void main(String[] args){
        RPSModel model = new RPSModel("localhost", 4713);
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(model.sock.getInputStream()));
            PrintWriter ut = new PrintWriter(model.sock.getOutputStream());

            String name = "EttNamn";
            ut.println(name);
            ut.flush();
            System.out.println(in.readLine());
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
