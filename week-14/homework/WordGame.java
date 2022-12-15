import java.util.*;

public class WordGame{
    public static void main(String[] args){
        Random rdn = new Random();
        Scanner sc = new Scanner(System.in);
        String[] words = { "cyka", "love", "war", "blin" };
        String word = words[rdn.nextInt(0, words.length)];
        String view = "";
        String in;
        StringBuilder sb;
        int correct = 0;
        int result;

        for(int i = 0; i < word.length(); i++){
            view += "_";
        }

        System.out.println("행맨 게임에 오신 것을 환영합니다.");

        while(correct != word.length()){
            System.out.println("현재의 상태: " + view);
            System.out.print("글자를 추측하시오: ");
            in = sc.nextLine().toLowerCase();

            if(in.length() > 1 || in.length() == 0){
                System.out.println("잘못된 입력 형식입니다.\n");
                continue;
            }

            result = word.indexOf(in.charAt(0));
            System.out.println();

            if(result == -1){
                continue;
            }

            correct++;
            sb = new StringBuilder(view);
            sb.setCharAt(result, in.charAt(0));
            view = sb.toString();
        }

        System.out.println("You Win!");
    }
}
