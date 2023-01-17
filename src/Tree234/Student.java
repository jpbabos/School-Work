package Tree234;

public class Student {
    int id;
    String name;

    public Student(){
        id = 0;
        name = "abc";
    }
    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }
    public String toString(){
        return "ID: " + this.id + " Name: " + this.name ;
    }
}
