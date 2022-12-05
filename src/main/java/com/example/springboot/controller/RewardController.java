package com.example.springboot.controller;

import com.example.springboot.model.RewardResponse;
import com.example.springboot.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Month;
import java.util.Map;

@RestController
public class RewardController {

    @Autowired
    RewardService rewardService;

    @GetMapping("/reward/{id}")
    public RewardResponse calculateRewards(@PathVariable("id") int userId) {
        Map<Month, Integer> points = rewardService.calculateRewards(userId);
        RewardResponse rewardResponse = new RewardResponse();
        rewardResponse.setRewardPoints(points);
        rewardResponse.setCustomerId(userId);

        return rewardResponse;

    }
}