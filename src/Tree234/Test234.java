package Tree234;

public class Test234 {
    public static void main(String[] args) {
        Tree t = new Tree();
        t.insert(new Student(10, "A"));
        t.insert(new Student(20, "B"));
        t.insert(new Student(30, "C"));
        t.insert(new Student(40, "D"));
        t.insert(new Student(50, "E"));
        t.insert(new Student(50, "F"));
        t.insert(new Student(60, "G"));
        t.insert(new Student(70, "H"));
        t.insert(new Student(80, "I"));
        t.insert(new Student(90, "J"));
        t.insert(new Student(5, "K"));
        t.insert(new Student(15, "L"));
        t.insert(new Student(25, "M"));
        t.insert(new Student(35, "N"));
        t.insert(new Student(45, "O"));
        t.insert(new Student(55,"P"));
        t.insert(new Student(65, "Q"));
        t.insert(new Student(75, "R"));
        t.insert(new Student(85, "S"));
        t.insert(new Student(95, "T"));
        t.insert(new Student(11, "U"));
        t.insert(new Student(21, "V"));
        t.insert(new Student(31, "W"));
        t.insert(new Student(41, "X"));
        t.insert(new Student(51, "Y"));
        t.insert(new Student(61, "Z"));
        t.inorderTraversal();
        t.search(55);
        t.search(50);
    }
}
