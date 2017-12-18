package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String usersList = "/Users/boris/IdeaProjects/171217-Serialisible-Write-Read/src/com/company/users.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserList userList = getUserList();
        addUser(userList);
        serialize(userList);
    }

    private static UserList getUserList() throws ClassNotFoundException {
        File file = new File(usersList);
        if(file.length() == 0){
            return new UserList();
        }else{
            return deserialize();
        }

    }

    private static void addUser(UserList userList) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter username:");
        String username = reader.readLine();

        for (User user : userList.getUsers()){
            if(user.getUsername().equals(username)) {
                System.out.println("Username is taken. Try Again:");
                return;
            }
        }

        System.out.println("Enter password:");
        String password = reader.readLine();

        System.out.println("Enter first name:");
        String firstName = reader.readLine();

        System.out.println("Enter last name:");
        String lastName = reader.readLine();

        System.out.println("Enter e-mail:");
        String email = reader.readLine();

        userList.getUsers().add(new User(username, password, firstName, lastName, email));

        reader.close();
    }


    public static void serialize(UserList userList){
        try{
            FileOutputStream fileOut = new FileOutputStream(usersList);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(userList);
            out.close();
            fileOut.close();
        }catch(IOException i){
            i.printStackTrace();
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

