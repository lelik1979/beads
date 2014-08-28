package com.lena.restservice;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Administrator on 25.08.14.
 */
public class JsonObject {


    private final int id;
    private final String name;

    public JsonObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .toString();
    }
}
