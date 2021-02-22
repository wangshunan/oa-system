package com.imooc.oa.dao;

import com.imooc.oa.entity.User;
import com.imooc.oa.utils.MybatisUtils;

public class UserDao {
    /**
     * ユーザー名で検索
     * @param username
     * @return　User情報、nullなら存在しない
     */
    public User selectByUsername(String username) {
        User u = (User) MybatisUtils.executeQuery(sqlSession ->
                sqlSession.selectOne("usermapper.selectByUsername", username));
        return u;
    };
}
