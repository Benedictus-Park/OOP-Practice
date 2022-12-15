import java.util.Scanner;

public class hw_3 {
    public static void main(String[] args) {
        final int SPEED_OF_SOUND = 340;
        int s;
        Scanner sc = new Scanner(System.in);

        System.out.print("시간 간격을 입력하시오(단위: 초): ");
        s = sc.nextInt();

        System.out.println(String.format("번개가 발생한 곳까지의 거리: %d", s * SPEED_OF_SOUND));

        sc.close();
    }
}
