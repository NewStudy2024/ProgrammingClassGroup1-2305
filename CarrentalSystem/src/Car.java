package carrentalsystem;

public class Car {
    String id;
    Brand brand;
    Cartype type;
    boolean isAvailable;
    double price;
    public Customer RentedTo;
    public Object RentedFrom;

    public Car(String id, double price, Brand brand, Cartype type){
        this.id = id;
        this.price = price;
        this.brand = brand;
        this.type = type;
    }


}
