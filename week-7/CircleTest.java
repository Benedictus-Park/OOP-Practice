class Circle{
    int x;
    int y;
    int radius;

    public Circle(){
        this.x = 0;
        this.y = 0;
        this.radius = -1;
    }

    public Circle(int x, int y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    private void setX(int x){
        this.x = x;
    }

    private void setY(int y){
        this.y = y;
    }

    private boolean setRadius(int radius){
        if(radius <= 0){
            return false;
        }

        this.radius = radius;
        return true;
    }

    private int getX(){
        return this.x;
    }

    private int getY(){
        return this.y;
    }

    private int getRadius(){
        return this.radius;
    }

    public String toString(){
        return "Circle [x=" + this.x + ", y=" + this.y + ", radius=" + this.radius + "]";
    }

    public static void move(Circle circle, int dx, int dy){
        circle.setX(circle.getX() + dx);
        circle.setY(circle.getY() + dy);
    }
}

public class CircleTest {
    public static void main(String[] args){
        Circle c = new Circle(10, 10, 5);
        System.out.println(c + "\n");
        Circle.move(c, 10, 20);
        System.out.println("move(10, 20) 호출 후");
        System.out.println(c);
    }
}
