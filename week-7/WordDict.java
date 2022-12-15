import java.util.Scanner;

class Word{
    private String eng;
    private String kor;

    public Word(){
        eng = null;
        kor = null;
    }

    public Word(String eng, String kor){
        this.eng = eng;
        this.kor = kor;
    }

    public String getEng(){
        return eng;
    }

    public String getKor(){
        return kor;
    }
}

public class WordDict {
    public static void main(String[] args){
        String tgt = null;
        boolean isFounded;
        Word[] dictionary = new Word[5];
        Scanner sc = new Scanner(System.in);

        dictionary[0] = new Word("house", "집");
        dictionary[1] = new Word("cat", "고양이");
        dictionary[2] = new Word("hell", "지옥");
        dictionary[3] = new Word("world", "세상");
        dictionary[4] = new Word("iraq", "이라크");

        while(true){
            System.out.print("검색할 단어를 입력하시오. (종료 q)");
            tgt = sc.nextLine();

            if(tgt.equals("q")){
                break;
            }

            isFounded = false;
            
            for(int i = 0; i < dictionary.length; i++){
                if(dictionary[i].getEng().equals(tgt)){
                    System.out.println(dictionary[i].getEng() + "->" + dictionary[i].getKor());
                    isFounded = true;
                    break;
                }
            }

            if(isFounded){
                continue;
            }

            System.out.println("사전에 없는 단어입니다!");
        }
    }
}
