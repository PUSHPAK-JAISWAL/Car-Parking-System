package com.CarParkingSystemBackend.api.Entity;

public class ParkingSlot {
    private String slotName;
    private boolean isEmpty;

    // Default Constructor
    public ParkingSlot() {
    }

    // Parameterized Constructor
    public ParkingSlot(String slotName, boolean isEmpty) {
        this.slotName = slotName;
        this.isEmpty = isEmpty;
    }

    // Getters and Setters
    public String getSlotName() {
        return slotName;
    }

    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    // Optional: toString method for debugging
    @Override
    public String toString() {
        return "ParkingSlot{" +
                "slotName='" + slotName + '\'' +
                ", isEmpty=" + isEmpty +
                '}';
    }
}
