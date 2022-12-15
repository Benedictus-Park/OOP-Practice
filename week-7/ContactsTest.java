import java.util.*;

class Contacts{
    private class Contact{
        private String name;
        private String tel;
        private String email;

        public Contact(String name, String tel, String email){
            this.name = name;
            this.tel = tel;
            this.email = email;
        }

        public String toString(){
            return getName() + " 전화번호: " + getTel() + "이메일: " + getEmail();
        }

        public void setName(String name){
            this.name = name;
        }

        public void setTel(String tel){
            this.tel = tel;
        }

        public void setEmail(String email){
            this.email = email;       
        }

        public String getName(){
            return this.name;
        }

        public String getTel(){
            return this.tel;
        }

        public String getEmail(){
            return this.email;
        }
    }

    static int count = 0;

    Scanner sc;
    Contact[] contacts;

    public Contacts(){
        sc = new Scanner(System.in);
        this.contacts = new Contact[0];
    }

    public void addContact(){
        String name;
        String tel;
        String email;

        System.out.println("연락처를 입력하시오(종료 -1)");
        
        do{
            System.out.print("이름과 전화번호, 이메일을 입력하시오. ");
            name = sc.next();

            if(name.equals("-1")){
                break;
            }

            tel = sc.next();
            email = sc.next();

            if(!addContactToContacts(name, tel, email)){
                System.out.println("전화번호부가 꽉 찼습니다. 연락처 등록을 중단합니다.");
                return;
            }
        }while(true);

        System.out.println("지인들의 수는 " + Contacts.count + "명 입니다.");
    }

    public void searchContact(){
        String name = null;

        System.out.print("검색할 이름을 입력하시오: ");
        sc.nextLine(); // Flush the buffer
        name = sc.nextLine();

        for(int i = 0; i < this.contacts.length; i++){
            if(this.contacts[i].getName().equals(name)){
                System.out.println(this.contacts[i].toString());
                return;
            }
        }

        System.out.println("해당 이름을 가진 연락처가 존재하지 않습니다.");
    }

    private boolean addContactToContacts(String name, String tel, String email){
        Contact contact;
        Contact[] new_contacts;
        
        if(Contacts.count == 100){
            return false;
        }

        contact = new Contact(name, tel, email);
        new_contacts = new Contact[this.contacts.length + 1];
        
        for(int i = 0; i < this.contacts.length; i++){
            new_contacts[i] = contacts[i];
        }
        new_contacts[this.contacts.length] = contact;
        Contacts.count++;

        this.contacts = new_contacts;

        return true;
    }

    private String getContactToString(Contact contact){
        return contact.toString();
    }

    public static int numOfContacts(){
        return count;
    }
}

public class ContactsTest{
    public static void main(String[] args){
        Contacts contacts = new Contacts();
        contacts.addContact();
        contacts.searchContact();
    }
}