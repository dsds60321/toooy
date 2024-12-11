package dev.gunho.toooy.appointment.constant;

import lombok.Getter;

@Getter
public enum Status {

    CLOSE("CLOSE"),
    PENDING("PENDING"),
    ONGOING("ONGOING"),;

    private final String value;

    Status(String value) {
        this.value = value;
    }

}
