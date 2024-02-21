package com.ridakaddir.backend.domain.campaign;

public class InvalidTransactionDateException extends Throwable {
    public InvalidTransactionDateException(String message) {
        super(message);
    }

}
