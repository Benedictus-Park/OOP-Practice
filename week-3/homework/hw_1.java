import java.util.*;

// 문제 1
public class hw_1 {
    public static void main(String[] args) {
        int input;
        String en;
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        input = sc.nextInt();
        sc.close();

        switch (input) {
            case 1 -> en = "ONE";
            case 2 -> en = "TWO";
            case 3 -> en = "THREE";
            case 4 -> en = "FOUR";
            case 5 -> en = "FIVE";
            case 6 -> en = "SIX";
            case 7 -> en = "SEVEN";
            case 8 -> en = "EIGHT";
            case 9 -> en = "NINE";
            default -> en = "OTHER";
        }

        System.out.println(en);
    }
}
