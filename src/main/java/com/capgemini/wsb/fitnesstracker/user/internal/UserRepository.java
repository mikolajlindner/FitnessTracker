package com.capgemini.wsb.fitnesstracker.user.internal;

import com.capgemini.wsb.fitnesstracker.user.api.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repozytorium do zarządzania encjami User.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Znajduje użytkowników na podstawie adresu e-mail, ignorując wielkość liter.
     *
     * @param email adres e-mail do wyszukania
     * @return lista pasujących użytkowników
     */
    List<User> findByEmailContainingIgnoreCase(String email);

    /**
     * Znajduje użytkowników, których data urodzenia jest wcześniejsza niż określona data.
     *
     * @param date data do porównania
     * @return lista pasujących użytkowników
     */
    List<User> findByBirthdateBefore(LocalDate date);
}