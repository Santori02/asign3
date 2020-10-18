package shop.store;

import shop.user.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserStore {
    private static Map<String, User> users=new HashMap<>();

    public UserStore() {}

    public static void add(User user){

        users.put(user.getLogin(),user);
    }

    public static Map<String, User> getUsers() {
        return users;
    }

    public static    User getUserBy(String login){
        if (users.get(login)!=null){
        return users.get(login);
        }
        return null;
    }
}
