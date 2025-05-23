package carrentalsystem;

public class Customer {

    public Brand FavoriteBrand;
    public int rentalDuration;
    public Cartype FavoriteCarType;
    public String firstName;
    public String lastName;    public Customer(String firstName, String lastName, Brand favoriteBrand, Cartype favoriteCarType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.FavoriteBrand = favoriteBrand;
        this.FavoriteCarType = favoriteCarType;
        this.rentalDuration = 24 + (int)(Math.random() * 48);
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }

}
