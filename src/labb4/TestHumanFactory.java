package labb4;
import labb4.human.Human;
import labb4.human.Man;
import labb4.human.NonBinary;
import labb4.human.Woman;

public class TestHumanFactory {
    public static void main(String[] args){
        Human billie = Human.create("Billie", "xxxxxx-560x");
        Human anna = Human.create("Anna", "xxxxxx-642x");
        Human magnus = Human.create("Magnus","xxxxxx-011x");
        System.out.println(billie);
        System.out.println(anna);
        System.out.println(magnus);

        System.out.println("---------------------------------------------");

        /*
        Human man = new Man("Magnus","xxxxxx-011x");
        Human woman = new Woman("Anna","xxxxxx-014x");
        Human nonBinary = new NonBinary("Billie","xxxxxx-010x");
        */


        //Human noName = new Human(){};

    }
}
