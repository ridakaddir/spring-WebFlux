package com.ridakaddir.backend.campaign;

import org.junit.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class CampaignServiceTest {

        @Test
        public void createCampaign() {
            Publisher<Integer> rangeOfIntegers = Flux.range(1, 10).delayElements(Duration.ofSeconds(1)).map(i -> i*2);

            Flux.from(rangeOfIntegers).subscribe(System.out::println);

            StepVerifier.create(rangeOfIntegers)
                    .expectNext(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)
                    .verifyComplete();

        }

        @Test
    public void completableFuture() {
        // given
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");


        // when
        Mono<String> mono = Mono.fromFuture(completableFuture);

        // then
        StepVerifier.create(mono)
                .expectNext("Hello")
                .verifyComplete();
    }

    @Test
    public void zipWithExample() {
        // given
        Mono<String> first = Mono.just("Hello");
        Mono<String> second = Mono.just("World");

        // when
        Mono<String> mono = first.zipWith(second).map(tuple -> tuple.getT1() + " " + tuple.getT2());

        // then
        StepVerifier.create(mono)
                .expectNext("Hello World")
                .verifyComplete();
    }


}