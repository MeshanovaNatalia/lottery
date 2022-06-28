package com.example.lottery.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
public class Participant {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    protected Long id;

    @NonNull
    private String name;

    @NonNull
    private Integer age;

    @NonNull
    private String city;

    public Participant(@NonNull String name, @NonNull Integer age, @NonNull String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }
}
