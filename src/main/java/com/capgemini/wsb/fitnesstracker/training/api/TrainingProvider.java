package com.capgemini.wsb.fitnesstracker.training.api;

import java.util.List;
import java.util.Optional;

/**
 * Interfejs dla dostawcy treningów.
 */
public interface TrainingProvider {

    /**
     * Pobiera trening na podstawie jego ID.
     * Jeśli trening o podanym ID nie zostanie znaleziony, zwrócony zostanie {@link Optional#empty()}.
     *
     * @param trainingId ID treningu do wyszukania
     * @return {@link Optional} zawierający znaleziony trening lub {@link Optional#empty()} jeśli nie znaleziono
     */
    Optional<Training> getTraining(Long trainingId);

    /**
     * Pobiera wszystkie treningi.
     *
     * @return lista wszystkich treningów
     */
    List<Training> findAllTrainings();

    /**
     * Pobiera treningi na podstawie ID użytkownika.
     *
     * @param userId ID użytkownika
     * @return lista treningów powiązanych z danym użytkownikiem
     */
    List<Training> findTrainingsByUserId(Long userId);

    /**
     * Pobiera zakończone treningi po określonym czasie.
     *
     * @param afterTime czas po którym treningi są uznawane za zakończone
     * @return lista zakończonych treningów po określonym czasie
     */
    List<Training> findFinishedTrainingsAfter(String afterTime);

    /**
     * Pobiera treningi na podstawie typu aktywności.
     *
     * @param activityType typ aktywności treningu
     * @return lista treningów powiązanych z danym typem aktywności
     */
    List<Training> findTrainingsByActivityType(String activityType);

    /**
     * Zapisuje trening.
     *
     * @param training trening do zapisania
     * @return zapisany trening
     */
    Training saveTraining(Training training);

    /**
     * Aktualizuje trening na podstawie jego ID.
     *
     * @param trainingId ID treningu do aktualizacji
     * @param training   zaktualizowane dane treningu
     * @return zaktualizowany trening
     */
    Training updateTraining(Long trainingId, Training training);
}