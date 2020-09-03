import com.cll.dao.userdao;
import com.cll.entity.User;
import com.cll.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class myBatisTestDemo {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    @Test
    public void getUserList() {
        SqlSession session = MybatisUtil.getsession();
        try {
            userdao userdao = session
                    .getMapper(userdao.class);
            List<User> users = userdao.userMapper();
            for (User user : users) {
                System.out.println(user.getId() + ":" + user.getName()
                        + ":" + user.getPassword());
            }
        } finally {

            session.close();
        }
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtil.getsession();
        User u = new User(8, "陈丽丽111", "测试");
        userdao userdao = sqlSession.getMapper(com.cll.dao.userdao.class);
        userdao.addUser(u);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserByid(){
        SqlSession sqlSession = MybatisUtil.getsession();
        userdao userdao = sqlSession.getMapper(com.cll.dao.userdao.class);
        userdao.updateUserByid(6,"陈聚聚222",null);
        sqlSession.commit();



    }
    @Test
    public void getUserByid(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        userdao userdao=sqlSession.getMapper(com.cll.dao.userdao.class);
        User u=userdao.getUserByid(1);
        System.out.println(u.getName());
    }

    @Test
    public  void listgetUser(){
        SqlSession sqlSession=MybatisUtil.getsession();
        userdao userdao=sqlSession.getMapper(com.cll.dao.userdao.class);
        List<Integer> inters=new ArrayList<Integer>();
        inters.add(1);
        inters.add(6);
       List<User> Userlist= userdao.listUser(inters);
        for(User u:Userlist){
            System.out.println("名称："+u.getName()+"密码："+u.getPassword());

        }

    }


}


