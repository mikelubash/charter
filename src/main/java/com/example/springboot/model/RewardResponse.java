package com.example.springboot.model;

import lombok.Data;

import java.time.Month;
import java.util.Map;
import java.util.Set;

@Data
public class RewardResponse {
    private int customerId;
    private Map<Month, Integer> rewardPoints;
}
