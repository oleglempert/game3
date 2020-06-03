package exm.retama.game3.conf;

import exm.retama.game3.random.RandomFrom2IntRangeGenerator;
import exm.retama.game3.random.RandomGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RandomGeneratorConfiguration {
//    @Autowired
//    private Environment env;

    @Value("${max.random.limit:10}")
    private int max;

    @Bean
    RandomGenerator getRandomGenerator() {
        return new RandomFrom2IntRangeGenerator(max);
    }
}
