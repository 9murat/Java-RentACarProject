package RentACar.Camp.business.concretes;

import RentACar.Camp.business.abstracts.IModelService;
import RentACar.Camp.business.requests.CreateModelRequest;
import RentACar.Camp.business.responses.GetAllBrandResponse;
import RentACar.Camp.business.responses.GetAllModelsResponse;

import RentACar.Camp.business.responses.GetByIdResponse;
import RentACar.Camp.business.responses.ModelGetByIdResponse;
import RentACar.Camp.business.rules.ModelBusinessRules;
import RentACar.Camp.core.utilities.mappers.ModelMapperService;
import RentACar.Camp.dataAccess.abstracts.IModelRepository;
import RentACar.Camp.entities.Brand;
import RentACar.Camp.entities.Model;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelManager implements IModelService {
    private final IModelRepository modelRepository;
    private final ModelMapperService modelMapperService;
    private final ModelBusinessRules modelBusinessRules;

    public ModelManager(IModelRepository modelRepository, ModelMapperService modelMapperService, ModelBusinessRules modelBusinessRules) {
        this.modelRepository = modelRepository;
        this.modelMapperService = modelMapperService;
        this.modelBusinessRules = modelBusinessRules;
    }


    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> getAllModelsResponses = models.stream().map(model -> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return getAllModelsResponses;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        this.modelBusinessRules.checkIfBrandIdExists(createModelRequest.getBrandId());
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class); // ( createBrandRequest ) (Brand clasına)eşitle.
        this.modelRepository.save(model);
    }

    @Override
    public ModelGetByIdResponse modelGetById(int id) {
        Model model=this.modelRepository.findById(id).orElseThrow();
        ModelGetByIdResponse modelGetByIdResponse=this.modelMapperService.forResponse().map(model,ModelGetByIdResponse.class);
        return modelGetByIdResponse;
    }
}
