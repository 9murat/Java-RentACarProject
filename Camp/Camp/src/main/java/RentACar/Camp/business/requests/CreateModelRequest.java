package RentACar.Camp.business.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.jetbrains.annotations.NotNull;
import org.springframework.validation.annotation.Validated;

@Data

public class CreateModelRequest {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 25)
    private String name;

    @NotNull
    private Integer brandId;

    public CreateModelRequest(@NotNull String name, @NotNull Integer brandId) {
        this.name = name;
        this.brandId = brandId;
    }

    public CreateModelRequest() {
    }
}
