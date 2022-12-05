package com.example.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;


@Entity
@Data
public class Transactions {
    @Id
    private int id;

    @Column
    private int customerId;

   @Column
   private int amount;

   @Column
    private LocalDate createdAt;

}
