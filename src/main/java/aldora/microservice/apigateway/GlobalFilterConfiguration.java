package aldora.microservice.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class GlobalFilterConfiguration {
    final Logger logger = LoggerFactory.getLogger(GlobalFilterConfiguration.class);

    @Bean
    public GlobalFilter secondFilter() {
        return (exchange, chain) -> {
            logger.info("My second global pre-filter executed");

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                logger.info("My second global post-filter executed");
            }));
        };
    }

    @Bean
    public GlobalFilter thirdFilter() {
        return (exchange, chain) -> {
            logger.info("My third global pre-filter executed");

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                logger.info("My third global post-filter executed");
            }));
        };
    }

    @Bean
    public GlobalFilter fourthFilter() {
        return (exchange, chain) -> {
            logger.info("My fourth global pre-filter executed");

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                logger.info("My fourth global post-filter executed");
            }));
        };
    }
}
