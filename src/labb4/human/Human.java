package labb4.human;
public abstract class Human {
    protected String name, pnr, gender;

    Human(){}

    public static Human create( String name, String pnr){
        int index = pnr.length() -2;

        if(pnr.charAt(index) == '0'){
            return new NonBinary(name, pnr);
        }
        else if(Character.getNumericValue(pnr.charAt(index))%2 == 0){
            return new Woman(name, pnr);
        }
        else if(Character.getNumericValue(pnr.charAt(index))%2 == 1){
            return new Man(name, pnr);
        }
        return null;
    }

    public String toString(){
        return "Hej jag heter " + name + " jag är " + gender;
    }

}
