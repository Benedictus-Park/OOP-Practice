import java.util.*;

class Book{
    private String title;
    private byte rating;

    public Book(String title, byte rating){
        this.title = title;
        this.rating = rating;
    }

    public String getTitle(){
        return title;
    };

    public byte getRating(){
        return rating;
    }

    public static Book createNewBook(Scanner sc){
        String title;
        byte rating;

        System.out.print("제목: ");
        title = sc.next();
        System.out.print("평점: ");
        rating = sc.nextByte();

        return new Book(title, rating);
    }

    public static Book[] addBook2Array(Book[] origin_arr, Book new_book){
        Book[] rtn = new Book[origin_arr.length + 1];

        for(int i = 0; i < origin_arr.length; i++){
            rtn[i] = origin_arr[i];
        }

        rtn[origin_arr.length] = new_book;

        return rtn;
    }

    private static Book searchBookByIdx(Book[] books, int idx){
        if(idx < 0 || idx >= books.length){
            return null;
        }
        else{
            return books[idx];
        }
    }

    public static void dispBookInfo(Scanner sc, Book[] books){
        int idx;
        Book book;

        System.out.print("책 번호 입력: ");
        idx = sc.nextInt() - 1;
        book = Book.searchBookByIdx(books, idx);

        if(book == null){
            System.out.println("# " + (idx + 1) + "번 책은 존재하지 않습니다.");
            return;
        }

        System.out.println("===== 책 정보 =====\n제목: " + book.getTitle() + "\n평점: " + book.getRating());
    }

    public static void dispAllBooks(Book[] books){
        if(books.length == 0){
            System.out.println("등록된 책이 없습니다.");
            return;
        }

        for(int i = 0; i < books.length; i++){
            System.out.println("# " + (i + 1) + "번 도서\n제목: " + books[i].title);
        }
    }
}

public class hw_2 {
    private static final byte REGIST_BOOK = 1;
    private static final byte SEARCH_BOOK = 2;
    private static final byte DISP_ALL_BOOKS = 3;
    private static final byte EXIT = 4;

    public static void main(String[] args){
        int selector;
        Book book;
        Book[] books = new Book[0];
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("==========================");
            System.out.println("1. 책 등록");
            System.out.println("2. 책 검색");
            System.out.println("3. 모든 책 출력");
            System.out.println("4. 종료");
            System.out.println("==========================");
            System.out.print("선택: ");
            selector = sc.nextByte();

            switch(selector){
                case REGIST_BOOK:
                    book = Book.createNewBook(sc);
                    books = Book.addBook2Array(books, book);
                    break;
                case SEARCH_BOOK:
                    Book.dispBookInfo(sc, books);
                    break;
                case DISP_ALL_BOOKS:
                    Book.dispAllBooks(books);
                    break;
                case EXIT:
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }while(selector != EXIT);

        sc.close();
    }
}
