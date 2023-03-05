package RentACar.Camp.business.abstracts;

import RentACar.Camp.business.requests.CreateBrandRequest;
import RentACar.Camp.business.requests.UpdateBrandRequest;
import RentACar.Camp.business.responses.GetAllBrandResponse;
import RentACar.Camp.business.responses.GetByIdResponse;
import RentACar.Camp.entities.Brand;

import java.util.List;

public interface IBrandService {
    GetByIdResponse getById(int id);

    List<GetAllBrandResponse> getAll(); // Bize gelen talep sonucu kullanıcya GetAllBrandResponse Liste halini gönderdik.

    void add(CreateBrandRequest createBrandRequest);

    void update(UpdateBrandRequest updateBrandRequest);

    void delete(int id);
}
