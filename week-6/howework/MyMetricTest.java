class MyMetric{
    public static double kiloToMile(double km){
        return km / 1.6093;
    }

    public static double mileToKilo(double mile){
        return mile * 1.6093;
    }
}

public class MyMetricTest {
    public static void main(String[] args){
        System.out.println("10km는 " + MyMetric.kiloToMile(10) + "mile.");
        System.out.println("10mi는 " + MyMetric.mileToKilo(10) + "km.");
    }
}
