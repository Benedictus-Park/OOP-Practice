package homework;

class Phone{
    protected String owner;

    public Phone(String owner){
        this.owner = owner;
    }

    void talk(){
        System.out.println(owner + "가 통화중입니다.");
    }
}

class Telephone extends Phone{
    private String when;

    public Telephone(String owner, String when){
        super(owner);
        this.when = when;
    }

    void autoAnswering(){
        System.out.println(owner + "가 부재중입니다. " + when + " 전화해주세요.");
    }
}

class Smartphone extends Telephone{
    private String game;

    public Smartphone(String owner, String when, String game){
        super(owner, when);
        this.game = game;
    }

    void playGame(){
        System.out.println(owner + "가 " + game + " 게임을 하는 중입니다.");
    }
}

public class Ptest{
    public static void main(String[] args){
        Phone[] phones = {
                new Phone("황진이"),
                new Telephone("길동이", "내일"),
                new Smartphone("민국이", null, "베그")
        };

        for(int i = 0; i < phones.length; i++){
            if(phones[i] instanceof Smartphone){
                ((Smartphone)phones[i]).playGame();
            }
            else if(phones[i] instanceof Telephone){
                ((Telephone)phones[i]).autoAnswering();
            }
            else if(phones[i] instanceof Phone){
                phones[i].talk();
            }
        }
    }
}
