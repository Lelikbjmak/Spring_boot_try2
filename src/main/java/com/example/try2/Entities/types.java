package com.example.try2.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

@Data
@Entity
public class types {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    private long id;


    private String string;


    @Nullable
    private double doubleval;


    @Nullable
    private int anInt;


    types(){}

    @JsonFormat(pattern = "dd.MM.yyyy", timezone = "Europe/Minsk")
    @Nullable
    private LocalDate date;

}
