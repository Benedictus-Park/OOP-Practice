class Animal {
    void walk() {
        System.out.println("걷을 수 있음");
    }
}

public class Bird extends Animal {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.walk();
        bird.fly();
        bird.sing();
    }

    void fly() {
        System.out.println("날을 수 있음");
    }

    void sing() {
        System.out.println("노래 부를 수 있음");
    }
}
