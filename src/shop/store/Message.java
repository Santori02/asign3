package shop.store;

import shop.items.Item;
import shop.user.Order;
import shop.user.User;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class Message {
    private User user;
    private Queue<Order> orders= new Queue<Order>() {
        @Override
        public boolean add(Order order) {
            return false;
        }

        @Override
        public boolean offer(Order order) {
            return false;
        }

        @Override
        public Order remove() {
            return null;
        }

        @Override
        public Order poll() {
            return null;
        }

        @Override
        public Order element() {
            return null;
        }

        @Override
        public Order peek() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Order> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Order> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }
    };
    private int total;

    public Message() {
    }

    public Message(User user, int total) {
        this.user = user;
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addOrder(Order o){
       orders.add(o);
    }

    public Queue<Order> getOrders() {
        return orders;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Message{" +
                "user=" + user +
                ", orders=" + orders +
                ", total=" + total +
                '}';
    }
}
