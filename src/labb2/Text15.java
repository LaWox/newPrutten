package labb2;

import java.util.*;
class  Text15 {
    public static void main(String[] u) {
        Scanner scan = new Scanner(System.in);
        Boardgame thegame = new FifteenModel();
        System.out.println("\nWelcome to Fifteen puzzle\n");
        while (true) {
            // Print out the current status
            for (int i=0; i<4; i++) {
                for (int j=0; j<4; j++)
                    System.out.print("  " + thegame.getStatus(i,j));
                System.out.println();
            }
            System.out.println();
            System.out.print("Your move: ");
            int i = scan.nextInt();
            int j = scan.nextInt();
            //System.out.print(i + " " + j);
            System.out.println("status:" + " " + thegame.getStatus(i, j));
            thegame.move(i,j);
            System.out.println(thegame.getMessage());
        }
    }
}
