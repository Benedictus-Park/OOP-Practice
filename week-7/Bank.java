class BankAccount{
    private int balance;

    public BankAccount(){
        this.balance = 0;
    }

    public BankAccount(int balance){
        setBalance(balance);
    }

    public String toString(){
        return "BankAccount [balance=" + getBalance() + "]";
    }

    private void setBalance(int balance){
        this.balance = balance;
    }

    private int getBalance(){
        return this.balance;
    }

    public void withdraw(int amount){
        this.setBalance(getBalance() - amount);
    }

    public void deposit(int amount){
        this.setBalance(getBalance() + amount);
    }

    public boolean transfer(int amount, BankAccount otherAccount){
        if(getBalance() < amount || getBalance() == 0){
            return false; // 마이너스 대출은 아니니까요 ㅎㅎ...
        }
        
        System.out.println("transfer(" + amount + ")");
        this.withdraw(amount);
        otherAccount.deposit(amount);

        return true;
    }
}

public class Bank {
    public static void main(String[] args){
        BankAccount a1 = new BankAccount(10000);
        BankAccount a2 = new BankAccount(0);
        System.out.println("a1: " + a1);
        System.out.println("a2: " + a2 + "\n");
        a1.transfer(1000, a2);
        System.out.println("a1: " + a1);
        System.out.println("a2: " + a2 + "\n");
    }
}
