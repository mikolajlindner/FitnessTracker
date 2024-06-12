package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.exception.api.NotFoundException;

/**
 * Wyjątek wskazujący, że nie znaleziono {@link Training}.
 */
@SuppressWarnings("squid:S110")
public class TrainingNotFoundException extends NotFoundException {

    /**
     * Prywatny konstruktor przyjmujący wiadomość o błędzie.
     *
     * @param message wiadomość o błędzie
     */
    private TrainingNotFoundException(String message) {
        super(message);
    }

    /**
     * Konstruktor tworzący wyjątek z wiadomością wskazującą, że trening o podanym ID nie został znaleziony.
     *
     * @param id ID treningu, który nie został znaleziony
     */
    public TrainingNotFoundException(Long id) {
        this("Training with ID=%s was not found".formatted(id));
    }
}