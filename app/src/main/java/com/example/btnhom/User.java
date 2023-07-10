package com.example.btnhom;


import java.util.ArrayList;
import java.util.List;

public class User {
    public static List<User> listUser = new ArrayList<User>();


    public String UserName;
    public String Email;
    public String Password;

    public User(String userName, String email, String password) {
        UserName = userName;
        Email = email;
        Password = password;
    }
}
