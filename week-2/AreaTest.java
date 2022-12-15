import java.util.Scanner;

public class AreaTest {
    public static void main(String[] args) {
        final double PI = 3.141592;
        double radius, area;
        Scanner input = new Scanner(System.in);

        radius = input.nextDouble();
        area = radius * radius * PI;

        System.out.println(area);
        input.close();
    }
}
