package Main;

import Model.Appointment;
import Model.BoardingBooking;
import Model.Pet;
import Model.Vet;

/**
 * Created by Eiger on 1/03/2016.
 */
public class BookingFactory {
    private BookingFactory() { }

    public static Appointment createAppointment(Vet vet, Pet pet) {
        return new Appointment(vet, pet);
    }

    public static BoardingBooking createBoardingBooking(Pet pet) {
        return new BoardingBooking(pet);
    }

}
