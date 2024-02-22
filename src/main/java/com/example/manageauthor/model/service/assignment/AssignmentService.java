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

    public static final String SQL_SELECT_ALL = "select am.id,am.date_start,am.date_end,am.note,p.name as name_post,a.name as name_author,a.price\n" +
            "from assignment am\n" +
            "join author a on a.id = am.id_author\n" +
            "join posts p on p.id = am.id_post\n" +
            "order by am.id asc;";
    public static final String SQL_INSERT = "insert into assignment(date_start,date_end,note,id_author,id_post) values \n" +
            "(?,?,?,?,?); ";
    public static final String SQL_SELECT_BY_ID = "select am.id,am.date_start,am.date_end,am.note,am.id_post,am.id_author\n" +
            "from assignment am\n" +
            "where am.id = ?;";
    public static final String SQL_UPDATE_BY_ID = "update assignment am set am.date_start = ?,am.date_end=?,am.note=?,am.id_post=?,am.id_author =?\n" +
            "where am.id = ?;";
    public static final String SQL_DELETE_BY_ID = "delete from assignment \n" +
            "where id = ?;";
    public static final String SQL_SELECT_BY_NAME = "select am.id,am.date_start,am.date_end,am.note,p.name as name_post,a.name as name_author,a.price\n" +
            "from assignment am\n" +
            "join author a on a.id = am.id_author\n" +
            "join posts p on p.id = am.id_post\n" +
            "where a.name = ?;";
    public static final String SQL_SORT_BY_NAME_AUTHOR = "select am.id,am.date_start,am.date_end,am.note,p.name as name_post,a.name as name_author,a.price\n" +
            "from assignment am\n" +
            "join author a on a.id = am.id_author\n" +
            "join posts p on p.id = am.id_post\n" +
            "order by a.name asc;";

    @Override
    public List<DTOAssignment> findAll() {
        List<DTOAssignment> dtoAssignmentList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
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
    public List<DTOAssignment> sortByName() {
        List<DTOAssignment> dtoAssignmentList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SORT_BY_NAME_AUTHOR);
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
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
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

    @Override
    public Assignment findById(int id) {
        Assignment assignment = null;
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idA = resultSet.getInt("id");
                String dateStart = resultSet.getString("date_start");
                String dateEnd = resultSet.getString("date_end");
                String note = resultSet.getString("note");
                int idPost = resultSet.getInt("id_post");
                int idAuthor = resultSet.getInt("id_author");
                assignment = new Assignment(idA,dateStart,dateEnd,note,idPost,idAuthor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return assignment;
    }

    @Override
    public void edit(Assignment assignment) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_BY_ID);
            preparedStatement.setString(1,assignment.getDateStart());
            preparedStatement.setString(2,assignment.getDateEnd());
            preparedStatement.setString(3,assignment.getNote());
            preparedStatement.setInt(4,assignment.getIdAuthor());
            preparedStatement.setInt(5,assignment.getIdPost());
            preparedStatement.setInt(6,assignment.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DTOAssignment> findByNameAuthor(String nameAuthor) {
        List<DTOAssignment> dtoAssignmentList = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_NAME);
            preparedStatement.setString(1,nameAuthor);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String dateS = String.valueOf(resultSet.getDate("date_start"));
                String dateE = String.valueOf(resultSet.getDate("date_end"));
                String note = resultSet.getString("note");
                String namePost = resultSet.getString("name_post");
                String nameAuthor1 = resultSet.getString("name_author");
                int price = resultSet.getInt("price");
                DTOAssignment dtoAssignment = new DTOAssignment(id,dateS,dateE,note,namePost,nameAuthor1,price);
                dtoAssignmentList.add(dtoAssignment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dtoAssignmentList;
    }

}
