package com.example.manageauthor.model.service.assignment;

import com.example.manageauthor.model.Assignment;
import com.example.manageauthor.model.DTOAssignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.manageauthor.config.ConnectionJDBC.getConnection;

public class AssignmentService implements IAssignmentService {

    @Override
    public List<DTOAssignment> findAll() {
        List<DTOAssignment> dtoAssignmentList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select am.id,am.date_start,am.date_end,am.note,p.name as name_post,a.name as name_author,a.price\n" +
                    "from assignment am\n" +
                    "join author a on a.id = am.id_author\n" +
                    "join posts p on p.id = am.id_post");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String dateS = String.valueOf(resultSet.getDate("date_start"));
                String dateE = String.valueOf(resultSet.getDate("date_end"));
                String note = resultSet.getString("note");
                String namePost = resultSet.getString("name_post");
                String nameAuthor = resultSet.getString("name_author");
                int price = resultSet.getInt("price");
                DTOAssignment dtoAssignment = new DTOAssignment(id,dateS,dateE,note,namePost,nameAuthor,price);
                dtoAssignmentList.add(dtoAssignment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dtoAssignmentList;
    }

    @Override
    public void createAssignment(Assignment assignment) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into assignment(date_start,date_end,note,id_author,id_post) values \n" +
                    "(?,?,?,?,?); ");
            preparedStatement.setString(1,assignment.getDateStart());
            preparedStatement.setString(2,assignment.getDateEnd());
            preparedStatement.setString(3,assignment.getNote());
            preparedStatement.setInt(4,assignment.getIdAuthor());
            preparedStatement.setInt(5,assignment.getIdPost());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
