// 문제 3
public class hw_2 {
    public static void main(String[] args) {
        int i, j, numOf369 = 0;

        for (i = 1; i <= 50; i++) {
            if (i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
                numOf369++;
            }
            if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
                numOf369++;
            }

            if (numOf369 > 0) {
                for (j = 0; j < numOf369; j++) {
                    System.out.print(" 짝");
                }
            } else {
                System.out.print(" " + i);
            }

            numOf369 = 0;
        }

        System.out.println();
    }
}
