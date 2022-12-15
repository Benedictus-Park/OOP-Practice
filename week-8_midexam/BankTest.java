package t;
import java.util.Scanner;

class Bank{
	private String acc_no;
	private String name;
	private int balance;

	public Bank(String a, String n, int b) {
		acc_no = a;
		name = n;
		balance = b;
	}

	public String toString() {
		return acc_no + "\t" + name + "\t" + balance;
	}

	public String getAccNo() {
		return acc_no;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int b) {
		balance = b;
	}
}

public class BankTest {
	private static Bank[] bankarr;
	private static Scanner sc;

	private static void createAcc() {
		Bank new_bank;
		Bank[] new_bankarr = new Bank[bankarr.length + 1];
		String acc_no;
		String name;
		int initial_balance;

		System.out.println("=================");
		System.out.println(" 계좌생성을 시작합니다!");
		System.out.println("=================");
		System.out.print("계좌번호 => ");
		acc_no = sc.nextLine();
		System.out.print("계좌주 => ");
		name = sc.nextLine();
		System.out.print("초기입금액 => ");
		initial_balance = sc.nextInt();
		sc.nextLine(); // 입력버퍼 비움

		new_bank = new Bank(acc_no, name, initial_balance);

		for(int i = 0; i < bankarr.length; i++) {
			new_bankarr[i] = bankarr[i];
		}

		new_bankarr[bankarr.length] = new_bank;
		bankarr = new_bankarr;

		System.out.println("계좌가 생성되었습니다.");
	}

	private static void showAcc() {
		System.out.println("=================");
		System.out.println(" 계좌목록을 조회합니다!");
		System.out.println("=================");

		for(int i = 0; i < bankarr.length; i++) {
			System.out.println(bankarr[i]);
		}
	}

	private static void deposit() {
		Bank tgt;
		String acc_no;
		int amount;

		System.out.println("=================");
		System.out.println(" 입금을 시작합니다!");
		System.out.println("=================");
		System.out.print("계좌번호 => ");
		acc_no = sc.nextLine();

		tgt = findAcc(acc_no);

		if(tgt == null) {
			System.out.println("해당 계좌가 없습니다.");
		}
		else {
			System.out.print("입금액 => ");
			amount = sc.nextInt();
			sc.nextLine(); // 입력버퍼 비움
			tgt.setBalance(tgt.getBalance() + amount);
			System.out.println("입금 성공!");
		}
	}

	private static void withdraw() {
		Bank tgt;
		String acc_no;
		int amount;

		System.out.println("=================");
		System.out.println(" 출금을 시작합니다!");
		System.out.println("=================");
		System.out.print("계좌번호 => ");
		acc_no = sc.nextLine();

		tgt = findAcc(acc_no);

		if(tgt == null) {
			System.out.println("해당 계좌가 없습니다.");
		}
		else {
			System.out.print("출금액 => ");
			amount = sc.nextInt();
			sc.nextLine(); // 입력버퍼 비움

			if(tgt.getBalance() < tgt.getBalance()) {
				System.out.println("계좌잔고가 부족합니다.");
				return;
			}

			tgt.setBalance(tgt.getBalance() - amount);
			System.out.println("출금 성공!");
		}
	}

	private static Bank findAcc(String acc_no) {
		for(int i = 0; i < bankarr.length; i++) {
			if(bankarr[i].getAccNo().equals(acc_no)) {
				return bankarr[i];
			}
		}

		return null;
	}

	public static void main(String[] args) {
		int selector;
		boolean run = true;

		bankarr = new Bank[0];
		sc = new Scanner(System.in);

		while(run) {
			System.out.println("=================================================");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.입금 | 4.출금 | 5.종료");
			System.out.println("=================================================");
			System.out.print("선택 > ");
			selector = sc.nextInt();
			sc.nextLine(); // 입력버퍼 비움

			if(selector == 1) {
				createAcc();
			}
			else if(selector == 2) {
				showAcc();
			}
			else if(selector == 3) {
				deposit();
			}
			else if(selector == 4) {
				withdraw();
			}
			else if(selector == 5) {
				System.out.println("프로그램 종료");
				run = false;
			}
		}
	}
}