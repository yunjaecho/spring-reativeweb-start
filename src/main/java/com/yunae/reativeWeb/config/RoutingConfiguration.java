package com.yunae.reativeWeb.config;

import com.yunae.reativeWeb.entity.Book;
import com.yunae.reativeWeb.handler.BookHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutingConfiguration {

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(BookHandler bookHandler) {
        // BookHandler 사용하지 않음
        return route(GET("/allBooks").and(accept(APPLICATION_JSON)), req -> {
            Flux<Book> flux =
                    Flux.just(
                            new Book("1234", "Boot String WebFlux"),
                            new Book("5678", "Boot String WebFlux2")
                    );

            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(flux, Book.class);
        })

        //return route(GET("/allBooks").and(accept(APPLICATION_JSON)), bookHandler::allBooks)
                ;

    }

}