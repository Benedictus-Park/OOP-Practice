import java.util.Scanner;

public class hw_4 {
    public static void main(String[] args) {
        int paid, price;
        Scanner sc = new Scanner(System.in);

        System.out.print("받은 돈: ");
        paid = sc.nextInt();

        System.out.print("상품 가격: ");
        price = sc.nextInt();

        System.out.println(String.format("부가세: %d\n잔돈: %d", price / 10, paid - price));
        sc.close();
    }
}
