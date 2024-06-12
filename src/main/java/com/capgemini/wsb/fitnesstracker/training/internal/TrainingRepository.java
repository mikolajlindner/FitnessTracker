package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repozytorium do zarządzania encjami Training.
 */
@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    /**
     * Znajduje treningi dla danego użytkownika na podstawie jego ID.
     *
     * @param userId ID użytkownika
     * @return lista treningów użytkownika
     */
    List<Training> findByUserId(Long userId);

    /**
     * Znajduje treningi zakończone po podanym czasie.
     *
     * @param endTime czas, po którym treningi są zakończone
     * @return lista treningów zakończonych po podanym czasie
     */
    List<Training> findByEndTimeAfter(LocalDateTime endTime);

    /**
     * Znajduje treningi według typu aktywności.
     *
     * @param activityType typ aktywności
     * @return lista treningów dla danego typu aktywności
     */
    List<Training> findByActivityType(ActivityType activityType);
}