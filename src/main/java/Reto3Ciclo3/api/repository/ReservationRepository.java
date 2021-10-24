package Reto3Ciclo3.api.repository;

import Reto3Ciclo3.api.model.Reservation;
import Reto3Ciclo3.api.repository.Crud.ReservationCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepo reservationCrudRepo;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepo.findAll();
    }

    public Optional<Reservation> getReservation (int id) {
        return reservationCrudRepo.findById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationCrudRepo.save(reservation);
    }

    public void delete(Reservation reservation){
        reservationCrudRepo.delete(reservation);
    }
}
