package it.proactivity.finalsteps.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "city")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    private Long id;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "city_pincode")
    private Integer cityPincode;

    public City(String cityName, Integer cityPincode) {
        this.cityName = cityName;
        this.cityPincode = cityPincode;
    }
}
