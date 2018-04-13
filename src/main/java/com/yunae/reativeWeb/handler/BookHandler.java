package com.yunae.reativeWeb.handler;

import com.yunae.reativeWeb.entity.Book;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class BookHandler {

    public Mono<ServerResponse> allBooks(ServerRequest request) {
        Flux<Book> flux =
                Flux.just(
                new Book("1234", "Boot String WebFlux"),
                new Book("5678", "Boot String WebFlux2")
                );

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(flux, Book.class);
    }
}
