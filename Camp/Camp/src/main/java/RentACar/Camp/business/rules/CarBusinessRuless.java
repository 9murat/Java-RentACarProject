package RentACar.Camp.business.rules;

import RentACar.Camp.core.utilities.exceptions.BusinessExceptions;
import RentACar.Camp.dataAccess.abstracts.ICarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarBusinessRuless {
    private final ICarRepository iCarRepository;

    public CarBusinessRuless(ICarRepository iCarRepository) {
        this.iCarRepository = iCarRepository;
    }
    public void checkIfPlateExists(String plate) {
        if (!this.iCarRepository.existsByPlate(plate)) {
            throw new BusinessExceptions(" Car Plate added"); // Burada Kendi business hatamızı kendimiz oluşturuyoruz.
        }
        throw new BusinessExceptions("Car plate already exists");
    }
}
