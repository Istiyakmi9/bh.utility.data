package in.bottomhalf.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import in.bottomhalf;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {

	RequestMicroservice
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
