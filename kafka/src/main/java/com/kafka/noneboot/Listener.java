package com.kafka.noneboot;

import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class Listener {
    private final CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(id = "foo", topics = "annotated1")
    public void listen(String id){
        this.latch.countDown();
    }
}
