import java.util.*;

public class SumOfInputs {
    public static void main(String[] args){
        int input = 0;
        int sum = 0;
        Scanner sc = new Scanner(System.in);

        while(input != -1){
            sum += input;
            System.out.print("정수를 입력하시오: ");
            input = sc.nextInt();
        }

        sc.close();

        System.out.println(String.format("정수의 합은 %d입니다.", sum));
    }
}
