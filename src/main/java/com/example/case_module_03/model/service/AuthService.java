package com.example.case_module_03.model.service;


import com.example.case_module_03.dao.UserDao;
import com.example.case_module_03.dto.UserDto;
import org.mindrot.jbcrypt.BCrypt;

public class AuthService {

    private UserDao userDao = null;

    public AuthService () {
        userDao = new UserDao();
    }

    public UserDto login(String email, String password) {
        UserDto userDto = userDao.get(email);
        boolean isCorrectPassword;
        if (userDto == null) {
            return null;
        } else {
            isCorrectPassword = BCrypt.checkpw(password, userDto.getPassword());
            if (isCorrectPassword) {
                return userDto;
            } else {
                return null;
            }
        }
    }
}
