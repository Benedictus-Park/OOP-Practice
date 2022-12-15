import java.util.Scanner;

public class MonthNum {
    public static void main(String[] args){
        int month;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.print("올바른 월을 입력하시오 [1-12]: ");
            month = sc.nextInt();
        }while(month < 1 || month > 12);
        sc.close();

        System.out.println(String.format("사용자가 입력한 월은 %d", month));
    }
}
