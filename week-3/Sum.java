public class Sum {
    public static void main(String[] args){
        int i, sum = 0;

        for(i = 1; i <= 10; i++){
            sum += i;
        }

        System.out.println(String.format("1부터 10까지의 정수의 합: %d", sum));
        // System.out.println(String.format("1부터 10까지의 정수의 합: %d", (10 * (10 + 1)) / 2));
    }
}
