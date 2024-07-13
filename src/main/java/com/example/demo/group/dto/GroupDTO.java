package com.example.demo.group.dto;

import com.example.demo.user.dto.UserDTO;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO {
    private Long groupId;
    private String groupName;
    private Set<UserDTO> assignedUsers;
}
