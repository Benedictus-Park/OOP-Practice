class ECar{
    private int dist;
    private byte battery;

    public ECar(){
        dist = 0;
        battery = 100;
    }

    public static ECar getInstance(){
        return new ECar();
    }

    public void dispDistance(){
        System.out.println("주행거리: " + dist + "km");
    }

    public void dispBattery(){
        System.out.println("배터리: " + battery + "%");
    }

    public void drive(){
        if(battery == 0){
            System.out.println("배터리 부족 기동불능");
            return;
        }

        System.out.println("1km 주행...");
        dist++;
        battery -= 10;
    }
}

public class hw_1 {
    public static void main(String[] args){
        ECar car = ECar.getInstance();

        car.dispDistance();
        car.dispBattery();

        car.drive();
        car.drive();

        car.dispDistance();
        car.dispBattery();

        for(int i = 0; i < 9; i++){
            car.drive();
        }
    }
}
