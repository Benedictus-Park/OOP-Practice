// 문제 7
public class hw_5 {
    public static void main(String[] args){
        int i, j;
        boolean hasDivisor = false;

        System.out.print("2부터 100사이 모든 소수 : ");

        for(i = 2; i <= 100; i++){
            for(j = 2; j < i; j++){
                if(i % j == 0){
                    hasDivisor = true;
                    break;
                }
            }

            if(hasDivisor){
                hasDivisor = false;
                continue;
            }
            else{
                System.out.print(" " + i);
            }
        }

        System.out.println();
    }
}
