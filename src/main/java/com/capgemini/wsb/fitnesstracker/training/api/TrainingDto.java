package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;
import com.capgemini.wsb.fitnesstracker.user.api.User;

import java.util.Date;

/**
 * Data Transfer Object (DTO) reprezentujący trening.
 */
public class TrainingDto {

    private Long id;
    private User user;
    private Long userId;
    private Date startTime;
    private Date endTime;
    private ActivityType activityType;
    private double distance;
    private double averageSpeed;

    /**
     * Domyślny konstruktor.
     */
    public TrainingDto() {
    }

    /**
     * Konstruktor tworzący TrainingDto z podanymi wartościami.
     *
     * @param id            ID treningu
     * @param user          Użytkownik powiązany z treningiem
     * @param userId        ID użytkownika powiązanego z treningiem
     * @param startTime     Czas rozpoczęcia treningu
     * @param endTime       Czas zakończenia treningu
     * @param activityType  Typ aktywności treningu
     * @param distance      Dystans treningu
     * @param averageSpeed  Średnia prędkość treningu
     */
    public TrainingDto(Long id, User user, Long userId, Date startTime, Date endTime, ActivityType activityType, double distance, double averageSpeed) {
        this.id = id;
        this.user = user;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activityType = activityType;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
    }

    /**
     * Pobiera ID treningu.
     *
     * @return ID treningu
     */
    public Long getId() {
        return id;
    }

    /**
     * Ustawia ID treningu.
     *
     * @param id nowe ID treningu
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Pobiera użytkownika powiązanego z treningiem.
     *
     * @return użytkownik powiązany z treningiem
     */
    public User getUser() {
        return user;
    }

    /**
     * Ustawia użytkownika powiązanego z treningiem.
     *
     * @param user nowy użytkownik powiązany z treningiem
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Pobiera ID użytkownika powiązanego z treningiem.
     *
     * @return ID użytkownika powiązanego z treningiem
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Ustawia ID użytkownika powiązanego z treningiem.
     *
     * @param userId nowe ID użytkownika powiązanego z treningiem
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Pobiera czas rozpoczęcia treningu.
     *
     * @return czas rozpoczęcia treningu
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Ustawia czas rozpoczęcia treningu.
     *
     * @param startTime nowy czas rozpoczęcia treningu
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * Pobiera czas zakończenia treningu.
     *
     * @return czas zakończenia treningu
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * Ustawia czas zakończenia treningu.
     *
     * @param endTime nowy czas zakończenia treningu
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * Pobiera typ aktywności treningu.
     *
     * @return typ aktywności treningu
     */
    public ActivityType getActivityType() {
        return activityType;
    }

    /**
     * Ustawia typ aktywności treningu.
     *
     * @param activityType nowy typ aktywności treningu
     */
    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    /**
     * Pobiera dystans treningu.
     *
     * @return dystans treningu
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Ustawia dystans treningu.
     *
     * @param distance nowy dystans treningu
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * Pobiera średnią prędkość treningu.
     *
     * @return średnia prędkość treningu
     */
    public double getAverageSpeed() {
        return averageSpeed;
    }

    /**
     * Ustawia średnią prędkość treningu.
     *
     * @param averageSpeed nowa średnia prędkość treningu
     */
    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }
}