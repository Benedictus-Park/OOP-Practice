import java.util.Scanner;

public class FirstTest {
    public static void main(String[] main) {
        int age;
        String name;
        Scanner input = new Scanner(System.in);

        System.out.print("동무, 보위부에서 나왔소. 동무 이름이 뭐임메?: ");
        name = input.nextLine();

        System.out.print("잘 들었소. 나이까지만 알려주라우: ");
        age = input.nextInt();

        System.out.println(String.format("\n그러면 고저... 동무는 %d세 %s, 맞소?\n", age, name));

        input.close();
    }
}
