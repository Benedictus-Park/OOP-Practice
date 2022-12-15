import java.util.Scanner;

public class hw_1 {
    public static void main(String[] args) {
        int numOfOrange;
        Scanner input = new Scanner(System.in);

        System.out.print("오렌지의 개수를 입력하시오: ");
        numOfOrange = input.nextInt();

        System.out.println((String.format("%d박스가 필요하고 %d개가 남습니다.", numOfOrange / 10, numOfOrange % 10)));
        input.close();
    }
}