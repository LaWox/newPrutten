import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Labb0 {
    public static void main(String[] args){
        /*Person newPerson = new Person("Britt", 27);
        System.out.println(newPerson);*/

        /*Student newStudent = new Student();
        System.err.println(newStudent);*/

        //printRandomStudents(15);
        //printRandomPersons(15);
        printRandomAll(5);

    }

    public static ArrayList<String> readFile(){
        ArrayList<String> list = new ArrayList<>();
        File names = new File("names.txt");
        try{
            Scanner inVal = new Scanner(names);
            while(inVal.hasNext()){
                list.add(inVal.next());
            }
        }
        catch (FileNotFoundException a ){
            System.err.println("File not found");
        }
        return list;
    }

    public static void printRandomPersons(int nrOfPersons){
        ArrayList<Person> personArrayList = new ArrayList<>();

        for(int i = 0; i < nrOfPersons; i++){
            //System.err.println("inne");
            Person newPerson = new Person();
            personArrayList.add(newPerson);

            System.err.println(personArrayList.get(i));
        }
    }

    public static void printRandomStudents(int nrOfStudents){
        ArrayList<Student> studentArrayList = new ArrayList<>();

        for(int i = 0; i < nrOfStudents; i++){
            //System.err.println("inne");
            Student newStudent = new Student();
            studentArrayList.add(newStudent);

            System.err.println(studentArrayList.get(i));
        }
    }

    public static void printRandomAll(int nrPeople){
        ArrayList<Person> personArrayList = new ArrayList<>();

        for(int i = 0; i < nrPeople; i++){
            //System.err.println("inne");
            Student newStudent = new Student();
            Person newPerson = new Person();
            personArrayList.add(newStudent);
            personArrayList.add(newPerson);
        }

        for(int x = 0; x < personArrayList.size(); x++) {
            System.out.println(personArrayList.get(x));
        }
    }
}


class Person {
    private String name;
    private int age;
    public static ArrayList<String> nameArray = Labb0.readFile();


    Person(String nameIn, int ageIn){
        this.name = nameIn;
        this.age = ageIn;
    }

    Person(){
        this.name = nameArray.get((int)(Math.random()*(nameArray.size()-1)));
        this.age = (int)((Math.random() * 75) + 15);
    }

    public String toString(){
        return "namn: " + this.name + " " + "alder: " + this.age + " ";
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }
}

class Student extends Person{
    int year;
    String programeCode = "CMETE";


    Student(int inYear, String inName, int inAge){
        super(inName, inAge);
        this.year  = inYear;
    }

    Student(){
        super();
        boolean ofAge = false;
        int earlyStartYear = (2018-(this.getAge()-15));

        while(!ofAge){
            this.year = (int)(1934 + Math.random()*83);
            if(this.year >= earlyStartYear){
                ofAge = true;
            }
        }
    }

    public String toString(){
        return super.toString() + "programm:" + this.year + this.programeCode;
    }

}