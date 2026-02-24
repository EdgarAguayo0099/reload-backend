package com.example.reload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; // ❗ ESTE IMPORT FALTABA

@SpringBootApplication
public class ReloadApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReloadApplication.class, args);
    }
}
