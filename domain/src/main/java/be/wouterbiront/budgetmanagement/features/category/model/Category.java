package be.wouterbiront.budgetmanagement.features.category.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Category {
    private final String id;
    private String name;
    private String description;

    @Builder
    private Category(String id, String name, String description) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id is required");

        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void changeName(String newName) {
        if (newName == null || newName.isBlank()) throw new IllegalArgumentException("name is required");

        this.name = newName;
    }

    public void changeDescription(String newDescription) {
        if (newDescription == null || newDescription.isBlank()) throw new IllegalArgumentException("description is required");

        this.description = newDescription;
    }
}
