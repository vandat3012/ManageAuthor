package com.example.manageauthor.model.service.posts;

import com.example.manageauthor.model.Posts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.manageauthor.config.ConnectionJDBC.getConnection;

public class PostsService implements IPostsService {

    @Override
    public List<Posts> findAllPost() {
        List<Posts> postsList = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement;
        {
            try {
                preparedStatement = connection.prepareStatement("select * from posts;");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String date = String.valueOf(resultSet.getDate("dates"));
                    Posts posts = new Posts(id,name,date);
                    postsList.add(posts);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return postsList;
    }
}
