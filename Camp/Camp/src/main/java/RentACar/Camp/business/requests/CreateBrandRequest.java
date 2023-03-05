package RentACar.Camp.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBrandRequest { // Sahibinden.com da  Talep oluştururken aratılan kısım . ismi , kilometre, yaş ...
    @NotNull
    @NotBlank
    @Size(min = 3, max = 25)
    private String name;
}
