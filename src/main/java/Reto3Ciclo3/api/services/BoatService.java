package Reto3Ciclo3.api.services;

import Reto3Ciclo3.api.model.Boat;
import Reto3Ciclo3.api.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatService {

    @Autowired
    private BoatRepository boatRepository;

    public List<Boat> getAll(){
        return boatRepository.getAll();
    }

    public Optional<Boat> getBoat(int boatId){
        return boatRepository.getBoat(boatId);
    }

    public Boat save(Boat b){
        if (b.getId()==null){
            return boatRepository.save(b);
        }else{
            Optional<Boat> baux=boatRepository.getBoat(b.getId());
            if (baux.isEmpty()){
                return boatRepository.save(b);
            }else{
                return b;
            }
        }
    }

    public Boat update(Boat boat){
        if (boat.getId() !=null){
            Optional<Boat> auxUpdt=boatRepository.getBoat(boat.getId());
            if(!auxUpdt.isEmpty()){
                if (boat.getName()!=null){
                    auxUpdt.get().setName(boat.getName());
                }
                if (boat.getBrand()!=null){
                    auxUpdt.get().setBrand(boat.getBrand());
                }
                if (boat.getYear()!=null){
                    auxUpdt.get().setYear(boat.getYear());
                }
                if (boat.getDescription()!=null){
                    auxUpdt.get().setDescription(boat.getDescription());
                }
                if (boat.getCategory()!=null){
                    auxUpdt.get().setCategory(boat.getCategory());
                }
                boatRepository.save(auxUpdt.get());
                return auxUpdt.get();
            }else{
                return boat;
            }
        }else{
            return boat;
        }
    }

    public boolean deleteBoat(int boatId){
        Boolean aBoolean = getBoat(boatId).map(boat -> {
            boatRepository.delete(boat);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
