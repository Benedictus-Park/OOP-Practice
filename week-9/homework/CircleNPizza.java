class Circle {
    protected int radius;

    public Circle(int r) {
        radius = r;
    }
}

class Pizza extends Circle {
    String pizzaType;

    public Pizza(String pizzaType, int r) {
        super(r);
        this.pizzaType = pizzaType;
    }

    public void print() {
        System.out.println("피자의 종류: " + pizzaType + ", 피자의 크기: " + radius);
    }
}

public class CircleNPizza {
    public static void main(String[] args) {
        Pizza obj = new Pizza("Pepperoni", 20);
        obj.print();
    }
}
