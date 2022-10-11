package gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/listHeaders")
						.filters(f -> f.addRequestHeader("Hello", "World"))
//						.uri("https://gs-spring-sample.cfapps.pcfeagleci.cf-app.com:443/listHeaders"))
						.uri("http://gs-spring-sample.apps.internal:8080/listHeaders"))
				.build();
	}

}
