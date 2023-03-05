package RentACar.Camp.business.abstracts;

import RentACar.Camp.business.requests.CreateCarRequest;

public interface ICarService {
    void add(CreateCarRequest createCarRequest);
}
