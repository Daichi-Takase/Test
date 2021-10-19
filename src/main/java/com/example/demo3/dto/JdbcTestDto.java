package com.example.demo3.dto;

import java.time.LocalDateTime;

public class JdbcTestDto {
    private int id;
    private String name;
    private LocalDateTime timestamp;

    public JdbcTestDto(int id, String name, LocalDateTime timestamp) {
        this.id = id;
        this.name = name;
        this.timestamp = timestamp;
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }
    
    public String toString() {
        return "id: " + this.id + ", name: " + this.name + ", tamestamp: " + this.timestamp;
    }
}