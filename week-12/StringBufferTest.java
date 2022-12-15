public class StringBufferTest{
    public static void main(String[] args){
        StringBuffer sb = new StringBuffer("Hello");
        int length = sb.length();
        int capacity = sb.capacity();

        System.out.println(length + "/" + capacity);

        sb = new StringBuffer("10+20=");
        sb.append(10+20);
        sb.insert(0, "수식: ");

        System.out.println(sb);
    }
}
