package com.imooc.oa.service;

import com.imooc.oa.dao.RbacDao;
import com.imooc.oa.dao.UserDao;
import com.imooc.oa.entity.Node;
import com.imooc.oa.entity.User;
import com.imooc.oa.service.exception.BussinessException;
import com.imooc.oa.utils.MD5Utils;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();
    private RbacDao rbacDao = new RbacDao();

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

    /**
     * MD5ログイン検証
     * @param username
     * @param password
     * @return　ユーザーデータ
     * @throws BussinessException L001-ユーザー存在しない, L002-パスワード間違う
     */
    public User checkLoginForMD5(String username, String password) {
        User u = userDao.selectByUsername(username);
        if ( u == null ) {
            throw new BussinessException("L001", "ユーザー存在しない");
        }
        String md5 = MD5Utils.md5Digest(password);
        if( !md5.equals((u.getPassword())) ) {
            throw new BussinessException("L002", "パスワード間違っている");
        }
        return u;
    };

    public List<Node> selectNodeByUserId(Long userId) {
        return (List)rbacDao.selectNodeByUserId(userId);
    };
}
