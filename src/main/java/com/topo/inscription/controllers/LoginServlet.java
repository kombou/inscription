package com.topo.inscription.controllers;

import com.topo.inscription.entity.Account;
import com.topo.inscription.repository.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet{
    Repository repository = Repository.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/LoginView.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Account account = new Account();

        account.setEmail(email);
        account.setPasswordHash(password);

        Map<String,String> errors = new HashMap<>();

        //verification de l'email
        if(email.length() == 0){
            errors.put("email","Veuillez renseigner une adresse email");
        }else if(!email.matches("^[a-z0-9._-]+@[a-z0-9._-]+\\.[a-z]{2,6}$")){
            errors.put("email","Votre email est incorrect");
        }

        //verification du mot de passe
        if(password.length() == 0){
            errors.put("password","Veuillez renseigner un mot de passe");
        }



        //verification du compte
        Account respAccount = repository.findByEmail(email);
        if(errors.size()==0){
            if(!(respAccount==null)){
                if(respAccount.getPasswordHash().equals(password)){
                    //stockage en session des paramettre de connection
                    HttpSession session = req.getSession();
                    session.setAttribute("email",respAccount.getEmail());
                    session.setAttribute("password",respAccount.getPasswordHash());

                    req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);

                }
            }else {
                req.setAttribute("account",account);
                errors.put("response","Ce compte n'existe pas");
                req.setAttribute("errors",errors);
                req.getRequestDispatcher("/WEB-INF/LoginView.jsp").forward(req, resp);
            }
        }else {
            req.setAttribute("errors",errors);
            req.setAttribute("account",account);
            req.getRequestDispatcher("/WEB-INF/LoginView.jsp").forward(req, resp);
        }
    }
}
