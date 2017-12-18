package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main_D {
    public static final String usersList = "/Users/boris/IdeaProjects/171217-Serialisible-Write-Read/src/com/company/users.txt";

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        UserList users = deserialize();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter username:");
        String username = reader.readLine();

        System.out.println("Enter password:");
        String password = reader.readLine();

        checkUser(users, username, password);

        reader.close();

        //Dispaly all users in the list
        //users.display();
    }

    private static void checkUser(UserList userList, String username, String password) {
        User currentUser = null;
        for(User user : userList.getUsers()){
            if(user.getUsername().equals(username)){
                currentUser = user;
            }
        }

        if (currentUser != null && currentUser.getPassword().equals(password)){
            System.out.println(currentUser.toString());
        }else{
            System.out.println("Wrong username or password");
        }
    }



    public static UserList deserialize() throws ClassNotFoundException {
        UserList userList = null;
        try {
            FileInputStream fileIn = new FileInputStream(usersList);
            ObjectInputStream in = new ObjectInputStream((fileIn));
            userList = (UserList) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i){
            i.printStackTrace();
        }
        return userList;
    }
}
