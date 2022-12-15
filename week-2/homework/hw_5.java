import java.util.Scanner;

public class hw_5 {
    public static void main(String[] args) {
        double m, v;
        Scanner sc = new Scanner(System.in);

        System.out.print("물체의 무게를 입력하시오(킬로그램): ");
        m = sc.nextDouble();

        System.out.print("물체의 속도를 입력하시오(미터/초): ");
        v = sc.nextDouble();

        System.out.println(String.format("물체는 %f(줄)의 에너지를 가지고 있다.", 0.5 * m * v * v));
        sc.close();
    }
}
