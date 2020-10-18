package shop.servlets;

import shop.ReschedulableTimer;
import shop.store.UserStore;
import shop.user.Order;
import shop.user.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;

public class UserServlet extends HttpServlet {
    private static int usercout=0;
    public UserServlet() {
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //timer Script
        //
        //
        //
        // .

        HttpSession session=req.getSession();

        if (session.getAttribute("user")!=null) {
            User user= (User) session.getAttribute("user");
            user.updateTimer();
        }


        if (req.getParameter("register")!=null){
            System.out.println("register case");
            String login= req.getParameter("login");
            String pass= req.getParameter("password");
            User user = new User(usercout,login,pass);
            UserStore.add(user);
            user.setStartDate(new Date());
            user.updateTimer();
            session.setAttribute("user",UserStore.getUserBy(login));
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            usercout++;
        }

        //logIn
        if (req.getParameter("logIn")!=null){
            System.out.println("Login case");
            String login = req.getParameter("login");
            String pass = req.getParameter("password");
            System.out.println(pass);

            if (UserStore.getUserBy(login) != null && UserStore.getUserBy(login).getPassword().equals(pass)){
                User user= UserStore.getUserBy(login);
                user.updateTimer();
                session.setAttribute("user",user);
                user.addNumOfSession();
            }else {session.setAttribute("err","wrong password or username");

                req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
            }
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        //logOut
        if (req.getParameter("logOut")!=null){
            User user =(User) session.getAttribute("user");
            user.setLastDate(new Date());
            session.removeAttribute("user");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }

    }
}