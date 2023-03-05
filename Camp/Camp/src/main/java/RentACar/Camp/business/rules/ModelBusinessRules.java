package RentACar.Camp.business.rules;

import RentACar.Camp.core.utilities.exceptions.BusinessExceptions;
import RentACar.Camp.dataAccess.abstracts.IBrandRepository;
import RentACar.Camp.dataAccess.abstracts.IModelRepository;
import org.springframework.stereotype.Service;

@Service
public class ModelBusinessRules {
    private final IModelRepository iModelRepository;
    private final IBrandRepository iBrandRepository;

    public ModelBusinessRules(IModelRepository iModelRepository, IBrandRepository iBrandRepository) {
        this.iModelRepository = iModelRepository;
        this.iBrandRepository = iBrandRepository;
    }
    public void checkIfBrandIdExists(int id){
        if (!this.iBrandRepository.existsById(id)){
            throw new BusinessExceptions("This brand id not found and this model not added .");
        }
        else
        {
            throw new BusinessExceptions("This brand found and model added");
        }
    }
}
