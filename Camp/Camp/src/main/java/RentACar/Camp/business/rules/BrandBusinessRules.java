package RentACar.Camp.business.rules;

import RentACar.Camp.core.utilities.exceptions.BusinessExceptions;
import RentACar.Camp.dataAccess.abstracts.IBrandRepository;
import RentACar.Camp.entities.Brand;
import org.springframework.stereotype.Service;

@Service
public class BrandBusinessRules {
    private final IBrandRepository iBrandRepository; // Veri tabanına gidip marka ismi var mı kontrol edicez.

    public BrandBusinessRules(IBrandRepository iBrandRepository) {
        this.iBrandRepository = iBrandRepository;
    }

    public void checkIfBrandNameExists(String name) {
        if (!this.iBrandRepository.existsByName(name)) {
            throw new BusinessExceptions(" Brand name added"); // Burada Kendi business hatamızı kendimiz oluşturuyoruz.
        }
        throw new BusinessExceptions("Brand name already exists");
    }
}
