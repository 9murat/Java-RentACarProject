package RentACar.Camp.business.responses;

import RentACar.Camp.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBrandResponse { // Gönderme işlemi . Ne , Nasıl gönderilecek .  Tüm Brand'leri listeleme işlemi
    private int id;
    private String name;


    // List<Brand>getAll(); Tüm her şeyi göndermeye çalıştık fakat amaç her şeyi değil istediklerimizi göndermek .
    // GetAllRsponse classı Bizim istediklerimizi gönderme classı . Her şeyi göndermicez
    // Response Classı Bizim kullanıcıya verdiğimiz kısım .

}
