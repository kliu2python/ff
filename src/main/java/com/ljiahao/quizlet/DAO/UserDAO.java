package com.ljiahao.quizlet.DAO;

import com.ljiahao.quizlet.model.User;

public interface UserDAO {
    public int registerUser(User user);

    public String loginUser(User user);
}
