package RentACar.Camp.dataAccess.abstracts;

import RentACar.Camp.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarRepository extends JpaRepository<Car,Integer> {
    boolean existsByPlate(String plate);
}
