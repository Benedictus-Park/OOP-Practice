package homework;

class Parent{
    String name = "심학규";

    void print(){
        System.out.println("나는 심청의 아버지인 " + name + "이다.");
    }
}

class Child extends Parent{
    String name = "심청";

    void print(){
        System.out.println("나는 심학규의 딸 " + name + "이다.");
    }
}

public class OvershadowTest{
    public static void main(String[] args){
        Parent p = new Child();
        System.out.println(p.name);
        p.print();
    }
}
