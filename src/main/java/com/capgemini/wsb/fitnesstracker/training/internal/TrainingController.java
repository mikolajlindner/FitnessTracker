package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.TrainingDto;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Kontroler REST do zarządzania treningami.
 */
@RestController
@RequestMapping("/v1/trainings")
public class TrainingController {

    private final TrainingService trainingService;

    /**
     * Konstruktor kontrolera przyjmujący serwis treningowy.
     *
     * @param trainingService serwis treningowy
     */
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    /**
     * Pobiera wszystkie treningi.
     *
     * @return lista wszystkich treningów w formie DTO
     */
    @GetMapping
    public List<TrainingDto> getAllTrainings() {
        return trainingService.getAllTrainings();
    }

    /**
     * Pobiera wszystkie treningi dla danego użytkownika.
     *
     * @param userId ID użytkownika
     * @return lista treningów użytkownika w formie DTO
     */
    @GetMapping("/user/{userId}")
    public List<TrainingDto> getAllTrainingsForUser(@PathVariable Long userId) {
        return trainingService.getAllTrainingsForUser(userId);
    }

    /**
     * Pobiera wszystkie zakończone treningi po określonym czasie.
     *
     * @param afterTime data po której treningi są uznawane za zakończone
     * @return lista zakończonych treningów w formie DTO
     */
    @GetMapping("/finished/{afterTime}")
    public List<TrainingDto> getAllFinishedTrainingsAfter(@PathVariable LocalDate afterTime) {
        return trainingService.getAllFinishedTrainingsAfter(afterTime);
    }

    /**
     * Pobiera wszystkie treningi według typu aktywności.
     *
     * @param activityType typ aktywności
     * @return lista treningów według typu aktywności w formie DTO
     */
    @GetMapping("/activityType")
    public List<TrainingDto> getAllTrainingsByActivityType(@RequestParam ActivityType activityType) {
        return trainingService.getAllTrainingsByActivityType(activityType);
    }

    /**
     * Tworzy nowy trening.
     *
     * @param trainingDto dane nowego treningu
     * @return utworzony trening w formie DTO
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainingDto createTraining(@RequestBody TrainingDto trainingDto) {
        return trainingService.createTraining(trainingDto);
    }

    /**
     * Aktualizuje istniejący trening.
     *
     * @param id          ID treningu do aktualizacji
     * @param trainingDto zaktualizowane dane treningu
     * @return zaktualizowany trening w formie DTO
     */
    @PutMapping("/{id}")
    public TrainingDto updateTraining(@PathVariable Long id, @RequestBody TrainingDto trainingDto) {
        return trainingService.updateTraining(id, trainingDto);
    }
}