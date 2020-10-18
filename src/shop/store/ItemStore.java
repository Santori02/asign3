package shop.store;

import shop.items.Furniture;
import shop.items.Item;
import shop.items.Sport;
import shop.user.User;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class ItemStore {
    private static LinkedList<Item> items = new LinkedList<>();
    public ItemStore() {

    }
    public static Item getItem(int id){

        return items.get(id);
    }
    public static LinkedList<Item> getItems() {
        return items;
    }

    public static void addItem(Item item) {
        ItemStore.items.add(item.getId(),item);
    }
}
