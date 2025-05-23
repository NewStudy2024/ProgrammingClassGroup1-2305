package carrentalsystem;

import java.util.List;

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
        for (Customer customer : customers) {
            bool rented = service.rentCarToCustomer(customer);
            if(rented)
            {
                System.out.println("Successfully rented car '"+car.id+"' to " + customer.getFirstName() + " " + customer.getLastName());
            }
        }
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
