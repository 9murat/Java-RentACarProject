package RentACar.Camp;

import RentACar.Camp.core.utilities.exceptions.BusinessExceptions;
import RentACar.Camp.core.utilities.exceptions.ProblemDetails;
import RentACar.Camp.core.utilities.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
public class CampApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper(); // ModellMapper Classında otomatik yazılmdığı için bunu biz kendimiz oluşturacağız.
    }

}
