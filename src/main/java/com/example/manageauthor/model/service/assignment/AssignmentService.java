package com.example.manageauthor.model.service.assignment;

import com.example.manageauthor.model.DTOAssignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.example.manageauthor.config.ConnectionJDBC.getConnection;

public class AssignmentService implements IAssignmentService {

    @Override
    public List<DTOAssignment> findAll() {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select a.id,a.name,a.age,a.address,a.phonenumber,p.name as name_post,p.dates,am.price\n" +
                    "from assignment am\n" +
                    "join author a on a.id = am.id_author\n" +
                    "join posts p on p.id = am.id_post");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
