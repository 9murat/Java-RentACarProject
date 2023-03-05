package RentACar.Camp.business.concretes;

import RentACar.Camp.business.abstracts.ICarService;
import RentACar.Camp.business.requests.CreateCarRequest;
import RentACar.Camp.business.rules.CarBusinessRuless;
import RentACar.Camp.core.utilities.mappers.ModelMapperService;
import RentACar.Camp.dataAccess.abstracts.ICarRepository;
import RentACar.Camp.entities.Car;
import org.springframework.stereotype.Service;

@Service
public class CarManager implements ICarService  {
    private final CarBusinessRuless carBusinessRuless;
    private final ModelMapperService modelMapperService;
    private final ICarRepository iCarRepository;

    public CarManager(CarBusinessRuless carBusinessRuless, ModelMapperService modelMapperService, ICarRepository iCarRepository) {
        this.carBusinessRuless = carBusinessRuless;
        this.modelMapperService = modelMapperService;
        this.iCarRepository = iCarRepository;
    }


    @Override
    public void add(CreateCarRequest createCarRequest) {
        this.carBusinessRuless.checkIfPlateExists(createCarRequest.getPlate());
        Car car =this.modelMapperService.forRequest().map(createCarRequest, Car.class);
        this.iCarRepository.save(car);
    }
}
