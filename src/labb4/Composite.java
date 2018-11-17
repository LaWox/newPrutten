package labb4;

import java.util.ArrayList;

public class Composite extends Component {
    ArrayList<Component> childList = new ArrayList<Component>();

    public Composite(double weight, String name){
        super(weight, name);
        this.childList=childList;


    }


    public void Add(Component C){

    }

    public void Remove(Component C){

     }

    public double getWeight(){
        return 0.123;
    }

    public String toString(){
        return null;
    }

}
