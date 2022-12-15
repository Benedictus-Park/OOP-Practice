class Rectangle implements Comparable{
    public int width = 0;
    public int height = 0;

    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int compareTo(Object other){
        Rectangle tgt = (Rectangle)other;

        if(this.width * this.height > tgt.width * tgt.height){
            return 1;
        }
        else if(this.width * this.height < tgt.width * tgt.height){
            return -1;
        }
        return 0;
    }
}

public class RactangleTest{
    public static void main(String[] args){
        Rectangle r1 = new Rectangle(10, 30);
        Rectangle r2 = new Rectangle(40, 2);

        if(r1.compareTo(r2) == 1){
            System.out.println("r1이 더 큼.");
        }
        else if(r2.compareTo(r2) == -1){
            System.out.println("r2가 더 큼.");
        }
        else{
            System.out.println("똑같지롱");
        }
    }
}
