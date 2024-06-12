package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingDto;
import org.springframework.stereotype.Component;

/**
 * Mapper do konwersji pomiędzy encjami Training a obiektami TrainingDto.
 */
@Component
public class TrainingMapper {

    /**
     * Konwertuje encję Training na TrainingDto.
     *
     * @param training encja treningu
     * @return TrainingDto reprezentujący podaną encję treningu
     */
    public TrainingDto toDto(Training training) {
        TrainingDto dto = new TrainingDto();
        dto.setId(training.getId());
        dto.setUser(training.getUser());
        dto.setStartTime(training.getStartTime());
        dto.setEndTime(training.getEndTime());
        dto.setActivityType(training.getActivityType());
        dto.setDistance(training.getDistance());
        dto.setAverageSpeed(training.getAverageSpeed());
        return dto;
    }

    /**
     * Konwertuje TrainingDto na encję Training.
     *
     * @param trainingDto obiekt DTO treningu
     * @return encja Training reprezentująca podane TrainingDto
     */
    public Training toEntity(TrainingDto trainingDto) {
        Training training = new Training(
                trainingDto.getUser(),
                trainingDto.getStartTime(),
                trainingDto.getEndTime(),
                trainingDto.getActivityType(),
                trainingDto.getDistance(),
                trainingDto.getAverageSpeed());
        return training;
    }
}