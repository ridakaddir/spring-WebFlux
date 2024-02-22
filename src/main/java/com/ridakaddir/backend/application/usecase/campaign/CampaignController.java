package com.ridakaddir.backend.application.usecase.campaign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class CampaignController {
    final CampaignService campaignService;
    final WebClient webClient;
    public CampaignController(CampaignService campaignService, WebClient.Builder webClientBuilder) {
        this.campaignService = campaignService;
        this.webClient = webClientBuilder.build();
    }

    @GetMapping("/campaigns")
    public Flux<Campaign> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }

    @GetMapping("/campaigns/{id}")
    public Mono<Campaign> getCampaignById(@PathVariable Long id) {
        log.info("Getting campaign by id: " + id);
        StringUtils.hasText("test");
        return campaignService.getCampaignById(id);
    }

    @PostMapping("/campaigns")
    public Mono<Campaign> createCampaign(@RequestBody Campaign campaign) {
        return campaignService.createCampaign(campaign);
    }

    @GetMapping("/test")
    public Mono<String> test() {
        // call this rest API https://jsonplaceholder.typicode.com/todos/1
        return webClient.get()
                .uri("https://jsonplaceholder.typicode.com/todos/1")
                .retrieve()
                .bodyToMono(String.class);
    }

}
