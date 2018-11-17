package labb4;

import java.util.ArrayList;

public class Composite extends Component {
    ArrayList<Component> childList;

    public Composite(double weight, String name){
        super(weight, name);
        this.childList = new ArrayList<>();
    }

    public void add(Component c){
        this.childList.add(c);
    }

    public void remove(Component c){
        childList.remove(c);
     }

    public double getWeight(){
        double currentWeight = this.weight;
        for(int i = 0; i < this.childList.size(); i ++){
            currentWeight += this.childList.get(i).getWeight();
        }
        return currentWeight;
    }

    public String toString(){
        String currentString = this.name;

        for(int i = 0; i < this.childList.size(); i++){
            currentString += "\n" + this.childList.get(i).toString();
        }
        return currentString;
    }

}
