package customermailapplication;

public class RegularCustomer extends Customer {

    @Override
    public String createMail() {
        return "Regular Customer";
    }

}
