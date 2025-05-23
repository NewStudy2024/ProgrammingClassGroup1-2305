package carrentalsystem;

import java.util.List;
import java.util.ArrayList;

public class SaleSimulator {
    private CarRentalService service;
    private List<Customer> customers;
    public void initializeCarRentalService() {
        service = new CarRentalService();
        customers = new java.util.ArrayList<>();
        int numCustomers = 3 + (int)(Math.random() * 3); // 3-5 customers
        for (int i = 0; i < numCustomers; i++) {
            customers.add(generateRandomCustomer());
        }
    }    public void runRentals()
    {
        List<Customer> successfulRentals = new ArrayList<>();
        for (Customer customer : customers) {
            Car rentedCar = service.rentCarToCustomer(customer);
            if(rentedCar != null)
            {
                System.out.println("Successfully rented car '"+rentedCar.id+"' to " + customer.firstName + " " + customer.lastName);
                successfulRentals.add(customer);
            }
        }
        // Remove customers who successfully rented cars
        customers.removeAll(successfulRentals);
    }

    private List<String> firstNames = List.of(
        "Lukas", "Anna", "Leon", "Sophie", "Paul"
    );
    private List<String> lastNames = List.of(
        "Müller", "Schmidt", "Schneider", "Fischer", "Weber"
    );
    public Customer generateRandomCustomer()
    {
        int random1 = (int) (Math.random() * firstNames.size());
        int random2 = (int) (Math.random() * lastNames.size());
        Brand[] brands = Brand.values();
        Cartype[] cartypes = Cartype.values();
        Brand favoriteBrand = brands[(int) (Math.random() * brands.length)];
        Cartype favoriteCarType = cartypes[(int) (Math.random() * cartypes.length)];
        return new Customer(
            firstNames.get(random1),
            lastNames.get(random2),
            favoriteBrand,
            favoriteCarType
        );

    }
}
