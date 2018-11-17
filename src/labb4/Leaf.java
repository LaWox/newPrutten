package labb4;

public class Leaf extends Component {

    public Leaf(double weight, String name){
        super(weight, name);
    }

    public void Add(Component C){

    }

    public void Remove(Component C){

    }

    public double getWeight(){
        return this.weight;
    }

    public String toString(){
        return this.name;
    }
}

