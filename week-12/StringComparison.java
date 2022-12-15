public class StringComparison{
    public static void main(String[] args){
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        String s4 = new String("Java");

        System.out.println(s1.equals(s2)); // true, Correct
        System.out.println(s1.equals(s3)); // true, Correct
        System.out.println(s1 == s2); // true, Not Correct
        System.out.println(s1 == s3); // false, Not Correct
    }
}
