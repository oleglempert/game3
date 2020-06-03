package exm.retama.game3.conf;

import exm.retama.game3.calculator.StepCalculator;
import exm.retama.game3.calculator.StepCalculatorImpl;
import exm.retama.game3.validator.InputGame3Validator;
import exm.retama.game3.validator.InputGame3ValidatorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
public class Game3Configuration {

    @Bean
    public StepCalculator getStepCalculator() {
        return new StepCalculatorImpl();
    }

    @Bean
    public InputGame3Validator getValidator() {
        return new InputGame3ValidatorImpl();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}

