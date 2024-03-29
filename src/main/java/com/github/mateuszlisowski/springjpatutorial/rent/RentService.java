package com.github.mateuszlisowski.springjpatutorial.rent;

public class RentService {

    public RentSchema serializeRent(Rent rent) {
        return new RentSchema(
                rent.getRentStart(),
                rent.getRentEnd(),
                rent.getDueDate(),
                rent.getMember().getId(),
                rent.getBook().getId()
        );
    }

    public Rent deserializeRent(RentSchema schema) {
        Rent rent = new Rent();
        rent.setRentStart(schema.rentStart());
        rent.setRentEnd(schema.rentEnd());
        rent.setDueDate(schema.dueDate());

        // rent.setMember();
        // rent.setBook();

        return rent;
    }
}
