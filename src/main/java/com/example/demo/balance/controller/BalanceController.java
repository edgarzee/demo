package com.example.demo.balance.controller;

import com.example.demo.balance.entity.Balance;
import com.example.demo.balance.service.BalanceService;
import com.example.demo.group.entity.Group;
import com.example.demo.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/balances")
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @GetMapping("/group/{groupId}/user/{userId}")
    public List<Balance> getBalancesByGroup(@PathVariable Long groupId, @PathVariable Long userId){
        User user = new User();
        user.setUserId(userId);
        Group group = new Group();
        group.setGroupId(groupId);
        return balanceService.getBalancesByGroup(user, group);
    }
}
