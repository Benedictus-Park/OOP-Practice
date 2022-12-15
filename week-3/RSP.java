import java.util.*;

public class RSP {
    final int SCISSOR = 0;
    final int ROCK = 1;
    final int PAPER = 2;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cpu_selection = ((int)(Math.random() * 10)) % 2;
        int usr_selection;

        System.out.print("(0) 가위 (1) 바위 (2) 보: ");
        usr_selection = sc.nextInt();

        if(cpu_selection - usr_selection == 0){
            System.out.println("비김");
        }
        else if(cpu_selection - usr_selection == -1){
            System.out.println(String.format("인간: %d, 컴퓨터: %d, 인간 승", usr_selection, cpu_selection));
        }
        else{
            System.out.println(String.format("인간: %d, 컴퓨터: %d, 인간 패", usr_selection, cpu_selection));
        }

        sc.close();
    }
}
