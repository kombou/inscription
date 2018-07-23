package com.topo.inscription.controllers;

import com.topo.inscription.entity.Account;
import com.topo.inscription.repository.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/RegistrationView.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String telephone = req.getParameter("telephone");
        String password = req.getParameter("password");
        String passwordMatch = req.getParameter("passwordMatch");

        Account account = new Account();

        account.setName(name);
        account.setSurname(surname);
        account.setEmail(email);
        account.setTelephone(telephone);
        account.setPasswordHash(passwordMatch);

        Map<String,String> errors = new HashMap<>();

        if(name == null){
            errors.put("name","votre nom ne doit pas être vide");
        }else if(name.length() < 4){
            errors.put("name","votre nom doit contenir aumoins 4 caractères");
        }else if(!name.matches("^[a-zA-Z]*$")){
            errors.put("name","votre nom contient des caractere incorrects");
        }else if(surname.length() <4){
            errors.put("surname","votre prenom doit avoir au moins 4 caractère");
        }else if(!surname.matches("^[a-zA-Z]*$")){
            errors.put("surname","votre prenom contient des caractere incorrects");
        }else if(email==null){
            errors.put("email","votre email ne doit pas être vide");
        }else if(!email.matches("^[a-z0-9.__-]+@[a-z0-9.__-]+\\.[a-z]{2,6}$")){
            errors.put("email","votre email est incorrect");
        }else if(!email.matches("^[a-zA-Z@.]*$")){
            errors.put("email","votre email contient des caractere incorrects");
        }else if(telephone.length() < 9){
            errors.put("telephone","votre numero doit comporter au moins 9 caractère");
        }else if(!telephone.matches("^[0-9]{9}$")){
            errors.put("telephone","votre numéro doit contenir 9 chiffre");
        }else if(password==null){
            errors.put("password","renseigner un mot de passe");
        }else if(password.length() < 6){
            errors.put("password","votre mot de passe doit être d\'aumoins 6 caractères");
        }else if(passwordMatch == null){
            errors.put("passwordMatch","entre a nouveau le mot de passe");
        }else if(!passwordMatch.equals(password)){
            errors.put("passwordMatch","saisir le même mot de passe");
        }

        if(errors.size() == 0){

           account.setId(Repository.getInstance().save(account));
            resp.sendRedirect("/display?id="+account.getId());

        }else {

            req.setAttribute("errors",errors);
            req.setAttribute("account",account);
            req.getRequestDispatcher("/RegistrationView.jsp").forward(req,resp);
        }



    }
}
