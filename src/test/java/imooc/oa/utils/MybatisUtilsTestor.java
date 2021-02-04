package imooc.oa.utils;

import com.imooc.oa.utils.MybatisUtils;
import org.junit.Test;

public class MybatisUtilsTestor {
    @Test
    public void testcase1() {
        String r = (String)MybatisUtils.executeQuery(sqlSession -> {
            String out = sqlSession.selectOne("test.sample");
            return out;
        });
        System.out.println(r);
    }

    @Test
    public void testcase2() {

    }
}
