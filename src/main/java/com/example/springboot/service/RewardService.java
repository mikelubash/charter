package com.example.springboot.service;

import com.example.springboot.model.Transactions;
import com.example.springboot.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Month;
import java.util.*;

@Service
public class RewardService {
    @Autowired
    RewardRepository rewardRepository;
    public Map<Month, Integer> calculateRewards(int userId) {
        //call repo

        List<Transactions> transactionsList = rewardRepository.findByCustomerId(userId);
        //calc rewards
        if (transactionsList.size() == 0) {
            return null;
        }
        Date today = new Date(System.currentTimeMillis());
        Month currMonth = today.toLocalDate().getMonth();
        Month lastMonth = today.toLocalDate().getMonth().minus(1);
        Month TwoAgoMonth = today.toLocalDate().getMonth().minus(2);
        HashMap<Month, Integer> pointMonths =  new HashMap();
        pointMonths.put(currMonth,0);
        pointMonths.put(lastMonth,0);
        pointMonths.put(TwoAgoMonth, 0);


        for (Transactions t: transactionsList) {
            Integer amt = t.getAmount();
            Integer rewards = 0;
            Month month = t.getCreatedAt().getMonth();
            if (amt > 50 && pointMonths.keySet().contains(month)) {
                if (amt > 100) {
                    rewards += (amt - 100) *2 + 50;
                } else {
                    rewards += (amt - 50);
                }
                pointMonths.put(month, pointMonths.get(month) + rewards);
            }
        }

        return pointMonths;
    }
}
