class Pizza{
    int radius;

    public Pizza(int r){
        this.radius = r;
    }

    Pizza whosLargest(Pizza p1, Pizza p2){
        if(p1.radius > p2.radius){
            return p1;
        }
        else{
            return p2;
        }
    }
}

public class PizzaTest {
    public static void main(String[] args){
        Pizza p1 = new Pizza(14);
        Pizza p2 = new Pizza(18);

        System.out.println(p1.whosLargest(p1, p2).radius + "인치 피자가 더 큼.");
    }
}
