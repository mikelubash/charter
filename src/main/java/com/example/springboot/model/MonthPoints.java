package com.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.Month;
import java.util.Date;

@Data
public class MonthPoints {
    private Month month;
    private Integer points;
}
