package com.ridakaddir.backend.domain.campaign;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Campaign getCampaignById(@PathVariable Long id) {
        return campaignService.getCampaignById(id).block();
    }

    @PostMapping("/campaigns")
    public Mono<Campaign> createCampaign(@RequestBody Campaign campaign) {
        return campaignService.createCampaign(campaign);
    }

}
