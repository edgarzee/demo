package com.example.demo.group.controller;

import com.example.demo.group.dto.GroupDTO;
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
    public ResponseEntity<Group> createGroup(@RequestBody Group groupObj){
        groupService.saveGroup(groupObj);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = {"/getGroups", "/{groupId}"})
    public List<GroupDTO> getGroups(@PathVariable(required = false) Long groupId){
        return groupService.getGroupDetails(groupId);
    }

    @DeleteMapping("/delete/{groupId}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long groupId){
        groupService.deleteGroup(groupId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{groupId}/user/{userId}")
    public Group assignUserToGroup(@PathVariable Long groupId, @PathVariable Long userId){
        return groupService.assignUserToGroup(groupId, userId);
    }
}
