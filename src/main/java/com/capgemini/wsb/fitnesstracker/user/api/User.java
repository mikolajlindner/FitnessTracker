package com.capgemini.wsb.fitnesstracker.user.api;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Encja reprezentująca użytkownika w systemie.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Domyślny konstruktor.
     */
    public User() {}

    /**
     * Tworzy nowego użytkownika z podanymi danymi.
     *
     * @param firstName imię użytkownika
     * @param lastName  nazwisko użytkownika
     * @param birthdate data urodzenia użytkownika
     * @param email     adres email użytkownika
     */
    public User(final String firstName, final String lastName, final LocalDate birthdate, final String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.email = email;
    }

    /**
     * Zwraca identyfikator użytkownika.
     *
     * @return identyfikator użytkownika
     */
    public Long getId() {
        return id;
    }

    /**
     * Ustawia identyfikator użytkownika.
     *
     * @param id nowy identyfikator użytkownika
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Zwraca imię użytkownika.
     *
     * @return imię użytkownika
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Ustawia imię użytkownika.
     *
     * @param firstName nowe imię użytkownika
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Zwraca nazwisko użytkownika.
     *
     * @return nazwisko użytkownika
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Ustawia nazwisko użytkownika.
     *
     * @param lastName nowe nazwisko użytkownika
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Zwraca datę urodzenia użytkownika.
     *
     * @return data urodzenia użytkownika
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * Ustawia datę urodzenia użytkownika.
     *
     * @param birthdate nowa data urodzenia użytkownika
     */
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Zwraca adres email użytkownika.
     *
     * @return adres email użytkownika
     */
    public String getEmail() {
        return email;
    }

    /**
     * Ustawia adres email użytkownika.
     *
     * @param email nowy adres email użytkownika
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Tworzy nowy obiekt Builder do budowania instancji User.
     *
     * @return nowy Builder dla klasy User
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Klasa Builder do tworzenia instancji User.
     */
    public static class Builder {
        private String firstName;
        private String lastName;
        private LocalDate birthdate;
        private String email;

        /**
         * Ustawia imię dla nowego użytkownika.
         *
         * @param firstName imię do ustawienia
         * @return bieżąca instancja Buildera
         */
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        /**
         * Ustawia nazwisko dla nowego użytkownika.
         *
         * @param lastName nazwisko do ustawienia
         * @return bieżąca instancja Buildera
         */
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        /**
         * Ustawia datę urodzenia dla nowego użytkownika.
         *
         * @param birthdate data urodzenia do ustawienia
         * @return bieżąca instancja Buildera
         */
        public Builder birthdate(LocalDate birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        /**
         * Ustawia adres email dla nowego użytkownika.
         *
         * @param email adres email do ustawienia
         * @return bieżąca instancja Buildera
         */
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        /**
         * Buduje i zwraca nową instancję User.
         *
         * @return nowo utworzona instancja User
         */
        public User build() {
            return new User(firstName, lastName, birthdate, email);
        }
    }
}