package RentACar.Camp.api.controler;

import RentACar.Camp.business.abstracts.IBrandService;
import RentACar.Camp.business.requests.CreateBrandRequest;
import RentACar.Camp.business.requests.UpdateBrandRequest;
import RentACar.Camp.business.responses.GetAllBrandResponse;
import RentACar.Camp.business.responses.GetByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/brands")
@RestController
public class BrandsController {
    private final IBrandService iBrandService;

    public BrandsController(IBrandService iBrandService) {
        this.iBrandService = iBrandService;
    }


    @GetMapping
    public List<GetAllBrandResponse> getAll() {
        return iBrandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdResponse getByIdResponse(@PathVariable int id) { // @PathVariable git id'yi path ("/api/brands") 'den al.
        return iBrandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateBrandRequest createBrandRequest) {
        this.iBrandService.add(createBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
        this.iBrandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.iBrandService.delete(id);
    }
}
