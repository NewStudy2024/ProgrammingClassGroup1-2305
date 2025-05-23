package carrentalsystem;

public class Main {
    public static void main(String[] args) {
        SaleSimulator simulator = new SaleSimulator();
        simulator.initializeCarRentalService();
        simulator.runRentals();
    }
}