public class StaticMethodTest {
    public static int cube(int x){
        return x * x * x;
    }

    public static void main(String[] args){
        System.out.println("10 * 10 * 10dms " + cube(10));
    }
}
