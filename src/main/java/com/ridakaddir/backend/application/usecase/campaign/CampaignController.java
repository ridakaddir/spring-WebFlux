package com.ridakaddir.backend.application.usecase.campaign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class CampaignController {
    final CampaignService campaignService;
    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
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

}
