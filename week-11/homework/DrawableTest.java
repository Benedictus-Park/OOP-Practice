interface Animal{
    void walk();
    void fly();
    void sing();
}

interface Drawable{
    void draw();
}

class Duck implements Animal, Drawable{
    public void walk(){
        System.out.println("걷을 수 있음");
    }

    public void fly(){
        System.out.println("날을 수 있음");
    }

    public void sing(){
        System.out.println("노래 부를 수 있음");
    }

    public void draw(){
        System.out.println("그릴 수 있음");
    }
}

public class DrawableTest{
    public static void main(String[] args){
        Duck duck = new Duck();

        duck.walk();
        duck.fly();
        duck.sing();
        duck.draw();
    }
}
