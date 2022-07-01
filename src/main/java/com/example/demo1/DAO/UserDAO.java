package com.example.demo1.DAO;
import com.example.demo1.model.User;

public interface UserDAO {
    public int registerUser(User user);

    public String loginUser(User user);
}
