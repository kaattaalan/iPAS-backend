package com.ingg.ipas.controllers;

import com.ingg.ipas.models.Group;
import com.ingg.ipas.payload.request.GroupRequest;
import com.ingg.ipas.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/")
    public ResponseEntity<?> getAllGroups() {
        List<Group> groupList = groupService.getAllGroups();
        if (groupList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(groupList, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> insertGroup(@Valid @RequestBody GroupRequest groupRequest, @CurrentSecurityContext(expression = "authentication?.principal?.id") Long userId){
        groupRequest.setUserId(userId);
        groupService.insertGroup(groupRequest);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateGroup(@Valid @RequestBody GroupRequest groupRequest,@CurrentSecurityContext(expression = "authentication?.principal?.id") Long userId){
        if (groupRequest.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        groupRequest.setUserId(userId);
        groupService.updateGroup(groupRequest);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
