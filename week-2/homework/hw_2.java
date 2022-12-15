import java.util.Scanner;

public class hw_2 {
    public static void main(String[] args) {
        int x, y;
        Scanner sc = new Scanner(System.in);

        System.out.print("x: ");
        x = sc.nextInt();

        System.out.print("y: ");
        y = sc.nextInt();

        System.out.println(String.format("두수의 합: %d\n두수의 차: %d\n두수의 곱: %d\n두수의 평균: %f\n큰수: %d\n작은수: %d", x + y, x - y,
                x * y, (double) (x + y) / 2.0, (x > y) ? x : y, (x > y) ? y : x));
        sc.close();
    }
}
