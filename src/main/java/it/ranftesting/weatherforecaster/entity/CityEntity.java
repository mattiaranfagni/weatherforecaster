package it.ranftesting.weatherforecaster.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "city")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long id;
    @Column(name = "city_name", nullable = false, unique = true)
    private String name;
    @Column(name = "city_latitude", nullable = false)
    private Float latitude;
    @Column(name = "city_longitude", nullable = false)
    private Float longitude;

    @OneToMany(
            mappedBy = "city",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OpenMeteoEntity> meteoData = new ArrayList<>();

    public void addMeteoData(OpenMeteoEntity meteo) {
        meteoData.add(meteo);
        meteo.setCity(this);
    }

    public void removeMeteoData(OpenMeteoEntity meteo) {
        meteoData.remove(meteo);
        meteo.setCity(null);
    }
}