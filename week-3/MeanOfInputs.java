import java.util.*;

public class MeanOfInputs {
    public static void main(String[] args){
        int score;
        int sumOfScores = 0;
        int numOfScores = 0;
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("정수를 입력하시오: ");
            score = sc.nextInt();

            if(score < 0){
                sc.close();
                break;
            }
            
            sumOfScores += score;
            numOfScores++;
        }

        System.out.println(String.format("평균은 %f", sumOfScores / (double)numOfScores));
    }
}
