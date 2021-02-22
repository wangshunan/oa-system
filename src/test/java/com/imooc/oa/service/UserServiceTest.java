package com.imooc.oa.service;

import junit.framework.TestCase;
import org.junit.Test;

public class UserServiceTest extends TestCase {
    private UserService userService = new UserService();

    @Test
    public void testCheckLogin() {
        userService.checkLogin("m8", "test");
    }
}