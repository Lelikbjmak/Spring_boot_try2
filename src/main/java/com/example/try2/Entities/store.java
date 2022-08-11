package com.example.try2.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NonNull
    private String model;

    @NonNull
    private String Country;

    @NonNull
    private double price;

    store(){}

    @Override
    public String toString() {
        return "Model: " + this.getModel() + ", price: " + this.getPrice();
    }

}
