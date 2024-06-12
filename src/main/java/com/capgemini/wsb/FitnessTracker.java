package com.capgemini.wsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Główna klasa aplikacji FitnessTracker.
 *
 */
@SpringBootApplication
public class FitnessTracker {

    /**
     * Główna metoda, która służy jako punkt wejścia dla aplikacji Spring Boot.
     *
     * @param args argumenty wiersza poleceń przekazane podczas uruchamiania aplikacji
     */
    public static void main(String[] args) {
        SpringApplication.run(FitnessTracker.class, args);
    }

}