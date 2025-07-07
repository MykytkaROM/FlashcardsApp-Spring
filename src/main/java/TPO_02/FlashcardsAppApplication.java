package TPO_02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

public class FlashcardsAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(FlashcardsAppApplication.class);
		FlashcardsController flashcardsController = context.getBean(FlashcardsController.class);
	}

}
