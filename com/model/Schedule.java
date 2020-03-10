package com.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "train_id")
    @NotBlank(message = "Numbers train must be filled in")
    private Integer trainId;

    @Column(name = "station_id")
    @NotBlank(message = "station must be filled in")
    private Integer stationId;

    @Column(name = "arrival_time")
    @DateTimeFormat(pattern = "yyyy-dd-MM  HH:mm")
    @NotBlank(message = "Arrival time  must be filled in")
    private LocalDateTime arrivalTime;


    @Column(name = "departure_time")
    @DateTimeFormat(pattern = "yyyy-dd-MM  HH:mm")
    @NotBlank(message = "Departure time  must be filled in")
    private LocalDateTime departureTime;

    @Transient
    private String stationName;

    public Schedule() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", trainId=" + trainId +
                ", stationId=" + stationId +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", stationName='" + stationName + '\'' +
                '}';
    }
}
