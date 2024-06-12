package com.capgemini.wsb.fitnesstracker.user.api;

/**
 * DTO reprezentujący uproszczone informacje o użytkowniku (tylko ID, imię i nazwisko).
 *
 * @param id        identyfikator użytkownika
 * @param firstName imię użytkownika
 * @param lastName  nazwisko użytkownika
 */
public record UserSimpleDto(Long id, String firstName, String lastName) {
}