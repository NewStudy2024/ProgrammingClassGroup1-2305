package carrentalsystem;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.Random;
import java.time.LocalDateTime;

public class CarRentalService {
    private List<Car> cars;

    public CarRentalService()
    {
        cars = InitCars(5);
    }

    public void addCar(Car car) {
        if (cars == null) {
            cars = new ArrayList<>();
        }
        cars.add(car);
    }

    private ArrayList<Car> InitCars(int amount)
    {
        ArrayList<Car> carList = new ArrayList<>();
        Random random = new Random();
        Brand[] brands = Brand.values();
        Cartype[] types = Cartype.values();

        for (int i = 0; i < amount; i++) {
            String id = "CAR" + String.format("%03d", i + 1);
            double price = 50.0 + (random.nextDouble() * 200.0); // Random price between 50-250
            Brand randomBrand = brands[random.nextInt(brands.length)];
            Cartype randomType = types[random.nextInt(types.length)];
            
            Car car = new Car(id, price, randomBrand, randomType);
            car.isAvailable = true;
            carList.add(car);
        }

        return carList;
    }
    

    private double calculateScore(Customer customer, Car car)
    {
        int score = 0;
        if(car.brand == customer.FavoriteBrand)
        {
            score = score + 25;
        }
        if(car.type == customer.FavoriteCarType)
        {
            score = score + 25;
        }
        //ToDo: Add more later
        return score;
    }

    public boolean rentCarToCustomer(Customer customer)
    {
        Map<Car, Double> map = new HashMap<>();
        cars.stream()
            .filter(car -> car.isAvailable)
            .forEach(car -> map.put(car, calculateScore(customer, car)));

        Optional<Map.Entry<Car, Double>> bestMatch = 
        map.entrySet().stream()
            .max(Map.Entry.comparingByValue());
            
        bestMatch.ifPresent(entry -> {
            Car selectedCar = entry.getKey();
            selectedCar.isAvailable = false;
            selectedCar.RentedTo = customer;
            selectedCar.RentedFrom = LocalDateTime.now();
            System.out.println("Rented car: " + selectedCar + " to customer: " + customer);
        });
        return bestMatch.isPresent();
    }
}
