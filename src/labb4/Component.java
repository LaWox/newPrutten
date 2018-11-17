package labb4;

public abstract class Component {
    double weight;
    String name;

    public Component(double weight, String name){
        this.weight=weight;
        this.name=name;
    }

    public abstract void add(Component C);


    public abstract void remove(Component C);


    public abstract double getWeight();

    public abstract String toString();

}
