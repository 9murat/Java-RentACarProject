package RentACar.Camp.business.abstracts;

import RentACar.Camp.business.requests.CreateBrandRequest;
import RentACar.Camp.business.requests.CreateModelRequest;
import RentACar.Camp.business.responses.GetAllBrandResponse;
import RentACar.Camp.business.responses.GetAllModelsResponse;
import RentACar.Camp.business.responses.ModelGetByIdResponse;

import java.util.List;

public interface IModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
    ModelGetByIdResponse modelGetById(int id);
}
