package RentACar.Camp.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelsResponse { // Response :  Son kullanıcıya gönderilecek kısmı burası . İstenmeyen kısmları buraya koymayız.
    private int id;
    private String name;
    private String brandName;

}
