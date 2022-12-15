import java.util.*;

class Circle{
    int r;

    public Circle(){
        this.r = (int)(Math.random() * 100);
    }

    public Circle(int d){
        this.r = d;
    }

    public String toString(){
        return "circle [r=" + this.r + "]";
    }
}

public class Circle2 {
    public static void main(String[] args){
        Circle[] circles = new Circle[3];
        
        for(int i = 0; i < circles.length; i++){
            circles[i] = new Circle();
        }

        System.out.println(circles[0]);
        System.out.println(circles[1]);
        System.out.println(circles[2]);
    }
}
