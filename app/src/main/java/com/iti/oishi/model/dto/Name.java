package com.iti.oishi.model.dto;

import com.google.gson.annotations.SerializedName;

public class Name {
    @SerializedName(value = "strArea", alternate = {"strCategory"})
    private String name;

    public String getName() {
        return name;
    }
}
