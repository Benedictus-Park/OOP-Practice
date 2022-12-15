import java.util.Scanner;

public class CalTime {
    public static void main(String[] args) {
        int s;
        Scanner input = new Scanner(System.in);

        System.out.print("초 입력하라: ");
        s = input.nextInt();

        System.out.println(String.format("%d초는 %d시간 %d분 %d초", s, s / 3600, (s % 3600) / 60, s % 60));

        input.close();
    }
}
