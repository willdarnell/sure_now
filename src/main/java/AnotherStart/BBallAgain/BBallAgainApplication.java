package AnotherStart.BBallAgain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BBallAgainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BBallAgainApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(PlayerRepository playerRepository) {
		return args -> {
			Player player = new Player("Miles Bridges",  43, List.of(Positions.PF)  );
			playerRepository.insert(player);
		};
	}

}
