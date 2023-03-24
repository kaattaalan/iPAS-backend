package com.ingg.ipas.services;

import com.ingg.ipas.models.Group;
import com.ingg.ipas.payload.request.GroupRequest;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();

    void insertGroup(GroupRequest groupRequest);

    void updateGroup(GroupRequest groupRequest);
}
