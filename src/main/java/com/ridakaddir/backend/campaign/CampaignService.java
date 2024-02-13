package com.ridakaddir.backend.campaign;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class CampaignService {
    private final CampaignRepository campaignRepository;

    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public Mono<Campaign> createCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    public Mono<Campaign> getCampaignById(Long id) {
        return campaignRepository.findById(id);
    }

    public Flux<Campaign> getAllCampaigns() {

        return campaignRepository.findAll().delayElements(Duration.ofSeconds(2));
    }
}
