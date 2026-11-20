package it.ranftesting.weatherforecaster.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}