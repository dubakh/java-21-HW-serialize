package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class UserList implements Serializable {

    static final long serialVersionUID = 1;

    ArrayList<User> users = new ArrayList<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "users=" + users +
                '}';
    }

    public void display() {
        for (User user : users) {
            System.out.println(user);
        }
    }


}
