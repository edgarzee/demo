package com.example.demo.balance.service;

import com.example.demo.balance.entity.Balance;
import com.example.demo.balance.repository.BalanceRepository;
import com.example.demo.group.entity.Group;
import com.example.demo.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceService {

    @Autowired
    private BalanceRepository balanceRepository;

    public List<Balance> getBalancesByGroup(User debtor, Group group) {
        return balanceRepository.findAllByDebtorAndGroup(debtor, group);
    }
}
