package com;

import org.junit.Test;
import com.service.UserDaoImpl;


public class UserServiceTest {
    @Test
    public void testCheck() {
        UserDaoImpl userService = new UserDaoImpl();
        userService.check();
    }
}
