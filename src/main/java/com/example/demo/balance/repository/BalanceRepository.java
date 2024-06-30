package com.example.demo.balance.repository;

import com.example.demo.balance.entity.Balance;
import com.example.demo.group.entity.Group;
import com.example.demo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BalanceRepository extends JpaRepository<Balance, Long> {
    List<Balance> findAllByDebtorAndGroup(User debtor, Group group);
    List<Balance> findAllByCreditorAndGroup(User creditor, Group group);
}
