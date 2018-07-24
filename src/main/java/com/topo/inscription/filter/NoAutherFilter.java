package com.topo.inscription.filter;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(urlPatterns = "/*")
public class NoAutherFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        List<String> urls = new ArrayList<>();
        urls.add("/login");
        urls.add("/registration");

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        if(urls.contains(request.getRequestURI())){

            if(session.getAttribute("account") != null){
                response.sendRedirect("/");
            }else{
                chain.doFilter(req,resp);
            }
        }else {
            chain.doFilter(req,resp);
        }
    }
}
