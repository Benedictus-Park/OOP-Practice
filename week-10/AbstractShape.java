abstract class Shape_a{
   int x, y;
   public void translate(int x, int y) {
       this.x = x;
       this.y = y;
   }
   public abstract void draw();
}

class Rectangle_a extends Shape_a{
    int width, height;
    public void draw() {
        System.out.println("사각형 그리기 메소드");
    }
}

class Circle_a extends Shape_a{
    int radius;
    public void draw() {
        System.out.println("원 그리기 메소드");
    }
}

public class AbstractShape {
    public static void main(String[] args) {
        // Shape_a s1 = new Shape_a();
        Shape_a s2 = new Circle_a();
    }
}
