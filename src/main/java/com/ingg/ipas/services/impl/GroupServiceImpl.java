package com.ingg.ipas.services.impl;

import com.ingg.ipas.models.Group;
import com.ingg.ipas.payload.request.GroupRequest;
import com.ingg.ipas.repository.GroupRepo;
import com.ingg.ipas.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepo groupRepo;

    @Override
    public List<Group> getAllGroups() {
        return groupRepo.findAll();
    }

    @Override
    public void insertGroup(GroupRequest groupRequest) {
        Group group = new Group();
        group.setName(groupRequest.getGroupName());
        groupRepo.save(group);
    }

    @Override
    public void updateGroup(GroupRequest groupRequest) {
        Optional<Group> optionalGroup = groupRepo.findById(groupRequest.getId());

        if (optionalGroup.isPresent()) {
            Group group = optionalGroup.get();
            group.setName(groupRequest.getGroupName());
            groupRepo.save(group);
        } else {
            throw new EntityNotFoundException("Group not found with id: " + groupRequest.getId());
        }
    }
}
