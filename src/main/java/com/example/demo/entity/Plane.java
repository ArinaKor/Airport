package com.example.demo.entity;

import com.example.demo.observer.Observed;
import com.example.demo.observer.Observer;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name="plane")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Plane  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_flight;
    @Column(name="date_flight")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date date_flight;
    @Column(name="time_flight")
    private Time time_flight;
    @Column(name="airport1")
    private String airport1;
    @Column(name="distance")
    private int distance;
    @Column(name="airport2")
    private String airport2;
    @Column(name="date2")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date date2;
    @Column(name="time2")
    private Time time2;
    @Column(name="count_transfer")
    private int count_transfer;
    @Column(name="type_ticket")
    private String type_ticket;
    @Column(name="price_ticket")
    private float price_ticket;
    @Column(name="company")
    private String company;
    @Column(name="max_weight")
    private int max_weight;


}
