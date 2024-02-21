package com.example.manageauthor.model.service.author;

import com.example.manageauthor.model.Author;
import com.mysql.cj.xdevapi.Collection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.manageauthor.config.ConnectionJDBC.getConnection;

public class AuthorService implements IAuthorService {
    @Override
    public List<Author> findAllAuthor() {
        List<Author> authorList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from author;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                Author author = new Author(id,name,price);
                authorList.add(author);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  authorList;
    }
}
