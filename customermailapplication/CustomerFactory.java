package customermailapplication;

public class CustomerFactory {
    public static Customer createCustomer(String type){
        if (type.equals("Regular")) 
			return new RegularCustomer();
		else if (type.equals("Mountain"))
			return new MountainCustomer();
        else if (type.equals("Delinquent"))
            return new DelinquentCustomer();
		return null;
    }

}
