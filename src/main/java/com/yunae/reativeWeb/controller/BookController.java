package com.yunae.reativeWeb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookController {

    @GetMapping("/book")
    public String getBook() {
        return "Book";
    }

    @GetMapping("/flux")
    public Flux<String> flux() {
        return Flux.just("a", "b", "c", "d");
    }

    @GetMapping("/mono")
    public Mono<String> mono() {
        return Mono.just("mono");
    }


}
