package com.example.demo.group.service;

import com.example.demo.group.dto.GroupDTO;
import com.example.demo.group.entity.Group;
import com.example.demo.group.repository.GroupRepository;
import com.example.demo.user.dto.UserDTO;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    public void saveGroup(Group groupObj){
        groupRepository.save(groupObj);
    }

    public List<GroupDTO> getGroupDetails(Long groupId) {
        List<Group> groups;
        if (groupId != null) {
            groups = groupRepository.findAllByGroupId(groupId);
        } else {
            groups = groupRepository.findAll();
        }

        return groups.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private GroupDTO convertToDTO(Group group) {
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setGroupId(group.getGroupId());
        groupDTO.setGroupName(group.getGroupName());
        groupDTO.setAssignedUsers(group.getAssignedUsers().stream().map(this::convertToUserDTO).collect(Collectors.toSet()));
        return groupDTO;
    }

    private UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    public void deleteGroup(Long groupId){
        groupRepository.deleteById(groupId);
    }

    public Group assignUserToGroup(Long groupId, Long userId) {
        Group group = groupRepository.findById(groupId).get();
        User user = userRepository.findById(userId).get();
        group.getAssignedUsers().add(user);
        return groupRepository.save(group);
    }
}
