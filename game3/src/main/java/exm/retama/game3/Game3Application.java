package exm.retama.game3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
public class Game3Application {
	private static Logger logger = LoggerFactory.getLogger(Game3Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Game3Application.class, args);
		logger.info("STTTTTTTTTTTTTTTTTTTTTTTTTTAAAAAAAAAAAAAAAAART");
	}

//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//		PropertySourcesPlaceholderConfigurer p =  new PropertySourcesPlaceholderConfigurer();
//		p.setIgnoreResourceNotFound(true);
//		return p;
//	}
}
