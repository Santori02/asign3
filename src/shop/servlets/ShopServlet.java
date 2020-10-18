package shop.servlets;

import shop.ReschedulableTimer;
import shop.store.ItemStore;
import shop.store.Message;
import shop.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "ShopServlet")
public class ShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        HttpSession session = request.getSession();


        if (session.getAttribute("user")!=null) {
            User user= (User) session.getAttribute("user");
            user.updateTimer();

        }

            if (request.getParameter("buy")!=null){
                String st = "";

                if (request.getParameter("scales")!=null){
                    User user= (User) session.getAttribute("user");

                    String[] ar=request.getParameterValues("scales");
                    Message message =new Message();
                    int total =0;
                    for (String s :ar) {
                        message.addOrder(user.getOrderBy(Integer.parseInt(s)));
                        System.out.println(s);
                        //add total order
                        total+=user.getOrderBy(Integer.parseInt(s)).totalOrder();

                    }
                    message.setTotal(total);
                    message.setUser(user);
                    request.setAttribute("message",message);


                }


                request.getRequestDispatcher("/jsp/confirmation.jsp").forward(request, response);
            }






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}