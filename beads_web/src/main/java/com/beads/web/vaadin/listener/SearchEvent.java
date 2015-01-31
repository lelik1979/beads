package com.beads.web.vaadin.listener;

import com.github.wolfie.blackboard.Event;

/**
 * Created by alexey.dranchuk on 9/1/15.
 *
 */
public class SearchEvent implements Event {

    private String searchString;

    public SearchEvent(String searchString) {
        this.searchString = searchString;
    }

    public String getSearchString() {
        return searchString;
    }
}
