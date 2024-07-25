package customermailapplication;

import java.util.Scanner;

public class CustomerMailApplication {

    // private Customer customer;

    // public void getCustomerTypeFromUser(String customerType) {
    // switch (customerType) {
    // case "Regular" -> customer = new RegularCustomer();
    // case "Mountain" -> customer = new MountainCustomer();
    // case "Delinquent" -> customer = new DelinquentCustomer();
    // }
    // }

    // public String generateMail() {
    // return customer.createMail();
    // }

    public static void main(String[] args) {
        try (Scanner inp = new Scanner(System.in)) {
            System.out.print("Please choose customer type 1. Regular, 2. Mountain, 3. Delinquent ");
            int type = inp.nextInt();
            Customer customer = switch (type) {
                case 1 -> CustomerFactory.createCustomer("Regular");
                case 2 -> CustomerFactory.createCustomer("Mountain");
                case 3 -> CustomerFactory.createCustomer("Delinquent");
                default -> null;
            };
            System.out.println(customer.createMail());
        }
    }
}
