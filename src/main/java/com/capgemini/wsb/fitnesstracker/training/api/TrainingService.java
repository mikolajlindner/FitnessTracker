package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Interfejs (API) do modyfikacji operacji na encjach {@link Training} za pośrednictwem API.
 * Implementujące klasy są odpowiedzialne za wykonywanie zmian w ramach transakcji bazodanowej,
 * czy to poprzez kontynuowanie istniejącej transakcji, czy tworzenie nowej, jeśli to konieczne.
 */
public interface TrainingService {

    /**
     * Pobiera wszystkie treningi.
     *
     * @return lista wszystkich TrainingDto
     */
    List<TrainingDto> getAllTrainings();

    /**
     * Pobiera treningi dla określonego użytkownika.
     *
     * @param userId ID użytkownika
     * @return lista TrainingDto dla określonego użytkownika
     */
    List<TrainingDto> getTrainingsByUserId(Long userId);

    /**
     * Pobiera zakończone treningi po określonej dacie.
     *
     * @param date data po której treningi są uznawane za zakończone
     * @return lista zakończonych TrainingDto po określonej dacie
     */
    List<TrainingDto> getFinishedTrainingsAfterDate(Date date);

    /**
     * Pobiera treningi według określonego typu aktywności.
     *
     * @param activityType typ aktywności do filtrowania treningów
     * @return lista TrainingDto dla określonego typu aktywności
     */
    List<TrainingDto> getTrainingsByActivityType(ActivityType activityType);

    /**
     * Tworzy nowy trening.
     *
     * @param trainingDto dane treningu w formie obiektu DTO
     * @return utworzony TrainingDto
     */
    TrainingDto createTraining(TrainingDto trainingDto);

    /**
     * Aktualizuje istniejący trening.
     *
     * @param id ID treningu do aktualizacji
     * @param trainingDto dane treningu w formie obiektu DTO z zaktualizowanymi szczegółami
     * @return zaktualizowany TrainingDto
     */
    TrainingDto updateTraining(Long id, TrainingDto trainingDto);

    /**
     * Usuwa trening.
     *
     * @param id ID treningu do usunięcia
     */
    void deleteTraining(Long id);

    /**
     * Pobiera wszystkie treningi dla użytkownika.
     *
     * @param userId ID użytkownika
     * @return lista TrainingDto dla określonego użytkownika
     */
    List<TrainingDto> getAllTrainingsForUser(Long userId);

    /**
     * Pobiera wszystkie zakończone treningi po określonej dacie.
     *
     * @param afterTime data po której treningi są uznawane za zakończone
     * @return lista zakończonych TrainingDto po określonej dacie
     */
    List<TrainingDto> getAllFinishedTrainingsAfter(LocalDate afterTime);

    /**
     * Pobiera wszystkie treningi według określonego typu aktywności.
     *
     * @param activityType typ aktywności do filtrowania treningów
     * @return lista TrainingDto dla określonego typu aktywności
     */
    List<TrainingDto> getAllTrainingsByActivityType(ActivityType activityType);
}