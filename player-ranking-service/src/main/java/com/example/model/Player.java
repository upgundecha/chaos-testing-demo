package com.example.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Data
@Entity
public class Player {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer playerId;
    private String name;
    private String country;
    private Integer position;
    private Integer rating;

}
