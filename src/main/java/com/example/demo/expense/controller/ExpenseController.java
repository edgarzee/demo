package com.example.demo.expense.controller;

import com.example.demo.expense.entity.Expense;
import com.example.demo.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<Expense> saveExpense(@RequestBody Expense expense){
        expenseService.saveExpense(expense);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Expense> getAllExpenses(){
        return expenseService.getAllExpenses();
    }
}
