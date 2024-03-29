package com.ridakaddir.backend.application.usecase.campaign;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends ReactiveCrudRepository<Campaign, Long> {
}
