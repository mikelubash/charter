package com.example.springboot.repository;

import com.example.springboot.model.Transactions;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RewardRepository extends CrudRepository<Transactions, Integer>
{
    List<Transactions> findByCustomerId(Integer id);
}
