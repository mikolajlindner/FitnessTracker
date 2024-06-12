package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import jakarta.persistence.*;

import java.util.Date;

/**
 * Encja reprezentująca trening.
 */
@Entity
@Table(name = "trainings")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "start_time", nullable = false)
    private Date startTime;

    @Column(name = "end_time", nullable = false)
    private Date endTime;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "activity_type", nullable = false)
    private ActivityType activityType;

    @Column(name = "distance")
    private double distance;

    @Column(name = "average_speed")
    private double averageSpeed;

    /**
     * Domyślny konstruktor.
     */
    public Training() {}

    /**
     * Konstruktor tworzący nowy trening.
     *
     * @param user          użytkownik powiązany z treningiem
     * @param startTime     czas rozpoczęcia treningu
     * @param endTime       czas zakończenia treningu
     * @param activityType  typ aktywności
     * @param distance      dystans pokonany podczas treningu
     * @param averageSpeed  średnia prędkość podczas treningu
     */
    public Training(
            final User user,
            final Date startTime,
            final Date endTime,
            final ActivityType activityType,
            final double distance,
            final double averageSpeed) {
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activityType = activityType;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
    }

    /**
     * Zwraca identyfikator treningu.
     *
     * @return identyfikator treningu
     */
    public Long getId() {
        return id;
    }

    /**
     * Zwraca użytkownika powiązanego z treningiem.
     *
     * @return użytkownik powiązany z treningiem
     */
    public User getUser() {
        return user;
    }

    /**
     * Ustawia użytkownika powiązanego z treningiem.
     *
     * @param user użytkownik powiązany z treningiem
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Zwraca czas rozpoczęcia treningu.
     *
     * @return czas rozpoczęcia treningu
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Ustawia czas rozpoczęcia treningu.
     *
     * @param startTime czas rozpoczęcia treningu
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * Zwraca czas zakończenia treningu.
     *
     * @return czas zakończenia treningu
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * Ustawia czas zakończenia treningu.
     *
     * @param endTime czas zakończenia treningu
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * Zwraca typ aktywności.
     *
     * @return typ aktywności
     */
    public ActivityType getActivityType() {
        return activityType;
    }

    /**
     * Ustawia typ aktywności.
     *
     * @param activityType typ aktywności
     */
    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    /**
     * Zwraca dystans pokonany podczas treningu.
     *
     * @return dystans pokonany podczas treningu
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Ustawia dystans pokonany podczas treningu.
     *
     * @param distance dystans pokonany podczas treningu
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * Zwraca średnią prędkość podczas treningu.
     *
     * @return średnia prędkość podczas treningu
     */
    public double getAverageSpeed() {
        return averageSpeed;
    }

    /**
     * Ustawia średnią prędkość podczas treningu.
     *
     * @param averageSpeed średnia prędkość podczas treningu
     */
    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }
}