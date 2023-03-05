package RentACar.Camp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Model>models; // Bu Markada çok fazla model olabileceği için listelemei işlemi olabilir .

}
