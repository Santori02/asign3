package shop.user;

import shop.items.Item;

public class Order {
    private int id;
    private Item item;
    private int amount;


    public Order(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int totalOrder(){
        Lambda lambda;
        lambda=(x,y)-> (int) (x*y);
        int res= lambda.total(amount,item.getPrice());
        return res;
    }
}
