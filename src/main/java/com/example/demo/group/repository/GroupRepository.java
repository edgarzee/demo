package com.example.demo.group.repository;

import com.example.demo.group.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findAllByGroupId(Long groupId);
}
