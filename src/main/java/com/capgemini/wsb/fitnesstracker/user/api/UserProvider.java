package com.capgemini.wsb.fitnesstracker.user.api;

import java.util.List;
import java.util.Optional;

public interface UserProvider {

    /**
     * Pobiera użytkownika na podstawie jego identyfikatora.
     * Jeśli użytkownik o podanym identyfikatorze nie zostanie znaleziony, zostanie zwrócony {@link Optional#empty()}.
     *
     * @param userId identyfikator użytkownika do wyszukania
     * @return {@link Optional} zawierający znalezionego użytkownika lub {@link Optional#empty()} jeśli nie znaleziono
     */
    Optional<User> getUser(Long userId);

    /**
     * Pobiera użytkownika na podstawie jego adresu email.
     * Jeśli użytkownik o podanym adresie email nie zostanie znaleziony, zostanie zwrócony {@link Optional#empty()}.
     *
     * @param email adres email użytkownika do wyszukania
     * @return {@link Optional} zawierający znalezionego użytkownika lub {@link Optional#empty()} jeśli nie znaleziono
     */
    Optional<User> getUserByEmail(String email);

    /**
     * Pobiera wszystkich użytkowników.
     *
     * @return Lista wszystkich użytkowników
     */
    List<User> findAllUsers();
}