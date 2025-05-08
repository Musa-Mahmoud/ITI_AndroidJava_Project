package com.iti.oishi.model.dto;

import java.util.List;

public class CategoryResponse {
    private final List<Category> categories;

    public CategoryResponse(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
