package it.ranftesting.weatherforecaster;

import org.springframework.boot.SpringApplication;

public class TestWeatherforecasterApplication {

	public static void main(String[] args) {
		SpringApplication.from(WeatherforecasterApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
