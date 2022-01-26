package com.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@RestController
public class GreetingController {

    @GetMapping(value = "/greeting")
    public Mono<String> greeting(){
        return Mono.just("Hello world webflux");
    }

    @GetMapping(value = "/test")
    public Mono<Map<String, String>> test(){
        return Mono.fromCallable(new Consumer());
    }

    private class Consumer implements Callable<Map<String, String>>{

        @Override
        public Map<String, String> call() throws Exception {

            Map<String, String> hash = new HashMap<>();
            hash.put("key", "value");
            return hash;
        }
    }

    @GetMapping(value = "/flux")
    public Flux<List<String>> flux(){
        List<String> list = new LinkedList<>();
        list.add("cc");
        list.add("dd");
        list.add("ee");
        return Flux.just(list);
    }

}
