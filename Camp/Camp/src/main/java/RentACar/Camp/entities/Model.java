package RentACar.Camp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// application.properties;
@Table(name = "model")          // spring.jpa.hibernate.ddl-auto=update : Veri tabanina git ve arti eksi ne varsa ekle çikar .
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "brand_id") // Modelin hangi marka araç olduğunu söylüyor.
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Car>cars; // Bu modelde çok fazla araç olabileceği için listelemei işlemi olabilir .
}
