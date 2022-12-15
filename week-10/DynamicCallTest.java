class Animal {
    void speak() {
        System.out.println("Animal 클래스의 sound()");
    }
}

class Dog extends Animal {
    void speak() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal {
    void speak() {
        System.out.println("야옹");
    }
}

public class DynamicCallTest {
    public static void main(String[] args){
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.speak();
        a2.speak();
    }
}
