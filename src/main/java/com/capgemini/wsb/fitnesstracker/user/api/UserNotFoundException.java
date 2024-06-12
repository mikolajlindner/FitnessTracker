package com.capgemini.wsb.fitnesstracker.user.api;

import com.capgemini.wsb.fitnesstracker.exception.api.NotFoundException;

/**
 * Wyjątek wskazujący, że użytkownik {@link User} nie został znaleziony.
 */
@SuppressWarnings("squid:S110")
public class UserNotFoundException extends NotFoundException {

    /**
     * Prywatny konstruktor używany wewnętrznie.
     *
     * @param message komunikat błędu
     */
    private UserNotFoundException(String message) {
        super(message);
    }

    /**
     * Konstruktor tworzący wyjątek z podanym identyfikatorem użytkownika.
     *
     * @param id identyfikator użytkownika
     */
    public UserNotFoundException(Long id) {
        this("Użytkownik o ID=%s nie został znaleziony".formatted(id));
    }

}