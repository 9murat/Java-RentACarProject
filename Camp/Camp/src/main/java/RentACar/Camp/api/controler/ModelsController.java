package RentACar.Camp.api.controler;

import RentACar.Camp.business.abstracts.IModelService;
import RentACar.Camp.business.requests.CreateBrandRequest;
import RentACar.Camp.business.requests.CreateModelRequest;
import RentACar.Camp.business.responses.GetAllBrandResponse;
import RentACar.Camp.business.responses.GetAllModelsResponse;
import RentACar.Camp.business.responses.ModelGetByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/models")
@RestController
public class ModelsController {
    private final IModelService iModelService;

    public ModelsController(IModelService iModelService) {
        this.iModelService = iModelService;
    }

    @GetMapping
    public List<GetAllModelsResponse> getAll() {
        return iModelService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateModelRequest createModelRequest){
        this.iModelService.add(createModelRequest);
    }

    @GetMapping("/{id}")
    public ModelGetByIdResponse getByIdResponse(@PathVariable int id){
        return iModelService.modelGetById(id);
    }
}
