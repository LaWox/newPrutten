package labb4;

public class Leaf extends Component {

    public Leaf(double weight, String name){
        super(weight, name);
    }

    public void add(Component C){

    }

    public void remove(Component C){

    }

    public double getWeight(){
        return this.weight;
    }

    public String toString(){
        return this.name;
    }

    public int getSize() {
        return 1;
    }
}

