import java.util.ArrayList;

class Node{
    String name;
    int age;

    public Node(String name, int age){
        this.name = name;
        this.age = age;
    }
}

public class class_test {
    public static void main(String[] args){
        Node ssafy;
        ssafy = new Node("오승연",25);
        System.out.println(ssafy.name + " " + ssafy.age);
        System.out.println();

//        Node[] people = new Node[20];
//        people[1]=Node("오승민",20);
    }
}
