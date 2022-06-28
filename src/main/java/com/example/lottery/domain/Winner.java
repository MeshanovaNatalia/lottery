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
public class Winner {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    protected Long id;

    @NonNull
    private String name;

    @NonNull
    private Integer age;

    @NonNull
    private String city;

    //Сумма выигрыша
    @NonNull
    private Integer winningAmount;

    public Winner(@NonNull String name, @NonNull Integer age, @NonNull String city, Integer winningAmount) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.winningAmount = winningAmount;
    }
}
