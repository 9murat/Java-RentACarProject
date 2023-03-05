package RentACar.Camp.business.concretes;

import RentACar.Camp.business.abstracts.IBrandService;
import RentACar.Camp.business.requests.CreateBrandRequest;
import RentACar.Camp.business.requests.UpdateBrandRequest;
import RentACar.Camp.business.responses.GetAllBrandResponse;
import RentACar.Camp.business.responses.GetByIdResponse;
import RentACar.Camp.business.rules.BrandBusinessRules;
import RentACar.Camp.core.utilities.mappers.ModelMapperService;
import RentACar.Camp.dataAccess.abstracts.IBrandRepository;
import RentACar.Camp.entities.Brand;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandManager implements IBrandService {
    private final IBrandRepository iBrandRepository;
    private final ModelMapperService modelMapperService;
    private final BrandBusinessRules brandBusinessRules;

    public BrandManager(IBrandRepository iBrandRepository, ModelMapperService modelMapperService, BrandBusinessRules brandBusinessRules) {
        this.iBrandRepository = iBrandRepository;
        this.modelMapperService = modelMapperService;
        this.brandBusinessRules = brandBusinessRules;
    }

    @Override
    public GetByIdResponse getById(int id) {
        Brand brand = this.iBrandRepository.findById(id).orElseThrow(); // brand'i (iBrandRepository.findById(id) ) göre bu bulmazsa hat fırlat .
        GetByIdResponse response = this.modelMapperService.forResponse().map(brand, GetByIdResponse.class); //GetByIdResponse'i (modelMapperService.forResponse ) göre bul ve brand'i (GetByIdResponse.class) çevir
        return response;
    }

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brands = iBrandRepository.findAll();
        List<GetAllBrandResponse> brandResponses = brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandResponse.class)).collect(Collectors.toList());
        // brands.stream().map = Elimizde bir liste varsa for gibi dolaşmamızı sağlıyor.
        // O an gezdiğim her bir brand için ( this.modelMapperService.forResponse  )  map'ini kullanarak map'le.
        // Her bir brand'i getAllResponse'a çevir.
        return brandResponses; // brandResponse return et.
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName()); // brandBusinessRules.checkIfBrandNameExists kontrol et doğru ise (message) yeerine createBrandRequest.getName ata. İş kuralları (if) buraya yazılmaz . Her şey kendi classında yazılır.
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class); // ( createBrandRequest ) (Brand clasına)eşitle.
        this.iBrandRepository.save(brand); // Veri tabanına bir tane brand kaydet . Yukarıdaki brand.
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.iBrandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.iBrandRepository.deleteById(id);
    }
}
