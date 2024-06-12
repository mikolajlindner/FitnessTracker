package com.capgemini.wsb.fitnesstracker.training.internal;

/**
 * Enum reprezentujący typy aktywności.
 */
public enum ActivityType {

    RUNNING("Running"),
    CYCLING("Cycling"),
    WALKING("Walking"),
    SWIMMING("Swimming"),
    TENNIS("Tennis");

    private final String displayName;

    /**
     * Konstruktor typu wyliczeniowego ActivityType.
     *
     * @param displayName wyświetlana nazwa typu aktywności
     */
    ActivityType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Pobiera wyświetlaną nazwę typu aktywności.
     *
     * @return wyświetlana nazwa typu aktywności
     */
    public String getDisplayName() {
        return displayName;
    }

}