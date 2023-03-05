package RentACar.Camp.api.controler;

import RentACar.Camp.business.abstracts.ICarService;
import RentACar.Camp.business.requests.CreateCarRequest;
import RentACar.Camp.business.requests.CreateModelRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/cars")
@RestController
public class CarsController {
    private final ICarService iCarService;

    public CarsController(ICarService iCarService) {
        this.iCarService = iCarService;
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateCarRequest createCarRequest){
        this.iCarService.add(createCarRequest);
    }
}
