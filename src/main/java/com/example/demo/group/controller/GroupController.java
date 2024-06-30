package com.example.demo.group.controller;

import com.example.demo.group.entity.Group;
import com.example.demo.group.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    public ResponseEntity<Group> saveGroup(@RequestBody Group group){
        groupService.saveGroup(group);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Group> getAllGroups(){
        return groupService.getAllGroups();
    }
}
