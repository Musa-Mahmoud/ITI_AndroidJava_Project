package com.iti.oishi.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NameResponse {
    @SerializedName("meals")
    private final List<Name> nameList;

    public NameResponse(List<Name> nameList) {
        this.nameList = nameList;
    }

    public List<Name> getNameList() {
        return nameList;
    }
}
