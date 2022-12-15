interface Queue{
    int dequeue();
    void enqueue(int item);
    boolean isEmpty();
}

class MyQueue implements Queue{
    int numOfData;
    int[] arr;

    public MyQueue(int size){
        numOfData = 0;
        arr = new int[size];
    }

    public int dequeue(){
        int data = arr[0];

        for(int i = 0; i < numOfData - 1; i++){
            arr[i] = arr[i + 1];
        }

        numOfData--;
        return data;
    }

    public void enqueue(int item){
        arr[numOfData++] = item;
    }

    public boolean isEmpty(){
        if(numOfData == 0){
            return true;
        }
        return false;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }
        else{
            System.out.print("[");
            for(int i = 0; i < numOfData; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.print("]");
        }
    }
}

public class QueueTest{
    public static void main(String[] args){
        MyQueue q = new MyQueue(5);

        q.enqueue(10);
        q.display();
        q.enqueue(20);
        q.display();
        q.enqueue(30);
        q.display();
        q.enqueue(40);
        q.display();

        q.dequeue();
        q.display();
        q.dequeue();
        q.display();
        q.dequeue();
        q.display();
        q.dequeue();
        q.display();
    }
}
