import java.util.*;

class Movie{
    private String title;
    private String director;
    private short year;
    private String mainActor;
    private double rating;

    public Movie(){
        this.title = null;
        this.rating = -1;
        this.director = null;
        this.year = -1;
    }

    public Movie(String title, String director, short year, String mainActor, double rating){
        this.title = title;
        this.director = director;
        this.year = year;
        this.mainActor = mainActor;
        this.rating = rating;
    }

    public String toString(){
        return "제목: " + title + "\n감독: " + director + "\n년도: " + year + "\n주연배우: " + mainActor + "\n평점: " + rating;
    }
}

public class MovieTest {
    public static void main(String[] args){
        String title;
        String director;
        short year;
        String mainActor;
        double rating;
        Movie movie = null;
        Scanner sc = new Scanner(System.in);

        System.out.print("제목: ");
        title = sc.next();
        System.out.print("감독: ");
        director = sc.next();
        System.out.print("년도: ");
        year = sc.nextShort();
        System.out.print("주연배우: ");
        mainActor = sc.next();
        System.out.print("평점: ");
        rating = sc.nextDouble();
        
        movie = new Movie(title, director, year, mainActor, rating);

        System.out.println(movie.toString());
    }
}
