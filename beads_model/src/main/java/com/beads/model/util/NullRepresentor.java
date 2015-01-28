package com.beads.model.util;

/**
 * Created by alexey.dranchuk on 28/1/15.
 *
 */
public class NullRepresentor {


    public static String getStringValue(Object obj) {
        return obj != null ? obj.toString() : "";
    }
}
