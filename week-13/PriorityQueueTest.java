import java.util.*;

public class PriorityQueueTest{
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(30);
        pq.add(80);
        pq.add(20);

        System.out.println(pq);
        System.out.println("삭제된 원소: " + pq.remove());
    }
}
