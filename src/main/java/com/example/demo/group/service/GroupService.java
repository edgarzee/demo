package com.example.demo.group.service;

import com.example.demo.group.entity.Group;
import com.example.demo.group.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public void saveGroup(Group group){
        groupRepository.save(group);
    }

    public List<Group> getAllGroups(){
        return groupRepository.findAll();
    }
}
