import java.util.*;

public class NumberGame {
    public static void main(String[] args){
        int ans = 59;
        int guess;
        Scanner sc = new Scanner(System.in);
        int tries = 0;

        do{
            System.out.print("정답을 추측하라: ");
            guess = sc.nextInt();
            tries++;

            if(guess > ans){
                System.out.println("Down");
            }
            else if(guess < ans){
                System.out.println("Up");
            }
        }while(guess != ans);

        System.out.println("정답! 시도횟수 " + tries + "회");
    }
}
