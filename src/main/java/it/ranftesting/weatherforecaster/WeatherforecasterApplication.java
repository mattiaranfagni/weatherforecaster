package it.ranftesting.weatherforecaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WeatherforecasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherforecasterApplication.class, args);
	}

}
