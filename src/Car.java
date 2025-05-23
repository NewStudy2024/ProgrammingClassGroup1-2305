
public class Car {
    String id;
    Brand brand;
    Cartype type;
    boolean isAvailable;
    double price;

    public Car(String id, double price, Brand brand, Cartype type){
        this.id = id;
        this.price = price;
        this.brand = brand;
        this.type = type;
    }


}
