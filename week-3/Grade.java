import java.util.Scanner;

public class Grade {
    public static void main(String[] args){
        int score;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.print("성적을 입력하시오: ");
            score = sc.nextInt();
        }while(score < 0);
        
        System.out.print("학점");

        if(score >= 90){
            System.out.println("A");
        }
        else if(score >= 80){
            System.out.println("B");
        }
        else{
            System.out.println("C");
        }

        sc.close();
    }
}
