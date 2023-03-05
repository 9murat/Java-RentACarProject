package RentACar.Camp.dataAccess.abstracts;

import RentACar.Camp.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsByName(String name);
    //  Jpa Brand'e gidiyor name bakıyor bu isimde marka var mı. Varsa true yoksa false
    // Exists komutunu görünce direkt gidiyor
    // Extends ettiğimizde spring jpa bize bir çok emir getiriyor .
    // Özel emirler yazmak istersek yazabiliriz.

}
