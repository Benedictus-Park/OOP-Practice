// 문제 4
public class hw_3 {
    public static void main(String[] args) {
        int i, sum = 0;

        for (i = 1; i <= 100; i++) {
            if (i % 3 == 0 || i % 4 == 0) {
                sum += i;
            }
        }

        System.out.println("3 또는 4의 배수의 합 = " + sum);
    }
}
