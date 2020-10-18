package shop.items;

import shop.store.ItemStore;

public class Item {
    private String itemName;
    private int id;
    private double price;

    public Item( int id,String itemName, double price) {
        this.itemName = itemName;
        this.id = id;
        this.price = price;
        ItemStore.addItem(this);
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
