package com.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
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

}
