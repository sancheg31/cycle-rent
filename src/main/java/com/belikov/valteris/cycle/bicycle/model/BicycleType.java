package com.belikov.valteris.cycle.bicycle.model;

public enum BicycleType {
    ALL("All"),
    MOUNTAIN("Mountain"),
    CITY("City"),
    FOR_KIDS("For kids");

    private final String stringType;

    public String getStringType() {
        return stringType;
    }

    BicycleType(String stringType) {
        this.stringType = stringType;
    }
}
