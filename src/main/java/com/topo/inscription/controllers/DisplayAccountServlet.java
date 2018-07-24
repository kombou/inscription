package com.topo.inscription.controllers;

import com.topo.inscription.entity.Account;
import com.topo.inscription.repository.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/display")
public class DisplayAccountServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringId = req.getParameter("id");
        Account account = Repository.getInstance().findById(Integer.parseInt(stringId));
        req.setAttribute("account",account);
        req.getRequestDispatcher("/WEB-INF/DisplayAccountView.jsp").forward(req,resp);
    }
}
