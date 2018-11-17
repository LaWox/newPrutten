package labb4;

public class TestLabb4 {

    public static void main (String[] args){

        /* Leaf gras = new Leaf() */
        /*Composites*/
        Composite resvaska = new Composite(1.2, "resväska");
        Composite necessar = new Composite(0.3, "necessär");
        Composite plastpase = new Composite(0.01, "plastpåse");

        /* Till plastpåsen */
        Leaf gras = new Leaf(0.5, "gräs");
        Leaf mdma = new Leaf(0.1, "MDMA");
        Leaf speed = new Leaf(0.25, "speed");

        /* Till Necessären */
        Leaf tandborste = new Leaf(0.1, "tandborste");
        Leaf gummi = new Leaf(0.2, "kondomer");

        /*Rakt  i väskan*/
        Leaf byxor = new Leaf(0.3,  "jeans");
        Composite tShirt = new Composite(0.2,  "t-shirt");

        /* i t-shirt*/
        Leaf kniv = new Leaf(1.3, "storKniven");

        /* Lägger allt i ordning */
        resvaska.add(necessar);
        resvaska.add(plastpase);
        resvaska.add(tShirt);
        resvaska.add(byxor);

        plastpase.add(gras);
        plastpase.add(mdma);
        plastpase.add(speed);

        necessar.add(tandborste);
        necessar.add(gummi);

        tShirt.add(kniv);

        /* Gör tester */
        System.out.println(resvaska.getWeight());
        System.out.print(resvaska.toString());


        /*ta bort och gör mer tester*/
        resvaska.remove(tShirt);
        System.out.println("\n" + "-----------------");
        System.out.println(resvaska.getWeight());
        System.out.print(resvaska.toString());

    }
}
