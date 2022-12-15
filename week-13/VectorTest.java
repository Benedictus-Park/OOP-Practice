import java.util.*;

public class VectorTest{
    public static void main(String[] args){
        Vector vc = new Vector();
        vc.add("Hell World!");
        vc.add(new Integer(10));
        vc.add(20);

        System.out.println("vector size: " + vc.size());

        for(int i = 0; i < vc.size(); i++){
            System.out.println("vector element " + i + ": " + vc.get(i));
        }
        String s = (String)vc.get(0);
    }
}
