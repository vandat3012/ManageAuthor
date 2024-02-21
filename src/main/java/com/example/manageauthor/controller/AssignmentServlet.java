package com.example.manageauthor.controller;

import com.example.manageauthor.HelloServlet;
import com.example.manageauthor.model.Assignment;
import com.example.manageauthor.model.Author;
import com.example.manageauthor.model.DTOAssignment;
import com.example.manageauthor.model.Posts;
import com.example.manageauthor.model.service.assignment.AssignmentService;
import com.example.manageauthor.model.service.assignment.IAssignmentService;
import com.example.manageauthor.model.service.author.AuthorService;
import com.example.manageauthor.model.service.author.IAuthorService;
import com.example.manageauthor.model.service.posts.IPostsService;
import com.example.manageauthor.model.service.posts.PostsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

@WebServlet (name = "assignmentServlet",urlPatterns = "/assignment")
public class AssignmentServlet extends HelloServlet {

    static IAssignmentService iAssignmentService = new AssignmentService();
    static IAuthorService iAuthorService = new AuthorService();
    static IPostsService iPostsService = new PostsService();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "create" :
                showFormCreate(request,response);
                break;
            default:
                showAllAssignment(request,response);
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        List<Author> author = iAuthorService.findAllAuthor();
        List<Posts> post = iPostsService.findAllPost();
        request.setAttribute("authors",author);
        request.setAttribute("post",post);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAllAssignment(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        List<DTOAssignment> dtoAssignments = iAssignmentService.findAll();
        request.setAttribute("dtoAssignment",dtoAssignments);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "create" :
                createNewAssignment(req,resp);
                break;
            default:
                showAllAssignment(req,resp);
    }
}

    private void createNewAssignment(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        int price = Integer.parseInt(req.getParameter("price"));
        int idAuthor = Integer.parseInt(req.getParameter("id_author"));
        int idPost = Integer.parseInt(req.getParameter("id_post"));

        try {
            resp.sendRedirect("/assignment");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }
