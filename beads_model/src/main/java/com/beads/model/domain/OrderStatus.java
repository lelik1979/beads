package com.beads.model.domain;

/**
 * Created by alexey.dranchuk on 29.09.14.
 *
 */

public enum OrderStatus {

    PENDING("PENDING"),
    COMPLETE("COMPLETE");

    private String dbValue;

    OrderStatus(String pending) {
        dbValue = pending;
    }

    public String getDbValue() {
        return dbValue;
    }
}
