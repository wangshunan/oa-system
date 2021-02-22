package com.imooc.oa.service;

import com.imooc.oa.dao.UserDao;
import com.imooc.oa.entity.User;
import com.imooc.oa.service.exception.BussinessException;

public class UserService {
    private UserDao userDao = new UserDao();

    /**
     * ログイン検証
     * @param username
     * @param password
     * @return　ユーザーデータ
     * @throws BussinessException L001-ユーザー存在しない, L002-パスワード間違う
     */
    public User checkLogin(String username, String password) {
        User u = userDao.selectByUsername(username);
        if ( u == null ) {
            throw new BussinessException("L001", "ユーザー存在しない");
        }
        if( !password.equals((u.getPassword())) ) {
            throw new BussinessException("L002", "パスワード間違っている");
        }
        return u;
    };
}
