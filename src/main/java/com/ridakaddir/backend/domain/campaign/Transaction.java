package com.ridakaddir.backend.domain.campaign;

import java.time.LocalDateTime;

public abstract class Transaction {
    private final float amount;
    private final LocalDateTime date;

    public Transaction(float amount, LocalDateTime date) {
        this.amount = amount;
        this.date = date;
    }

    public float amount() {
        return amount;
    }

    public LocalDateTime date() {
        return date;
    }
}
