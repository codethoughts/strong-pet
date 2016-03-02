package Main;

import Model.Customer;
import Model.Pet;

/**
 * Created by Eiger on 1/03/2016.
 */
public class CustomerFactory {
    private CustomerFactory() { }
    public static Pet createPet(Customer owner) {
        return new Pet(owner);
    }
    public static Customer createCustomer(String ic_number, Pet pet) {
        return new Customer(ic_number, pet);
    }
}
