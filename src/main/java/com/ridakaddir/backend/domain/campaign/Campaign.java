package com.ridakaddir.backend.domain.campaign;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Campaign {
    private BudgetValueObject budget;
    private StartDateValueObject startDate;
    private EndDateValueObject endDate;
    private RewardPercentValueObject reward;

    public Integer calculateReward(Transaction transaction) throws InvalidTransactionDateException {
        if (transaction.amount() > budget.value()) {
            return budget.value();
        }
        if (transaction.date().isBefore(startDate.date()) || transaction.date().isAfter(endDate.date())) {
            throw new InvalidTransactionDateException("Transaction date is not within the campaign date range.");
        }
        return (int) (transaction.amount() * this.reward.value());
    }

}
