package com.beads.email.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexey.dranchuk on 26/1/15.
 *
 */
public class Batch {

    private List<Integer> ids;

    public Batch(List<Integer> ids) {
        this.ids = new ArrayList<>(ids);
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "ids=" + ids +
                '}';
    }
}
