package com.imooc.oa.service;

import com.imooc.oa.entity.Node;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class UserServiceTest extends TestCase {
    private UserService userService = new UserService();

    @Test
    public void testCheckLogin() {
        userService.checkLogin("m8", "test");
    }

    @Test
    public void testSelectNodeByUserId() {
        List<Node> nodeList = userService.selectNodeByUserId(2L);
        System.out.println(nodeList);
    }
}