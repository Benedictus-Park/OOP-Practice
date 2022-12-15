class Car{
    static int numberOfCars = 0;

    String model;
    String manufacturer;

    public Car(){
        this.model = null;
        this.manufacturer = null;
        Car.numberOfCars++;

        System.out.println("자동차 1대 생산, 누적 생산량 = " + Car.numberOfCars);
    }

    public Car(String model, String manufacturer){
        this.model = model;
        this.manufacturer = manufacturer;
        Car.numberOfCars++;

        System.out.println("자동차 1대 생산, 누적 생산량 = " + Car.numberOfCars);
    }

    public static int getNumberOfCar(){
        return Car.numberOfCars;
    }

    public String toString(){
        return "Car[차종: " + this.getModel() + ", 생산자: " + this.getManufacturer() + "]";
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public String getModel(){
        return this.model;
    }

    public String getManufacturer(){
        return this.manufacturer;
    }
}

public class CarFactory {
    public static void main(String[] args){
        Car a = new Car();
        Car b = new Car("빨간모닝", "KIA");
        new Car("빨간모닝", "KIA");
        new Car("빨간모닝", "KIA");
        new Car("빨간모닝", "KIA");
        new Car("빨간모닝", "KIA");
        System.out.println(b);
    }
}
