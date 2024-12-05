package dev.gunho.toooy.user.entity;

import lombok.Getter;

@Getter
public enum UserRole {

    DEFAULT("DEFAULT");

    private final String value;

    UserRole(String value) {
        this.value = value;
    }

}
