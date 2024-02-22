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
            case "edit" :
                showFormEdit(request,response);
                break;
            case "delete" :
                deleteAssignment(request,response);
                break;
            case "sort" :
                sortByName(request,response);
                break;
            default:
                showAllAssignment(request,response);
        }
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        List<DTOAssignment> dtoAssignments = iAssignmentService.sortByName();
        request.setAttribute("dtoAssignment",dtoAssignments);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteAssignment(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iAssignmentService.delete(id);
        try {
            response.sendRedirect("/assignment");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Assignment assignment = iAssignmentService.findById(id);
        List<Posts> posts = iPostsService.findAllPost();
        List<Author> authors = iAuthorService.findAllAuthor();
        request.setAttribute("assignment",assignment);
        request.setAttribute("post",posts);
        request.setAttribute("author",authors);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");
        try {
            requestDispatcher.forward(request,response);
            response.sendRedirect("/assignment");
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
            case "edit" :
                editAssignment(req,resp);
                break;
            case "find" :
                findByName(req,resp);
                break;
            default:
                showAllAssignment(req,resp);
    }
}



    private void editAssignment(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String dateS = req.getParameter("dateS");
        String dateE = req.getParameter("dateE");
        String note = req.getParameter("note");
        int idPost = Integer.parseInt(req.getParameter("id_post"));
        int idAuthor = Integer.parseInt(req.getParameter("id_author"));
        Assignment assignment = new Assignment(id,dateS,dateE,note,idPost,idAuthor);
        iAssignmentService.edit(assignment);
        try {
            resp.sendRedirect("/assignment");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createNewAssignment(HttpServletRequest req, HttpServletResponse resp) {
        String dateS = req.getParameter("dateS");
        String dateE = req.getParameter("dateE");
        String note = req.getParameter("note");
        int idPost = Integer.parseInt(req.getParameter("id_post"));
        int idAuthor = Integer.parseInt(req.getParameter("id_author"));
        Assignment assignment = new Assignment(dateS,dateE,note,idPost,idAuthor);
        iAssignmentService.createAssignment(assignment);
        try {
            resp.sendRedirect("/assignment");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void findByName(HttpServletRequest req, HttpServletResponse resp) {
        String nameAuthor = req.getParameter("nameAuthor");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/list.jsp");
        List<DTOAssignment> dtoAssignments = iAssignmentService.findByNameAuthor(nameAuthor);
        req.setAttribute("dtoAssignment",dtoAssignments);
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    }
