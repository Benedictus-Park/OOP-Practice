import java.util.*;

public class Score_2 {
    public static void main(String[] args){
        int number;
        char grade = 'F';
        Scanner sc = new Scanner(System.in);

        System.out.print("성적을 입력하시오: ");
        number = sc.nextInt() / 10;

        switch(number){
            case 10:
                grade = 'A';
                break;
            case 9:
                grade = 'B';
                break;
            case 8:
                grade = 'C';
                break;
            case 7:
                grade = 'D';
                break;
        }

        System.out.println(String.format("학점: %c", grade));
        sc.close();
    }
}
