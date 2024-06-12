package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingDto;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingNotFoundException;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingService;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserNotFoundException;
import com.capgemini.wsb.fitnesstracker.user.internal.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementacja serwisu do zarządzania treningami.
 */
@Service
public class TrainingServiceImpl implements TrainingService {

    private static final Logger log = LoggerFactory.getLogger(TrainingServiceImpl.class);

    private final TrainingRepository trainingRepository;
    private final UserRepository userRepository;
    private final TrainingMapper trainingMapper;

    public TrainingServiceImpl(TrainingRepository trainingRepository, UserRepository userRepository, TrainingMapper trainingMapper) {
        this.trainingRepository = trainingRepository;
        this.userRepository = userRepository;
        this.trainingMapper = trainingMapper;
    }

    /**
     * Pobiera wszystkie treningi.
     *
     * @return lista wszystkich treningów
     */
    @Override
    public List<TrainingDto> getAllTrainings() {
        log.info("Fetching all trainings");
        return trainingRepository.findAll().stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Pobiera treningi dla danego użytkownika na podstawie jego ID.
     *
     * @param userId ID użytkownika
     * @return lista treningów użytkownika
     */
    @Override
    public List<TrainingDto> getTrainingsByUserId(Long userId) {
        return List.of();
    }

    /**
     * Pobiera zakończone treningi po określonej dacie.
     *
     * @param date data, po której treningi są zakończone
     * @return lista zakończonych treningów po określonej dacie
     */
    @Override
    public List<TrainingDto> getFinishedTrainingsAfterDate(Date date) {
        return List.of();
    }

    /**
     * Pobiera treningi według typu aktywności.
     *
     * @param activityType typ aktywności
     * @return lista treningów dla danego typu aktywności
     */
    @Override
    public List<TrainingDto> getTrainingsByActivityType(ActivityType activityType) {
        return List.of();
    }

    /**
     * Pobiera wszystkie treningi dla danego użytkownika.
     *
     * @param userId ID użytkownika
     * @return lista treningów użytkownika
     */
    @Override
    public List<TrainingDto> getAllTrainingsForUser(Long userId) {
        log.info("Fetching trainings for user with ID={}", userId);
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        return trainingRepository.findByUserId(user.getId()).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Pobiera wszystkie zakończone treningi po określonej dacie.
     *
     * @param date data, po której treningi są zakończone
     * @return lista zakończonych treningów po określonej dacie
     */
    @Override
    public List<TrainingDto> getAllFinishedTrainingsAfter(LocalDate date) {
        log.info("Fetching all finished trainings after {}", date);
        return trainingRepository.findByEndTimeAfter(date.atStartOfDay()).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Pobiera wszystkie treningi według typu aktywności.
     *
     * @param activityType typ aktywności
     * @return lista treningów dla danego typu aktywności
     */
    @Override
    public List<TrainingDto> getAllTrainingsByActivityType(ActivityType activityType) {
        log.info("Fetching all trainings by activity type {}", activityType);
        return trainingRepository.findByActivityType(activityType).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Tworzy nowy trening.
     *
     * @param trainingDto dane treningu
     * @return utworzony trening
     */
    @Override
    public TrainingDto createTraining(TrainingDto trainingDto) {
        log.info("Creating training {}", trainingDto);
        User user = userRepository.findById(trainingDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException(trainingDto.getUserId()));
        Training training = trainingMapper.toEntity(trainingDto);
        training.setUser(user);
        training = trainingRepository.save(training);
        return trainingMapper.toDto(training);
    }

    /**
     * Aktualizuje istniejący trening.
     *
     * @param id         ID treningu do aktualizacji
     * @param trainingDto dane treningu do aktualizacji
     * @return zaktualizowany trening
     */
    @Override
    public TrainingDto updateTraining(Long id, TrainingDto trainingDto) {
        log.info("Updating training with ID={}", id);
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new TrainingNotFoundException(id));

        User user = userRepository.findById(trainingDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException(trainingDto.getUserId()));

        training.setUser(user);
        training.setStartTime(trainingDto.getStartTime());
        training.setEndTime(trainingDto.getEndTime());
        training.setActivityType(trainingDto.getActivityType());
        training.setDistance(trainingDto.getDistance());
        training.setAverageSpeed(trainingDto.getAverageSpeed());

        training = trainingRepository.save(training);
        return trainingMapper.toDto(training);
    }

    /**
     * Usuwa trening na podstawie ID.
     *
     * @param id ID treningu do usunięcia
     */
    @Override
    public void deleteTraining(Long id) {
        log.info("Deleting training with ID={}", id);
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new TrainingNotFoundException(id));
        trainingRepository.delete(training);
    }
}