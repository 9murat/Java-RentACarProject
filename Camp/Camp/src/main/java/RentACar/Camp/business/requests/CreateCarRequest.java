package RentACar.Camp.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data

public class CreateCarRequest {
    @NotEmpty
    private String modelName;
   private String plate;
   private double dailyPrice;
   private int modelYear;
   private String state;

    public CreateCarRequest( String modelName, String plate, double dailyPrice, int modelYear, String state) {

        this.modelName = modelName;
        this.plate = plate;
        this.dailyPrice = dailyPrice;
        this.modelYear = modelYear;
        this.state = state;
    }

    public CreateCarRequest() {
    }
}
