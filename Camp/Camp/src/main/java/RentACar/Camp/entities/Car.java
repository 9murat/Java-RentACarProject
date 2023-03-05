package RentACar.Camp.entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car { // Hangi modelde kaç tane araba old. gösterir . 1 modelde 10 tane araba olaiblir.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "plate", unique = true) // Plaka
    private String plate;

    @Column(name = "daily_price")
    private double dailyPrice;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "state") // Hangi durumda
    private String state;  // 1- Available , 2- Rented , 3-Maintenance

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "model_id") // Aracın hangi model olduğunu söylüyor. Zaten model classın da Brand_id var .
    private Model model;

}