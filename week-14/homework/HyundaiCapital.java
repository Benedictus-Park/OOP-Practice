import java.util.*;
import java.lang.Integer;

public class HyundaiCapital{

    public static void main(String[] args){
        Random rdn = new Random();
        Scanner sc = new Scanner(System.in);
        Object[] keys;
        ArrayList<String> fakes = new ArrayList<String>();
        HashMap<Integer, String> view = new HashMap<Integer, String>();
        HashMap<String, String> hm = new HashMap<String, String>();
        String tmp1;
        int tmp2;
        int answer;
        int in;

        hm.put("스위스", "베른");
        hm.put("몽골", "울란바토르");
        hm.put("그리스", "아테네");
        hm.put("베트남", "하노이");

        keys = hm.keySet().toArray();

        fakes.add("방콕");
        fakes.add("암스테르담");
        fakes.add("모스크바");

        for(int i = 0; i < keys.length; i++){
            fakes.add(hm.get((String)keys[i]));
        }

        System.out.println("\"수도맞추기\" 게임을 시작합니다. -1을 입력하면 종료합니다.");
        System.out.println("현재 " + hm.size() + "개의 수도가 들어 있습니다.");

        for(int i = 0; i < keys.length; i++){
            tmp1 = hm.get((String)keys[i]);
            tmp2 = rdn.nextInt(0, 4);
            answer = tmp2;

            System.out.println((String)keys[i] + "?");

            view.clear();
            view.put(tmp2, tmp1);

            while(view.size() != 4){
                tmp2 = rdn.nextInt(0, 4);
                tmp1 = fakes.get(tmp2);

                if(!view.containsValue(tmp1)){
                    view.put(tmp2, tmp1);
                }
            }

            for(int j = 0; j < 4; j++){
                System.out.print("(" + (j + 1) + ") " + view.get(j) + " ");
            }
            System.out.print(" :>");
            in = sc.nextInt();
            sc.nextLine();

            if(in < 1 || in > 4){
                if(in == -1){
                    System.out.println("\"수도맞추기\"를 종료합니다...");
                    return;
                }
                System.out.println("입력 형식이 잘못되었습니다.");
            }
            else if((in - 1) == answer){
                System.out.println("정답입니다!");
            }
            else{
                System.out.println("오답입니다!");
            }
        }
    }
}
