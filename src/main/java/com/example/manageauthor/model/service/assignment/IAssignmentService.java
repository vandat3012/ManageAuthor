package com.example.manageauthor.model.service.assignment;

import com.example.manageauthor.model.Assignment;
import com.example.manageauthor.model.DTOAssignment;

import java.util.List;

public interface IAssignmentService {
    List<DTOAssignment> findAll();
    void createAssignment(Assignment assignment);
}
