import java.util.*;

public class Divisor {
    public static void main(String[] args){
        int i, max;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.print("양의 정수를 입력하시오: ");
            max = sc.nextInt();
        }while(max < 1);

        sc.close();

        System.out.println(String.format("%d의 약수는 다음과 같습니다.", max));

        for(i = 1; i <= max; i++){
            if(i == 1){
                System.out.print("1");
            }
            else if(max % i == 0){
                System.out.print(String.format(" %d", i));
            }
        }
        System.out.println();
    }
}
