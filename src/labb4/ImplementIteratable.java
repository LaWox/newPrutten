package labb4;

import java.util.Iterator;
import java.util.ArrayList;

public class ImplementIteratable extends Composite implements Iterable<Component> {

    ArrayList<Component> stack;

    ImplementIteratable(double weight, String name){
        super(weight, name);
        this.stack = new ArrayList<Component>();
    }

    private void createStack(Component elem){
        stack.add(elem);
        if(elem instanceof Composite){
            for(int i = 0; i < ((Composite) elem).childList.size(); i ++){
                createStack(((Composite) elem).childList.get(i));
            }
        }
    }

    private void createStackWidth(int index){
        Component elem = stack.get(index);
        if(stack.get(index) instanceof Composite){
            for(int i = 0; i < ((Composite) elem).childList.size(); i ++){
                stack.add(((Composite) elem).childList.get(i));
            }
            index ++;
            createStackWidth(index);
        }
        else{
            stack.add(elem);
        }
    }

    public Iterator<Component> iterator() {
        Iterator<Component> iter = new Iterator<>() {

            private int index = 0;
            private int size = getSize();

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Component next() {
                if(this.hasNext()){
                    index ++;
                    return stack.get(index-1);
                }
                return null;
            }
        };
        return iter;
    }

    public static void main(String[] args){
        /*Composites*/
        ImplementIteratable resvaska = new ImplementIteratable(1.2, "resväska");
        Composite necessar = new Composite(0.3, "necessär");
        Composite plastpase = new Composite(0.01, "plastpåse");

        /* Till plastpåsen */
        Leaf gras = new Leaf(0.5, "Medecin");
        Leaf mdma = new Leaf(0.1, "MnM's");
        Leaf speed = new Leaf(0.25, "koffeinPiller");

        /* Till Necessären */
        Leaf tandborste = new Leaf(0.1, "tandborste");
        Leaf gummi = new Leaf(0.2, "tandkräm");

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

        resvaska.createStack(resvaska);

        /* Bredden först
        resvaska.stack.add(resvaska);
        resvaska.createStackWidth(0);
        */


        Iterator iter = resvaska.iterator();

        while(iter.hasNext()){
            System.out.println((iter.next()));
        }

        System.out.println("-------------------------------------------");

        for (Component comp: resvaska) {
            System.out.println("component: " + comp.name);
        }

    }
}


