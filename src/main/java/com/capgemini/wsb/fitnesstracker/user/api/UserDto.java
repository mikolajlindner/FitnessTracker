package com.capgemini.wsb.fitnesstracker.user.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;

import java.time.LocalDate;

/**
 * Obiekt transferu danych (DTO) reprezentujący użytkownika.
 *
 * @param id        identyfikator użytkownika, może być null
 * @param firstName imię użytkownika
 * @param lastName  nazwisko użytkownika
 * @param birthdate data urodzenia użytkownika, sformatowana jako yyyy-MM-dd
 * @param email     adres email użytkownika
 */
public record UserDto(@Nullable Long id, String firstName, String lastName,
                      @JsonFormat(pattern = "yyyy-MM-dd") LocalDate birthdate,
                      String email) {
}