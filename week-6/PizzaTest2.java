class Pizza2{
    private String toppings;
    private int radius;
    static final double PI = 3.14159267;
    static int count = 0;

    public Pizza2(String toppings){
        this.toppings = toppings;
        this.count++;
    }
}

public class PizzaTest2 {
    public static void main(String[] args){
        Pizza2 p1 = new Pizza2("Super Supreme");
        Pizza2 p2 = new Pizza2("Cheese");
        Pizza2 p3 = new Pizza2("Pepperoni");
        int cnt = Pizza2.count;

        System.out.println("지금까지 판매된 피자 개수 = " + cnt);
    }
}
