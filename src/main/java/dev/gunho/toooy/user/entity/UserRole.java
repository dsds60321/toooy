package dev.gunho.toooy.user.entity;

import lombok.Getter;

@Getter
public enum UserRole {

    ROLE_DEFAULT("DEFAULT");

    private final String value;

    UserRole(String value) {
        this.value = value;
    }

}
