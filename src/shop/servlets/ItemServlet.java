package shop.servlets;

import shop.ReschedulableTimer;
import shop.items.*;
import shop.store.ItemStore;
import shop.store.Message;
import shop.store.UserStore;
import shop.user.Order;
import shop.user.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.HttpCookie;
import java.util.LinkedList;
import java.util.Queue;

public class ItemServlet extends HttpServlet {
    private static boolean flag=false;

    private static int count=0;
    public ItemServlet() {
    }
    private void add(){
        Item ball = new Sport(0,"ball1",34);
        Item item = new Furniture(1,"bed",53.4);
        Item item1 =new Furniture(2,"desc",53.4);
        Item item2 =new Gadgets(3,"phone",53.4);
        Item item3 =new Clothes(4,"shoes",53.4);
        Item item4 = new Gadgets(5,"laptop",45);

        flag=true;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (flag==false){
            add();
        }


        HttpSession session = req.getSession();
        if (session.getAttribute("user")!=null) {
            User user= (User) session.getAttribute("user");
            user.updateTimer();
        }


        if (req.getParameter("Sport")!=null){

            session.setAttribute("item","Sport");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }


        if (req.getParameter("Clothes")!=null){
            session.setAttribute("item","Clothes");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }


        if (req.getParameter("Gadgets")!=null){
            System.out.println("servlet called");
            session.setAttribute("item","Gadgets");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }


        if (req.getParameter("Furniture")!=null){
            System.out.println("servlet called");
            session.setAttribute("item","Furniture");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }


        if (req.getParameter("ALL")!=null){
            System.out.println("servlet called");
            session.setAttribute("item","");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }


        if (req.getParameter("addToCart")!=null){
            int amount =Integer.parseInt(req.getParameter("amount"));
            int id =Integer.parseInt(req.getParameter("item_id"));
            User user= (User) session.getAttribute("user");
            Order order = new Order(ItemStore.getItem(id),amount);
            user.addOrders(order);
        }

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
