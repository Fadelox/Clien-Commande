package org.example.food;

import org.example.food.entities.Client;
import org.example.food.repositories.ClientRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FoodApplication {

    public static void main(String[] args) {SpringApplication.run(FoodApplication.class, args);}



}
