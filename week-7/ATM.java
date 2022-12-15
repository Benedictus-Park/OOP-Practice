import java.util.Scanner;

class Account{
    private int balance;
    private int pin;
    private final int account_id;

    public Account(int pin, int account_id){
        this.balance = 0;
        this.pin = pin;
        this.account_id = account_id;
    }

    public boolean validatePIN(int pin){
        return this.pin == pin; 
    }

    public int incBalance(int amount){
        balance += amount;
        return balance;
    }

    public int decBalance(int amount){
        balance -= amount;
        return balance;
    }

    public int getBalance(){
        return balance;
    }

    public int getAccountId(){
        return account_id;
    }
}

class BankComputerNetwork{
    private final int BANK_CODE = 23;
    private Account[] accounts;

    public BankComputerNetwork(){
        accounts = new Account[0];
    }

    public int addAccount(int pin){
        int account_id;
        Account new_account;
        Account[] expanded_accounts;

        if(accounts.length == 998){
            return -1;
        }

        account_id = BANK_CODE * 1000 + accounts.length + 1; // 계좌번호 형식은 은행 코드(nn) + 계좌 개설 순번(xxx) -> nnxxx
        new_account = new Account(pin, account_id);
        expanded_accounts = new Account[accounts.length + 1];

        for(int i = 0; i < accounts.length; i++){
            expanded_accounts[i] = accounts[i];
        }
        expanded_accounts[accounts.length] = new_account;
        accounts = expanded_accounts;

        return account_id;
    }

    public int deposit(int from, int amount){
        return accounts[idx(from)].incBalance(amount);
    }

    public int withdraw(int from, int amount){
        if(accounts[idx(from)].getBalance() < amount){
            return -1;
        }
        else{
            return accounts[idx(from)].decBalance(amount);
        }
    }

    public int[] remit(int from, int to, int amount){
        int[] result = new int[2];

        if(accounts[idx(from)].getBalance() < amount){
            result[0] = -1;
        }
        else if(idx(to) >= accounts.length){
            result[0] = -2; // 송금 보내는 계좌가 없는 경우는 고려하지 않음.
        }
        else{
            result[0] = accounts[idx(from)].decBalance(amount);
            result[1] = accounts[idx(to)].incBalance(amount);
        }
        
        return result;
    }

    public boolean validatePIN(int tgt_account, int pin){
        return accounts[idx(tgt_account)].validatePIN(pin);
    }

    private int idx(int account_id){
        return account_id - 23001;
    }
}

public class ATM {
    static Scanner sc = new Scanner(System.in);
    static BankComputerNetwork net = new BankComputerNetwork();
    
    static void performDeposit(int user_account_id){
        int amount;

        System.out.print("입금액");
        amount = sc.nextInt();

        System.out.println("현재 잔액은 " + net.deposit(user_account_id, amount) + "입니다.");
    }
    
    static void performWithdraw(int user_account_id){
        int amount;
        int result;

        System.out.print("인출액");
        amount = sc.nextInt();
        result = net.withdraw(user_account_id, amount);

        if(result > -1){
            System.out.println("현재 잔액은 " + result + "입니다.");
        }
        else{
            System.out.println("출금계좌 잔고 부족");
        }
    }
                 
    static void performRemit(int user_account_id){
        int amount, to;
        int[] result;

        System.out.print("이체액");
        amount = sc.nextInt();
        System.out.print("이체 계좌 번호");
        to = sc.nextInt();

        result = net.remit(user_account_id, to, amount);

        if(result[0] > -1){
            System.out.println("현재 잔액은 " + result[0] + "입니다.");
            System.out.println(to + "님의 현재 잔액은 " + result[1] + "입니다.");
        }
        else if(result[0] == -1){
            System.out.println("출금계좌 잔고 부족");
        }
        else if(result[0] == -2){
            System.out.println("계좌번호를 잘못 입력하셨습니다.");
        }
    }

    public static void main(String[] args){
        final int DEPOSIT = 1;
        final int WITHDRAW = 2;
        final int REMIT = 3;
        final int EXIT = 4;

        int input;
        int user_account_id;

        user_account_id = net.addAccount(1220); // 이 은행의 첫 번째 계좌 개설자는 유저! + 카드 삽입한 상태라고 가정! 계좌번호 23001
        net.addAccount(1234); // 계좌번호 23002
        net.addAccount(1234); // 계좌번호 23003
        net.addAccount(1234); // 계좌번호 23004
        net.addAccount(1234); // 계좌번호 23005
        net.addAccount(1234); // 계좌번호 23006

        while(true){
            System.out.print("PIN을 입력하시오 : ");
            input = sc.nextInt();

            if(net.validatePIN(user_account_id, input)){
                break;
            }
            
            System.out.println("PIN이 잘못되었습니다.");
        }

        while(true){
            System.out.println("1. 현금 입금");
            System.out.println("2. 현금 인출");
            System.out.println("3. 계좌 이체");
            System.out.println("4. 종료\n");
            System.out.print("번호를 선택하세요 : ");
            input = sc.nextInt();

            switch(input){
                case DEPOSIT:
                    performDeposit(user_account_id);
                    break;
                case WITHDRAW:
                    performWithdraw(user_account_id);
                    break;
                case REMIT:
                    performRemit(user_account_id);
                    break;
                case EXIT:
                    return;
            }
        }
    }
}
