package com.beads.model.domain;

import com.beads.model.ComboBoxCaption;
import com.beads.model.util.NullRepresentor;
import java.io.Serializable;

/**
 * Created by alexey.dranchuk on 29.09.14.
 *
 */

public enum OrderStatus implements Serializable, ComboBoxCaption {

    PENDING("PENDING"),
    ERROR("ERROR"),
    COMPLETE("COMPLETE");

    private String dbValue;

    OrderStatus(String pending) {
        dbValue = pending;
    }

    public String getDbValue() {
        return dbValue;
    }

    @Override
    public String getComboBoxCaption() {
        return NullRepresentor.getStringValue(dbValue);
    }
}
