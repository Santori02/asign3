package shop.user;


import shop.ReschedulableTimer;
import shop.store.UserStore;


import java.util.*;


public class User {


    private int u_id;
    private String login;
    private String password;
    private Date StartDate;
    private Date LastDate;
    private int counter=0;
    private LinkedList<Order> orders = new LinkedList<>();
    private int numOfSession=0;


    private boolean flag=false;
    private ReschedulableTimer timer= new ReschedulableTimer();
    private Runnable task1 =new TimerTask() {
        @Override
        public void run() {
            User user= UserStore.getUserBy(login);
            user.getOrders().clear();
            user.nullCount();
        }
    };

    public void updateTimer() {
        if (flag==false){
            timer.schedule(task1, 60000);//1 min= 60000 ms}
            flag=true;
        }else {
            timer.reschedule(60000);
        }
    }


    private void nullCount(){
        this.counter=0;
    }


    public User(int u_id, String login, String password) {
        this.u_id = u_id;
        this.login = login;
        this.password = password;
        UserStore.add(this);
    }
    public int getU_id() {
        return u_id;
    }
    public void clear(){
        this.orders.clear();
    }
    public String getLogin() {
        return this.login;
    }
    public int getNumOfSession() {
        return numOfSession;
    }
    public void addNumOfSession() {
        this.numOfSession ++;
    }
    public String getPassword() {
        return this.password;
    }
    public Date getStartDate() {
        return StartDate;
    }
    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }
    public Date getLastDate() {
        return LastDate;
    }
    public void setLastDate(Date lastDate) {
        LastDate = lastDate;
    }
    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter++;
    }
    public LinkedList<Order> getOrders() {
        return orders;
    }
    public void addOrders(Order order) {
        order.setId(counter);
        this.orders.add(counter,order);
        counter++;
    }
    public Order getOrderBy(int id){

        return orders.get(id);
    }
}
