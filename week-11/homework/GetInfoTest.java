import java.util.Random;

interface GetInfo{
    double getValue();
}

interface Measurable{
    double average(Measurable[] objects);
}

class Student implements GetInfo, Measurable{
    double score;

    public Student(double score){
        this.score = score;
    }

    public double getValue(){
        return score;
    }

    public double average(Measurable[] objects){
        Student[] students = (Student[])objects;
        double sum = 0;

        for(int i = 0; i < students.length; i++){
            sum += students[i].getValue();
        }

        return sum / students.length;
    }
}

public class GetInfoTest{
    static final int NUM_OF_STUDENTS = 10;

    public static void main(String[] args){
        Random rdn = new Random();
        Student[] students = new Student[NUM_OF_STUDENTS];

        for(int i = 0; i < students.length; i++){
            students[i] = new Student((rdn.nextDouble() * 10) % 4.5);
        }

        System.out.println(NUM_OF_STUDENTS + "명 평균 성적: " + String.format("%.2f", students[0].average((Measurable[])students)));
    }
}