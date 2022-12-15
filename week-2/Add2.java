import java.util.Scanner;

public class Add2 {
    public static void main(String[] args) {
        int x, y, sum;
        Scanner input = new Scanner(System.in);

        System.out.print("첫 번째 정수 입력하라우: ");
        x = input.nextInt();

        System.out.print("두 번쨰 정수는 뭐임메?: ");
        y = input.nextInt();

        sum = x + y;
        System.out.println(String.format("여기, 더한 결과 있소: %d + %d = %d", x, y, sum));

        input.close();
    }
}
