import java.util.Scanner;

public class Condition {
    public static void main(String[] args){
        int x;
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하시오: ");
        x = sc.nextInt();

        if(x % 2 == 0){
            System.out.println("짝수");
        }
        else{
            System.out.println("홀수");
        }

        sc.close();
    }
}
