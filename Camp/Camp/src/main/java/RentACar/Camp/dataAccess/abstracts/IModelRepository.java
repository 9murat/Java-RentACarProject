package RentACar.Camp.dataAccess.abstracts;

import RentACar.Camp.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IModelRepository extends JpaRepository<Model ,Integer> {
}
