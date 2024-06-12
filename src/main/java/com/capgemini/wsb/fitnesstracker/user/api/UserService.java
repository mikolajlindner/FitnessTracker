package com.capgemini.wsb.fitnesstracker.user.api;

import java.util.List;

/**
 * Interfejs (API) do operacji modyfikujących na encjach {@link User} poprzez API.
 * Implementujące klasy są odpowiedzialne za wykonywanie zmian w ramach transakcji bazy danych,
 * kontynuując istniejącą transakcję lub tworząc nową, jeśli jest to wymagane.
 */
public interface UserService {

    /**
     * Tworzy nowego użytkownika w systemie.
     *
     * @param userDto obiekt transferu danych zawierający szczegóły użytkownika
     * @return utworzony UserDto
     */
    UserDto createUser(UserDto userDto);

    /**
     * Aktualizuje istniejącego użytkownika w systemie.
     *
     * @param id      identyfikator użytkownika do aktualizacji
     * @param userDto obiekt transferu danych zawierający zaktualizowane szczegóły użytkownika
     * @return zaktualizowany UserDto
     */
    UserDto updateUser(Long id, UserDto userDto);

    /**
     * Usuwa użytkownika z systemu.
     *
     * @param id identyfikator użytkownika do usunięcia
     */
    void deleteUser(Long id);

    /**
     * Pobiera wszystkich użytkowników z systemu.
     *
     * @return lista UserDto reprezentująca wszystkich użytkowników
     */
    List<UserDto> findAllUsers();

    /**
     * Pobiera użytkownika na podstawie jego identyfikatora.
     *
     * @param id identyfikator użytkownika do pobrania
     * @return UserDto reprezentujący użytkownika
     */
    UserDto findUserById(Long id);

    /**
     * Wyszukuje użytkowników na podstawie adresu email, ignorując wielkość liter.
     *
     * @param email adres email do wyszukania
     * @return lista UserDto reprezentująca pasujących użytkowników
     */
    List<UserDto> searchUsersByEmail(String email);

    /**
     * Pobiera użytkowników starszych niż określony wiek.
     *
     * @param age wiek do porównania
     * @return lista UserDto reprezentująca pasujących użytkowników
     */
    List<UserDto> getUsersOlderThan(int age);
}